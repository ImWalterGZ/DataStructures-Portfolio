import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Carrera {
    private String[] nombres;
    private char[] generos;
    private int[] edades;
    private boolean[] maestrias;
    private int cantidad;

    // Constructor principal que pide los datos
    public Carrera() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader leer = new BufferedReader(inputStreamReader);

            System.out.println("Ingrese la cantidad de maestros:");
            cantidad = Integer.parseInt(leer.readLine());

            nombres = new String[cantidad];
            generos = new char[cantidad];
            edades = new int[cantidad];
            maestrias = new boolean[cantidad];

            for (int i = 0; i < cantidad; i++) {
                System.out.println("\nDatos del maestro " + (i+1));
                System.out.println("Ingrese el nombre del maestro:");
                nombres  [i] = leer.readLine();

                System.out.println("Ingrese el genero del maestro: H - M");
                generos  [i] = leer.readLine().toUpperCase().charAt(0);

                System.out.println("Ingrese la edad del maestro:");
                edades   [i] = Integer.parseInt(leer.readLine());

                System.out.println("Tiene maestría? Y - N");
                maestrias[i] = Character.toUpperCase(leer.readLine().charAt(0)) == 'Y';
            }

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }


    public double calcularEdadPromedio() {
        int suma = 0;
        for (int edad : edades) {
            suma += edad;
        }
        return (double) suma / cantidad;
    }


    public String obtenerProfesorMasJoven() {
        int indiceMinimo = 0;
        for (int i = 0; i <= cantidad - 1; i++) {
            if (edades[i] < edades[indiceMinimo]) {
                indiceMinimo = i;
            }
        }
        return nombres[indiceMinimo];
    }

    public int contarProfesoresMenoresAlPromedio() {
        double promedio = calcularEdadPromedio();
        int contador = 0;
        for (int edad : edades) {
            if (edad < promedio) {
                contador++;
            }
        }
        return contador;
    }

    public int contarMujeres() {
        int contador = 0;
        for (char genero : generos) {
            if (genero == 'M') {
                contador++;
            }
        }
        return contador;
    }

    public int contarProfesoresConMaestria() {
        int contador = 0;
        for (boolean tieneMaestria : maestrias) {
            if (tieneMaestria) {
                contador++;
            }
        }
        return contador;
    }
}
