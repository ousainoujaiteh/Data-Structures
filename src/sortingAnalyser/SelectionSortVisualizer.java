package sortingAnalyser;

/**
 * A class that provides a visualized Selection Sort algorithm.
 */
public class SelectionSortVisualizer {

    /**
     * Sorts the array using Selection Sort and updates the sorting panel.
     *
     * @param array        the array to sort
     * @param sortingPanel the panel to update
     */
    public static void sort(int[] array, SortingPanel sortingPanel) {
        int n = array.length;
        try {
            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                sortingPanel.highlight(minIdx);
                for (int j = i + 1; j < n; j++) {
                    sortingPanel.compare(minIdx, j);
                    Thread.sleep(50);

                    if (array[j] < array[minIdx]) {
                        minIdx = j;
                        sortingPanel.highlight(minIdx);
                        Thread.sleep(50);
                    }
                }
                ArrayUtils.swap(array, minIdx, i);
                sortingPanel.repaint();
                Thread.sleep(50);
            }
            sortingPanel.resetHighlights();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

