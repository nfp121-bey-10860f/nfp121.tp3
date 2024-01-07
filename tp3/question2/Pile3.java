package question2;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Vector;

public class Pile3 implements PileI {

    private Vector<Object> v;
    private int ptr;

    public Pile3() {
        this(CAPACITE_PAR_DEFAUT);
    }

    public Pile3(int taille) {
        if (taille <= 0)
          taille = CAPACITE_PAR_DEFAUT;
        this.v = new Vector<Object>();
        this.ptr = -1;
        this.v.setSize(taille);
    }

    public void empiler(Object o) throws PilePleineException {
        if(estPleine())
            throw new PilePleineException();
        this.ptr ++;
        this.v.set(this.ptr, o);
    }

    public Object depiler() throws PileVideException {
        if(estVide())
            throw new PileVideException();
        Object temp = v.elementAt(ptr);
        v.set(ptr, null);
        ptr --;
        return temp;
    }

    public Object sommet() throws PileVideException {
        if(ptr < 0){
            return null;
        }
        return v.elementAt(ptr);
    }

    public int taille() {
        return this.ptr+1;
    }

    public int capacite() {
        return v.size();
    }

    public boolean estVide() {
        return this.ptr == -1;
    }

    public boolean estPleine() {
        return  this.ptr == this.v.size()-1;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr; i >= 0; i--) {
            sb.append(v.get(i));
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // public boolean equals(Object o) {
        // if(o instanceof Pile3){
            // if((this.taille() == Pile3.class.cast(o).taille()) &&  (this.capacite() == Pile3.class.cast(o).capacite())){
                // for(int i = 0; i<v.size(); i++){
                    // if(this.v.get(i) != Pile3.class.cast(o).v.get(i)){
                        // return false;
                    // }
                // }
                // return true;
            // }
        // }
        // return false;
    // }
// public boolean equals(Object o) {
    // if (o instanceof PileI) {
      // PileI p = (PileI) o;
      // return this.capacite() == p.capacite()
          // && this.hashCode() == p.hashCode();
    // } else
      // return false;
    // }
    public boolean equals(Object o) {
    return this.toString().equals(o.toString());
    }
    public int hashCode() {
        return toString().hashCode();
    }
}