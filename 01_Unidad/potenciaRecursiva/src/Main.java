import javax.tools.SimpleJavaFileObject;

public class Main {
    static int intentos = 1;
    public static double pow (double number, int potencia){
        System.out.println(intentos++);

        // Caso base - Cuando se va a detener
        if (potencia == 0) return 1;
        if (potencia == 1) return number;
        return number * pow(number, potencia-1);

    }

    public static void imprimirArray(double [] array, int indice) {
        System.out.println(array[indice]);
        if (indice > 0 ){
            imprimirArray(array, --indice);
        }


    }



    private static int ocurrencias(int i,  int [] array, int x){
        if (array[i] == x){

            if (i==array.length-1){
                return 1;
            }
            return 1 + ocurrencias(++i,array,x);



        } else {
            if (i==array.length-1){
                return 0;
            }
            return 0 + ocurrencias(++i,array,x);

        }

        }
    private static int ocurrencias1(int j,  int [] array1, int y){
        if (j == array1.length){
            return 0;
        }
        if (array1[j] == y){
            return 1 + ocurrencias1(++j, array1, y);
        } else{
            return ocurrencias1(++j, array1, y);
        }
    }

    public static double sumaMatriz(int i, double [][] array){
        if (i == array.length){
            return 0;
        }   
        return sumArray(0, array[i++]) + sumaMatriz(i, array);

    }

    private static double sumArray(int indice, double [] array){
        double actual = array[indice];
        if (indice++ < array.length-1){
            return actual + sumArray(indice, array);
        } else {
            return actual;
        }

    }


    public static void main(String[] args) {
        // System.out.println(sumArray(0,new double[] {1,2,3}));
        // imprimirArray(new double[] {1,2,3}, 2);
        double[][] array1 = {
                {1.0, 1.0, 1.0},
                {4.5},
                {10, 10, 10}
        };
        System.out.println(sumaMatriz(0, array1));

    }

}