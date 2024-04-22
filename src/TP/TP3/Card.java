package TP.TP3;

/**
 * The Card Class
 */
public class Card {

    private String m_value;
    private Color m_color;

    private enum Color {

        /**
         * Carreau
         */
        DIAMONDS,

        /**
         * Cœur
         */
        HEARTS,

        /**
         * Pique
         */
        SPADES,

        /**
         * Trèfle
         */
        CLUBS
    }

    private Card(String value, Color color) {
        m_value = value;
        m_color = color;
    }

    public String getValue() {
        return m_value;
    }

    public void setValue(String value) {
        this.m_value = value;
    }

    public String getColor() {
        return String.valueOf(m_color);
    }

    public void setColor(String colorStr) {
        Color color = strToColor(colorStr);
        if (color != null) {
            this.m_color = color;
        }
    }

    public static void main(String[] args) {
        Card card = new Card("Q", Color.HEARTS);
        System.out.println(card);
    }

    /**
     * Simple Card factory
     *
     * @param value: the card's value
     * @param colorStr: the card's color
     * @return the new card
     */
    public static Card newCard(String value, String colorStr) {
        Color color = strToColor(colorStr);
        if (color == null) {
            return null;
        }
        return new Card(value, color);
    }

    private static Color strToColor(String colorStr) {
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

        if (m_value.equals("Joker")) {
            return """
                      _____
                     |Joker|
                     |==%, |
                     | \\/>\\|
                     | _>^^|
                     |/_\\/_|
                    """;
        }

        String value;
        if (!m_value.equals("10")) {
            value = m_value + " ";
        } else {
            value = m_value;
        }
        switch (m_color) {
            case DIAMONDS:
                return """
                          _____
                         """+"|"+value+"^  |\n"+"""
                         | / \\ |
                         | \\ / |
                         |  .  |
                         """ + "|___"+value+"|\n";
            case HEARTS:
                return """
                          _____
                         """+"|"+value+" _ |\n"+"""
                         |( v )|
                         | \\ / |
                         |  .  |
                         """ + "|___"+value+"|\n";
            case SPADES:
                return """
                          _____
                         """+"|"+value+".  |\n"+"""
                         | /.\\ |
                         |(_._)|
                         |  |  |
                         """ + "|___"+value+"|\n";
            case CLUBS:
                return """
                          _____
                         """+"|"+value+"_  |\n"+"""
                         | ( ) |
                         |(_'_)|
                         |  |  |
                         """ + "|___"+value+"|\n";
        }
        return null;
    }
}
