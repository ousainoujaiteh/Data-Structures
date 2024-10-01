package complexity;

/**
 * @author ousainoujaiteh
 * <p> University of The Gambia (UTG) </p>
 * @since 2024
 * The Complexity class provides examples of different time complexities.
 * Each method demonstrates a specific time complexity by performing operations
 * whose growth rate matches that complexity.
 */
public class Complexity {

    /**
     * Constant time complexity O(1).
     * This method performs a single operation, which does not depend on the input size.
     *
     * @param n Input parameter, but it is not used to affect the complexity.
     */
    public void constantTime(int n) {
        System.out.println("This is O(1) complexity.");  // Constant operation
    }

    /**
     * Linear time complexity O(n).
     * This method performs a loop that iterates 'n' times.
     *
     * @param n Input size that dictates how many times the loop will run.
     */
    public void linearTime(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("Iteration " + i);
        }
        // Complexity: O(n) because the loop runs n times.
    }

    /**
     * Quadratic time complexity O(n^2).
     * This method performs a nested loop, where each loop runs 'n' times.
     *
     * @param n Input size that dictates how many times the loops will run.
     */
    public void quadraticTime(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Iteration (" + i + ", " + j + ")");
            }
        }
        // Complexity: O(n^2) because the outer loop runs n times,
        // and for each iteration of the outer loop, the inner loop runs n times.
    }

    /**
     * Cubic time complexity O(n^3).
     * This method performs a triply nested loop, where each loop runs 'n' times.
     *
     * @param n Input size that dictates how many times the loops will run.
     */
    public void cubicTime(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.println("Iteration (" + i + ", " + j + ", " + k + ")");
                }
            }
        }
        // Complexity: O(n^3) because there are three nested loops, each running n times.
    }

    /**
     * Logarithmic time complexity O(log n).
     * This method performs a loop where the iteration variable doubles each time,
     * reducing the size of the problem with each iteration.
     *
     * @param n Input size that dictates how many times the loop will run.
     */
    public void logarithmicTime(int n) {
        for (int i = 1; i < n; i *= 2) {
            System.out.println("Iteration " + i);
        }
        // Complexity: O(log n) because the loop variable doubles each time,
        // reducing the problem size by half in each iteration.
    }

    /**
     * Linearithmic time complexity O(n log n).
     * This method performs a loop 'n' times, and within each iteration, it performs
     * a logarithmic number of operations.
     *
     * @param n Input size that dictates how many times the outer and inner loops will run.
     */
    public void linearithmicTime(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j *= 2) {
                System.out.println("Iteration (" + i + ", " + j + ")");
            }
        }
        // Complexity: O(n log n) because the outer loop runs n times (O(n)),
        // and the inner loop runs log(n) times (O(log n)).
    }

    /**
     * Exponential time complexity O(2^n).
     * This method recursively calls itself twice for each input value, resulting
     * in an exponential number of operations.
     *
     * @param n Input size.
     */
    public void exponentialTime(int n) {
        if (n <= 1) {
            System.out.println("Base case: n = " + n);
        } else {
            exponentialTime(n - 1);
            exponentialTime(n - 1);
        }
        // Complexity: O(2^n) because each call splits into two more calls, leading to
        // exponential growth in the number of recursive calls.
    }

    /**
     * Factorial time complexity O(n!).
     * This method recursively calls itself 'n' times, and for each recursive call, it performs
     * additional recursive calls proportional to the remaining problem size.
     *
     * @param n Input size.
     */
    public void factorialTime(int n) {
        if (n == 0) {
            System.out.println("Base case: n = " + n);
        } else {
            for (int i = 0; i < n; i++) {
                factorialTime(n - 1);
            }
        }
        // Complexity: O(n!) because for each value of n, the method is called n times,
        // with each subsequent call calling itself n-1 times.
    }

    public int fib(int n)
    {
        if (n <= 1) {
            return 1;
        }
        return fib(n-1) + fib(n + 1);
    }

    public static void main(String[] args) {
        Complexity complexity = new Complexity();

        System.out.println("Constant time complexity:");
        complexity.constantTime(10);

        System.out.println("\nLinear time complexity:");
        complexity.linearTime(5);

        System.out.println("\nQuadratic time complexity:");
        complexity.quadraticTime(3);

        System.out.println("\nCubic time complexity:");
        complexity.cubicTime(2);

        System.out.println("\nLogarithmic time complexity:");
        complexity.logarithmicTime(16);

        System.out.println("\nLinearithmic time complexity:");
        complexity.linearithmicTime(8);

        System.out.println("\nExponential time complexity:");
        complexity.exponentialTime(3);

        System.out.println("\nFactorial time complexity:");
        complexity.factorialTime(3);
    }
}

