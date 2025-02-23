import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void captura(double [][] matriz) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader leer = new BufferedReader(in);

        try {
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.printf("Ingrese el valor [%d][%d]", i,j);
                    matriz[i][j] = Double.parseDouble(leer.readLine());
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
   public static void main(String [] args){

//       double [] array = new double[20];
//       double [] array1 = {1.2,3.2,35.4,1.2,1.0,2.3};
//       // Esta declaración sucede en el heap.
//       double [] array2 = new double[]{2.12,2.1,4.2};
//
//       int [][] matriz = new int[2][2];
//       int [][] matriz1 = {
//               {1,1,1,1,1},
//               {2,2,2,2,2}};
//       // las matrices pueden no ser cuadradas
//       int [][] matriz2 = new int[2][3];
//       int [][] matriz3 = new int[3][2];
//       // Podemos dejar la cantidad de elementos por lsta vacía
//       int [][] matrix = new int[3][];
//
//       matrix[0] = new int[10];
//       matrix[1] = new int[5];
//       matrix[2] = new int[2];
//
//       System.out.println(Arrays.toString(matrix));

       double [][] A = new double[2][2];
       double [][] B = new double[2][2];
       double [][] C = new double[2][2];

       captura(A);
       captura(B);




       for (int i = 0; i < A.length; i++) {
           for (int j = 0; j < B.length; j++) {
            C[i][j] = A[i][j] + B[i][j];
           }

       }

       for (int i = 0; i < A.length ; i++) {
           System.out.printf(" %s \n", Arrays.toString(C[i]));

       }





   }
}