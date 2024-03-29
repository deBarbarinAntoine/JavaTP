package TP.TP1.geometry;

public class rectangle extends shape {

    private double m_side_long;
    private double m_side_large;

    public rectangle() {
        m_side_large = TP.utils.utils.getDoubleInput("Enter the side of the rectangle:");
        m_side_long = TP.utils.utils.getDoubleInput("Enter the side of the rectangle:");
    }
    @Override
    public double area() {
        return m_side_long * m_side_large;
    }

    @Override
    public String toString() {
        return "+--------+\n|    |\n+--------+";
    }
}
