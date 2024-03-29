package TP.TP1;

import java.util.Scanner;

import static TP.utils.utils.*;

/**
 * The type Tp 1 1.
 */
public class TP1_1 {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        inputAndLoop();
    }

    /**
     * Input and loop.
     */
    public static void inputAndLoop() {

        // creating the Scanner taking the System input.
        Scanner input = new Scanner(System.in);

        // getting the user's name.
        System.out.println("Please enter your name:");
        String name = input.nextLine();
        System.out.println("Welcome, " + name + " !");

        // getting the first number.
        float number = (float) getDoubleInput("Enter a number:");

        // getting the second number.
        float number2 = (float) getDoubleInput("Enter another number:");

        // printing the greater number.
        System.out.println("The greater number is " + Math.max(number, number2) + ".");

        // getting the integer number.
        int num = getIntInput("Enter an integer:");

        // printing whether the number is odd or even.
        if (num % 2 == 0) {
            System.out.println(num + " is an even number.");
        } else {
            System.out.println(num + " is an odd number.");
        }
    }
}
