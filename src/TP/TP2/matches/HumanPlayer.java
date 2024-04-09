package TP.TP2.matches;

import static TP.utils.utils.getIntInput;

/**
 * The type Human player.
 */
public class HumanPlayer implements Player {

    private String m_name;

    /**
     * Instantiates a new Human player.
     *
     * @param name the player's name
     */
    HumanPlayer(String name) {
        m_name = name;
    }

    @Override
    public int play(int matches) {

        // display the player's name
        System.out.println("Player 1: " + m_name);

        int choice;
        do {
            // takes the player's input
            choice = getIntInput("How many matches do you want to take? [1-3]");
        } while (choice > 3 || choice < 1 || choice > matches);

        return choice;
    }

    @Override
    public String getName() {
        return m_name;
    }

    @Override
    public type getType() {
        return type.Human;
    }
}
