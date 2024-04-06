package TP.TP2.matches;

import static java.lang.Math.random;

public class AIPlayer implements Player {

    private String m_name;

    AIPlayer(String name) {
        m_name = name;
    }

    @Override
    public int play(int matches) {
        System.out.println("Player 2: " + m_name);
        if (matches < 4) {
            return matches;
        }
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
