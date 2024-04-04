package TP.TP2.matches;

public class Game {

    private Player player1;
    private Player player2;

    public Game() {
        player1 = new HumanPlayer();
        player2 = new AIPlayer();
    }
}
