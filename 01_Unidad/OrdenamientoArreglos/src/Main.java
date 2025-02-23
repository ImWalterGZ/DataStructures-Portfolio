import utilis.Iarrays;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        Iarrays metodos = new Iarrays(1000);
        int [] sorted = metodos.CocktailSort();

        metodos.array = sorted;

        System.out.println(metodos.binariaRecursiva(19));





        long end = System.currentTimeMillis();

        System.out.printf("\nSorting took %d milliseconds", end - start);
    }
}
