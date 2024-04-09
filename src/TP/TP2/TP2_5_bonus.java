package TP.TP2;

import static TP.utils.utils.getIntInput;

/**
 * The type Tp 2 5 bonus.
 */
public class TP2_5_bonus {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        getCollatz();
    }

    /**
     * Calc a single collatz integer.
     *
     * @param num the num
     * @return the int
     */
    public static int calcCollatz(int num) {

        // if even number
        if (num % 2 == 0) {
            return num / 2;

        // if odd number
        } else {
            return (3 * num) + 1;
        }
    }

    /**
     * Gets the whole collatz suite.
     */
    public static void getCollatz() {
        int num;
        do {
            // takes the user's input
            num = getIntInput("Enter a positive integer: [1 - ...]");
        } while (num < 1);

        // display the initial result
        System.out.println("U[0] = " + num);

        // display the remainder until it hits 1
        int i = 1;
        while (num != 1) {
            num = calcCollatz(num);
            System.out.println("U["+i+"] = "+ num);
            ++i;
        }
    }
}
