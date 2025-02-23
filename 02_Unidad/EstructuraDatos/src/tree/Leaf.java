package tree;

import lista.Nodo;

public class Leaf<T> extends Nodo<T> {
    private long level;

    public Leaf(){
        super((T) null);
    }

    public Leaf(T element){
        super(element);
        level = 0;
    }

    public Leaf(Leaf<T> leaf){
        this(leaf.getValue());
    }

    public long getLevel() {
        return level;
    }

    public void setLevel(long level) {
        this.level = level;
    }
}