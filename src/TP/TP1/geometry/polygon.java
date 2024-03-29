package TP.TP1.geometry;

public interface polygon {
    public double area();
    public void calcArea();
    enum type {
        circle,
        fourthCircle,
        rectangle,
        square,
        squareTriangle,
        trapezoid,
    };
}
