package TP.TP2.matches;

public interface Player {
    public int play(int matches);
    public String getName();
    public type getType();

    enum type {
        Human, Computer,
    }
}
