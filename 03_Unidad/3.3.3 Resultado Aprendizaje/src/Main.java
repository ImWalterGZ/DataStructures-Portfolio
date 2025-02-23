import Ejercicio1.Terna;
import Ejercicio2.ListaNumbers;
import Ejercicio3.Sets;
import Ejercicio1.ListaResumen;
import lista.DLinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean exit = false;

        while (!exit) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Operaciones con Lista de ternas");
            System.out.println("2. Operaciones con Listas de numeros");
            System.out.println("3. Operaciones con Sets");
            System.out.println("4. Salir");

            try {
                int choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        menuListaResumen(reader);
                        break;
                    case 2:
                        menuListaNumbers(reader);
                        break;
                    case 3:
                        resolverProblemasSets();
                        break;
                    case 4:
                        exit = true;
                        System.out.println("Au revoir");
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (IOException | NumberFormatException e) {
                System.out.println("Error al leer la opción. Intente de nuevo.");
            }
        }
    }

    private static void menuListaNumbers(BufferedReader reader) {
        try {
            System.out.println("Ingrese el primer número:");
            int num1 = Integer.parseInt(reader.readLine());
            System.out.println("Ingrese el segundo número:");
            int num2 = Integer.parseInt(reader.readLine());

            ListaNumbers lnum1 = new ListaNumbers(num1);
            ListaNumbers lnum2 = new ListaNumbers(num2);

            boolean backToMenu = false;
            while (!backToMenu) {
                System.out.println("Seleccione una operación:");
                System.out.println("1. Convertir número a lista");
                System.out.println("2. Convertir lista a número");
                System.out.println("3. Multiplicar números");
                System.out.println("4. Volver al menú principal");

                int choice = Integer.parseInt(reader.readLine());
                switch (choice) {
                    case 1:
                        System.out.println("Lista del primer número: " + lnum1);
                        System.out.println("Lista del segundo número: " + lnum2);
                        break;
                    case 2:
                        System.out.println("Número del primer lista: " + lnum1.convertirListaANumero());
                        System.out.println("Número del segundo lista: " + lnum2.convertirListaANumero());
                        break;
                    case 3:
                        ListaNumbers R = new ListaNumbers(0);
                        R = lnum1.generar_multiplicacion(lnum1, lnum2, R);
                        System.out.println("El producto de " + num1 + " y " + num2 + " es: " + R.convertirListaANumero());
                        System.out.println("Lista del producto: " + R);
                        break;
                    case 4:
                        backToMenu = true;
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer la entrada. Intente de nuevo.");
        }
    }

    private static void menuListaResumen(BufferedReader reader) {
        try {
            DLinkedList<Character> lista1 = new DLinkedList<>();
            DLinkedList<Character> lista2 = new DLinkedList<>();

            System.out.println("Ingrese el número de elementos para la primera lista:");
            int n1 = Integer.parseInt(reader.readLine());
            System.out.println("Ingrese los elementos de la primera lista (un solo carácter por línea):");
            for (int i = 0; i < n1; i++) {
                String input = reader.readLine();
                if (input.length() > 0) {
                    lista1.add(input.charAt(0));
                } else {
                    System.out.println("Entrada vacía, intente de nuevo.");
                    i--;
                }
            }

            System.out.println("Ingrese el número de elementos para la segunda lista:");
            int n2 = Integer.parseInt(reader.readLine());
            System.out.println("Ingrese los elementos de la segunda lista (un solo carácter por línea):");
            for (int i = 0; i < n2; i++) {
                String input = reader.readLine();
                if (input.length() > 0) {
                    lista2.add(input.charAt(0));
                } else {
                    System.out.println("Entrada vacía, intente de nuevo.");
                    i--;
                }
            }

            ListaResumen<Character> listaResumen = new ListaResumen<>();

            long startTime = System.nanoTime();

            DLinkedList<Terna<Character>> resumen = listaResumen.generarListaResumen(lista1, lista2);

            long endTime = System.nanoTime();
            long duration = (endTime - startTime);

            System.out.println("Tiempo de ejecución: " + duration + " nanosegundos");
            System.out.println("Resumen de las listas:");
            Iterator<Terna<Character>> iterator = resumen.right();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer la entrada. Intente de nuevo.");
        }
    }


    private static void resolverProblemasSets() {
        Sets<Integer> frances = new Sets<>();
        Sets<Integer> aleman = new Sets<>();
        Sets<Integer> espanol = new Sets<>();

        frances.add(30);
        frances.add(7);
        frances.add(3);
        frances.add(2);

        aleman.add(20);
        aleman.add(5);
        aleman.add(3);
        aleman.add(2);

        espanol.add(13);
        espanol.add(5);
        espanol.add(3);
        espanol.add(7);

        System.out.println("\nConjuntos iniciales:");
        System.out.println("Set frances: " + frances);
        System.out.println("Set aleman: " + aleman);
        System.out.println("Set espanol: " + espanol);


        Sets<Integer> espanolAleman = espanol.union(aleman);
        System.out.println("Unión de espanol y aleman: " + espanolAleman);

        Sets<Integer> soloFrances = frances.difference(espanolAleman);
        System.out.println("Alunmnos que solo están en francés: " + soloFrances);
        Sets<Integer> todos = espanolAleman.union(frances);
        int cantAlumnos = todos.sumaConjunto();
        System.out.println("Cantidad de alumnos que no estudian idiomas: " + (100 - cantAlumnos));
    }

}