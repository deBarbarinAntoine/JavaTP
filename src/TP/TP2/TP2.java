package TP.TP2;

import TP.TP;
import TP.menu.Menu;

import static TP.TP2.TP2_1.primeTest;
import static TP.TP2.TP2_2.getFibonacci;
import static TP.TP2.TP2_3.getGoldenRatio;
import static TP.TP2.TP2_5.getArchimedeResults;
import static TP.TP2.TP2_5_bonus.getCollatz;
import static TP.TP2.TP2_6.matchesGame;

/**
 * The type Tp 2.
 *
 * @author Antoine de Barbarin
 * @version 1.0
 * @since 29/03/2024
 */
public class TP2 implements TP {

    /**
     * Instantiates a new Tp 2.
     */
    public TP2() {}

    @Override
    public void execute() {
        String[] options = {"TP 2.1 Prime Number", "TP 2.2 Fibonacci", "TP 2.3 Golden Ratio", "TP 2.5 Archimedes", "TP 2.6 Match Game", "TP 2.5 (bonus) Collatz Conjecture"};
        Menu menu = new Menu("What do you want to do?", options);

        for (;;) {
            int choice = menu.display();

            switch (choice) {
                case 1:
                    primeTest();
                    break;
                case 2:
                    getFibonacci();
                    break;
                case 3:
                    getGoldenRatio();
                    break;
                case 4:
                    getArchimedeResults();
                    break;
                case 5:
                    matchesGame();
                    break;
                case 6:
                    getCollatz();
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
        TP2 tp = new TP2();
        tp.execute();
    }
}
