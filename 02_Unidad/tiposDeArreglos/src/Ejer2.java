import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ejer2 {
    char[][] arregloLetras;
    int totalVocales;
    char[] arregloVocales;
    int[] cantidadVocales;
    char[] vocales;

    public Ejer2(){
        int valorX = 0, valorY = 0;
        cantidadVocales = new int[]{0,0,0,0,0};
        vocales = new char[]{'a', 'e', 'i', 'o', 'u'};
        try{
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader leer = new BufferedReader(inputStreamReader);
            System.out.println("Numero de filas:");
              valorX = Integer.parseInt(leer.readLine());
            System.out.println("Numero de columnas");
              valorY = Integer.parseInt(leer.readLine());



        arregloLetras = new char[valorX][valorY];

        for (int i = 0; i < arregloLetras.length; i++){
            for (int j = 0 ; j < arregloLetras[0].length ; j++){
                System.out.println("Inserta letra " + i + " " + j);
                arregloLetras[i][j] = leer.readLine().charAt(0);
            }
        }
        } catch (IOException e ){
            System.out.println(e.getMessage());
        }
    }

    public void vocales(){
        // Usaré esta función para darle memoria y asignar valores a los diferentes atributos de la clase

        //? Definir total de vocales

        for (char[] arregloLetra : arregloLetras) {
            // Nunca habia usado for mejorados, están padres
            for (int j = 0; j < arregloLetras[0].length; j++) {
                char minus = Character.toLowerCase(arregloLetra[j]);
                if     (minus == 'a' ||
                        minus == 'e' ||
                        minus == 'i' ||
                        minus == 'o' ||
                        minus == 'u') {
                    totalVocales++;
                }
            }
        }
        System.out.printf("Total de vocales: %d \n",totalVocales);

        //? Crear arreglo con las vocales
        arregloVocales = new char[totalVocales];
        int z = 0;
        for (char[] arregloLetra : arregloLetras) {
            // Nunca habia usado for mejorados, están padres
            for (int j = 0; j < arregloLetras[0].length; j++) {
                char minus = Character.toLowerCase(arregloLetra[j]);
                if     (minus == 'a' ||
                        minus == 'e' ||
                        minus == 'i' ||
                        minus == 'o' ||
                        minus == 'u') {
                    arregloVocales[z++] = minus;
                }
            }
        }
        System.out.println(Arrays.toString(arregloVocales));

        //? Determinar la cantidad de ocurrencias de cada vocal
        z = 0;
        for (char[] arregloLetra : arregloLetras) {
            // Nunca habia usado for mejorados, están padres
            for (int j = 0; j < arregloLetras[0].length; j++) {
                char minus = Character.toLowerCase(arregloLetra[j]);
                if     (minus == 'a'){
                    cantidadVocales[0] += 1;
                } else if (minus == 'e'){
                    cantidadVocales[1] += 1;
                } else if(minus == 'i') {
                    cantidadVocales[2] += 1;
                } else if (minus == 'o') {
                    cantidadVocales[3] += 1;
                } else if (minus == 'u') {
                    cantidadVocales[4] += 1;
                }
            }
        }

        for (int k = 0; k < vocales.length; k++){
            System.out.printf("Cantidad de %c = %d\n", vocales[k], cantidadVocales[k]);
        }
    }
    public boolean buscaPalabras(){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader leer = new BufferedReader(inputStreamReader);
        try {
            System.out.println("Ingresa la palabra a buscar");
            String word = leer.readLine();
            return buscaPalabra(word, 0);
        } catch ( IOException e) {
            System.out.println(e.getMessage());



        }
        return false;
    }

    public boolean buscaPalabra(String word, int index){
        // Recursivo por que a lo que sabe el omelete
        char actual = Character.toLowerCase(word.charAt(index));
        for (int i = 0; i < arregloLetras.length; i++){
            for (int j = 0; j < arregloLetras[0].length; j++){
                if (actual == arregloLetras[i][j]){
                    if (index == word.length() - 1){
                        System.out.println("Palabra a buscar: "+ word);
                        System.out.println("La palabra si se encuentra en la matriz");
                        return true;
                    } else{
                        return buscaPalabra(word, ++index);
                    }
                }
            }
        }
        System.out.println("Palabra a buscar: " + word);
        System.out.println("No está en el arreglo");
        return false;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Matriz letras:\n");

        for (char[] fila : arregloLetras) {
            sb.append("|| ");
            for (int valor : fila) {
                sb.append(String.format("%c ", valor));
            }
            sb.append("|\n");
        }

        return sb.toString();
    }




}
