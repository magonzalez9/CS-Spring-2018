/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv_proto;

/**
 *
 * @author marco
 */
public class GraphControls extends javax.swing.JFrame {

    private DisplayGrapher displayGrapher;
    private DisplayPhase displayPhase;
    int h = 10000;
    int h2 = h;
    int p = 10;
    int p2 = p;
    double a, b, α, β;
    static DataPairList list = new DataPairList();

    /**
     * Creates new form GraphControls
     */
    public GraphControls() {
        initComponents();
        setVisible(true);
        this.setSize(500, 500);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        aTextField = new javax.swing.JTextField();
        bTextField = new javax.swing.JTextField();
        alphaTextField = new javax.swing.JTextField();
        betaTextField = new javax.swing.JTextField();
        aLabel = new javax.swing.JLabel();
        bLabel = new javax.swing.JLabel();
        alphaLabel = new javax.swing.JLabel();
        betaLabel = new javax.swing.JLabel();
        textField = new javax.swing.JTextField();
        graphButton = new javax.swing.JButton();
        phaseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        aTextField.setText(".05");
        getContentPane().add(aTextField);
        aTextField.setBounds(270, 50, 70, 20);

        bTextField.setText(".1");
        bTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(bTextField);
        bTextField.setBounds(270, 90, 70, 20);

        alphaTextField.setText(".00001");
        alphaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alphaTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(alphaTextField);
        alphaTextField.setBounds(270, 130, 70, 20);

        betaTextField.setText(".00001");
        betaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                betaTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(betaTextField);
        betaTextField.setBounds(270, 170, 70, 20);

        aLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        aLabel.setText("a");
        getContentPane().add(aLabel);
        aLabel.setBounds(250, 50, 10, 17);

        bLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bLabel.setText("b");
        getContentPane().add(bLabel);
        bLabel.setBounds(250, 90, 20, 20);

        alphaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alphaLabel.setText("α");
        getContentPane().add(alphaLabel);
        alphaLabel.setBounds(250, 120, 20, 30);

        betaLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        betaLabel.setText("β");
        getContentPane().add(betaLabel);
        betaLabel.setBounds(250, 160, 20, 30);

        textField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldActionPerformed(evt);
            }
        });
        getContentPane().add(textField);
        textField.setBounds(10, 40, 180, 240);

        graphButton.setText("Graph");
        graphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphButtonActionPerformed(evt);
            }
        });
        getContentPane().add(graphButton);
        graphButton.setBounds(270, 210, 73, 23);

        phaseButton.setText("Phase");
        phaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phaseButtonActionPerformed(evt);
            }
        });
        getContentPane().add(phaseButton);
        phaseButton.setBounds(270, 250, 80, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bTextFieldActionPerformed

    private void betaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_betaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_betaTextFieldActionPerformed

    private void textFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldActionPerformed

    private void graphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphButtonActionPerformed
        makeTheOtherFrame();
        a = Double.parseDouble(aTextField.getText());
        b = Double.parseDouble(bTextField.getText());
        α = Double.parseDouble(alphaTextField.getText());
        β = Double.parseDouble(betaTextField.getText());

        // Populate list
        while (h > 0 && p > 0) {
            int hp = h * p;
            int hp2 = h2 * p2;
            h += a * h - α * hp;
            p += β * hp - b * p;
            int dh = (int) (a * h2 - α * hp2);
            int dp = (int) (β * hp2 - b * p2);
            h2 += dh;
            p2 += dp;

            list.add(new DataPair(h, p));
        }

        // Send list to otherFrame
        displayGrapher.go(list);
    }//GEN-LAST:event_graphButtonActionPerformed

    private void alphaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alphaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alphaTextFieldActionPerformed

    private void phaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phaseButtonActionPerformed
        // TODO add your handling code here:
        makePhaseGrapher();
        a = Double.parseDouble(aTextField.getText());
        b = Double.parseDouble(bTextField.getText());
        α = Double.parseDouble(alphaTextField.getText());
        β = Double.parseDouble(betaTextField.getText());

        // Populate list
        while (h > 0 && p > 0) {
            int hp = h * p;
            int hp2 = h2 * p2;
            h += a * h - α * hp;
            p += β * hp - b * p;
            int dh = (int) (a * h2 - α * hp2);
            int dp = (int) (β * hp2 - b * p2);
            h2 += dh;
            p2 += dp;

            list.add(new DataPair(h, p));
        }

        // Send list to otherFrame
        displayPhase.go(list);

    }//GEN-LAST:event_phaseButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GraphControls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GraphControls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GraphControls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GraphControls.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GraphControls().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aLabel;
    private javax.swing.JTextField aTextField;
    private javax.swing.JLabel alphaLabel;
    private javax.swing.JTextField alphaTextField;
    private javax.swing.JLabel bLabel;
    private javax.swing.JTextField bTextField;
    private javax.swing.JLabel betaLabel;
    private javax.swing.JTextField betaTextField;
    private javax.swing.JButton graphButton;
    private javax.swing.JButton phaseButton;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
    private void makeTheOtherFrame() {
        displayGrapher = new DisplayGrapher();
    }

    private void makePhaseGrapher() {
        displayPhase = new DisplayPhase();
    }
}
