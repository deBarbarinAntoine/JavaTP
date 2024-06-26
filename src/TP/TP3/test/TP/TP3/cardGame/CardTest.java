package TP.TP3.cardGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * The type Card test.
 */
class CardTest {

    /**
     * Gets value.
     */
    @Test
    void getValue() {
        Card card = Card.newCard("A", "SPADES");
        Assertions.assertNotNull(card);
        Assertions.assertEquals("A", card.getValue());
    }

    /**
     * Sets value.
     */
    @Test
    void setValue() {
        Card card = Card.newCard("4", "DIAMONDS");
        if (card != null) {
            card.setValue("10");
        }
        Assertions.assertEquals("10", card.getValue());
    }

    @Test
    void strToColor() {
        HashMap<String, Card.Color> colorTest = new HashMap<>();
        colorTest.put("ClUbs", Card.Color.CLUBS);
        colorTest.put("DiAmonDs", Card.Color.DIAMONDS);
        colorTest.put("SpaDes", Card.Color.SPADES);
        colorTest.put("hEaRtS", Card.Color.HEARTS);

        colorTest.forEach((k, v) -> {
            Assertions.assertEquals(v, Card.strToColor(k));
            k = "   " + k + "     ";
            Assertions.assertEquals(v, Card.strToColor(k));
            k = k.trim().toUpperCase();
            Assertions.assertEquals(v, Card.strToColor(k));
            k = k.toLowerCase();
            Assertions.assertEquals(v, Card.strToColor(k));
            k = k + "s";
            Assertions.assertNotEquals(v, Card.strToColor(k));
        });
    }

    /**
     * Gets color.
     */
    @Test
    void getColor() {
        Card card = Card.newCard("J", "CLUBS");
        Assertions.assertEquals("CLUBS", card.getColor());
    }

    /**
     * Sets color.
     */
    @Test
    void setColor() {
        Card card = Card.newCard("K", "SPADES");
        card.setColor("HEARTS");
        Assertions.assertEquals("HEARTS", card.getColor());
    }

    /**
     * Equals.
     */
    @Test
    void equals() {
        Card card = Card.newCard("7", "HEARTS");
        Card card2 = Card.newCard("7", "HEARTS");
        Assertions.assertNotNull(card);
        Assertions.assertNotNull(card2);
        Assertions.assertEquals(card.getColor(), card2.getColor());
        Assertions.assertEquals(card.getValue(), card2.getValue());
        Assertions.assertTrue(card.equals(card2));
    }

    /**
     * New card.
     */
    @Test
    void newCard() {
        Card card = Card.newCard("9", "DIAMONDS");
        Assertions.assertNotNull(card);
    }

    /**
     * Copy card.
     */
    @Test
    void copyCard() {
        Card card = Card.newCard("JOKER", "CLUBS");
        Card card2 = Card.copyCard(card);
        Assertions.assertNotNull(card2);
        Assertions.assertEquals(card.getColor(), card2.getColor());
        Assertions.assertEquals(card.getValue(), card2.getValue());
        Assertions.assertTrue(card.equals(card2));
        Assertions.assertNotEquals(card, card2);
    }

    /**
     * Assign a card's value to another.
     */
    @Test
    void assign() {
        Card card = Card.newCard("J", "CLUBS");
        Card card2 = Card.newCard("3", "DIAMONDS");
        Assertions.assertNotNull(card);
        Assertions.assertNotNull(card2);
        card.assign(card2);
        Assertions.assertEquals(card.getColor(), card2.getColor());
        Assertions.assertEquals(card.getValue(), card2.getValue());
        Assertions.assertTrue(card.equals(card2));
        Assertions.assertNotEquals(card, card2);
    }

    /**
     * Test to string.
     */
    @Test
    void testToString() {
        Card card = Card.newCard("Q", "SPADES");
        String expected = """
                          _____ 
                         |Q .  |
                         | /.\\ |
                         |(_._)|
                         |  |  |
                         |____Q|
                         """;
        Assertions.assertEquals(card.toString(), expected);
    }
}