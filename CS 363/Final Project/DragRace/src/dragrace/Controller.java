package dragrace;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Controller extends JComponent {

    static JPanel panel;
    static int column = 1; // Track size will probably be from 1 - 1100
    static int row = 195;
    static boolean running = true;

    Controller(JPanel panel) {
        this.panel = panel;
    }

    static Thread thread = new Thread() {

        @Override
        public void run() {
            try {
                while (true) {
                    if (running) {
                        panel.repaint();
                        column += 10; // this will be the speed 

                    }
                    thread.sleep(100);
                    if (column == 100) {
                        toggleRunning();
                    }
                }

            } catch (java.lang.InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    };

    public static void toggleRunning() {
        if (thread.isAlive()) {
            running = !running;
        }

    }

    public static void move() {
        if (!thread.isAlive()) {
            thread.start();
        } else if (thread.isAlive()) {
            toggleRunning();
        }
        //column = 3;
    }
}