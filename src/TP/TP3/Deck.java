package TP.TP3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;

/**
 * The type Deck.
 */
public class Deck {
    private ArrayList<Card> cards = new ArrayList<>();

    private Deck() {
        for (Card.Color color : EnumSet.allOf(Card.Color.class)) {
            for (cardValues value : EnumSet.allOf(cardValues.class)) {
                if (value == cardValues.JOKER) continue;
                this.cards.add(Card.newCard(value.toString(), color.toString()));
            }
        }
        this.cards.add(Card.newCard("JOKER", "DIAMONDS"));
        this.cards.add(Card.newCard("JOKER", "CLUBS"));
    }

    /**
     * Simple Deck factory.
     *
     * @return a new deck
     */
    public static Deck newDeck() {
        return new Deck();
    }

    /**
     * Shuffles the Deck.
     */
    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    /**
     * Draw the last card of the Deck (removing it).
     *
     * @return the last card
     */
    public Card draw() {
        return this.cards.remove(this.getCards().size()-1);
    }

    /**
     * Gets all the cards of the Deck.
     *
     * @return the cards
     */
    public ArrayList<Card> getCards() {
        return this.cards;
    }

    /**
     * The entry point of the class.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Deck deck = newDeck();
        deck.shuffle();
        System.out.println("Drawing the last card of the deck: ");
        System.out.println(deck.draw());
        System.out.println("\n\n\n");
        System.out.println(deck);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        Card [] [] dividedDeck = new Card [9] [6];
        for (int i = 0; i < this.cards.size() ; ++i) {
            dividedDeck[i/6] [i%6] = this.cards.get(i);
        }

        for (Card [] cardSet : dividedDeck) {
            for (int y = 0; y < this.cards.getFirst().toString().split("\n").length; ++y) {
                for (Card card : cardSet) {
                    for (int x = 0; x < this.cards.getFirst().toString().split("\n")[1].length(); ++x) {
                        if (y == 0 && x == 6) {
                            output.append(" ");
                            continue;
                        }
                        if (card != null) output.append(card.toString().split("\n")[y].charAt(x));
                    }
                    output.append("  ");
                }
                output.append("\n");
            }
        }

        return output.toString();
    }

    enum cardValues {
        /**
         * Ace card value.
         */
        ACE("A"),
        /**
         * 2 card value.
         */
        TWO("2"),
        /**
         * 3 card value.
         */
        THREE("3"),
        /**
         * 4 card value.
         */
        FOUR("4"),
        /**
         * 5 card value.
         */
        FIVE("5"),
        /**
         * 6 card value.
         */
        SIX("6"),
        /**
         * 7 card value.
         */
        SEVEN("7"),
        /**
         * 8 card value.
         */
        EIGHT("8"),
        /**
         * 9 card value.
         */
        NINE("9"),
        /**
         * 10 card value.
         */
        TEN("10"),
        /**
         * Jack card value.
         */
        JACK("J"),
        /**
         * Queen card value.
         */
        QUEEN("Q"),
        /**
         * King card values.
         */
        KING("K"),
        /**
         * Joker card value.
         */
        JOKER("JOKER");

        /**
         * The card value's label.
         */
        final String m_label;

        cardValues(String label) {
            this.m_label = label;
        }

        /**
         * @param label : a card's value
         * @return the corresponding card value like in the enum.
         */
        public static String labelToValue(String label) {
            return switch (label) {
                case "A" -> ACE.name();
                case "2" -> TWO.name();
                case "3" -> THREE.name();
                case "4" -> FOUR.name();
                case "5" -> FIVE.name();
                case "6" -> SIX.name();
                case "7" -> SEVEN.name();
                case "8" -> EIGHT.name();
                case "9" -> NINE.name();
                case "10" -> TEN.name();
                case "J" -> JACK.name();
                case "Q" -> QUEEN.name();
                case "K" -> KING.name();
                case "JOKER" -> JOKER.name();
                default -> "";
            };
        }

        @Override
        public String toString() {
            return this.m_label;
        }
    }
}
