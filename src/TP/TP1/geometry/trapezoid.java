package TP.TP1.geometry;

import static TP.utils.utils.getDoubleInput;

public class trapezoid extends shape {

    private double m_side_long;
    private double m_side_little;
    private double m_height;

    public trapezoid() {
        double sideLong = getDoubleInput("Enter the long side of the trapezoid:");
        double sideLittle = getDoubleInput("Enter the little side of the trapezoid:");
        m_height = getDoubleInput("Enter the height of the trapezoid:");
        m_side_little = Math.min(sideLittle, sideLong);
        m_side_long = Math.max(sideLittle, sideLong);
    }
    @Override
    public double area() {
        return (m_side_long + m_side_little) * m_height * .5;
    }
}
