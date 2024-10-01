package sorting;

/**
 * @author Ousainou Jaiteh
 * <p> University of The Gambia (UTG) </p>
 * @since 2024
 * A class provides an implementation of sorting
 * Algorithms on Java
 */
public class SortingImplementation {
    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};

        selectionSort(data);

        for (int element: data){
            System.out.println("Element : " + element);
        }
    }

    public static void swapArray(int[] array,int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void bubbleSort(int[] array){
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++){
            swapped = false;
            // last i elements are already in place
            for (int j = 0; j < n - i - 1; j++){
                // Traverse the array from 0 to n - i -1
                // Swap if the element foung is greater than next element
                if (array[j] > array[j + 1]){
                    swapArray(array,i,j);
                    swapped = true;
                }
            }
            // break if no swapped is done
            if (!swapped) break;
        }
    }

    public static void selectionSort(int[] array){
        int n = array.length;
        for (int i = 0; i < n - 1; i++){
            // Find the minimum element in the unsorted array
            int minIdx = i;
            for (int j = i + 1; j < n; j++){
                if (array[j] < array[minIdx]){
                    minIdx = j;
                }
            }
            // Swap the found minimum element with first element
            swapArray(array,i,minIdx);
        }
    }

    public static void insertionSort(int[] array){
        int n = array.length;
        for (int i = 1; i < n; i++){
            int key = array[i]; // current value
            int j = i - 1; // previous element
            // Move elements greater than key to one position ahead
            while (j >= 0 && array[j] > key){
                swapArray(array,j, j + 1);
            }
        }
    }

    /**
     * Sorts an array using the Merge Sort algorithm.
     * @param arr The array to be sorted
     * @param left The starting index of the array (or subarray)
     * @param right The ending index of the array (or subarray)
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    /**
     * Merges two subarrays of arr[].
     * First subarray is arr[left..mid]
     * Second subarray is arr[mid+1..right]
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        // Calculate sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        // Merge the temp arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    /**
     * Sorts an array using the Quick Sort algorithm.
     * @param arr The array to be sorted
     * @param low Starting index
     * @param high Ending index
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // pi is partitioning index, arr[pi] is now at right place
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * This function takes last element as pivot, places the pivot element at its
     * correct position in sorted array, and places all smaller elements to left of
     * pivot and all greater elements to right of pivot.
     */
    private static int partition(int[] arr, int low, int high) {
        // Choose the rightmost element as pivot
        int pivot = arr[high];
        // Index of smaller element and indicates the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;    // increment index of smaller element

                // Swap elements
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Place the pivot in its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


}
