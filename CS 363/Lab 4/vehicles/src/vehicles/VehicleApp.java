package vehicles;

import java.awt.*;

/**
 * The applet for Vehicles. 
 *  
 * An old, sad Applet (you must use Run File), missing the VehicleApp.form file; this would be a good class to replace with a JFrame
 */
public class VehicleApp extends java.applet.Applet {
    
    Controller theController;
    Image offScreen;
    
    /** Initializes the applet VehicleApp */
    public void init() {
        ////System.out.println("initing");
        initComponents();
        reset();
    }
    
    void reset() {
        theController = new Controller(this);
        offScreen = this.createImage(1500, 1500);
        setSize(1500,1500);
        theController.start();
    }

//    public void stop() {
//        //System.out.println("adieu"); 
//        System.exit(0);
//    }
    
    /** paint the Controller, which will paint the world
     * @param g The Graphics context; what a surprise
     */    
    public void paint(Graphics g) {
        theController.paint(g);
    }

    /** 
     * Seems the Vehicle.form file got lost in the shuffle... 
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        stepButton = new java.awt.Button();
        runButton = new java.awt.Button();

        setLayout(null);

        stepButton.setLabel("step");
        stepButton.setName("null");
        stepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepButtonActionPerformed(evt);
            }
        });

        add(stepButton);
        stepButton.setBounds(0, 0, 40, 20);

        runButton.setLabel("run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        add(runButton);
        runButton.setBounds(0, 20, 50, 22);

    }//GEN-END:initComponents

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        for (int i=0; i<1000000; i++)
            theController.incSteps();
    }//GEN-LAST:event_runButtonActionPerformed

    private void stepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepButtonActionPerformed
        theController.incSteps();
    }//GEN-LAST:event_stepButtonActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button stepButton;
    private java.awt.Button runButton;
    // End of variables declaration//GEN-END:variables
    
}
