package Ejercicio2;

import lista.DLinkedList;
import lista.Nodo;


public class ListaNumbers extends DLinkedList<Integer> {

    private int number;

    public ListaNumbers(int number1) {
        super();
        this.number = number1;
        convertirNumeroALista();
    }

    private void convertirNumeroALista() {
        int digit;
        int operation = number;
        while (operation > 0) {
            digit = operation % 10;
            this.addAt(0, digit);
            length++;
            operation /= 10;
        }
    }

    public int convertirListaANumero() {
        return convertirListaANumero(this.length - 1, tail, 1);
    }

    public int convertirListaANumero(long posicion, Nodo<Integer> tail, int multiplicador) {
        if (tail == null) {
            return 0;
        }
        if (tail.getLeft() == null) {
            return 0;
        }
        int current = tail.getLeft().getValue() * multiplicador;
        return current + convertirListaANumero(--posicion, tail.getLeft(), multiplicador * 10);
    }

    public ListaNumbers generar_multiplicacion(ListaNumbers l1, ListaNumbers l2, ListaNumbers R) {
        int number1 = l1.convertirListaANumero();
        int number2 = l2.convertirListaANumero();
        
        int result = number1 * number2;
        
        while (!R.isEmpty()) {
            R.remove(R.getLastElement());
        }
        
        int digit;
        while (result > 0) {
            digit = result % 10;
            R.addAt(0, digit);
            result /= 10;
        }
        
        return R;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("< ");
        Nodo<Integer> current = root.getRight();
        
        while (current != null && current.getValue() != null) {
            result.append(current.getValue());
            if (current.getRight() != null && current.getRight().getValue() != null) {
                result.append(" , ");
            }
            current = current.getRight();
        }
        
        result.append(" >");
        return result.toString();
    }
};
