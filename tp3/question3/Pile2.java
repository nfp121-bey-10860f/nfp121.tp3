package question3;

import question1.PilePleineException;
import question1.PileVideException;

import java.util.Stack;

public class Pile2<T> implements PileI<T>{
    private Stack<T> stk;
    private int capacite;
    private int ptr;

    public Pile2(int taille){
        if (taille <= 0)
          taille = CAPACITE_PAR_DEFAUT;
        this.capacite = taille;
        this.ptr = -1;
        this.stk = new Stack<T>();
        this.stk.setSize(taille);
    }

    public Pile2(){
        this(CAPACITE_PAR_DEFAUT);
    }

    public void empiler(T o) throws PilePleineException{
        if(estPleine())
            throw new PilePleineException();
        this.ptr ++;
        this.stk.set(this.ptr, o);
    }

    public T depiler() throws PileVideException{
        if(estVide())
            throw new PileVideException();
        T temp = stk.elementAt(ptr);
        stk.set(ptr, null);
        ptr --;
        return temp;
    }

    public T sommet() throws PileVideException{
        if(estVide())
            return null;
        return stk.elementAt(ptr);
    }
    
    public int capacite(){
        return this.capacite;
    }
    
    public int taille(){
        return this.ptr+1;
    }
    
    public boolean estVide(){
        return this.ptr == -1;
    }
    
    public boolean estPleine(){
        return this.ptr == capacite-1;
    }
    
    public boolean equals(Object o){
        if(o instanceof Pile2){
            if((this.taille() == Pile2.class.cast(o).taille()) &&  (this.capacite() == Pile2.class.cast(o).capacite())){
                for(int i = 0; i<stk.size(); i++){
                    if(this.stk.get(i) != Pile2.class.cast(o).stk.get(i)){
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
    
    public int hashCode(){
        return toString().hashCode();
    }
    
    public String toString(){
        String s = "[";
        for(int i = ptr; i >= 0; i--){
            s += stk.get(i);
            if (i > 0)
                s+=", ";
        }
        return s + "]";
    }
} 