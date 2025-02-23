import Excepciones.EmptyException;
import Excepciones.FullException;
import Queue.QueueArray;
import lista.DLinkedList;
import lista.LinkedList;
import lista.Nodo;
import tree.SBtree;

import java.sql.ClientInfoStatus;
import java.util.Iterator;
import java.util.Random;

// Compendio de estructuras de datos de la materia Estructuras de datos
// Lets f go
public class Main {
    public static void main(String[] args) throws FullException, EmptyException {
//        LinkedList<Integer> list = new LinkedList<>();
//
////        list.add(1);
////        list.add(13);
////        list.add(33);
////        list.add(-3);
//
////        Random random = new Random();
////        for (int i = 0; i < 1000 ; i++){
////            list.add(random.nextInt(1,50));
////        }
//
//
//        // Get Prev Element
////        Nodo<Integer> last = list.getPrevElement(33);
////        if (last != null) System.out.printf(" %d ", last.getValue());
////
////        for ( Iterator <Integer> iterator = list.iterator(); iterator.hasNext();){
////            System.out.printf(" %d \n", iterator.next() );
////        }
//
//
//        // getElement
//        list.add(4);
//        list.add(-3);
//        list.add(8);
//        list.add(32);
//
//        System.out.println(list.getElement(4));
//        list.remove(4);
//        System.out.println(list.getElement(4));
//
//  ! Double linked list
//        DLinkedList<Double> dobleEnlace  = new DLinkedList<>();
//
//        dobleEnlace.add(6.1);
//        dobleEnlace.add(3.0);
//        dobleEnlace.add(5.0);
//        dobleEnlace.add(3.2);
//
//
//        Iterator<Double> iterator = dobleEnlace.right();
//        while (iterator.hasNext()){
//            System.out.println(" e " + iterator.next());
//
//        }
//
//// ! Stack
//
//        StackArray<String> pila = new StackArray<>();
//        pila.push("Perla");
//        pila.push("Mari");
//        pila.push("Estreca");
//        pila.push("Denso");
//        pila.push("Memo");
//        pila.push("Alan");
//        pila.push("aleman");
//        pila.push("Milton");
//        pila.push("dnesamente");
//        pila.push("dnesamente");
//        System.out.println(pila.search("Memo"));
//
//
//        // Intentar añadir un elemento a una pila llena
//        if (!pila.push("Extra")) {
//            System.out.println("No se pudo agregar 'Extra' porque la pila está llena.");
//        }
//
//        // Mostrar el elemento en la cima
//        pila.peek();
//
//        // Intentar remover un elemento de una pila vacía
//        pila.pop();

//        QueueArray<String> cnames = new QueueArray<>(4);
//        cnames.add("ian");
//        cnames.add("Mari");
//        cnames.add("rochin");
//        cnames.add("milton");
//        cnames.add("iguana");
//
//        System.out.println("Element " + cnames.element());
//        System.out.println(cnames.peek());
//
//        for (String name : cnames){
//            System.out.printf("%s\n", name);

        SBtree<Integer> abb = new SBtree<>();
//        abb.add(10);
//        abb.add(15);
//        abb.add(18);
//        abb.add(6);
//        abb.add(8);
//        abb.add(14);
//        abb.add(1);
        abb.add(10);

        abb.add(15);
        abb.add(6);
        abb.add(8);
        abb.add(14);
        abb.add(20);
        abb.add(10);
        abb.add(2);
        abb.add(3);
        abb.treePrinter();
        abb.remove(10);
        System.out.println("\n");
        abb.remove(20);

        abb.treePrinter();
        abb.remove(15);
        abb.treePrinter();

    }
}