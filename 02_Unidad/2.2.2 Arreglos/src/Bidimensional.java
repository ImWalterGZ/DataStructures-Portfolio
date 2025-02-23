import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Bidimensional {
    int[][] biarreglo;
    int filas;
    int columnas;

    public Bidimensional() {
        try {
            this.filas = readInteger("Ingrese la cantidad de filas");
            this.columnas = readInteger("Ingrese la cantidad de columnas");
            this.biarreglo = new int[filas][columnas];
        } catch (IOException e) {
            System.err.println("An IOException was caught: " + e.getMessage());
            e.printStackTrace();
        }

        this.randomValues();
    }
    public Bidimensional(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.biarreglo = new int[filas][columnas];
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

    private void randomValues() {
        Random random = new Random();

        for (int i = 0; i < this.biarreglo.length; i++) {
            for (int j = 0; j < this.biarreglo[0].length; j++) {
                this.biarreglo[i][j] = random.nextInt(10);
            }
        }
    }

    public Bidimensional sumaBidimensional(Bidimensional b) {
        if (this.filas != b.filas || this.columnas != b.columnas) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para la suma.");
        }

        Bidimensional producto = new Bidimensional(this.filas, this.columnas);
        for (int i = 0; i < this.biarreglo.length; i++) {
            for (int j = 0; j < this.biarreglo[0].length; j++) {
                producto.biarreglo[i][j] = this.biarreglo[i][j] + b.biarreglo[i][j];
            }
        }
        return producto;
    }

    public Bidimensional restaBidimensional(Bidimensional b) {
        if (this.filas != b.filas || this.columnas != b.columnas) {
            throw new IllegalArgumentException("Las matrices deben tener las mismas dimensiones para la resta.");
        }

        Bidimensional producto = new Bidimensional(this.filas, this.columnas);
        for (int i = 0; i < this.biarreglo.length; i++) {
            for (int j = 0; j < this.biarreglo[0].length; j++) {
                producto.biarreglo[i][j] = this.biarreglo[i][j] - b.biarreglo[i][j];
            }
        }
        return producto;
    }

    public Bidimensional multiBidimensional(Bidimensional b) {
        if (this.columnas != b.filas) {
            throw new IllegalArgumentException(
                    "No se pueden multiplicar las matrices: el número de columnas de la primera matriz debe ser igual al número de filas de la segunda matriz."
            );
        }

        Bidimensional producto = new Bidimensional(this.filas, b.columnas);
        for (int i = 0; i < producto.filas; i++) {
            for (int j = 0; j < producto.columnas; j++) {
                producto.biarreglo[i][j] = multiBidimensional(this.biarreglo[i], b.biarreglo, j);
            }
        }
        return producto;
    }

    public int multiBidimensional(int[] a, int[][] b, int j) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int multi = a[i] * b[i][j];
            sum += multi;
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder matriz = new StringBuilder();

        for (int i = 0; i < this.biarreglo.length; i++) {
            matriz.append("| ");
            for (int j = 0; j < this.biarreglo[0].length; j++) {
                matriz.append(this.biarreglo[i][j]).append(" ");
            }
            matriz.append("|\n");
            matriz.append("| ");
            matriz.append("--".repeat(Math.max(0, this.biarreglo[0].length)));
            matriz.append("|\n");
        }
        return matriz.toString();
    }
}
