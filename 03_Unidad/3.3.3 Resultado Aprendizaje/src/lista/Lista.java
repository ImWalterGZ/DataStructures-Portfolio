package lista;


public interface Lista<T> {

    boolean isEmpty();

    Nodo<T> getLastElement();

    Nodo<T> getPrevElement(T value);

    long getElement(T element);

    Nodo<T> getElementAt(long position);


    boolean isThere(T value);

    boolean isThere(Nodo<T> node);

    void add(T value);

    void add(Nodo<T> node);

    void remove(T value);

    void remove(Nodo<T> node);

    void addAt(long position, T value);

    void addAt(long position, Nodo<T> node);

    void addAfter(long position, T value);

    void addAfter(long position, Nodo<T> node);

    void addBefore(long position, Nodo<T> node);

    void addBefore(long position, T value);

    void removeAfter(long position, T value);

    void removeAfter(long position, Nodo<T> node);

    void removeBefore(long position, T value);

    void removeBefore(long position, Nodo<T> node);

    void addStart(T value);

    void addStart(Nodo<T> node);

    long getLength();

    void removeAll(T value);

    void removeAll(Nodo<T> value);

    String toString();
}
