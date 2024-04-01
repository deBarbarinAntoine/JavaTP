package TP.menu;

/**
 * The type Menu.
 */
public class Menu {
    /**
     * The title.
     */
    private String m_title;
    /**
     * The options.
     */
    private String[] m_options;

    /**
     * Instantiates a new Menu.
     *
     * @param title   the title
     * @param options the options
     */
    public Menu(String title, String[] options) {
        m_title = title;
        m_options = options;
    }

    /**
     * Displays the menu and takes the user's input.
     *
     * @return the user's choice.
     */
    public int display() {

        System.out.println(m_title);
        System.out.println();

        for (int i = 0; i < m_options.length; ++i) {
            System.out.println(i+1 + ".\t" + m_options[i]);
        }
        System.out.println("\n0.\tCancel\n");
        System.out.println();

        int choice = 0;
        do {
            choice = TP.utils.utils.getIntInput("Choose an option [0-"+m_options.length+"]:");
        } while (choice < 0 || choice > m_options.length);


        return choice;
    }
}
