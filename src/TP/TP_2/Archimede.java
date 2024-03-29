package TP.TP_2;

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
}
