import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    // Este metodo no regresa nada, ya que toma la lista como objeto y altera el objeto en lugar de una copia
    public static void captura(Double [] sueldos){
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader leer = new BufferedReader(in);
        Double alto = 0.0, bajo = 0.0;

        try{
            // Estamos iterando mientras que i sea menor a la longitud del array, ya que el array tiene
            // 10 posiciones, pero tenemos que tener en cuenta la posicion 0 / 9, en lugar de 1 /10
            for (int i = 0; i < sueldos.length; i++){
                System.out.println("Ingrese el sueldo: " + (i + 1));
                sueldos[i] = Double.parseDouble(leer.readLine());
                if (sueldos[i] > alto){
                    alto = sueldos[i];
                }
                if (i == 0){
                    bajo = sueldos[i];
                }
                if (sueldos[i] < bajo){
                    bajo = sueldos[i];
                }


            }
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
        System.out.printf("Valor mas alto %f", alto);
        System.out.printf("Valor mas bajo %f", bajo);


    }

    static double sueldoAlto(double[] sueldos){
        double mayorD = sueldos[0];

        for (double in: sueldos){
            if (in > mayorD){
                mayorD = in;
            }
        }
        return mayorD;
    }
    static double sueldoBajo(double[] sueldos){
        double bajo = sueldos[0];

        for (double in: sueldos){
            if (in < bajo){
                bajo = in;
            }
        }
        return bajo;
    }
    public static void main(String[] args) {

        Double [] sueldos = new Double[10];


        captura(sueldos);
        double suma = sumaSalarios(sueldos);
        System.out.println(suma);
        System.out.println(Arrays.toString(sueldos));


        // Paso de variable por referencia
        // En java las unicas variables que se pasan por referencia son los objetos.
        // Los primitivos se pasan los valores, se toma una copia del valor.
        // Cuando es por referencia, le estoy diciendo que le estoy pasando la direccion de memoria







        // hacer un programa que utilizando un array almacene
        // 10 salarios de los trabajadores

        // El prgrama realizará la suma de los salarios para calcular el salario promedio
        // Además, encontrará la posicion del salario mas alto y mas bajo
        // Relizelo toddo con funciones estáticas

        // Necesitaremos tres metodos




    }

    private static double sumaSalarios(Double[] sueldos) {

        double total = 0.0;

        if (sueldos == null){
            return 0;
        } else {
            for (double in: sueldos){
                total += in;
            }
        }
        return total;


    }
}
