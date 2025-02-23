public class Main {
    public static void main(String[] args) {
        System.out.println("Bidimensional");

        System.out.println("Matriz 1");
        Bidimensional matriz1 = new Bidimensional();
        System.out.println(matriz1.toString());

        System.out.println("Matriz 2");
        Bidimensional matriz2 = new Bidimensional();
        System.out.println(matriz2.toString());

        long startTimeBidimensional = System.nanoTime();
        System.out.println("Suma de matrices");
        try {
            Bidimensional matriz3 = matriz1.sumaBidimensional(matriz2);
            System.out.println(matriz3.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la suma: " + e.getMessage());
        }

        System.out.println("Resta de matrices");
        try {
            Bidimensional matriz3 = matriz1.restaBidimensional(matriz2);
            System.out.println(matriz3.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la resta: " + e.getMessage());
        }

        System.out.println("Multiplicación de matrices");
        try {
            Bidimensional matriz3 = matriz1.multiBidimensional(matriz2);
            System.out.println(matriz3.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la multiplicación: " + e.getMessage());
        }

        long endTimeBidimensional = System.nanoTime();
        long durationBidimensional = (endTimeBidimensional - startTimeBidimensional) ;
        System.out.println("Tiempo de ejecución para operaciones bidimensionales: " + durationBidimensional + " ms");

        System.out.println("Unidimensional");

        System.out.println("Array 1");
        Unidimensional array1 = new Unidimensional();
        System.out.println(array1.toString());

        System.out.println("Array 2");
        Unidimensional array2 = new Unidimensional();
        System.out.println(array2.toString());

        long startTimeUnidimensional = System.nanoTime();
        System.out.println("Suma de matrices");
        try {
            Unidimensional arraySum = array1.sumaArreglo(array2);
            System.out.println(arraySum.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la suma: " + e.getMessage());
        }

        System.out.println("Resta de matrices");
        try {
            Unidimensional arrayResta = array1.restaArreglo(array2);
            System.out.println(arrayResta.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la resta: " + e.getMessage());
        }

        System.out.println("Multiplicación de matrices");
        try {
            Unidimensional array3 = array1.multiplicarArreglo(array2);
            System.out.println(array3.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Error en la multiplicación: " + e.getMessage());
        }

        long endTimeUnidimensional = System.nanoTime();
        long durationUnidimensional = (endTimeUnidimensional - startTimeUnidimensional);
        System.out.println("Tiempo de ejecución para operaciones unidimensionales: " + durationUnidimensional + " ms");

        // Comparación de tiempos
        System.out.println("Comparación de tiempos de ejecución:");
        System.out.println("Bidimensional: " + durationBidimensional + " ms");
        System.out.println("Unidimensional: " + durationUnidimensional + " ms");
    }
}
