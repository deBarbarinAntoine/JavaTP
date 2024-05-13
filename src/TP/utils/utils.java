package TP.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.*;
import java.util.Scanner;

/**
 * The type Utils.
 */
public class utils {

    /**
     * getFloatInput takes a message to return a float.
     *
     * @param msg the message to display before taking the user's input.
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
     * getIntInput takes a message to return an int.
     *
     * @param msg the message to display before taking the user's input.
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

    private static boolean existsFile(String filename) {
        File file = new File(filename);
        return file.exists();
    }

    private static void checkFile(String filename) throws IOException {
        if (!existsFile(filename)) {
            File file = new File(filename);
            file.createNewFile();
        }
    }

    public static void writeJSONFile(String filename, ObjectNode jsonObj, boolean append) throws IOException {
        checkFile(filename);
        try (Writer w = new FileWriter(filename, append)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(w, jsonObj);
        } catch (IOException exception) {
            System.out.println("An error occurred: \n" + exception);
        }
    }

    public static ObjectNode readJSONFile(String filename) throws IOException {
        try (Reader r = new FileReader(filename)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(r, ObjectNode.class);
        } catch (FileNotFoundException exception) {
            System.out.println("File " + filename + " doesn't exist");
            return null;
        }
    }
}
