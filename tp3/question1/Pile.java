package question1;

import question1.PilePleineException;
import question1.PileVideException;

/**
 * Classe Pile :
 * modifier de facon quelle prend des object
 * et non pas des int 
 * @Anthony Trad
 * @1.0
 */
public class Pile {
    public final static int TAILLE_PAR_DEFAUT = 5;

    private Object[] zone;
    private int ptr;

    /**
     * Constructors :
     * Initialzier la pile avec une taille indiques
     * params : la taille de la pille
     */
    public Pile(int taille) {
        if (taille < 0)
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
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(zone[i]);
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}