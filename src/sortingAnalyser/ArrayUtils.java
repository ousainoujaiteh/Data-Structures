package sortingAnalyser;

/**
 * Utility class providing a method to swap two elements in an array.
 */
public class ArrayUtils {

    /**
     * Swaps two elements in the specified array.
     *
     * @param array the array containing elements to swap
     * @param i     the index of the first element
     * @param j     the index of the second element
     */
    public static void swap(int[] array, int i, int j) {
        if (i == j) return; // No need to swap identical indices
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}

