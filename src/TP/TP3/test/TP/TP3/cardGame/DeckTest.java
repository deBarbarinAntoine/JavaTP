package TP.TP3.cardGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * The type Deck test.
 */
class DeckTest {

    /**
     * New deck.
     */
    @Test
    void newDeck() {
        Deck deck = Deck.newDeck();
        Assertions.assertNotNull(deck);
        Assertions.assertEquals(54, deck.getCards().size());
    }

    /**
     * Shuffle.
     */
    @Test
    void shuffle() {
        Deck deck = Deck.newDeck();
        Deck shuffledDeck = Deck.newDeck();
        shuffledDeck.shuffle();
        boolean equals = true;
        for (int i = 0; i < deck.getCards().size(); i++) {
            equals = deck.getCards().get(i).equal(shuffledDeck.getCards().get(i));
            if (!equals) break;
        }
        Assertions.assertFalse(equals);
    }

    /**
     * Draw.
     */
    @Test
    void draw() {
        Deck deck = Deck.newDeck();
        Card drawnCard = deck.draw();
        Card card = Card.newCard("JOKER", "CLUBS");
        Assertions.assertNotNull(drawnCard);
        Assertions.assertTrue(drawnCard.equal(card));
        Assertions.assertEquals(53, deck.getCards().size());
    }

    /**
     * Test to string.
     */
    @Test
    void testToString() {
        Deck deck = Deck.newDeck();
        String expected = """
                 _____    _____    _____    _____    _____    _____  \s
                |A ^  |  |2 ^  |  |3 ^  |  |4 ^  |  |5 ^  |  |6 ^  | \s
                | / \\ |  | / \\ |  | / \\ |  | / \\ |  | / \\ |  | / \\ | \s
                | \\ / |  | \\ / |  | \\ / |  | \\ / |  | \\ / |  | \\ / | \s
                |  .  |  |  .  |  |  .  |  |  .  |  |  .  |  |  .  | \s
                |____A|  |____2|  |____3|  |____4|  |____5|  |____6| \s
                 _____    _____    _____    _____    _____    _____  \s
                |7 ^  |  |8 ^  |  |9 ^  |  |10^  |  |J ^  |  |Q ^  | \s
                | / \\ |  | / \\ |  | / \\ |  | / \\ |  | / \\ |  | / \\ | \s
                | \\ / |  | \\ / |  | \\ / |  | \\ / |  | \\ / |  | \\ / | \s
                |  .  |  |  .  |  |  .  |  |  .  |  |  .  |  |  .  | \s
                |____7|  |____8|  |____9|  |___10|  |____J|  |____Q| \s
                 _____    _____    _____    _____    _____    _____  \s
                |K ^  |  |A  _ |  |2  _ |  |3  _ |  |4  _ |  |5  _ | \s
                | / \\ |  |( v )|  |( v )|  |( v )|  |( v )|  |( v )| \s
                | \\ / |  | \\ / |  | \\ / |  | \\ / |  | \\ / |  | \\ / | \s
                |  .  |  |  .  |  |  .  |  |  .  |  |  .  |  |  .  | \s
                |____K|  |____A|  |____2|  |____3|  |____4|  |____5| \s
                 _____    _____    _____    _____    _____    _____  \s
                |6  _ |  |7  _ |  |8  _ |  |9  _ |  |10 _ |  |J  _ | \s
                |( v )|  |( v )|  |( v )|  |( v )|  |( v )|  |( v )| \s
                | \\ / |  | \\ / |  | \\ / |  | \\ / |  | \\ / |  | \\ / | \s
                |  .  |  |  .  |  |  .  |  |  .  |  |  .  |  |  .  | \s
                |____6|  |____7|  |____8|  |____9|  |___10|  |____J| \s
                 _____    _____    _____    _____    _____    _____  \s
                |Q  _ |  |K  _ |  |A .  |  |2 .  |  |3 .  |  |4 .  | \s
                |( v )|  |( v )|  | /.\\ |  | /.\\ |  | /.\\ |  | /.\\ | \s
                | \\ / |  | \\ / |  |(_._)|  |(_._)|  |(_._)|  |(_._)| \s
                |  .  |  |  .  |  |  |  |  |  |  |  |  |  |  |  |  | \s
                |____Q|  |____K|  |____A|  |____2|  |____3|  |____4| \s
                 _____    _____    _____    _____    _____    _____  \s
                |5 .  |  |6 .  |  |7 .  |  |8 .  |  |9 .  |  |10.  | \s
                | /.\\ |  | /.\\ |  | /.\\ |  | /.\\ |  | /.\\ |  | /.\\ | \s
                |(_._)|  |(_._)|  |(_._)|  |(_._)|  |(_._)|  |(_._)| \s
                |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  | \s
                |____5|  |____6|  |____7|  |____8|  |____9|  |___10| \s
                 _____    _____    _____    _____    _____    _____  \s
                |J .  |  |Q .  |  |K .  |  |A _  |  |2 _  |  |3 _  | \s
                | /.\\ |  | /.\\ |  | /.\\ |  | ( ) |  | ( ) |  | ( ) | \s
                |(_._)|  |(_._)|  |(_._)|  |(_'_)|  |(_'_)|  |(_'_)| \s
                |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  | \s
                |____J|  |____Q|  |____K|  |____A|  |____2|  |____3| \s
                 _____    _____    _____    _____    _____    _____  \s
                |4 _  |  |5 _  |  |6 _  |  |7 _  |  |8 _  |  |9 _  | \s
                | ( ) |  | ( ) |  | ( ) |  | ( ) |  | ( ) |  | ( ) | \s
                |(_'_)|  |(_'_)|  |(_'_)|  |(_'_)|  |(_'_)|  |(_'_)| \s
                |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  |  | \s
                |____4|  |____5|  |____6|  |____7|  |____8|  |____9| \s
                 _____    _____    _____    _____    _____    _____  \s
                |10_  |  |J _  |  |Q _  |  |K _  |  |J   *|  |J   *| \s
                | ( ) |  | ( ) |  | ( ) |  | ( ) |  | O   |  | O   | \s
                |(_'_)|  |(_'_)|  |(_'_)|  |(_'_)|  |  K  |  |  K  | \s
                |  |  |  |  |  |  |  |  |  |  |  |  |   E |  |   E | \s
                |___10|  |____J|  |____Q|  |____K|  |*___R|  |*___R| \s
                """;
        Assertions.assertEquals(expected, deck.toString());
    }
}