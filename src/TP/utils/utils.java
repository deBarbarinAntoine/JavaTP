package TP.utils;

import java.util.Scanner;

public class utils {

    /**
     * getFloatInput takes a message and a scanner to return a float.
     *
     * @param msg   the message to display before taking the user's input.
     * @param input the scanner you want to use.
     * @return float found in the scanner.
     */
    public static double getDoubleInput(String msg) {

        Scanner input = new Scanner(System.in);

        // setting the variables needed.
        boolean validInput;
        double number = 0;

        do {
            validInput = true;

            // printing the message.
            System.out.println(msg);

            // checking if the input is a float.
            if (input.hasNextDouble()) {
                number = input.nextDouble();
            } else {

                // if the input is invalid, print a message, set the boolean at false, and clear the buffer.
                System.out.println("Invalid number: please enter an integer or a double with a comma.");
                validInput = false;
                input.next();
            }
        } while (!validInput);

        return number;
    }

    /**
     * getIntInput takes a message and a scanner to return an int.
     * @param msg the message to display before taking the user's input.
     * @param input the scanner you want to use.
     * @return int found in the scanner.
     */
    public static int getIntInput(String msg) {

        Scanner input = new Scanner(System.in);

        // setting the variables needed.
        boolean validInput;
        int number = 0;

        do {
            validInput = true;

            // printing the message.
            System.out.println(msg);

            // checking if the input is an int.
            if (input.hasNextInt()) {
                number = input.nextInt();
            } else {

                // if the input is invalid, print a message, set the boolean at false, and clear the buffer.
                System.out.println("Invalid number: please enter an integer.");
                validInput = false;
                input.next();
            }
        } while (!validInput);

        return number;
    }
}
