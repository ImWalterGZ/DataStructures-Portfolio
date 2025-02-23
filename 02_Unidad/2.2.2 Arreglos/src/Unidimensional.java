import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Unidimensional {
    int filas;
    int columnas;
    int [] arreglo;

    public Unidimensional() {
        try {
            this.filas = readInteger("Ingrese la cantidad de filas");

            this.columnas = readInteger("Ingrese la cantidad de columnas");
            this.arreglo = new int[filas * columnas];

        } catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }

        this.randomValues();
    }

    public Unidimensional(int filas, int columnas){
        this.filas = filas;
        this.columnas = columnas;
        this.arreglo = new int [filas * columnas];
    }
    private int readInteger(String prompt) throws IOException {
        int result = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                BufferedReader leer = new BufferedReader(new InputStreamReader(System.in));
                System.out.println(prompt);
                String line = leer.readLine();
                result = Integer.parseInt(line);
                validInput = true;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a valid integer.");
            }
        }

        return result;

    }
    private void randomValues(){
        Random random = new Random();

        for (int i = 0; i < this.arreglo.length; i++){
                this.arreglo[i] = random.nextInt(10);
        }
    }

    public Unidimensional sumaArreglo(Unidimensional b) {
        if (b.filas != this.filas || b.columnas != this.columnas) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para la suma.");
        }

        Unidimensional producto = new Unidimensional(this.filas, this.columnas);
        for (int i = 0; i < this.arreglo.length; i++) {
            producto.arreglo[i] = this.arreglo[i] + b.arreglo[i];
        }
        return producto;
    }

    public Unidimensional restaArreglo(Unidimensional b) {
        if (b.filas != this.filas || b.columnas != this.columnas) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para la resta.");
        }

        Unidimensional producto = new Unidimensional(this.filas, this.columnas);
        for (int i = 0; i < this.arreglo.length; i++) {
            producto.arreglo[i] = this.arreglo[i] - b.arreglo[i];
        }
        return producto;
    }

    private int convertirCoordenadas(int row, int col) {
        return row * this.columnas + col;
    }

    public void setValue(int row, int col, int value) {
        if (row < 0 || row >= this.filas || col < 0 || col >= this.columnas) {
            throw new IndexOutOfBoundsException("No valido");
        }
        this.arreglo[convertirCoordenadas(row, col)] = value;
    }

    public int getValue(int row, int col) {
        if (row < 0 || row >= this.filas || col < 0 || col >= this.columnas) {
            throw new IndexOutOfBoundsException("Invalido");
        }
        return this.arreglo[convertirCoordenadas(row, col)];
    }

    public Unidimensional multiplicarArreglo(Unidimensional b) {
        if (this.columnas != b.filas) {
            throw new IllegalArgumentException(
                    "No se pueden multiplicar las matrices: " +
                            "columnas de matriz A (" + this.columnas + ") " +
                            "debe ser igual a filas de matriz B (" + b.filas + ")"
            );
        }

        Unidimensional resultado = new Unidimensional(this.filas, b.columnas);

        for (int i = 0; i < this.filas; i++) {
            for (int j = 0; j < b.columnas; j++) {
                int suma = 0;
                for (int k = 0; k < this.columnas; k++) {
                    suma += this.getValue(i, k) * b.getValue(k, j);
                }
                resultado.setValue(i, j, suma);
            }
        }

        return resultado;
    }


    @Override
    public String toString() {
        StringBuilder matriz = new StringBuilder();

        for (int i = 0; i < this.filas; i++) {
            matriz.append("| ");
            for (int j = 0; j < this.columnas; j++) {
                matriz.append(String.valueOf(getValue(i, j))).append(" ");
            }
            matriz.append("|\n");
            matriz.append("| ");
            matriz.append("--".repeat(Math.max(0, this.columnas)));
            matriz.append("|\n");
        }
        return matriz.toString();
    }




}
