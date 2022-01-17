package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile4 implements PileI, Cloneable {
  
    private Maillon stk;
    private int capacite;
    private int nombre;

    private static class Maillon implements Cloneable {
        private Object element;
        private Maillon suivant;

        public Maillon(Object element, Maillon suivant) {
            this.element = element;
            this.suivant = suivant;
        }

        public Maillon suivant() {
            return this.suivant;
        }

        public Object element() {
            return this.element;
        }

        public Object clone() throws CloneNotSupportedException {
            Maillon m = (Maillon) super.clone();
            m.element = element;
            return m;
        }
    }

    public Pile4(int taille) {
        if (taille <= 0)
            taille = CAPACITE_PAR_DEFAUT;
        this.stk = null;
        this.capacite = taille;
        this.nombre = 0;
    }

    public Pile4() {
        this(PileI.CAPACITE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        if(estVide()){
            stk = new Maillon(o, null);
        }else{
            Maillon n = new Maillon(o, null);
            n.suivant = stk;
            stk = n;
        }
        this.nombre ++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        Object temp = stk.element();
        stk = stk.suivant();
        this.nombre --;
        return temp;
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return stk.element(); 
    }

    public boolean estVide() {
        return stk == null; 
    }

    public boolean estPleine() {
        return nombre == capacite; 
    }
    
    public String toString() {

        String s = "[";

        if(!estVide()){
            Maillon temp = stk;
            while(temp != null){
                s += temp.element();
                if(temp.suivant() != null)
                    s += ", ";
                temp = temp.suivant();
            }
        }
        return s + "]";
    }

    public boolean equals(Object o) {
        if (o instanceof Pile4) {
            if((this.taille() == Pile4.class.cast(o).taille()) &&  (this.capacite() == Pile4.class.cast(o).capacite())){
                Maillon temp = stk;
                Maillon temp1 = Pile4.class.cast(o).stk;
                while(temp != null && temp1 != null){
                    if(temp.element() != temp1.element()){
                        return false;
                    }
                    temp = temp.suivant();
                    temp1 = temp1.suivant();
                }
                return true;
            }
        }
        return false;
    }
// public boolean equals(Object o) {
    // if (o instanceof PileI) {
      // PileI p = (PileI) o;
      // return this.capacite() == p.capacite()
          // && this.hashCode() == p.hashCode();
    // } else
      // return false;
    // }
    // public boolean equals(Object o) {
    // return this.toString().equals(o.toString());
    // }
    public int capacite() {
        return this.capacite;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public int taille() {
        return nombre;
    }
}