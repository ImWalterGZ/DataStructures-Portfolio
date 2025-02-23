public class Pilas<T> {
    private Nodo<T> cima;
    private int tamaño;

    public Pilas() {
        this.cima = null;
        this.tamaño = 0;
    }

    public boolean estaVacia() {
        return cima == null;
    }

    public int getTamaño() {
        return tamaño;
    }

    public T verCima() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        return cima.dato;
    }

    public void push(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (!estaVacia()) {
            nuevoNodo.setSiguiente(cima);
        }
        cima = nuevoNodo;
        tamaño++;
    }

    public T pop() {
        if (estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        }
        T elemento = cima.getDato();
        cima = cima.getSiguiente();
        tamaño--;
        return elemento;
    }

    public void vaciar() {
        cima = null;
        tamaño = 0;
    }

    @Override
    public String toString() {
        if (estaVacia()) {
            return "Pila vacía";
        }
        
        StringBuilder sb = new StringBuilder("Pila: ");
        Nodo<T> actual = cima;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(" -> ");
            }
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
}
