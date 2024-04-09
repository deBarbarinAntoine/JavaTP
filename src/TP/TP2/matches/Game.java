package TP.TP2.matches;

import java.util.Scanner;

import static TP.utils.utils.getIntInput;
import static java.lang.Math.random;

/**
 * The type Game.
 */
public class Game {

    private Player player1;
    private Player player2;
    private int matches;
    private boolean isEnded;

    /**
     * Instantiates a new Game with the player input.
     */
    public Game() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Match Game!");

        // taking the player's name
        System.out.println("Enter your name: ");
        String name = input.nextLine();

        // taking the number of matches for the game
        this.matches = getIntInput("How many matches do you want? [< 5 for random and 30 maximum]");

        // instantiate a new player for Player 1
        this.player1 = new HumanPlayer(name);

        // choosing the opponent's type
        System.out.println("Do you want to play against an AI? (Y/n)");
        String answer = input.nextLine();

        // Human Player
        if (answer.equalsIgnoreCase("N")) {

            // taking the player's name
            System.out.println("Player 2 > Enter your name: ");
            String namePlayer2 = input.nextLine();

            // instantiate a new player for Player 2
            this.player2 = new HumanPlayer(namePlayer2);

        // AI Player: instantiate a new AIPlayer for Player 2
        } else {
            this.player2 = new AIPlayer("AI player");
        }

        // initializing the matches number if necessary
        if (this.matches < 5 || this.matches > 30) {
            this.matches = (int) (random() * 100000) % 30;
        }
    }

    @Override
    public String toString() {
        return " |".repeat(matches);
    }

    /**
     * Play the game!
     */
    public void play() {
        do {
            // display the matches
            System.out.println(this);

            // refresh the matches' number according to the first player's turn
            this.matches -= player1.play(this.matches);

            // checking if there are no matches left
            if (this.matches <= 0) {
                this.isEnded = true;

                // endgame message
                System.out.println(player2.getName() + " won the game!");
                break;
            }

            // checking the player 2's type
            switch (player2.getType()) {

                // human player
                case Human -> {

                    // display the matches
                    System.out.println(this);

                    // refresh the matches' number according to the second player's turn
                    this.matches -= player2.play(this.matches);
                }
                // AI player
                case Computer -> {

                    // getting the second player's pick
                    int AIplay = player2.play(this.matches);

                    // refresh the matches' number
                    this.matches -= AIplay;

                    // display the AI player's pick
                    System.out.println(player2.getName()+ " took "+ AIplay + " matches.");
                }
            }

            // checking if there are no matches left
            if (this.matches <= 0) {
                this.isEnded = true;

                // endgame message
                System.out.println(player1.getName() + " won the game!");
            }

        // loop through the game until it ends
        } while (!isEnded);
    }
}
