package TP.TP2;

import TP.TP;

import static TP.TP2.TP2_1.primeTest;
import static TP.TP2.TP2_2.getFibonacci;
import static TP.TP2.TP2_3.getGoldenRatio;
import static TP.TP2.TP2_5.getArchimedeResults;

/**
 * The type Tp 2.
 */
public class TP2 implements TP {

    /**
     * The constant goldenRatio.
     */
    protected static final double goldenRatio = (1 + Math.sqrt(5)) / 2;

    public TP2() {}

    @Override
    public void execute() {
        primeTest();
        getFibonacci();
        getGoldenRatio();
        getArchimedeResults();
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
