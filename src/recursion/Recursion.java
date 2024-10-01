package recursion;

public class Recursion {

    public static void main(String[] args) {

    }

    public static boolean isPrime(int num , int i){
        if (num < 2){
            return false;
        } else if (i == 1) {
            return true;
        } else if (num % i == 0) {
            return false;
        } else {
            return isPrime(num, i-1);
        }
    }

    public static int gcd(int num1, int num2) {
        // Computing absolute value
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        // Base case
        if (num1 == 0) {
            return num2;
        } else if (num2 == 0) {
            return num1;
        }
        // Recursion case
        if (num1 > num2) {
            return gcd( num1 % num2, num2);
        } else {
            return gcd(num2 % num1, num1);
        }
    }
}
