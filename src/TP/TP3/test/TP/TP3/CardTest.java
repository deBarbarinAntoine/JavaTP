package TP.TP3;

import TP.TP3.cardGame.Card;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
     * Equal.
     */
    @Test
    void equal() {
        Card card = Card.newCard("7", "HEARTS");
        Card card2 = Card.newCard("7", "HEARTS");
        Assertions.assertEquals(card.getColor(), card2.getColor());
        Assertions.assertEquals(card.getValue(), card2.getValue());
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