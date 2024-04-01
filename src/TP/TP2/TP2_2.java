package TP.TP2;

import static TP.utils.utils.getIntInput;

public class TP2_2 {

    public static void main(String[] args) {
        getFibonacci();
    }

    /**
     * Fibonacci int.
     *
     * @param num the num
     * @return the int
     */
    public static int fibonacci(int num) {
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
        int num = getIntInput("Enter a positive integer:");
        if (num < 0) return;
        int result = fibonacci(num);
        System.out.println("Fibonacci de "+num+" est: "+result);
    }
}
