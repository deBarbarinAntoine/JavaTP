package TP.TP_2;

public class TP2 {

    protected static final double goldenRatio = (1 + Math.sqrt(5)) / 2;

    public static void main(String[] args) {
        primeTest();
        getFibonacci();
        getGoldenRatio();
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void primeTest() {
        int num = TP.utils.utils.getIntInput("Enter an integer:");
        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }

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

    public static void getFibonacci() {
        int num = TP.utils.utils.getIntInput("Enter a positive integer:");
        if (num < 0) return;
        int result = fibonacci(num);
        System.out.println("Fibonacci de "+num+" est: "+result);
    }

    public static double goldenRatio(int num) {
        if (num < 0) return 0;
        if (num == 1) return 1;
        return (double) fibonacci(num + 1) / fibonacci(num);
    }

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
