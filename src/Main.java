import view.Viewer;

import java.io.IOException;

/**
 * The Main class is the entry point of the program. It creates a Viewer object and displays the GuestView.
 */
public class Main {

    /**
     * The main method creates a Viewer object and displays the GuestView.
     * @param args the command-line arguments
     * @throws IOException if an I/O error occurs
     */
    public static void main(String[] args) throws IOException {
        Viewer GUI = new Viewer();
        GUI.GuestView();
    }
}
