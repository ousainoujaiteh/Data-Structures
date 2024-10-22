package stacks;

public class StackTester {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack
        System.out.println("Stack: " + stack);

        // Peek at the top element
        System.out.println("Top element: " + stack.peek());

        // Pop an element
        System.out.println("Popped element: " + stack.pop());

        // Check if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Get the size of the stack
        System.out.println("Stack size: " + stack.size());

        // Clear the stack
        stack.clear();
        System.out.println("Stack after clearing: " + stack);
    }
}

