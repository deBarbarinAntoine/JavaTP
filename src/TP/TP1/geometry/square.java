package TP.TP1.geometry;

public class square extends shape {
    private double m_side;

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
