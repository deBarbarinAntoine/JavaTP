package TP.TP2;

import static TP.utils.utils.getIntInput;

/**
 * The type Tp 2 5.
 */
public class TP2_5 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        getArchimedeResults();
    }

    /**
     * Gets archimede results.
     */
    public static void getArchimedeResults() {
        int n;
        do {
            // takes the user's input
            n = getIntInput("Enter a positive and not null integer:");
        } while (n < 1);

        // getting the results of Archimedes
        double [] [] result = Archimedes.An(n);

        // display the results in a table looping through the results
        int i = 1;
        System.out.println("Nº\tX\t\t\t\t\tY");
        for (double[] values: result) {
            System.out.println(i + ".\t"+values[0]+"\t"+values[1]);
            ++i;
        }
    }
}
