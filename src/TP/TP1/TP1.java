package TP.TP1;

import static TP.TP1.TP1_1.inputAndLoop;
import static TP.TP1.TP1_2.calc;
import static TP.TP1.TP1_3.trapezoidArea;
import static TP.TP1.TP1_4.shapeArea;

import TP.TP;
import TP.menu.Menu;

/**
 * The type Tp 1.
 *
 * @author Antoine de Barbarin
 * @version 1.0
 * @since 25/03/2024
 */
public class TP1 implements TP {

    /**
     * Instantiates a new Tp 1.
     */
    public TP1() {}

    @Override
    public void execute() {
        String[] options = {"TP 1.1 Input & Loop", "TP 1.2 Calculator", "TP 1.3 Trapezoid Area", "TP 1.4 Shape Area"};
        Menu menu = new Menu("What do you want to do?", options);

        for (;;) {
            int choice = menu.display();

            switch (choice) {
                case 1:
                    inputAndLoop();
                    break;
                case 2:
                    calc();
                    break;
                case 3:
                    trapezoidArea();
                    break;
                case 4:
                    shapeArea();
                    break;
                default:
                    return;
            }
        }
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TP tp = new TP1();
        tp.execute();
    }
}