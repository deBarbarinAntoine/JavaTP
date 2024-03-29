package TP.TP_2;

public class Archimede {
    public static double Cn(double x, double y) {
        if (x < 0 || y < 0) return 0;
        return 2 * x * y / (x + y);
    }

    public static double In(double x, double y) {
        if (x < 0 || y < 0) return 0;
        return Math.sqrt(x * y);
    }
}
