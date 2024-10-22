package queues;

/**
 * A generic queue implementation using a singly linked list.
 *
 * @param <E> the type of elements held in this queue
 */
public class Queue<E> {

    /**
     * The front node of the queue.
     */
    private Node<E> front;

    /**
     * The rear node of the queue.
     */
    private Node<E> rear;

    /**
     * The number of elements in the queue.
     */
    private int size;

    /**
     * Constructs an empty queue.
     */
    public Queue() {
        front = rear = null;
        size = 0;
    }

    /**
     * Inserts the specified element into this queue.
     *
     * @param element the element to add
     */
    public void enqueue(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (rear != null) {
            rear.next = newNode;
        }
        rear = newNode;

        if (front == null) {
            front = rear;
        }
        size++;
    }

    /**
     * Retrieves and removes the head of this queue.
     *
     * @return the head of this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public E dequeue() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty.");
        }
        E element = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return element;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue
     * @throws java.util.NoSuchElementException if this queue is empty
     */
    public E peek() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Queue is empty.");
        }
        return front.data;
    }

    /**
     * Tests if this queue is empty.
     *
     * @return {@code true} if this queue contains no elements; {@code false} otherwise
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue
     */
    public int size() {
        return size;
    }

    /**
     * Removes all elements from this queue.
     */
    public void clear() {
        front = rear = null;
        size = 0;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return a string representation of this queue
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node<E> current = front;
        while (current != null) {
            sb.append(current.data);
            current = current.next;
            if (current != null) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    /**
     * A private static class representing a node in the queue.
     *
     * @param <E> the type of elements held in this node
     */
    private static class Node<E> {
        /**
         * The data stored in this node.
         */
        private E data;

        /**
         * The next node in the queue.
         */
        private Node<E> next;

        /**
         * Constructs a new node with the specified data and next node.
         *
         * @param data the data to be stored in this node
         * @param next the next node in the queue
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}

