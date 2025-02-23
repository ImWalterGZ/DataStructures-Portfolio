package tree;

import Excepciones.EmptyException;
import lista.Nodo;

public interface Tree<T> {
    boolean add(T element);
    boolean remove(T element);
    void inorder(); //busca por izquierda
    void postorder();
    void preorder(); // derecha - raiz -izquirda
    void ampSearch(); // por niveles
    void deepSearch(T element); // todo a la derecha - todo a la izquierda - todo a la derecha - todo a la izquierda
    int height();
    void level();
    boolean isEmpty() throws EmptyException;
    Nodo<T> search(T element) throws EmptyException;
    boolean isThere(T element) throws EmptyException;

}