import java.util.Arrays;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


//
//!      Ejercicio 1, matriz con numeros primos
//        Ejer1 arrayInicial = new Ejer1();
//
//        System.out.println("Filas: "+arrayInicial.arreglo.length);
//        System.out.println("Columnas: "+arrayInicial.arreglo[0].length);
//        System.out.println(arrayInicial.toString());
//        arrayInicial.sumatoria();
//
//        System.out.println("Arreglo con sumas:" + Arrays.toString(arrayInicial.listadoSumas));
//        arrayInicial.mayoresmenores();
//
//        arrayInicial.monterrey();


////!       Ejercicio 2, matriz con letras
        Ejer2 matrizLetras = new Ejer2();
        System.out.println(matrizLetras.toString());
        matrizLetras.vocales();

        matrizLetras.buscaPalabras();

//!       Ejercicio 3, profesores de la UTCH

        Carrera carrera = new Carrera();
        System.out.println("La edad promedio es: " + carrera.calcularEdadPromedio());
        System.out.println("El profesor mas joven es: " + carrera.obtenerProfesorMasJoven());
        System.out.println("Hay " + carrera.contarProfesoresMenoresAlPromedio() + " debajo de la edad promedio");
        System.out.println("Hay " + carrera.contarMujeres() + " maestras en la escuela");
        System.out.println("Hay " + carrera.contarProfesoresConMaestria() + " profesores con maestría");


    }
}