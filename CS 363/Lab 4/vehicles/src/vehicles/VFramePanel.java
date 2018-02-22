package vehicles;

import java.awt.*;

/**
 *
 * @author Marco Feb 20, 2018 3:51:14 PM
 */
public class VFramePanel extends javax.swing.JPanel {

   Controller theController;

    public VFramePanel() {
        initComponents();
        reset();
        
    }
    
    public void reset() {
        theController = new Controller(this);
        setSize(1500, 1500);
        theController.start();
    }
    
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        theController.paint(g);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stepButton = new javax.swing.JButton();
        runButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

        setLayout(null);

        stepButton.setText("step");
        stepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepButtonActionPerformed(evt);
            }
        });
        add(stepButton);
        stepButton.setBounds(20, 10, 70, 25);

        runButton.setText("run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });
        add(runButton);
        runButton.setBounds(20, 40, 70, 25);

        resetButton.setText("reset");
        add(resetButton);
        resetButton.setBounds(20, 70, 70, 25);
    }// </editor-fold>//GEN-END:initComponents

    private void stepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_stepButtonActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < 10; i++) {
            theController.incSteps();
        }
    }//GEN-LAST:event_runButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton resetButton;
    private javax.swing.JButton runButton;
    private javax.swing.JButton stepButton;
    // End of variables declaration//GEN-END:variables

}
