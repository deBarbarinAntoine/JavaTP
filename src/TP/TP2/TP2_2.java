package TP.TP2;

import static TP.utils.utils.getIntInput;

/**
 * The type Tp 2 2.
 */
public class TP2_2 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        getFibonacci();
    }

    /**
     * Fibonacci suite (recursive function).
     *
     * @param num the integer
     * @return the result
     */
    public static int fibonacci(int num) {

        // check if num is positive (error handling)
        if (num < 0) {
            return -1;
        }
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        return fibonacci(num-2) + fibonacci(num-1);
    }

    /**
     * Gets fibonacci.
     */
    public static void getFibonacci() {
        int num;
        do {
            // takes the user's input
            num = getIntInput("Enter a positive integer:");
        } while (num < 0);

        // printing the result
        System.out.println("Fibonacci de "+num+" est: " + fibonacci(num));
    }
}
