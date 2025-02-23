package Utilis;


public interface Conjuntable<T> {

    boolean isEmpty();

    void clear();

    void add(T element);

    void remove(T element);

    boolean contains(T element);

    Sets<T> union(Sets<T> set);

    Sets<T> intersection(Sets<T> set);

    Sets<T> difference(Sets<T> set);

    boolean subset(Sets<T> set);
}
