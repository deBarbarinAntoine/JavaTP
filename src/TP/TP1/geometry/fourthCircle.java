package TP.TP1.geometry;

/**
 * The type Fourth circle.
 */
public class fourthCircle extends shape {

    private double m_radius;
    /**
     * The Pi.
     */
    static final double pi = Math.PI;

    /**
     * Instantiates a new Fourth circle.
     */
    public fourthCircle() {
        m_radius = TP.utils.utils.getDoubleInput("Enter the radius of the circle:");
    }

    @Override
    public double area() {
        return (pi * Math.pow(m_radius, 2)) / 4;
    }

    @Override
    public String toString() {
        return """
                            .
                        *   |
                     *      |
                    *_______|
                """;
    }
}
