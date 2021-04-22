import java.awt.EventQueue;

import javax.swing.JFrame;

public class Library extends JFrame {
    static Library frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame= new Library();
                    frame.setVisible(true);
                } catch (Exception r) {
                    r.printStackTrace();
                }
            }
        });
    }

}
