import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LibraryView extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LibraryView frame = new LibraryView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
