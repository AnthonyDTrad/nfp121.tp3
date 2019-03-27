package question2;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * A remplacer en partie par votre classe Pile de la question 1.
 * 
 * @Anthony Trad
 * @1.0
 */
public class Pile implements PileI {
    public final static int TAILLE_PAR_DEFAUT = 5;

    private Object[] zone;
    private int ptr;
    
    /**
     * Constructors :
     * Initialzier la pile avec une taille indiques
     * params : la taille de la pille
     */
    public Pile(int taille) {
         if (taille <= 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }
    /**
     * Constructors :
     * Initialzier la pile avec une taille predefinis (par defaut)
     *
     */
    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }
    /**
     * emplier un object dans la pile 
     * params : l'object a empiler
     * exeptions : si la pile est pleine, on ne peut pas empiler
     */
    public void empiler(Object i) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = i;
        this.ptr++;
    }
    /**
     * depiler un object dans la pile 
     * params : l'object a depiler
     * exeptions : si la pile est vide, on ne peut pas depiler
     * returns : retourne lobject qui a etait depiler 
     */
    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
         if (estVide())
            throw new PileVideException();

        return zone[ptr-1] ;
    }
    /**
     * avoir la capacite : combien delement sont vide 
     * returns : retourne la capacite
     */
    public int capacite() {
        return zone.length-ptr;}
    /**
     * avoir la taille
     * returns : retourne la taille
     */
    public int taille() {
        return ptr;
    }
    /**
     * voir si la pile est vide ou pas
     * returns : retourne letat expilquer
     */
    public boolean estVide() {
        return ptr == 0;
    }
    /**
     * voir si la pile est pleine ou pas
     * returns : retourne letat expilquer
     */
    public boolean estPleine() {
        return ptr == zone.length;
    }

    public boolean equals(Object o)
    {   
        if(!(o instanceof Pile))
            return false;
        
        Pile pi = (Pile)o;

        if (pi.taille() == this.taille() && pi.capacite() == this.capacite()){
            for(int i=0; i <zone.length; i++){
                Object tmp = zone[i];
                for(int j =0; j<pi.zone.length; j++){
                    if(tmp != pi.zone[i]&&j==pi.zone.length-1)
                        return false;
                }
            }
            return true;
        }                
        return false;
    }

    // fonction fournie
    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
       String s = "[";
       for(int i=zone.length-1;i>0;i--)
         if(zone[i]!=null)
           s+=zone[i]+ ", ";
       if(zone[0]!=null)
        s+=zone[0];
        return s+"]";
    }
}