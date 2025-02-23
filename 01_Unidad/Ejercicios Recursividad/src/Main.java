import java.util.Locale;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static int conejitos(int i){
        if (i == 0){
            return 0 ;
        }
        if (i % 2 == 1){
            return 2 + conejitos(--i);
        }
        else return 3 + conejitos(--i);


    }

    public static String asterisco(String word){
        return asterisco(word, 0);

    }

    public static String asterisco(String word, int pos){
        if (word.length() == 1){
            return String.valueOf(word.charAt(0));
        } else{

            if (String.valueOf(word.charAt(0)).equals(String.valueOf(word.charAt(1)))){
                return  (String.valueOf(word.charAt(0)))+"*"+asterisco(word.substring(1), --pos)  ;
            }
            return String.valueOf(word.charAt(0))+asterisco(word.substring(1), --pos);
        }


    }

    public static String binarios(int number){
        if (number == 0 ) return "0";
        if (number == 1){
            return "1";
        }
        if (number % 2 == 0){
            return  binarios(number/2) + "0";
        }
        return  binarios(number/2) + "1";


    }

    public static String inverse(String word){
        if (word.charAt(0))
    }





    public static void main(String[] args) {
        String hola = "Hola";
        // System.out.println(conejitos(2));
        System.out.println(asterisco("         "));
        System.out.println(binarios(100));

    }
}