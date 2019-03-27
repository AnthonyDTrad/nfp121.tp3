package question1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.regex.Pattern;

public class IHMPile extends JFrame implements ActionListener{
    private JTextField donnee = new JTextField(6);
    private JTextField sommet = new JTextField(6);
    private JLabel     contenu = new JLabel(" ");

    private Pile p;
    private String _oldStackValue;

    public IHMPile(){
        super("IHM Pile");
        JButton    boutonEmpiler = new JButton("empiler");
        JButton    boutonDepiler = new JButton("depiler");

        JPanel enHaut = new JPanel();
        enHaut.add(donnee);
        enHaut.add(boutonEmpiler);
        enHaut.add(boutonDepiler);
        enHaut.add(sommet);
        setLayout(new BorderLayout(5,5));
        add("North",enHaut);
        add("Center",contenu);
        enHaut.setBackground(Color.red);
        setLocation(100,100);
        pack();setVisible(true);
        boutonEmpiler.addActionListener(this);
        boutonDepiler.addActionListener(this);

        p = new Pile(5);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("empiler"))
        {
            String donnesAEmpiler=donnee.getText();
            
            if(donnesAEmpiler != null && !donnesAEmpiler.isEmpty())
                try
                {
                    if(!contenu.getText().contains("["))
                        contenu.setText("");
                    
                    sommet.setText("");
                        
                    p.empiler(donnesAEmpiler);
                    contenu.setText(contenu.getText()+"["+ donnesAEmpiler +"]");
                }
                catch(PilePleineException exp)
                {
                    if(contenu.getText().contains("["))
                    {
                        _oldStackValue=contenu.getText();
                    }
                        contenu.setText("Coudnt add " + donnesAEmpiler +" car la pile  est pleine !");
                    
                }
        }
        else
        {            
           try
                {
                   Object removedObj= p.depiler();
                   if(removedObj!=null&&!removedObj.toString().isEmpty()&&!contenu.getText().isEmpty())
                   {
                      if(!contenu.getText().contains("[")&&_oldStackValue!=null&&!_oldStackValue.isEmpty())
                        contenu.setText(_oldStackValue);
                       
                    String res="["+ removedObj.toString() + "]";
                    contenu.setText(contenu.getText().replaceFirst(Pattern.quote(res),""));
                    sommet.setText(removedObj.toString());
                   } 
                }
                catch(PileVideException exp)
                {
                    
                    contenu.setText("La Pile est Vide!!");
                }
        }
    }

    public static void main(String[] args){
        new IHMPile();
    }
}
