package TP.TP2;

/**
 * The type Archimede.
 */
public class Archimedes {
    /**
     * Cn double.
     *
     * @param x the x
     * @param y the y
     * @return the result (double)
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
     * @return the result (double)
     */
    public static double In(double x, double y) {
        if (x < 0 || y < 0) return 0;
        return Math.sqrt(x * y);
    }

    /**
     * An double [ ] [ ].
     *
     * @param n the n
     * @return a 2D array with the results (double [ ] [ ])
     */
    public static double[] [] An(int n) {

        // creating the 2D array
        double [] [] result = new double [n] [2];

        double x = 4;
        double y = 2 * Math.sqrt(2);

        // filling the array with the results (n times)
        for (int i = 0; i < n; ++i) {
            result [i] [0] = Cn(x, y);
            result [i] [1] = In(x, y);
            x = result [i] [0];
            y = result [i] [1];
        }

        return result;
    }
}
