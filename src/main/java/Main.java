import view.Viewer;

import javax.mail.MessagingException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, MessagingException {
        Viewer GUI = new Viewer();
        GUI.GuestView();
    }

}