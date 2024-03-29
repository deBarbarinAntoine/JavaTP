package TP.TP_2;

/**
 * The type Tp 2.
 */
public class TP2 {

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
        primeTest();
        getFibonacci();
        getGoldenRatio();
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
        int num = TP.utils.utils.getIntInput("Enter an integer:");
        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
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
        int num = TP.utils.utils.getIntInput("Enter a positive integer:");
        if (num < 0) return;
        int result = fibonacci(num);
        System.out.println("Fibonacci de "+num+" est: "+result);
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
        int num = TP.utils.utils.getIntInput("Enter a positive integer:");
        if (num < 0) return;
        for (int i = 1; i < num; i++) {
            System.out.println("O["+i+"] = " + goldenRatio(i));
        }
        System.out.println("O["+num+"] = " + goldenRatio(num));
        System.out.println("The golden ratio is: "+ goldenRatio);
    }
}
