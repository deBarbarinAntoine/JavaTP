package TP.TP2;

import TP.TP;

import static TP.utils.utils.getIntInput;

/**
 * The type Tp 2 1.
 */
public class TP2_1 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        primeTest();
    }

    /**
     * Is prime boolean.
     *
     * @param num the num
     * @return the boolean
     */
    public static boolean isPrime(int num) {

        // looking for a possible divisor
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }

        // if there is no divisor found, num is a prime number
        return true;
    }

    /**
     * Prime test.
     */
    public static void primeTest() {

        // gets the user's input
        int num = getIntInput("Enter an integer:");

        // checking if num is a prime number
        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
