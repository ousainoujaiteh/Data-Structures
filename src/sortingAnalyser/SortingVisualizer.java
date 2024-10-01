package sortingAnalyser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The main class that sets up the GUI for the sorting visualizer.
 */
public class SortingVisualizer extends JFrame {

    private SortingPanel sortingPanel;
    private JComboBox<String> algorithmComboBox;
    private JButton startButton;

    public SortingVisualizer() {
        setTitle("Sorting Algorithm Visualizer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Initialize components
        sortingPanel = new SortingPanel();
        algorithmComboBox = new JComboBox<>(new String[]{
                "Bubble Sort",
                "Selection Sort",
                "Insertion Sort",
                "Merge Sort",
                "Quick Sort"
        });
        startButton = new JButton("Start Sorting");

        // Set up control panel
        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Select Algorithm:"));
        controlPanel.add(algorithmComboBox);
        controlPanel.add(startButton);

        // Add components to frame
        add(sortingPanel, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        // Add action listener to the start button
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSorting();
            }
        });
    }

    /**
     * Starts the sorting animation based on the selected algorithm.
     */
    private void startSorting() {
        String selectedAlgorithm = (String) algorithmComboBox.getSelectedItem();
        int[] array = sortingPanel.getArray();

        // Create a new thread to avoid blocking the GUI
        new Thread(() -> {
            switch (selectedAlgorithm) {
                case "Bubble Sort":
                    BubbleSortVisualizer.sort(array, sortingPanel);
                    break;
                case "Selection Sort":
                    SelectionSortVisualizer.sort(array, sortingPanel);
                    break;
                case "Insertion Sort":
                    InsertionSortVisualizer.sort(array, sortingPanel);
                    break;
                case "Merge Sort":
                    MergeSortVisualizer.sort(array, sortingPanel);
                    break;
                case "Quick Sort":
                    QuickSortVisualizer.sort(array, sortingPanel);
                    break;
            }
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SortingVisualizer frame = new SortingVisualizer();
            frame.setVisible(true);
        });
    }
}

