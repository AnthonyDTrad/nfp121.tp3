package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

/**
 * Décrivez votre classe PileVector ici.
 * 
 * @Anthony Trad 
 * @1.0
 */
public class Pile3 implements PileI {
    private static int _DEFAULT_SIZE=5;
    private Vector<Object> v;
    private int cap;
    
    public Pile3()throws Exception{
        this(_DEFAULT_SIZE);
    }

    public Pile3(int taille){
        if(taille<=0)
            taille=_DEFAULT_SIZE;
          
        v=new Vector<Object>();
          this.cap=taille;
        
    }

    public void empiler(Object o) throws PilePleineException {
        if(this.estPleine())
            throw new PilePleineException();            
        v.add(o);
        cap--;
    }

    public Object depiler() throws PileVideException {
       if(this.estVide())
            throw new PileVideException();
        cap++;
        Object del=v.get(v.size()-1);
        v.remove(del);
        return del;
    }

    public Object sommet() throws PileVideException {
        if(this.estVide())
            throw new PileVideException();
        return v.get(v.size()-1);
    }

    public int taille() {
        return this.v.size();
    }

    public int capacite() {
        return cap;
    }

    public boolean estVide() {
        return v.isEmpty();
    }

    public boolean estPleine() {
        return v.size()==cap;
    }

    public String toString() {
        String s = "[";
       for(int i=v.size()-1;i>0;i--)
        if(v.get(i)!=null)
           s+=v.get(i)+ ", ";
       if(v.get(0)!=null)
        s+=v.get(0);
        return s+"]";
    }

    public boolean equals(Pile3 o) {
        try{
            if(o.taille()==this.taille()&&o.capacite()==this.capacite())
            {
                for(int i=0;i<this.taille();i++)
                    if(!o.depiler().equals(this.depiler()))
                        return false;
                return true;
            }
        }
        catch(PileVideException exp)
        {
           return o.taille()==this.taille()&&o.capacite()==this.capacite();
        }
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

}
