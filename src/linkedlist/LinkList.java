package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a node in the doubly linked list used for browser history.
 *
 * @author ousainoujaiteh
 */
class Node {
    String url;
    Node prev;
    Node next;

    /**
     * Constructs a new Node with the given URL.
     *
     * @param url the URL of the web page.
     */
    public Node(String url) {
        this.url = url;
    }
}

/**
 * Manages browser history using a doubly linked list.
 *
 * @author ousainoujaiteh
 */
class BrowserHistory {
    private Node head;     // Starting page
    private Node current;  // Current page being viewed

    private List<String> bookmarks = new ArrayList<>();

    /**
     * Initializes the browser history with the homepage.
     *
     * @param homepage the homepage URL.
     */
    public BrowserHistory(String homepage) {
        head = new Node(homepage);
        current = head;
    }

    /**
     * Visits a new URL and updates the browser history.
     *
     * @param url the URL to visit.
     */
    public void visit(String url) {
        Node newNode = new Node(url);
        current.next = newNode;
        newNode.prev = current;
        current = newNode;
    }

    /**
     * Moves back in the browser history by a specified number of steps.
     *
     * @param steps the number of steps to move back.
     * @return the URL after moving back.
     */
    public String back(int steps) {
        while (current.prev != null && steps > 0) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }

    /**
     * Moves forward in the browser history by a specified number of steps.
     *
     * @param steps the number of steps to move forward.
     * @return the URL after moving forward.
     */
    public String forward(int steps) {
        while (current.next != null && steps > 0) {
            current = current.next;
            steps--;
        }
        return current.url;
    }

    /**
     * Prints the entire browser history, highlighting the current page.
     */
    public void printHistory() {
        Node temp = head;
        while (temp != null) {
            if (temp == current) {
                System.out.print("[" + temp.url + "] <-> ");
            } else {
                System.out.print(temp.url + " <-> ");
            }
            temp = temp.next;
        }
        System.out.println("None");
    }

    /**
     * Clears the browser history except for the current page.
     */
    public void clearHistory() {
        // your code here !!!
    }

    /**
     * Searches the history for URLs containing the specified keyword.
     *
     * @param keyword the keyword to search for.
     * @return a list of matching URLs.
     */
    public List<String> searchHistory(String keyword) {
        // code implementation here !!!
        return null;
    }


    /**
     * Bookmarks the current page.
     * Check if the current url is not bookmark add it to the bookmaark
     */
    public void bookmarkCurrentPage() {
       // your code here
    }

    /**
     * Retrieves the list of bookmarked URLs.
     *
     * @return a list of bookmarks.
     */
    public List<String> getBookmarks() {
        return null; // complete code implementation
    }

    /**
     * Demonstrates the functionality of the BrowserHistory class.
     *
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("homepage.com");
        browserHistory.visit("utg.gm");
        browserHistory.visit("youtube.com");
        browserHistory.visit("github.com");

        System.out.println("Current History:");
        browserHistory.printHistory();

        // Navigate back and forward
        System.out.println("\nBack 2 steps: " + browserHistory.back(2));  // Should go back to "utg.gm"
        System.out.println("Forward 1 step: " + browserHistory.forward(1));  // Should go forward to "youtube.com"

        System.out.println("\nHistory after navigation:");
        browserHistory.printHistory();
    }
}
