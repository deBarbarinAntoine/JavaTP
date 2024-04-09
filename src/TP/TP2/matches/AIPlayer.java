package TP.TP2.matches;

import static java.lang.Math.random;

/**
 * The type AI player.
 */
public class AIPlayer implements Player {

    private String m_name;

    /**
     * Instantiates a new AI player.
     *
     * @param name the player's name
     */
    AIPlayer(String name) {
        m_name = name;
    }

    @Override
    public int play(int matches) {

        // display the player's name
        System.out.println("Player 2: " + m_name);

        // smart play when it's crucial
        if (matches < 5 && matches > 1) {
            return matches - 1;

        // when there is no other choice
        } else if (matches == 1) {
            return 1;
        }

        // random play when it doesn't matter
        return (((int) (random() * 100000)) % 3) + 1;
    }

    @Override
    public String getName() {
        return m_name;
    }

    @Override
    public type getType() {
        return type.Computer;
    }
}
