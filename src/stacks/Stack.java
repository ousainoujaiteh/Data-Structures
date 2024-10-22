package stacks;

/**
 * A generic stack implementation using a singly linked list.
 *
 * @param <E> the type of elements held in this stack
 */
public class Stack<E> {

    /**
     * The top node of the stack.
     */
    private Node<E> top;

    /**
     * The number of elements in the stack.
     */
    private int size;

    /**
     * Constructs an empty stack.
     */
    public Stack() {
        top = null;
        size = 0;
    }

    /**
     * Pushes an item onto the top of this stack.
     *
     * @param element the element to be pushed onto this stack
     */
    public void push(E element) {
        Node<E> newNode = new Node<>(element, top);
        top = newNode;
        size++;
    }

    /**
     * Removes and returns the element at the top of this stack.
     *
     * @return the element at the top of this stack
     * @throws java.util.EmptyStackException if this stack is empty
     */
    public E pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        E element = top.data;
        top = top.next;
        size--;
        return element;
    }

    /**
     * Looks at the element at the top of this stack without removing it from the stack.
     *
     * @return the element at the top of this stack
     * @throws java.util.EmptyStackException if this stack is empty
     */
    public E peek() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return top.data;
    }

    /**
     * Tests if this stack is empty.
     *
     * @return {@code true} if and only if this stack contains no items; {@code false} otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Returns the number of elements in this stack.
     *
     * @return the number of elements in this stack
     */
    public int size() {
        return size;
    }

    /**
     * Removes all elements from this stack.
     */
    public void clear() {
        top = null;
        size = 0;
    }

    /**
     * Returns a string representation of this stack. The string representation
     * consists of a list of the stack's elements in the order they are returned
     * by its iterator, enclosed in square brackets ("[]"). Adjacent elements are
     * separated by the characters ", " (comma and space).
     *
     * @return a string representation of this stack
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Node<E> current = top;
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
     * A private static class representing a node in the stack.
     *
     * @param <E> the type of elements held in this node
     */
    private static class Node<E> {
        /**
         * The data stored in this node.
         */
        private E data;

        /**
         * The next node in the stack.
         */
        private Node<E> next;

        /**
         * Constructs a new node with the specified data and next node.
         *
         * @param data the data to be stored in this node
         * @param next the next node in the stack
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
}

