package TP.TP1.geometry;

import static TP.utils.utils.getDoubleInput;

/**
 * The type Trapezoid.
 */
public class trapezoid extends shape {

    private double m_side_long;
    private double m_side_short;
    private double m_height;

    /**
     * Instantiates a new Trapezoid.
     */
    public trapezoid() {
        double sideLong = getDoubleInput("Enter the long side of the trapezoid:");
        double sideShort = getDoubleInput("Enter the short side of the trapezoid:");
        m_height = getDoubleInput("Enter the height of the trapezoid:");
        m_side_short = Math.min(sideShort, sideLong);
        m_side_long = Math.max(sideShort, sideLong);
    }
    @Override
    public double area() {
        return (m_side_long + m_side_short) * m_height * .5;
    }

    @Override
    public String toString() {
        return "   +----+\n  /      \\\n /        \\\n+----------+";
    }
}
