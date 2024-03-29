package TP.menu;

public class Menu {
    String m_title;
    String[] m_options;

    public Menu(String title, String[] options) {
        m_title = title;
        m_options = options;
    }

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
