package TP.TP3;

import TP.TP;
import TP.TP3.cardGame.Deck;
import TP.TP3.stamps.CollectionTimbre;
import TP.menu.Menu;
import TP.utils.utils;

import java.util.ArrayList;

/**
 * The type Tp 3.
 *
 * @author Antoine de Barbarin
 * @version 1.0
 * @since 22 /04/2024
 */
public class TP3  implements TP {

    /**
     * Instantiates a new Tp 3.
     */
    public TP3() {}

    /**
     * The entry point of the TP.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TP tp = new TP3();
        tp.execute();
    }

    @Override
    public void execute() {
        String[] options = new String[]{"New Card Game", "New Stamp Collection"};
        Menu menu = new Menu("************ TP 3 - Card Game & Stamp Collections ****************", options);

        for (;;) {
            int choice = menu.display();

            switch (choice) {
                case 0:
                    System.out.println("See you soon!");
                    return;
                case 1:
                    System.out.println("New Card Game");
                    this.cardGameMenu(Deck.newDeck());
                    break;
                case 2:
                    System.out.println("New Stamp Collection");
                    this.stampCollectionMenu();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Card game menu.
     *
     * @param deck the deck
     */
    public void cardGameMenu(Deck deck) {

        String[] options = new String[]{"Shuffle cards", "Draw card", "Reveal deck"};
        Menu menu = new Menu("************ Card Game **************", options);

        for (;;) {
            int choice = menu.display();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    deck.shuffle();
                    break;
                case 2:
                    if (!deck.isEmpty()) {
                        System.out.println(deck.draw());
                    } else {
                        System.out.println("No cards in this deck");
                    }
                    break;
                case 3:
                    if (!deck.isEmpty()) {
                        System.out.println(deck);
                    } else {
                        System.out.println("No cards in this deck");
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Stamp collection menu.
     */
    public void stampCollectionMenu() {

        ArrayList<String> fields = new ArrayList<>();
        fields.add("valeur");
        fields.add("devise");
        fields.add("filet");
        fields.add("dentelure");
        fields.add("pays");
        fields.add("oeuvre");
        fields.add("designation");
        fields.add("dessinateur");
        fields.add("graveur");

        ArrayList<String> order = new ArrayList<>();
        order.add("y");
        order.add("n");

        CollectionTimbre myCollection = null;
        String filename = "";

        String[] options = new String[]{"Retrieve a Stamp collection from a JSON File", "Sort Stamp collection", "Reveal Stamp collection", "Save Stamp collection"};
        Menu menu = new Menu("************ Stamp Collection **************", options);

        for (;;) {
            int choice = menu.display();

            switch (choice) {
                case 0:
                    return;

                case 1:
                    filename = utils.getStringInput("Enter the path to the Json File:", null);
                    myCollection = CollectionTimbre.newCollectionTimbre(filename);

                    break;

                case 2:
                    if (myCollection != null) {

                        String sortingField = utils.getStringInput("Enter the sorting field: [valeur, devise, filet, dentelure, pays, oeuvre, designation, dessinateur, graveur]", fields);
                        String sortingOrder = utils.getStringInput("Sort in ascending order [y/n]:", order).toLowerCase();
                        myCollection.sortBy(sortingField, sortingOrder.equals("y"));

                    } else System.out.println("You need to import a Stamp collection to do that!");

                    break;

                case 3:
                    if (myCollection != null) {

                        System.out.println(myCollection);

                    } else System.out.println("You need to import a Stamp collection to do that!");

                    break;

                case 4:
                    if (myCollection != null && !filename.isEmpty()) {

                        String isSameFile = utils.getStringInput("Do you want to overwrite the current file? [y/n]:", order).toLowerCase();

                        if (isSameFile.equals("y")) {
                            utils.writeFile(filename, utils.jsonStringify(myCollection.toJson()), false);

                        } else {
                            filename = utils.getStringInput("Enter the path to the Json File:", null);
                            utils.writeFile(filename, utils.jsonStringify(myCollection.toJson()), false);
                        }

                    } else System.out.println("You need to import a Stamp collection to do that!");

                    break;

                default:
                    break;
            }
        }
    }
}
