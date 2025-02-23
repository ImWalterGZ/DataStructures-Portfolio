package lista;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DLinkedList<T> implements Lista<T> {

    protected Nodo<T> root, tail;
    protected long length;

    public boolean mismoTipoDato(DLinkedList<T> otraLista) {
        if (this.length == 0 || otraLista.length == 0) {
            System.out.println("Una de las listas esta vacia");
            return false;
        }
        if (this.root != null && otraLista.root != null) {
            Class<?> thisData = this.root.getRight().getValue().getClass();
            Class<?> otroData = otraLista.root.getRight().getValue().getClass();
            return thisData.equals(otroData);
        }
        return false;

    }

    public Iterator<T> right() {
        return new Iterator<T>() {
            Nodo<T> copy = root.getRight(), sub_node;

            @Override
            public boolean hasNext() {
                if (copy == null) return false;
                sub_node = copy;
                copy = copy.getRight();
                return true;
            }

            @Override
            public T next() {
                return sub_node.getValue();
            }
        };
    }


    public Iterator<T> left() {
        return new Iterator<T>() {
            Nodo<T> copy = tail.getLeft(), sub_node;

            @Override
            public boolean hasNext() {
                if (copy == null) return false;
                sub_node = copy;
                copy = copy.getRight();
                return true;
            }

            @Override
            public T next() {
                return sub_node.getValue();
            }
        };
    }

    public DLinkedList(T value) {
        this.root = new Nodo<>();
        this.tail = new Nodo<>();
        this.length = 0;
        if (value != null) {
            length++;
            Nodo<T> nuevo = new Nodo<>(value);
            root.setRight(nuevo);
            tail.setLeft(nuevo);
        }
    }

    public DLinkedList(Nodo<T> nodo) {
        if (nodo != null) {
            length++;
            root.setRight(nodo);
            tail.setLeft(nodo);
        }

    }

    public DLinkedList() {
        this((T) null);
    }

    @Override
    public boolean isEmpty() {
        if (root.getRight() == null && tail.getLeft() == null) {
            return true;
        }
        return false;
    }

    public Nodo<T> getLastElement() {
        return getLastElement(tail);
    }

    private Nodo<T> getLastElement(Nodo<T> root) {
        if (tail.getLeft() == null) {
            return null;
        }
        return tail.getLeft();
    }

    @Override
    public Nodo<T> getPrevElement(T value) {
        Nodo<T> tmp = null;
        try {
            isEmpty();
            tmp = getPrevElement(root, value);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        return tmp;
    }

    ;

    private Nodo<T> getPrevElement(Nodo<T> root, T value) {
        if (root.getRight() == null) {
            return null;
        }
        if (root.getRight().getValue().equals(value)) {
            return root;
        } else return getPrevElement(root.getRight(), value);
    }

    ;

    @Override
    public long getElement(T element) {
        try {
            isEmpty();
        } catch (NoSuchElementException e) {
            e.getMessage();
        }
        int counter = 0;
        return getElement(element, root.getRight(), counter);
    }

    public long getElement(T element, Nodo<T> root, long counter) {
        if (root == null) {
            return -1;
        }
        if (element.equals(root.getValue())) return counter;
        if (counter >= length - 1) return -1;
        return getElement(element, root.getRight(), ++counter);
    }

    @Override
    public Nodo<T> getElementAt(long position) {
        try {
            isEmpty();
            if (position < length) {
                return getElementAt(position, root.getRight(), 0);
            }


        } catch (EmptyStackException e) {
            e.getMessage();
        }
        return null;
    }

    public Nodo<T> getElementAt(long position, Nodo<T> root, long counter) {
        if (position - 1 == counter) {
            return root;
        }
        return getElementAt(position, root.getRight(), ++counter);
    }

    @Override
    public boolean isThere(T value) {
        if (root.getRight() == null) {
            return false;
        }
        return isThere(value, root);
    }

    public boolean isThere(T value, Nodo<T> root) {
        try {
            if (root.getRight() == null) {
                if (root.getValue().equals(value)) {
                    return true;
                }
                return false;
            }
            if (!value.equals(root.getValue())) {
                return isThere(value, root.getRight());
            }
            return true;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public boolean isThere(Nodo<T> node) {
        return isThere(node.getValue(), root);

    }

    @Override
    public void add(T value) {
        if (value != null) {
            Nodo<T> nouveau = new Nodo<>(value);

            if (length == 0) {
                root.setRight(nouveau);
                tail.setLeft(nouveau);
            } else {
                Nodo<T> last = tail.getLeft();
                last.setRight(nouveau);
                nouveau.setLeft(last);
                tail.setLeft(nouveau);
            }
            length++;
        }
    }

    @Override
    public void add(Nodo<T> node) {
        if (node != null) {
            if (node.getValue() != null) add(node.getValue());
        }

    }

    @Override
    public void remove(T value) {
        if (value == null) {
            return;
        }
        try {
            if (isEmpty()) {
                return;
            }
            Nodo<T> prevNode = getPrevElement(value);

            if (prevNode == null || prevNode.getRight() == null) {
                return;
            }
            Nodo<T> nodeToRemove = prevNode.getRight();
            Nodo<T> nextNode = nodeToRemove.getRight();

            prevNode.setRight(nextNode);
            if (nextNode != null) {
                nextNode.setLeft(prevNode);
            } else {
                tail.setLeft(prevNode);
            }
            if (length == 1) {
                root.setRight(null);
                tail.setLeft(null);
            }
            length--;
        } catch (NoSuchElementException e) {
            System.out.printf(" %s ", e.getMessage());
        }


    }

    @Override
    public void remove(Nodo<T> node) {
        if (node != null) {
            if (node.getValue() != null) {
                remove(node.getValue());
            }
        }

    }

    @Override
    public void addAt(long position, T value) {
        if (length == 0) {
            add(value);
        } else if (position >= length) {
            position = length - 1;
        } else {

            addAt(position, 0, value, root);
        }
    }

    public void addAt(long position, long index, T value, Nodo<T> nodo) {
        if (index == position) {
            Nodo<T> inyected = new Nodo<>(value);
            if (nodo.getRight() == null) {
                tail.setLeft(inyected);
            }
            Nodo<T> nextNode = nodo.getRight();
            inyected.setRight(nodo.getRight());
            nextNode.setLeft(inyected);
            nodo.setRight(inyected);
        } else {
            addAt(position, ++index, value, nodo.getRight());
        }
    }

    ;

    @Override
    public void addAt(long position, Nodo<T> node) {

    }

    @Override
    public void addAfter(long position, T value) {

    }

    @Override
    public void addAfter(long position, Nodo<T> node) {

    }

    @Override
    public void addBefore(long position, Nodo<T> node) {

    }

    @Override
    public void addBefore(long position, T value) {

    }

    @Override
    public void removeAfter(long position, T value) {

    }

    @Override
    public void removeAfter(long position, Nodo<T> node) {

    }

    @Override
    public void removeBefore(long position, T value) {

    }

    @Override
    public void removeBefore(long position, Nodo<T> node) {

    }

    @Override
    public void addStart(T value) {

    }

    @Override
    public void addStart(Nodo<T> node) {

    }

    @Override
    public long getLength() {
        return this.length;
    }

    @Override
    public void removeAll(T value) {

    }

    public void removeAll(T value, Nodo<T> root) {
        if (root.getValue().equals(value)) {
            remove(root);
        }
        if (root.getRight() != null) {
            removeAll(value, root.getRight());
        }
    }

    @Override
    public void removeAll(Nodo<T> value) {
        while (isThere(value)) {
            remove(value);
        }
    }

    @Override
    public String toString() {
        return "DLinkedList{" +
                "root=" + root +
                ", tail=" + tail +
                ", length=" + length +
                '}';
    }
}
