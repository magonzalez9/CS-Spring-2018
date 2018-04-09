package dragrace;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Container extends JComponent {

    static JPanel panel;
    static int column = 3;
    static int row = 195;

    Container(JPanel panel) {
        this.panel = panel;
        setBounds(0, 0, panel.getWidth(), panel.getHeight());
    }

    public void paint(Graphics g) {
        ImageIcon image = new ImageIcon(new ImageIcon(getClass().getResource("images/car1.png")).getImage());

        g.drawImage(image.getImage(), column, row, 80, 40, null);

        ImageIcon image2 = new ImageIcon(new ImageIcon(getClass().getResource("images/car2.png")).getImage());

        g.drawImage(image2.getImage(), column, 90, 80, 40, null);

        ImageIcon image3 = new ImageIcon(new ImageIcon(getClass().getResource("images/car6.png")).getImage());

        g.drawImage(image3.getImage(), column, 260, 80, 40, null);

        g.setColor(Color.WHITE);

        // draw the track here...
    }

    static Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                while (true) {

                    panel.repaint();

                    column += 10; // this will be the speed 

                    thread.sleep(100);
                }

            } catch (java.lang.InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    };

    public static void move() {
        if (!thread.isAlive()) {
            thread.start();
        }
        column = 3;
    }
}
