package TP.TP2.matches;

import java.util.Scanner;

import static TP.utils.utils.getIntInput;
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
        this.matches = getIntInput("How many matches do you want? [< 5 for random and 30 maximum]");
        this.player1 = new HumanPlayer(name);
        System.out.println("Do you want to play against an AI? (Y/n)");
        String answer = input.nextLine();
        if (answer.equalsIgnoreCase("N")) {
            System.out.println("Player 2 > Enter your name: ");
            String namePlayer2 = input.nextLine();
            this.player2 = new HumanPlayer(namePlayer2);
        } else {
            this.player2 = new AIPlayer("AI player");
        }
        if (this.matches < 5 || this.matches > 30) {
            this.matches = (int) (random() * 100000) % 30;
        }
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
                System.out.println(player1.getName() + " won the game!");
                break;
            }
            switch (player2.getType()) {
                case Human -> {
                    System.out.println(this);
                    this.matches -= player2.play(this.matches);
                }
                case Computer -> {
                    int AIplay = player2.play(this.matches);
                    this.matches -= AIplay;
                    System.out.println(player2.getName()+ " took "+ AIplay + " matches.");
                }
            }
            if (this.matches <= 0) {
                this.isEnded = true;
                System.out.println(player2.getName() + " won the game!");
            }
        } while (!isEnded);
    }
}
