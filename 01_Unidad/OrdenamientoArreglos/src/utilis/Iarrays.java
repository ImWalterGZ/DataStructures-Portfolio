package utilis;

import java.util.Random;
import java.util.Arrays;

public class Iarrays {
    private final int SIZE = 10;
    public int[] array; // Change from double[] to int[]

    public Iarrays() {
        array = new int[SIZE];
    }

    public Iarrays(int size) {
        if (size > 0) {
            array = new int[size];
            Random random = new Random();
            for (int i = 0; i < array.length; i++) {
                array[i] = random.nextInt(100); // Generate random integers
            }
            System.out.println(Arrays.toString(array));
        } else {
            array = new int[0]; // Handle case for size <= 0
        }
    }

    public int binarySearchI(int searched) {
        int start = 0, end = array.length - 1; // Corrected end index
        while (start <= end) { // Fixed condition to include end
            int center = (start + end) / 2;
            if (searched < array[center]) {
                end = center - 1;
            } else if (searched > array[center]) {
                start = center + 1;
            } else {
                return center; // Element found
            }
        }
        return -1; // Element not found
    }

    public int binariaRecursiva(int searched){
        return binariaRecursiva(searched, 0, array.length);
    }

    public int binariaRecursiva(int searched, int start, int end){
        int center = ( start + end )/2;
        if(searched == array[center]){
            return center;
        }
        if (searched > array[center]) {
            binariaRecursiva(searched, center+1,end);

        }
        if (searched < array[center]) {
            binariaRecursiva(searched,start, center-1);
        }

        if (start > end) return -1;
        return -1;
    }

    public int[] CocktailSort() {
        boolean swapped = true;
        int[] copy = Arrays.copyOf(this.array, this.array.length);

        while (swapped) {
            swapped = false;
            // Forward pass
            for (int i = 0; i < copy.length - 1; i++) {
                if (copy[i] > copy[i + 1]) {
                    int temp = copy[i];
                    copy[i] = copy[i + 1];
                    copy[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // If no swaps, array is sorted

            swapped = false;
            // Backward pass
            for (int i = copy.length - 1; i > 0; i--) {
                if (copy[i - 1] > copy[i]) {
                    int temp = copy[i - 1];
                    copy[i - 1] = copy[i];
                    copy[i] = temp;
                    swapped = true;
                }
            }
        }
        return copy; // Return the sorted array
    }
}
