package TP.TP2;

import static TP.TP2.TP2_2.fibonacci;
import static TP.utils.utils.getIntInput;

public class TP2_3 {

    public static void main(String[] args) {
        getGoldenRatio();
    }

    /**
     * Golden ratio double.
     *
     * @param num the num
     * @return the double
     */
    public static double goldenRatio(int num) {
        if (num < 0) return 0;
        if (num == 1) return 1;
        return (double) fibonacci(num + 1) / fibonacci(num);
    }

    /**
     * Gets golden ratio.
     */
    public static void getGoldenRatio() {
        int num = getIntInput("Enter a positive integer:");
        if (num < 0) return;
        for (int i = 1; i < num; i++) {
            System.out.println("O["+i+"] = " + goldenRatio(i));
        }
        System.out.println("O["+num+"] = " + goldenRatio(num));
        System.out.println("The golden ratio is: "+ TP2.goldenRatio);
    }
}
