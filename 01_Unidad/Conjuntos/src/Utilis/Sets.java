package Utilis;

import javax.swing.text.AbstractDocument;
import java.awt.color.ICC_ColorSpace;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sets<T> implements Conjuntable<T>, Iterator<T> {

    private T[] data;
    private int nElem;
    private static final int SIZE = 20;
    private int pos = 0;

    public Sets() {
        this(SIZE);
    }

    public Sets(int size){
        // type erasure
        // Creamos una lista de tipo Object
        // Tenemos que formatear esta lista para poder trabajar con el
        // Para eso usamos un casting con (T[])
        data = (T []) new Object[size];
        Arrays.fill(data, null);
        nElem = 0;
        pos = 0;

    }


    public Sets (Sets <T> set){
        this.data = Arrays.copyOf(set.data, set.data.length);
        this.nElem = set.nElem;
        this.pos = 0;
    }


    public int sumaConjunto(){
        int suma = 0;
        for (int i = 0; i<nElem; i++){

            suma += Integer.parseInt(String.valueOf((Integer) data[i]));
        }
    return suma;
    }

    @Override
    public boolean isEmpty() {
        return nElem == 0;
    }

    @Override
    public void clear() {
        nElem = 0;
        Arrays.fill(data, null);
    }

    @Override
    public void add(T element) {
        if (nElem >= data.length)
            data = Arrays.copyOf(data, data.length+1);
        if (!contains(element)){
            data[nElem++] = element;
        }


    }

    @Override
    public void remove(T element) {

        if (!isEmpty()){
            for (int i  = 0 ; i < nElem ; i++){
                if (data[i].equals(element))
                    System.out.println("i ="+i + "element = " + element );
                    data[i] = null;
            }
        }
    }

    @Override
    public boolean contains(T element) {
        if (!isEmpty()){
            for (int i = 0; i < nElem ; i++){
                if (data[i].equals(element))
                 return true;
            }
        }
        return false;
    }

    @Override
    public Sets<T> union(Sets<T> set) {
        Sets<T> newSet = new Sets<T>(this);
        pos = 0;
        while (set.hasNext()) {
            T temp = set.next();
            if (!newSet.contains(temp)) {
                newSet.add(temp);
            }
        }

        return newSet;
    }

    @Override
    public Sets<T> difference(Sets<T> set) {
        Sets<T> newSet = new Sets<>(set.nElem);
        pos = 0;

        while(this.hasNext()){
            T temp = this.next();
            if (!set.contains(temp)){
                newSet.add(temp);
            }
        }
        return newSet;


    }



    @Override
    public Sets<T> intersection(Sets<T> set) {
        Sets<T> newSet = new Sets<T>(this.nElem);
        pos = 0;

        while (set.hasNext()){
            T temp = set.next();
            if (!this.contains(temp)){
                newSet.add(temp);
            }

        }
        return newSet;
    }

    @Override
    public boolean subset(Sets<T> set) {
        boolean isOn = true;

        while (isOn){

            if (this.hasNext()){
                T temp = this.next();
                if (set.contains(temp)) isOn = false;
            }
        }

        return isOn;
    }

    @Override
    public boolean hasNext() {
        return pos < nElem;
    }

    @Override
    public T next() throws NoSuchElementException {

        if (hasNext()) {
            return data[pos++];
        }
        throw new NoSuchElementException("Il n'y a pas d'elements");

    }

    @Override
    public String toString(){
        StringBuilder set = new StringBuilder();
        pos = 0;
        set.append(" ");
        while (this.hasNext()){
            T temp = this.next();
            if (temp != null)set.append(temp + " ");

        }
        return set.toString();
    }


}
