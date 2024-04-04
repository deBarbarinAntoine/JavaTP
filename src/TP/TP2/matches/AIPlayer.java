package TP.TP2.matches;

public class AIPlayer implements Player {

    private String m_name;

    @Override
    public void play() {
        System.out.println("IAPlayer " + m_name);
    }

    @Override
    public String getM_name() {
        return m_name;
    }
}
