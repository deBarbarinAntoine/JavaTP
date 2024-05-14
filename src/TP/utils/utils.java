package TP.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.ArrayList;
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

    private static void checkFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    /**
     * Write a jsonString into a file.
     *
     * @param filename   the file's name
     * @param jsonString the json string
     * @param append     whether to append the writing content or not
     */
    public static void writeFile(String filename, String jsonString, boolean append) {
        try (Writer w = new FileWriter(filename, append)) {
            checkFile(filename);
            w.write(jsonString);
        } catch (IOException exception) {
            System.out.println("An error occurred: \n" + exception);
        }
    }

    /**
     * Read json file to retrieve an ObjectNode.
     *
     * @param filename the file's name
     * @return the ObjectNode
     */
    @Nullable
    public static ObjectNode readJSONFile(String filename) {
        try (Reader r = new FileReader(filename)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(r, ObjectNode.class);
        } catch (IOException exception) {
            System.out.println("File " + filename + " doesn't exist");
            return null;
        }
    }

    /**
     * Read json file to retrieve an ArrayNode.
     *
     * @param filename the file's name
     * @return the ArrayNode
     */
    @Nullable
    public static ArrayNode readJSONArrayFile(String filename) {
        try (Reader r = new FileReader(filename)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(r, ArrayNode.class);
        } catch (IOException exception) {
            System.out.println("File " + filename + " doesn't exist");
            return null;
        }
    }

    /**
     * Convert JSON ObjectNode to a String.
     *
     * @param jsonObj the json object
     * @return the string
     */
    public static String jsonStringify(ObjectNode jsonObj) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStringify;
        try {
            jsonStringify = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObj);
        } catch (JsonProcessingException exception) {
            System.out.println("An error occurred: \n" + exception);
            return "";
        }
        return jsonStringify;
    }

    /**
     * Convert JSON ArrayNode to a String.
     *
     * @param jsonObj the json object
     * @return the string
     */
    public static String jsonStringify(ArrayNode jsonObj) {
        if (jsonObj == null || jsonObj.isEmpty()) return "[]";
        StringBuilder jsonStringify = new StringBuilder("[\n");
        int i = 0;
        for (JsonNode obj: jsonObj) {
            jsonStringify.append(obj.toPrettyString());
            if (i + 1 < jsonObj.size()) jsonStringify.append(",\n");
            ++i;
        }
        jsonStringify.append("\n]");
        return jsonStringify.toString();
    }

    /**
     * Convert an array of JSON ObjectNode to an ArrayNode.
     *
     * @param items the JSON items
     * @return the ArrayNode
     */
    public static ArrayNode toJsonArray(ArrayList<ObjectNode> items) {
        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sg = new StringBuilder("[\n");
        int i = 0;
        for (ObjectNode item : items) {
            sg.append(jsonStringify(item));
            if (i + 1 < items.size()) sg.append(",\n");
            ++i;
        }
        sg.append("\n]");
        ArrayNode jsonArray;
        try {
            jsonArray = mapper.readValue(sg.toString(), ArrayNode.class);
        } catch (JsonProcessingException exception) {
            System.out.println("An error occurred: \n" + exception);
            return null;
        }
        return jsonArray;
    }

    /**
     * Convert a list of objects to a JSON ArrayNode.
     *
     * @param <T> the type parameter
     * @param arr the arr
     * @return the ArrayNode
     */
    public static <T> ArrayNode toJson(ArrayList<T> arr) {
        ObjectMapper mapper = new ObjectMapper();
        ArrayNode jsonArray = new ArrayNode(JsonNodeFactory.instance);
        for (T obj : arr) {
            jsonArray.add(mapper.valueToTree(obj));
        }
        return jsonArray;
    }
}
