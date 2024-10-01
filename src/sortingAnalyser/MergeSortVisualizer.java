package sortingAnalyser;

/**
 * A class that provides a visualized Merge Sort algorithm.
 */
public class MergeSortVisualizer {

    /**
     * Sorts the array using Merge Sort and updates the sorting panel.
     *
     * @param array        the array to sort
     * @param sortingPanel the panel to update
     */
    public static void sort(int[] array, SortingPanel sortingPanel) {
        try {
            mergeSort(array, 0, array.length - 1, sortingPanel);
            sortingPanel.resetHighlights();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Recursively sorts the array using Merge Sort algorithm.
     *
     * @param array        the array to sort
     * @param left         the starting index
     * @param right        the ending index
     * @param sortingPanel the panel to update
     * @throws InterruptedException if the thread is interrupted
     */
    private static void mergeSort(int[] array, int left, int right, SortingPanel sortingPanel) throws InterruptedException {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort first and second halves
            mergeSort(array, left, mid, sortingPanel);
            mergeSort(array, mid + 1, right, sortingPanel);

            // Merge the sorted halves
            merge(array, left, mid, right, sortingPanel);
        }
    }

    /**
     * Merges two subarrays of array[].
     *
     * @param array        the main array
     * @param left         left index
     * @param mid          middle index
     * @param right        right index
     * @param sortingPanel the panel to update
     * @throws InterruptedException if the thread is interrupted
     */
    private static void merge(int[] array, int left, int mid, int right, SortingPanel sortingPanel) throws InterruptedException {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temp arrays
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        // Merge the temp arrays back into array[left..right]
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            sortingPanel.highlight(k);
            Thread.sleep(10);

            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            sortingPanel.repaint();
            Thread.sleep(10);
            k++;
        }

        // Copy the remaining elements of L[], if any
        while (i < n1) {
            sortingPanel.highlight(k);
            Thread.sleep(10);

            array[k] = L[i];
            i++;
            k++;
            sortingPanel.repaint();
            Thread.sleep(10);
        }

        // Copy the remaining elements of R[], if any
        while (j < n2) {
            sortingPanel.highlight(k);
            Thread.sleep(10);

            array[k] = R[j];
            j++;
            k++;
            sortingPanel.repaint();
            Thread.sleep(10);
        }
    }
}

