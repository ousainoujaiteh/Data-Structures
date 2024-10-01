package sortingAnalyser;

/**
 * A class that provides a visualized Bubble Sort algorithm.
 */
public class BubbleSortVisualizer {

    /**
     * Sorts the array using Bubble Sort and updates the sorting panel.
     *
     * @param array        the array to sort
     * @param sortingPanel the panel to update
     */
    public static void sort(int[] array, SortingPanel sortingPanel) {
        int n = array.length;
        boolean swapped;
        try {
            for (int i = 0; i < n - 1; i++) {
                swapped = false;
                for (int j = 0; j < n - i - 1; j++) {
                    sortingPanel.compare(j, j + 1);
                    Thread.sleep(30); // Pause for visualization

                    if (array[j] > array[j + 1]) {
                        ArrayUtils.swap(array, j, j + 1);
                        swapped = true;
                        sortingPanel.repaint();
                        Thread.sleep(30); // Pause after swap
                    }
                }
                if (!swapped) break;
            }
            sortingPanel.resetHighlights();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

