package pendmain;

import java.awt.*;

/**
 *
 * @author Marco Feb 14, 2018 7:31:25 PM
 */
public class View extends javax.swing.JPanel {

    Controller theController;

    public View() {
        initComponents();
        reset(); 
    }
    
    void reset(){
        theController = new Controller(this);
        theController.addPend(new Pendulum(320, 200, .2, 0, 300));
        theController.addPend(new Pendulum(300, 200, 0.01, 0, 300));
        theController.addPend(new Pendulum(280, 200, 0, 0, 300));
        theController.addPend(new Pendulum(260, 200, 0, 0, 300));
        theController.addPend(new Pendulum(240, 200, 0, 0, 300));
        theController.start();
        
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        theController.paint(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        setLayout(null);

        goButton.setText("GO");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });
        add(goButton);
        goButton.setBounds(90, 10, 200, 80);

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        add(resetButton);
        resetButton.setBounds(320, 10, 78, 29);
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        // TODO add your handling code here:
        //System.out.println("button????");
        theController.toggleRunning();
    }//GEN-LAST:event_goButtonActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
        int mouseX = evt.getX();
        int mouseY = evt.getY();
        //System.out.println("x,y = " + mouseX + " " + mouseY);
        theController.addPend(new Pendulum(300, 200, mouseX, mouseY));
        repaint();
    }//GEN-LAST:event_formMousePressed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_resetButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton goButton;
    private javax.swing.JButton resetButton;
    // End of variables declaration//GEN-END:variables

}
