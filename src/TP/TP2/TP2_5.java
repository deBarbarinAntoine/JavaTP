package TP.TP2;

import static TP.utils.utils.getIntInput;

public class TP2_5 {

    public static void main(String[] args) {
        getArchimedeResults();
    }

    public static void getArchimedeResults() {
        int n = getIntInput("Enter a positive and not null integer:");
        if (n < 1) {
            System.out.println("No result available for this value!");
            return;
        }
        double [] [] result = Archimede.An(n);
        int i = 1;
        System.out.println("Nº\tX\t\t\t\t\tY");
        for (double[] values: result) {
            System.out.println(i + ".\t"+values[0]+"\t"+values[1]);
            ++i;
        }
    }
}
