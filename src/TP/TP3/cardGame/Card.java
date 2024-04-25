package TP.TP3.cardGame;

import java.util.ArrayList;

/**
 * The Card Class
 */
public class Card {

    private String m_value;
    private Color m_color;

    /**
     * The enum Color.
     */
    protected enum Color {

        /**
         * Carreaux
         */
        DIAMONDS,

        /**
         * Cœurs
         */
        HEARTS,

        /**
         * Piques
         */
        SPADES,

        /**
         * Trèfles
         */
        CLUBS
    }

    private Card(String value, Color color) {
        m_value = value;
        m_color = color;
    }

    /**
     * Gets the card's value.
     *
     * @return the value
     */
    public String getValue() {
        return m_value;
    }

    /**
     * Sets a new value.
     * <p>
     * Does nothing if the value is invalid.
     *
     * @param value the value
     */
    public void setValue(String value) {
        value = value.toUpperCase().trim();
        if (!Deck.cardValues.valueOf(Deck.cardValues.labelToValue(value)).equals("")) {
            this.m_value = value;
        }
    }

    /**
     * Gets the card's color.
     *
     * @return the color
     */
    public String getColor() {
        return String.valueOf(m_color);
    }

    /**
     * Sets a new color.
     * <p>
     * Does nothing if the color is invalid.
     *
     * @param colorStr the color in string format
     */
    public void setColor(String colorStr) {
        Color color = strToColor(colorStr);
        if (color != null) {
            this.m_color = color;
        }
    }

    /**
     * Compares two cards
     *
     * @param card the card you want to compare to
     * @return true or false according to the cards' value and color
     */
    public boolean equal(Card card) {
        return m_value.equals(card.m_value) && m_color.equals(card.m_color);
    }

    /**
     * The entry point of the class.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card("Joker", Color.SPADES));
        cards.add(new Card("A", Color.HEARTS));
        cards.add(new Card("4", Color.DIAMONDS));
        cards.add(new Card("10", Color.CLUBS));

        for (int y = 0; y < cards.getFirst().toString().split("\n").length; ++y) {
            for (int i = 0; i < cards.size(); ++i) {
                for (int x = 0; x < cards.getFirst().toString().split("\n")[1].length(); ++x) {
                    if (y == 0 && x == 6) {
                        System.out.print(" ");
                        continue;
                    }
                    System.out.print(cards.get(i).toString().split("\n")[y].charAt(x));
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    /**
     * Simple Card factory
     *
     * @param value    : the card's value
     * @param colorStr : the card's color
     * @return the new card
     */
    public static Card newCard(String value, String colorStr) {
        Color color = strToColor(colorStr);
        if (color == null) {
            return null;
        }
        return new Card(value, color);
    }

    /**
     * Used to copy a card
     *
     * @param card : the card to copy
     * @return the duplicated card
     */
    public static Card copyCard(Card card) {
        return newCard(card.getValue(), card.getColor());
    }

    /**
     * Used to assign a specific card's value to a card
     *
     * @param card: the card holding the values you want in your card.
     */
    public void assign(Card card) {
        m_value = card.getValue();
        m_color = strToColor(card.getColor());
    }

    static Color strToColor(String colorStr) {
        return switch (colorStr.toUpperCase().trim()) {
            case "DIAMONDS" -> Color.valueOf("DIAMONDS");
            case "HEARTS" -> Color.valueOf("HEARTS");
            case "SPADES" -> Color.valueOf("SPADES");
            case "CLUBS" -> Color.valueOf("CLUBS");
            default -> null;
        };
    }

    @Override
    public String toString() {

        if (m_value.toUpperCase().trim().equals("JOKER")) {
            return """
                     _____ 
                    |J   *|
                    | O   |
                    |  K  |
                    |   E |
                    |*___R|
                    """;
        }

        String value1, value2;
        if (!m_value.equals("10")) {
            value1 = m_value + " ";
            value2 = "_" + m_value;
        } else {
            value1 = value2 = m_value;
        }
        switch (m_color) {
            case DIAMONDS:
                return """
                          _____ 
                         """+"|"+value1+"^  |\n"+"""
                         | / \\ |
                         | \\ / |
                         |  .  |
                         """ + "|___"+value2+"|\n";
            case HEARTS:
                return """
                          _____ 
                         """+"|"+value1+" _ |\n"+"""
                         |( v )|
                         | \\ / |
                         |  .  |
                         """ + "|___"+value2+"|\n";
            case SPADES:
                return """
                          _____ 
                         """+"|"+value1+".  |\n"+"""
                         | /.\\ |
                         |(_._)|
                         |  |  |
                         """ + "|___"+value2+"|\n";
            case CLUBS:
                return """
                          _____ 
                         """+"|"+value1+"_  |\n"+"""
                         | ( ) |
                         |(_'_)|
                         |  |  |
                         """ + "|___"+value2+"|\n";
        }
        return null;
    }
}
