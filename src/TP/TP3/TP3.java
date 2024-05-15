package TP.TP3;

import TP.TP;
import TP.TP3.cardGame.Deck;
import TP.TP3.stamps.Timbre;

/**
 * The type Tp 3.
 *
 * @author Antoine de Barbarin
 * @version 1.0
 * @since 22/04/2024
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
        Deck deck = Deck.newDeck();
        deck.shuffle();
        for (int i = 0; i < 7; ++i) {
            System.out.println("Drawing the last card of the deck: ");
            System.out.println(deck.draw());
            System.out.printf("The deck has now %d cards\n", deck.getCards().size());
            System.out.println("\n\n\n");
        }
        System.out.println(deck);
    }
}
