package Ejercicio1;

import Ejercicio1.Terna;
import lista.DLinkedList;
import lista.Nodo;

public class ListaResumen<T> {

    public DLinkedList<Terna<T>> generarListaResumen(DLinkedList<T> lista1, DLinkedList<T> lista2) {
        if (!lista1.mismoTipoDato(lista2)) {
            System.out.println("No guardan el mismo tipo de dato");
            return null;
        }

        DLinkedList<Terna<T>> ternas = new DLinkedList<>();

        while (lista1.getLength() > 0 || lista2.getLength() > 0) {
            int counter1 = 0;
            int counter2 = 0;
            Nodo<T> elemento = null;
            if (!lista1.isEmpty()) {
                elemento = lista1.getLastElement();
            } else if (!lista2.isEmpty()) {
                elemento = lista2.getLastElement();
            }

            while (lista1.isThere(elemento) || lista2.isThere(elemento)) {
                if (lista1.isThere(elemento)) {
                    counter1++;
                }
                if (lista2.isThere(elemento)) {
                    counter2++;
                    lista2.remove(elemento);
                }
                lista1.remove(lista1.getLastElement());
            }

            Terna<T> terna = new Terna<>(elemento.getValue(), counter1, counter2);
            ternas.add(terna);
        }

        return ternas;
    }
}
