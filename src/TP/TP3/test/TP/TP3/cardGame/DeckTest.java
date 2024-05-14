package TP.TP3.cardGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

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

        HashSet<Card> Hearts = new HashSet<>();
        HashSet<Card> Diamonds = new HashSet<>();
        HashSet<Card> Spades = new HashSet<>();
        HashSet<Card> Clubs = new HashSet<>();
        HashSet<Card> Jokers = new HashSet<>();

        for (Card card: deck) {
            if (card.getValue().equals("JOKER")) {
                Jokers.add(card);
                continue;
            }
            switch (card.getColor()) {
                case "HEARTS":
                    Hearts.add(card);
                    break;
                case "DIAMONDS":
                    Diamonds.add(card);
                    break;
                case "CLUBS":
                    Clubs.add(card);
                    break;
                case "SPADES":
                    Spades.add(card);
                    break;
                default:
                    throw new IllegalStateException("Unexpected card color");
            }
        }

        Assertions.assertNotNull(Hearts);
        Assertions.assertEquals(13, Hearts.size());

        Assertions.assertNotNull(Diamonds);
        Assertions.assertEquals(13, Diamonds.size());

        Assertions.assertNotNull(Clubs);
        Assertions.assertEquals(13, Clubs.size());

        Assertions.assertNotNull(Spades);
        Assertions.assertEquals(13, Spades.size());

        Assertions.assertNotNull(Jokers);
        Assertions.assertEquals(2, Jokers.size());
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
        for (int i = 0; i < deck.getCards().size(); ++i) {
            equals = deck.getCards().get(i).equal(shuffledDeck.getCards().get(i));
            if (!equals) break;
        }
        Assertions.assertFalse(equals);
    }

    /**
     * isEmpty.
     */
    @Test
    void isEmpty() {
        Deck deck = Deck.newDeck();

        for (int i = 0; i < 54; ++i) {
            Assertions.assertFalse(deck.isEmpty());
            deck.draw();
        }

        Assertions.assertTrue(deck.isEmpty());
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

        for (int i = 0; i < 53; ++i) {
            deck.draw();
        }

        Assertions.assertTrue(deck.isEmpty());
        Assertions.assertNull(deck.draw());
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

    @Test
    void testClone() {
        
    }
}