import matrices.Unimatrix;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {

    public static void leerDatos(Unimatrix a){
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader leer = new BufferedReader(in);

        for (int i = 0; i < a.getSeed() ; i++){
            for (int j = 0; j < a.getSeed(); j++) {

                try {
                    System.out.printf("Ingrese el valor de %d:%d ", i,j);

                    double valor = Double.parseDouble(leer.readLine());
                    a.set(i,j, valor);

                } catch (Exception e ){
                    System.out.println(e.getMessage());
                }


            }
        }
    }

    public static void main(String[] args) {

        Unimatrix matrizA, matrizB, matrizC;

        matrizA = new Unimatrix();
        matrizB = new Unimatrix(matrizA);
        matrizC = new Unimatrix();
        leerDatos(matrizA);


//        matrizC = matrizA.suma(matrizB);
        matrizC = matrizA.suma(matrizB);

        System.out.println(matrizC);

    }

}