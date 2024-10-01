package sortingAnalyser;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * A panel that displays the array as a series of bars.
 */
public class SortingPanel extends JPanel {

    private int[] array;
    private int highlightedIndex = -1;
    private int comparedIndex = -1;

    public SortingPanel() {
        generateNewArray();
    }

    /**
     * Generates a new random array.
     */
    public void generateNewArray() {
        int size = 50;
        array = new int[size];
        Random rand = new Random();

        int height = getHeight();
        if (height <= 0) {
            height = 400;
        }

        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(height);
        }
        repaint();
    }


    /**
     * Returns the array to be sorted.
     *
     * @return the array
     */
    public int[] getArray() {
        return array;
    }

    /**
     * Highlights a specific index during sorting.
     *
     * @param index the index to highlight
     */
    public void highlight(int index) {
        this.highlightedIndex = index;
        repaint();
    }

    /**
     * Highlights two indices being compared.
     *
     * @param index1 the first index
     * @param index2 the second index
     */
    public void compare(int index1, int index2) {
        this.highlightedIndex = index1;
        this.comparedIndex = index2;
        repaint();
    }

    /**
     * Resets the highlights.
     */
    public void resetHighlights() {
        this.highlightedIndex = -1;
        this.comparedIndex = -1;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (array == null) return;

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / array.length;

        for (int i = 0; i < array.length; i++) {
            if (i == highlightedIndex) {
                g.setColor(Color.RED);
            } else if (i == comparedIndex) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.GRAY);
            }
            int barHeight = array[i];
            g.fillRect(i * barWidth, height - barHeight, barWidth, barHeight);
        }
    }
}

