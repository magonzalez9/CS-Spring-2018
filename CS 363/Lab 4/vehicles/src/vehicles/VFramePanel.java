package vehicles;

import java.awt.*;

/**
 *
 * @author Marco Feb 20, 2018 3:51:14 PM
 */
public class VFramePanel extends javax.swing.JPanel {

    public VFramePanel() {
        initComponents();
        setLayout(null);
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        theController.paint(); 
        g.fillOval(100,100,100,100);            // Just checking!
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setLayout(null);

        jButton1.setText("step");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(50, 30, 75, 29);

        jButton2.setText("run forever");
        add(jButton2);
        jButton2.setBounds(40, 60, 113, 29);

        jButton3.setText("reset");
        add(jButton3);
        jButton3.setBounds(30, 100, 75, 29);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables

}
