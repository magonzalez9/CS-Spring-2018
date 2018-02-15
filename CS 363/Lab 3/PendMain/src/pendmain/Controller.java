
package pendmain;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 *
 * @author Marco
 */
class Controller extends Thread {
    boolean running = false;
    Model theModel;
    private final View theView;
    
    Controller(View thePanel) {
        this.theView = thePanel;
        theModel = new Model();
    }


    public void run() {
        for(;;) {
            if (running) {
                theModel.step();
                theView.repaint();
            }
            delay();
        }
    }
    
    void toggleRunning() {
        running = !running;
    }

    void paint(Graphics g) {
        theModel.paint(g);
//        Graphics2D g2 = (Graphics2D) g;
//        g2.translate(300, 200);
//        g2.rotate(Math.PI/2);
//        g2.translate(-300, -200);
    }

    private void delay() {
        try {
            sleep(33);
        } catch (Exception e){}
    }

    void addPend(Pendulum pendulum) {
        theModel.add(pendulum);
    }


}
