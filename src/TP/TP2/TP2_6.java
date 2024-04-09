package TP.TP2;

import TP.TP2.matches.Game;

/**
 * The type Tp 2 6.
 */
public class TP2_6 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        matchesGame();
    }

    /**
     * Matches game: static method to initiate a new game.
     */
    public static void matchesGame() {

        // instantiate a new game
        Game game = new Game();

        // play the game
        game.play();
    }
}
