package sortingAnalyser;

/**
 * A class that provides a visualized Quick Sort algorithm.
 */
public class QuickSortVisualizer {

    /**
     * Sorts the array using Quick Sort and updates the sorting panel.
     *
     * @param array        the array to sort
     * @param sortingPanel the panel to update
     */
    public static void sort(int[] array, SortingPanel sortingPanel) {
        try {
            quickSort(array, 0, array.length - 1, sortingPanel);
            sortingPanel.resetHighlights();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Recursively sorts the array using Quick Sort algorithm.
     *
     * @param array        the array to sort
     * @param low          the starting index
     * @param high         the ending index
     * @param sortingPanel the panel to update
     * @throws InterruptedException if the thread is interrupted
     */
    private static void quickSort(int[] array, int low, int high, SortingPanel sortingPanel) throws InterruptedException {
        if (low < high) {
            int pi = partition(array, low, high, sortingPanel);

            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1, sortingPanel);
            quickSort(array, pi + 1, high, sortingPanel);
        }
    }

    /**
     * Partitions the array and updates the sorting panel.
     *
     * @param array        the array to partition
     * @param low          the starting index
     * @param high         the ending index
     * @param sortingPanel the panel to update
     * @return the partitioning index
     * @throws InterruptedException if the thread is interrupted
     */
    private static int partition(int[] array, int low, int high, SortingPanel sortingPanel) throws InterruptedException {
        int pivot = array[high];
        sortingPanel.highlight(high); // Highlight pivot
        Thread.sleep(10);

        int i = (low - 1); // Index of smaller element
        for (int j = low; j <= high - 1; j++) {
            sortingPanel.compare(j, high); // Compare current element with pivot
            Thread.sleep(10);

            if (array[j] < pivot) {
                i++;
                ArrayUtils.swap(array, i, j);
                sortingPanel.repaint();
                Thread.sleep(10);
            }
        }
        ArrayUtils.swap(array, i + 1, high);
        sortingPanel.repaint();
        Thread.sleep(10);

        return i + 1;
    }
}

