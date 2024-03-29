package TP.TP1.geometry;

/**
 * The type Square triangle.
 */
public class squareTriangle extends shape {

    private double m_side_long;
    private double m_side_short;

    /**
     * Instantiates a new Square triangle.
     */
    public squareTriangle() {
        m_side_short = TP.utils.utils.getDoubleInput("Enter the short side of the square triangle:");
        m_side_long = TP.utils.utils.getDoubleInput("Enter the long side of the square triangle:");
    }

    @Override
    public double area() {
        return (m_side_long * m_side_short) / 2;
    }

    @Override
    public String toString() {
        return "+\n|\\\n| \\\n|  \\\n+---+";
    }
}
