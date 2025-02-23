import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

public class Ejer1 {

    int[][] arreglo;
    Random random;
    int[] listadoSumas;
    int[] listaPrimos;

    public Ejer1(int valorX, int valorY, boolean flag) {
        arreglo = new int[valorX][valorY];
        if (flag == true){
            capturaDatos(this.arreglo);
        }
        else {
            random = new Random();
            for (int i = 0; i < arreglo.length; i++){
                for (int j = 0; j < arreglo[0].length; j++) {
                    arreglo[i][j] = random.nextInt(150);
                }

            }

        }
    }
    public Ejer1() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader leer = new BufferedReader(inputStreamReader);

            System.out.println("Ingrese el número de filas:");
            int valorX = Integer.parseInt(leer.readLine());

            System.out.println("Ingrese el número de columnas:");
            int valorY = Integer.parseInt(leer.readLine());

            arreglo = new int[valorX][valorY];
            capturaDatos(this.arreglo);
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Número inválido, por favor intente de nuevo.");
        }
    }

    public void capturaDatos(int[][] arreglo){
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader leer = new BufferedReader(in);

        for (int i = 0; i < arreglo.length; i++){
            for (int j = 0; j < arreglo[0].length; j++) {
                boolean valido = false;
                while(!valido){
                        System.out.println("Ingrese el valor de la coordenada: "+ i + " " + j);

                        try{
                            try{
                                arreglo[i][j] = Integer.parseInt(leer.readLine());

                            } catch (IOException e){
                                System.out.println(e.getMessage());
                            }
                            valido = true;
                        } catch (NumberFormatException f){
                            System.out.println("Numero invalido, vuelve a intentar");

                        }

                }

            }

        }
    }

    public void llenarAlea() {
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo[0].length; j++) {
                arreglo[i][j] = random.nextInt(0, 10);

            }
        }

    }
    public void mayoresmenores(){
        System.out.println("Fila con mayor sumatoria ⬆\uFE0E = Fila " + obtenerPosicion(verificarMasalto(listadoSumas,0), listadoSumas, 0));

        System.out.println("Fila con menor sumatoria ⬇\uFE0E  = Fila " + obtenerPosicion(verificarMasBajo(listadoSumas,0), listadoSumas, 0));

    }

    public int sumatoria(){
        listadoSumas = new int[this.arreglo.length];

        for (int i = 0; i < this.arreglo.length; i++){
            int cont = 0;
            for (int k = 0 ; k < this.arreglo[0].length; k++){
                cont += this.arreglo[i][k];
            }
            listadoSumas[i] = cont;
            //System.out.println("Fila " + i + " = " + listadoSumas[i]);
        }

        // viva la recursividad

        return obtenerPosicion(verificarMasalto(listadoSumas,0), listadoSumas, 0);
    }

    public int[] monterrey(){

        int[] listadoPrimos = new int[contarPrimos(this, 0)];
        int z = 0;
        for (int i = 0; i < this.arreglo.length; i++){
            for (int j = 0; j < this.arreglo[0].length ; j++){
                if (isPrimo(this.arreglo[i][j],2)){
                    listadoPrimos[z++] = this.arreglo[i][j];
                    System.out.printf("%d ",this.arreglo[i][j]);
                }
            }
        }
        return listadoPrimos;
    }

    public int contarPrimos(Ejer1 arreglo, int index){
        int cont = 0;
        for (int i = 0; i < arreglo.arreglo.length; i++){
            for (int j = 0; j < arreglo.arreglo[0].length ; j++){
                if (isPrimo(arreglo.arreglo[i][j],2)){
                    cont++;
                }
            }
        }
        System.out.println("Cantidad numeros primos en la matriz = " + cont);
        return cont;
    }

    public boolean isPrimo(int valor,int divisor){
        return valor == 1 || valor == 0  ? false : divisor < valor ? valor % divisor == 0 ? false : isPrimo(valor, ++ divisor) : true;

    }

    public int verificarMasalto(int[] valores, int index){

        if(index == valores.length -1){
            return valores[index];
        }
        int valor = valores[index];
        int nextValor = verificarMasalto(valores, ++ index);
        return valor > nextValor ? valor : nextValor;

    }
    public int verificarMasBajo(int[] valores, int index){

        if(index == valores.length -1){
            return valores[index];
        }
        int valor = valores[index];
        int nextValor = verificarMasBajo(valores, ++ index);
        return valor < nextValor ? valor : nextValor;

    }

    public int obtenerPosicion(int buscado, int[] valores, int index ){
        try {
            return valores[index] == buscado ? index : obtenerPosicion(buscado, valores, ++index);
        } catch (NoSuchElementException e){
            System.out.println(e);
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Matriz:\n");

        for (int[] fila : arreglo) {
            sb.append("|| ");
            for (int valor : fila) {
                sb.append(String.format("%3d ", valor));
            }
            sb.append("|\n");
        }

        return sb.toString();
    }




}