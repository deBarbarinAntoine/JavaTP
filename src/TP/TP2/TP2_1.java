package TP.TP2;

import TP.TP;

import static TP.utils.utils.getIntInput;

public class TP2_1 {

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
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * Prime test.
     */
    public static void primeTest() {
        int num = getIntInput("Enter an integer:");
        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
}
