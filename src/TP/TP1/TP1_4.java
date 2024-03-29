package TP.TP1;

import TP.TP1.geometry.*;
import TP.menu.Menu;

import static TP.TP1.TP1_3.trapezoidArea;
import static TP.TP1.geometry.shape.NewPolygon;

/**
 * The type Tp 1 4.
 */
public class TP1_4 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        shapeArea();
    }

    /**
     * Shape area.
     */
    public static void shapeArea() {
        String[] options = {"Square", "Rectangle", "Square Triangle", "Circle", "Fourth of a circle", "Trapezoid"};
        Menu menu = new Menu("What shape do you want to create?", options);
        int choice = menu.display();

        polygon.type  myType = switch (choice) {
            case 1 -> polygon.type.square;
            case 2 -> polygon.type.rectangle;
            case 3 -> polygon.type.squareTriangle;
            case 4 -> polygon.type.circle;
            case 5 -> polygon.type.fourthCircle;
            case 6 -> polygon.type.trapezoid;
            default -> null;
        };

        if (myType != null) {
            polygon myShape = NewPolygon(myType);
            myShape.calcArea();
        }
    }
}
