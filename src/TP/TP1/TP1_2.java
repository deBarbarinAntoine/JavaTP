package TP.TP1;

import TP.menu.Menu;

import static TP.utils.utils.getDoubleInput;

public class TP1_2 {

    public static void main(String[] args) {
        calc();
    }
    public static void calc() {

        // creating the menu to choose the operation.
        String[] options = {"Addition", "Subtraction", "Multiplication", "Division"};
        Menu menu = new Menu("Choose an operator:", options);

        // displaying the menu.
        int choice = menu.display();

        double num1 = getDoubleInput("Enter the first number:");

        double num2 = getDoubleInput("Enter the second number:");

        boolean ok = true;

        double result = switch (choice) {
            case 1 -> num1 + num2;
            case 2 -> num1 - num2;
            case 3 -> num1 * num2;
            case 4 -> {
                if (num2 == 0) {
                    ok = false;
                    System.out.println("Cannot divide a number with 0.");
                    yield 0;
                } else {
                    yield num1 / num2;
                }
            }
            default -> {
                ok = false;
                System.out.println("exiting the calculator...");
                yield 0;
            }
        };

        if (ok) {
            System.out.println("The result is: " + result);
        }
    }
}
