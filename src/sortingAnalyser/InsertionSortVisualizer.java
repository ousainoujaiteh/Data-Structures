package sortingAnalyser;

/**
 * A class that provides a visualized Insertion Sort algorithm.
 */
public class InsertionSortVisualizer {

    /**
     * Sorts the array using Insertion Sort and updates the sorting panel.
     *
     * @param array        the array to sort
     * @param sortingPanel the panel to update
     */
    public static void sort(int[] array, SortingPanel sortingPanel) {
        int n = array.length;
        try {
            for (int i = 1; i < n; ++i) {
                int key = array[i];
                int j = i - 1;

                sortingPanel.highlight(i);
                Thread.sleep(30);

                while (j >= 0 && array[j] > key) {
                    array[j + 1] = array[j];
                    j = j - 1;

                    sortingPanel.repaint();
                    sortingPanel.highlight(j);
                    Thread.sleep(30);
                }
                array[j + 1] = key;
                sortingPanel.repaint();
                Thread.sleep(30);
            }
            sortingPanel.resetHighlights();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

