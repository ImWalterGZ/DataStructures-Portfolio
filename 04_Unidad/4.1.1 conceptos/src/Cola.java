public class Cola<T> {
    private Nodo<T> frente;    // Front of the queue
    private Nodo<T> finall;    // Back of the queue
    private int tamaño;        // Size of the queue
    
    public Cola() {
        frente = null;
        finall = null;
        tamaño = 0;
    }
    
    // Check if queue is empty
    public boolean estaVacia() {
        return frente == null;
    }
    
    // Get queue size
    public int getTamaño() {
        return tamaño;
    }
    
    // Add element to the queue (enqueue)
    public void encolar(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            finall.setSiguiente(nuevoNodo);
        }
        finall = nuevoNodo;
        tamaño++;
    }
    
    // Remove and return first element (dequeue)
    public T desencolar() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        
        T elemento = frente.getDato();
        frente = frente.getSiguiente();
        tamaño--;
        
        if (frente == null) {
            finall = null;  // If queue becomes empty, update final_ pointer
        }
        
        return elemento;
    }
    
    // Get first element without removing it
    public T primero() {
        if (estaVacia()) {
            throw new IllegalStateException("La cola está vacía");
        }
        return frente.getDato();
    }
    
    // Clear the queue
    public void vaciar() {
        frente = null;
        finall = null;
        tamaño = 0;
    }
    
    // Convert queue to string representation
    @Override
    public String toString() {
        if (estaVacia()) {
            return "Cola vacía";
        }
        
        StringBuilder sb = new StringBuilder("Cola: ");
        Nodo<T> actual = frente;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(" <- ");
            }
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
} 