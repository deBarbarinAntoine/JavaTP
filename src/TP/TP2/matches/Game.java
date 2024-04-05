package TP.TP2.matches;

import java.util.Scanner;

import static java.lang.Math.random;

public class Game {

    private Player player1;
    private Player player2;
    private int matches;
    private boolean isEnded;

    public Game() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Match Game!");
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        player1 = new HumanPlayer(name);
        player2 = new AIPlayer("AI player");
        matches = (int) (random() * 100000) % 30;
    }

    @Override
    public String toString() {
        return " |".repeat(matches);
    }

    public void play() {
        do {
            System.out.println(this);
            this.matches -= player1.play(this.matches);
            if (this.matches <= 0) {
                this.isEnded = true;
                System.out.println(player1.getM_name() + " won the game!");
                break;
            }
            int AIplay = player2.play(this.matches);
            this.matches -= AIplay;
            System.out.println(player2.getM_name()+ " took "+ AIplay + " matches.");
            if (this.matches <= 0) {
                this.isEnded = true;
                System.out.println(player2.getM_name() + " won the game!");
            }
        } while (!isEnded);
    }
}
