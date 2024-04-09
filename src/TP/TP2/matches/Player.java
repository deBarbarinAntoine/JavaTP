package TP.TP2.matches;

/**
 * The interface Player.
 */
public interface Player {
    /**
     * Play: the player's turn.
     *
     * @param matches the number of matches left in the game
     * @return the number of matches taken by the player
     */
    public int play(int matches);

    /**
     * Gets the player's name.
     *
     * @return the name
     */
    public String getName();

    /**
     * Gets the player's type.
     *
     * @return the type
     */
    public type getType();

    /**
     * The enum Type.
     */
    enum type {
        /**
         * Human type.
         */
        Human,
        /**
         * Computer type.
         */
        Computer,
    }
}
