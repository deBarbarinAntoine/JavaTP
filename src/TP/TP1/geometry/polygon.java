package TP.TP1.geometry;

/**
 * The interface Polygon.
 */
public interface polygon {
    /**
     * Area double.
     *
     * @return the polygon's area
     */
    public double area();

    /**
     * Calc area.
     */
    public void calcArea();

    /**
     * The enum Type.
     */
    enum type {
        /**
         * Circle type.
         */
        circle,
        /**
         * Fourth circle type.
         */
        fourthCircle,
        /**
         * Rectangle type.
         */
        rectangle,
        /**
         * Square type.
         */
        square,
        /**
         * Square triangle type.
         */
        squareTriangle,
        /**
         * Trapezoid type.
         */
        trapezoid,
    };
}
