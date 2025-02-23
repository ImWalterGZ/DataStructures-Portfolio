package Ejercicio1;

public class Terna<T> {
    T elemento;
    int cantidadL1;
    int cantidadL2;

    public Terna(T elemento, int cantidadL1, int cantidadL2) {
        this.elemento = elemento;
        this.cantidadL1 = cantidadL1;
        this.cantidadL2 = cantidadL2;
    }

    @Override
    public String toString() {
        return "<" + elemento + "," + cantidadL1 + "," + cantidadL2 + ">";
    }
}
