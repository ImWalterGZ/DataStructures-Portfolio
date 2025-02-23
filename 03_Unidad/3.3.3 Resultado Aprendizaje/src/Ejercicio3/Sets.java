package Ejercicio3;
import lista.DLinkedList;
import lista.Nodo;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sets<T> extends DLinkedList<T> implements Iterable<T> {


    public Sets() {
        super();
    }


    public int sumaConjunto() {
        int suma = 0;
        Nodo<T> current = root.getRight();
        while (current != null && current.getValue() != null) {
            suma += (Integer) current.getValue();
            current = current.getRight();
        }
        return suma;
    }

    public void clear() {
        while (!this.isEmpty()) {
            remove(this.getLastElement());
        }
    }

    public Sets<T> union(Sets<T> set) {
        if (set == null) {
            throw new IllegalArgumentException("El conjunto es null");
        }
        
        Sets<T> result = new Sets<>();
        
        if (root != null) {
            Nodo<T> current = root.getRight();
            while (current != null && current.getValue() != null) {
                result.add(current.getValue());
                current = current.getRight();
            }
        }
        
        if (set.root != null) {
            Nodo<T> current = set.root.getRight();
            while (current != null && current.getValue() != null) {
                if (!result.isThere(current.getValue())) {
                    result.add(current.getValue());
                }
                current = current.getRight();
            }
        }
        
        return result;
    }

    public Sets<T> difference(Sets<T> set) {
        if (set == null) {
            throw new IllegalArgumentException("El conjunto es null");
        }

        Sets<T> newSet = new Sets<>();
        
        for (T element : this) {
            newSet.add(element);
        }
        
        for (T element : set) {
            newSet.remove(element);
        }

        return newSet;
    }

 
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("{ ");
        Iterator<T> it = this.iterator();
        
        while (it.hasNext()) {
            result.append(it.next());
            if (it.hasNext()) {
                result.append(", ");
            }
        }
        result.append(" }");
        
        return result.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Nodo<T> current = root != null ? root.getRight() : null;
            
            @Override
            public boolean hasNext() {
                return current != null && current.getValue() != null;
            }
            
            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = current.getValue();
                current = current.getRight();
                return value;
            }
        };
    }

}
