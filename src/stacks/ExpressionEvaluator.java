package stacks;

/**
 * A comprehensive expression evaluator that handles infix, postfix, and prefix expressions.
 * Provides functionality to convert between different notations and evaluate expressions.
 *
 * @author ousainoujaiteh
 */
public class ExpressionEvaluator {

    /**
     * Evaluates an infix expression.
     * Example: "2 + 3 * 4"
     *
     * @param expression the infix expression to evaluate
     * @return the result of the evaluation
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static double evaluateInfix(String expression) {
        return evaluatePostfix(infixToPostfix(expression));
    }

    /**
     * Converts an infix expression to postfix notation using the Shunting Yard algorithm.
     *
     * @param infix the infix expression to convert
     * @return the equivalent postfix expression
     * @throws IllegalArgumentException if the infix expression is invalid
     */
    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : infix.trim().toCharArray()) {
            if (Character.isWhitespace(c)) continue;

            if (Character.isDigit(c)) {
                postfix.append(c).append(' ');
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(' ');
                }
                if (!stack.isEmpty()) stack.pop(); // Remove '('
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(c)) {
                    postfix.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(' ');
        }

        return postfix.toString().trim();
    }

    /**
     * Converts an infix expression to prefix notation.
     *
     * @param infix the infix expression to convert
     * @return the equivalent prefix expression
     * @throws IllegalArgumentException if the infix expression is invalid
     */
    public static String infixToPrefix(String infix) {
        // Reverse the infix expression
        StringBuilder reversed = new StringBuilder(infix).reverse();

        // Replace parentheses
        for (int i = 0; i < reversed.length(); i++) {
            if (reversed.charAt(i) == '(') reversed.setCharAt(i, ')');
            else if (reversed.charAt(i) == ')') reversed.setCharAt(i, '(');
        }

        // Convert to postfix and reverse again
        String postfix = infixToPostfix(reversed.toString());
        return new StringBuilder(postfix).reverse().toString();
    }

    /**
     * Evaluates a postfix expression.
     * Example: "2 3 4 * +"
     *
     * @param postfix the postfix expression to evaluate
     * @return the result of the evaluation
     * @throws IllegalArgumentException if the postfix expression is invalid
     */
    public static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) continue;

            char c = token.charAt(0);
            if (Character.isDigit(c)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(c)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression");
                }
                double b = stack.pop();
                double a = stack.pop();
                stack.push(applyOperator(c, a, b));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression");
        }
        return stack.pop();
    }

    /**
     * Evaluates a prefix expression.
     * Example: "+ * 3 4 2"
     *
     * @param prefix the prefix expression to evaluate
     * @return the result of the evaluation
     * @throws IllegalArgumentException if the prefix expression is invalid
     */
    public static double evaluatePrefix(String prefix) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = prefix.split("\\s+");

        // Process tokens in reverse order
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (token.isEmpty()) continue;

            char c = token.charAt(0);
            if (Character.isDigit(c)) {
                stack.push(Double.parseDouble(token));
            } else if (isOperator(c)) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid prefix expression");
                }
                double a = stack.pop();
                double b = stack.pop();
                stack.push(applyOperator(c, a, b));
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid prefix expression");
        }
        return stack.pop();
    }

    /**
     * Determines if a character is a valid operator.
     *
     * @param c the character to check
     * @return true if the character is an operator, false otherwise
     */
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * Returns the precedence of an operator.
     *
     * @param op the operator
     * @return the precedence value (higher means higher precedence)
     */
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    /**
     * Applies an operator to two operands.
     *
     * @param op the operator to apply
     * @param a the first operand
     * @param b the second operand
     * @return the result of the operation
     * @throws IllegalArgumentException if the operator is invalid or division by zero is attempted
     */
    private static double applyOperator(char op, double a, double b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/':
                if (b == 0) throw new IllegalArgumentException("Division by zero");
                return a / b;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
    }
}