/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montehall;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marco
 */
public class MonteFrame extends javax.swing.JFrame {

    MontePlay play = new MontePlay();
    List<Boolean> doors = new ArrayList<>();

    public MonteFrame() {
        initComponents();
        door1.setOpaque(true);
        door2.setOpaque(true);
        door3.setOpaque(true);
        switchButton.setVisible(false);
        stayButton.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        door1 = new javax.swing.JButton();
        door2 = new javax.swing.JButton();
        door3 = new javax.swing.JButton();
        switchButton = new javax.swing.JButton();
        stayButton = new javax.swing.JButton();
        retryButton = new javax.swing.JButton();
        iterationInput = new javax.swing.JTextField();
        generateSwitch = new javax.swing.JButton();
        generateStay = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        door1.setText("Door 1");
        door1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                door1ActionPerformed(evt);
            }
        });
        getContentPane().add(door1);
        door1.setBounds(40, 30, 100, 160);

        door2.setText("Door 2");
        door2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                door2ActionPerformed(evt);
            }
        });
        getContentPane().add(door2);
        door2.setBounds(170, 30, 100, 160);

        door3.setText("Door 3");
        door3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                door3ActionPerformed(evt);
            }
        });
        getContentPane().add(door3);
        door3.setBounds(290, 30, 100, 160);

        switchButton.setText("Switch");
        switchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(switchButton);
        switchButton.setBounds(110, 200, 100, 29);

        stayButton.setText("Stay");
        stayButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stayButtonActionPerformed(evt);
            }
        });
        getContentPane().add(stayButton);
        stayButton.setBounds(220, 200, 100, 29);

        retryButton.setText("Go Again");
        retryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retryButtonActionPerformed(evt);
            }
        });
        getContentPane().add(retryButton);
        retryButton.setBounds(400, 30, 100, 29);
        getContentPane().add(iterationInput);
        iterationInput.setBounds(640, 50, 130, 40);

        generateSwitch.setText("Switch");
        generateSwitch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateSwitchActionPerformed(evt);
            }
        });
        getContentPane().add(generateSwitch);
        generateSwitch.setBounds(690, 90, 90, 29);

        generateStay.setText("Stay");
        generateStay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateStayActionPerformed(evt);
            }
        });
        getContentPane().add(generateStay);
        generateStay.setBounds(690, 120, 90, 29);

        jLabel1.setText("Simulate");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(640, 30, 80, 20);

        textArea.setColumns(20);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 260, 450, 160);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void door1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_door1ActionPerformed
        // TODO add your handling code here:
        doors = play.selectDoor(0);
        door1.setBackground(Color.GREEN);
        door1.setEnabled(false);

        if (play.getDonkeyDoor() == 1) {
            door2.setText("Donkey");
            door3.setBackground(Color.YELLOW);
            door2.setEnabled(false);
        } else if (play.getDonkeyDoor() == 2) {
            door3.setText("Donkey");
            door2.setBackground(Color.YELLOW);
            door3.setEnabled(false);
        }

        textArea.setText("Would you like to switch doors or stay");

        switchButton.setVisible(true);
        stayButton.setVisible(true);


    }//GEN-LAST:event_door1ActionPerformed

    private void switchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_switchButtonActionPerformed
        // TODO add your handling code here:
        play.setStay(false);
        play.getGameResult();
        textArea.setText(doors.toString() + "\n" + play.getResultString());
        door1.setBackground(null);
        door2.setBackground(null);
        door3.setBackground(null);

