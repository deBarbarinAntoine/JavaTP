package TP.TP2.matches;

import static TP.utils.utils.getIntInput;

public class HumanPlayer implements Player {

    private String m_name;

    HumanPlayer(String name) {
        m_name = name;
    }

    @Override
    public int play(int matches) {
        System.out.println("Player 1: " + m_name);
        int choice;
        do {
            choice = getIntInput("How many matches do you want to take? [1-3]");
        } while (choice > 3 || choice < 1 || choice > matches);
        return choice;
    }

    @Override
    public String getM_name() {
        return m_name;
    }
}
