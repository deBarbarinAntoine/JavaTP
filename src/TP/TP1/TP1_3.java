package TP.TP1;

import TP.TP1.geometry.trapezoid;

/**
 * The type Tp 1 3.
 */
public class TP1_3 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        trapezoidArea();
    }

    /**
     * Trapezoid area.
     */
    public static void trapezoidArea() {
        trapezoid myTrapezoid = new trapezoid();
        myTrapezoid.calcArea();
    }
}
