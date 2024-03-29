package TP.TP1.geometry;

public class fourthCircle extends shape {

    private double m_radius;
    static final double pi = Math.PI;

    public fourthCircle() {
        m_radius = TP.utils.utils.getDoubleInput("Enter the radius of the circle:");
    }

    @Override
    public double area() {
        return (pi * Math.pow(m_radius, 2)) / 4;
    }
}
