package TP.TP2;

import static TP.TP2.TP2_2.fibonacci;
import static TP.utils.utils.getIntInput;

/**
 * The type Tp 2 3.
 */
public class TP2_3 {

    /**
     * The constant goldenRatio.
     */
    protected static final double goldenRatio = (1 + Math.sqrt(5)) / 2;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        getGoldenRatio();
    }

    /**
     * Golden ratio: compute the golden ratio of an integer.
     *
     * @param num: an integer
     * @return the result (double)
     */
    public static double goldenRatio(int num) {
        if (num < 0) return 0;
        if (num == 1) return 1;
        return (double) fibonacci(num + 1) / fibonacci(num);
    }

    /**
     * Gets the golden ratio.
     */
    public static void getGoldenRatio() {
        int num;
        do {
            // takes the user's input
            num = getIntInput("Enter a positive integer: [0 - 33]");
        } while (num < 0 || num > 33);

        // display all the steps up to the chosen integer
        for (int i = 1; i < num; i++) {
            System.out.println("O["+i+"] = " + goldenRatio(i));
        }
        // display the final result
        System.out.println("O["+num+"] = " + goldenRatio(num));

        // display the actual golden ratio
        System.out.println("The golden ratio is: "+ goldenRatio);
    }
}
