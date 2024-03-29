package TP.TP1.geometry;

public class squareTriangle extends shape {

    private double m_side_long;
    private double m_side_large;

    public squareTriangle() {
        m_side_large = TP.utils.utils.getDoubleInput("Enter the side of the square triangle:");
        m_side_long = TP.utils.utils.getDoubleInput("Enter the side of the square triangle:");
    }

    @Override
    public double area() {
        return (m_side_long * m_side_large) / 2;
    }

    @Override
    public String toString() {
        return "+\n|\\\n|  \\\n|    \\\n+-----+";
    }
}
