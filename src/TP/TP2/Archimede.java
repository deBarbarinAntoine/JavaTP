package TP.TP2;

/**
 * The type Archimede.
 */
public class Archimede {
    /**
     * Cn double.
     *
     * @param x the x
     * @param y the y
     * @return the double
     */
    public static double Cn(double x, double y) {
        if (x < 0 || y < 0) return 0;
        return 2 * x * y / (x + y);
    }

    /**
     * In double.
     *
     * @param x the x
     * @param y the y
     * @return the double
     */
    public static double In(double x, double y) {
        if (x < 0 || y < 0) return 0;
        return Math.sqrt(x * y);
    }

    public static double[] [] An(int n) {

        double [] [] result = new double [n] [2];
        double x = 4;
        double y = 2 * Math.sqrt(2);

        for (int i = 1; i <= n; i++) {
            result [i-1] [0] = Cn(x, y);
            result [i-1] [1] = In(x, y);
            x = result [i-1] [0];
            y = result [i-1] [1];
        }

        return result;
    }
}
