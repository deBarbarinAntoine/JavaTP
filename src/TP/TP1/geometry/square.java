package TP.TP1.geometry;

/**
 * The type Square.
 */
public class square extends shape {
    private double m_side;

    /**
     * Instantiates a new Square.
     */
    public square() {
        m_side = TP.utils.utils.getDoubleInput("Enter the side of the square:");
    }

    @Override
    public double area() {
        return m_side * m_side;
    }

    @Override
    public String toString() {
        return "+----+\n|    |\n+----+";
    }
}
