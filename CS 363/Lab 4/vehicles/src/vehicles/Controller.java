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
    
    Applet theApplet;       // the View!
    VehiclePanel vPanel;        // the Better View!
    boolean runningBool = false;
    
    int delayNum = 33;
    
    int stepsToTake;
    AbstractWorld theWorld;  // the Model!
    
    /** Creates a new instance of Controller
     * @param theApplet The calling Applet, so the Controller can repaint() it.
     */
    public Controller(Applet theApplet) {
        this.theApplet = theApplet;
        theWorld = new ProtoWorld();
    }
    
    public Controller(VehiclePanel vP) {
        this.vPanel = vP;
        theWorld = new ProtoWorld();
    }
    
    /** Paint the World (by passing the buck to theWorld)
     * @param g The screen
     */    
    public void paint(Graphics g) {
        theWorld.paint(g);
    }
    
    /** Add one to the number of steps to take. */    
    public void toggleRunning(){
        runningBool = !runningBool;
    }
    
    public void incStep(){
        stepsToTake = 1;
    }
    
    public void incSteps(){
        
    }
    
    public void flushVehicles(){
        theWorld.flushVehicles();
    }
    
    /** Forever loop, controlled by the variable stepsToTake */    
    public void run() {
        System.out.println("running");
        for (;;) {
            if (stepsToTake > 0) {      // if we should take a step, do so
                stepsToTake--;
                step();
            } else if(runningBool){
                step();
            }
            delay(delayNum);                  // always delay, to avoid spin-lock
         }
   }
    
    /** Does one step -- step, repaint, pause */    
    private void step() {
        theWorld.step();
        vPanel.repaint();
     }
    
    void setDelay(int d){
        this.delayNum = d;
    }
    
    int getDelay(){
       return this.delayNum; 
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

    void addVehicle(AbstractVehicle vehicle) {
        theWorld.addVehicle(vehicle);
    }
    
    void addSource(AbstractSource source){
        theWorld.addSource(source);
    }

    void flushSources() {
        theWorld.flushSources();
    }
}
