import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int seed = 3;
        int[] diagonal = new int[seed * seed];

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader leer = new BufferedReader(in);

        System.out.println("Ingrese la semilla");

        int[] mat = new int[seed * seed];
        int contador = 0;

        for (int i = 0; i < seed; i++) {
            for (int j = 0; j < seed; j++) {
                // if corto
                // Vamos a asignar 1 o 0 dependiendo la comparación de I == J a la posición del array
                // mat[seed * i + j] = i == j? 1 : 0;

                if (i == j) {
                    mat[contador] = 1;
                } else {
                    mat[contador] = 0;
                }
                contador++;
                System.out.printf("%d ", mat[contador-1]);

            }
            System.out.println();


        }


    }
}
