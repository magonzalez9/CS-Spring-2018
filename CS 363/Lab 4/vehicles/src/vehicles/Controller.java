package vehicles;

/*
 * Controller.java
 *
 * Created on September 11, 2003, 11:13 AM
 * Modified most recently 2/20/18 to clean things up and add comments
 */

import java.applet.*;
import java.awt.*;

/** Runs the World, Threaded so the animation works. */
public class Controller extends Thread {
    
    VFramePanel thePanel;       // the View!
    int stepsToTake;
    AbstractWorld theWorld;  // the Model!
    
    /** Creates a new instance of Controller
     * @param theApplet The calling Applet, so the Controller can repaint() it.
     */
    public Controller(VFramePanel p) {
        thePanel = p;
        theWorld = new ProtoWorld();
    }
    
    /** Paint the World (by passing the buck to theWorld)
     * @param g The screen
     */    
    public void paint(Graphics g) {
        theWorld.paint(g);
    }
    
    /** Add one to the number of steps to take. */    
    public void incSteps() {stepsToTake++;}
    
    /** Forever loop, controlled by the variable stepsToTake */    
    public void run() {
        System.out.println("running");
        for (;;) {
            if (stepsToTake > 0) {      // if we should take a step, do so
                stepsToTake--;
                step();
            }
            delay(33);                  // always delay, to avoid spin-lock
         }
   }
    
    /** Does one step -- step, repaint, pause */    
    private void step() {
        theWorld.step();
        thePanel.repaint();
     }
    
    /** Waits a bit
     * @param t num milliseconds to pause
     *
     */    
    private void delay(int t) {
        try {
            sleep(t);  
        } catch (Exception e) {}
    }
}