//        if (door1.isEnabled()) {
//            door1.setBackground(Color.GREEN);
//        } else if (door2.isEnabled()) {
//            door2.setBackground(Color.GREEN);
//        } else {
//            door3.setBackground(Color.GREEN);
//        }
        switchButton.setVisible(false);
        stayButton.setVisible(false);

      
        
        if (play.getDoors().get(0) == false){
            door1.setBackground(Color.red);
        } else{
            door1.setBackground(Color.green);
        }
        if (play.getDoors().get(1) == false){
            door2.setBackground(Color.red);
        } else{
            door2.setBackground(Color.green);
        }
         if (play.getDoors().get(2) == false){
            door3.setBackground(Color.red);
        } else {
             door3.setBackground(Color.green);
         }
        


    }//GEN-LAST:event_switchButtonActionPerformed

    private void stayButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stayButtonActionPerformed
        // TODO add your handling code here:
        play.setStay(true);
        play.getGameResult();
        textArea.setText(doors.toString() + " \n" + play.getResultString());
        switchButton.setVisible(false);
        stayButton.setVisible(false);

        if (play.getDoors().get(0) == false){
            door1.setBackground(Color.red);
        } else{
            door1.setBackground(Color.green);
        }
        
        if (play.getDoors().get(1) == false){
            door2.setBackground(Color.red);
        } else{
            door2.setBackground(Color.green);
        }
        
         if (play.getDoors().get(2) == false){
            door3.setBackground(Color.red);
        } else {
             door3.setBackground(Color.green);
         }

    }//GEN-LAST:event_stayButtonActionPerformed

    private void door2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_door2ActionPerformed
        // TODO add your handling code here:
        doors = play.selectDoor(1);
        door2.setBackground(Color.GREEN);
        door2.setEnabled(false);

        if (play.getDonkeyDoor() == 0) {
            door1.setText("Donkey");
            door3.setBackground(Color.YELLOW);
            door1.setEnabled(false);

        } else if (play.getDonkeyDoor() == 2) {
            door3.setText("Donkey");
            door1.setBackground(Color.YELLOW);
            door3.setEnabled(false);
        }
        textArea.setText("Would you like to switch doors or stay");

        switchButton.setVisible(true);
        stayButton.setVisible(true);
    }//GEN-LAST:event_door2ActionPerformed

    private void door3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_door3ActionPerformed
        // TODO add your handling code here:
        doors = play.selectDoor(2);
        door3.setBackground(Color.GREEN);
        door3.setEnabled(false);

        if (play.getDonkeyDoor() == 0) {
            door1.setText("Donkey");
            door1.setEnabled(false);
            door2.setBackground(Color.YELLOW);
        } else if (play.getDonkeyDoor() == 1) {
            door2.setText("Donkey");
            door2.setEnabled(false);
            door1.setBackground(Color.YELLOW);
        }
        textArea.setText("Would you like to switch doors or stay");

        switchButton.setVisible(true);
        stayButton.setVisible(true);
    }//GEN-LAST:event_door3ActionPerformed

    private void retryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retryButtonActionPerformed
        // TODO add your handling code here:
        door1.setEnabled(true);
        door2.setEnabled(true);
        door3.setEnabled(true);

        door1.setBackground(null);
        door2.setBackground(null);
        door3.setBackground(null);
        door1.setText("Door 1");
        door2.setText("Door 2");
        door3.setText("Door 3");

        textArea.setText(null);
    }//GEN-LAST:event_retryButtonActionPerformed

    private void generateSwitchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateSwitchActionPerformed
        // TODO add your handling code here:
        String iterateString = iterationInput.getText();
        int iterate = Integer.parseInt(iterateString);

        play.simulate(iterate, 1);

        textArea.setText("SWITCHED and iterated: " + iterate + " time(s)"
                + "\n" + "Times Won: " + play.getTimesWon()
                + "\n" + "Times Lost: " + play.getTimesLost());


    }//GEN-LAST:event_generateSwitchActionPerformed

    private void generateStayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateStayActionPerformed
        // TODO add your handling code here:
        String iterateString = iterationInput.getText();
        int iterate = Integer.parseInt(iterateString);

        play.simulate(iterate, 0);
        textArea.setText("STAYED and iterated: " + iterate + " time(s)"
                + "\n" + "Times Won: " + play.getTimesWon()
                + "\n" + "Times Lost: " + play.getTimesLost());
   
    }//GEN-LAST:event_generateStayActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MonteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MonteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MonteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MonteFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton door1;
    private javax.swing.JButton door2;
    private javax.swing.JButton door3;
    private javax.swing.JButton generateStay;
    private javax.swing.JButton generateSwitch;
    private javax.swing.JTextField iterationInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton retryButton;
    private javax.swing.JButton stayButton;
    private javax.swing.JButton switchButton;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables
}
