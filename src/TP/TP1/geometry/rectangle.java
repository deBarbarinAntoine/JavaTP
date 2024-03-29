package TP.TP1.geometry;

/**
 * The type Rectangle.
 */
public class rectangle extends shape {

    private double m_side_long;
    private double m_side_short;

    /**
     * Instantiates a new Rectangle.
     */
    public rectangle() {
        m_side_short = TP.utils.utils.getDoubleInput("Enter the short side of the rectangle:");
        m_side_long = TP.utils.utils.getDoubleInput("Enter the long side of the rectangle:");
    }
    @Override
    public double area() {
        return m_side_long * m_side_short;
    }

    @Override
    public String toString() {
        return "+--------+\n|        |\n+--------+";
    }
}
