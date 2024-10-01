package sortingAnalyser;

/**
 * An interface for sorting algorithms with visualization.
 */
public interface SortAlgorithmVisualizer {

    /**
     * Sorts the array and updates the sorting panel.
     *
     * @param array        the array to sort
     * @param sortingPanel the panel to update
     */
    void sort(int[] array, SortingPanel sortingPanel);
}

