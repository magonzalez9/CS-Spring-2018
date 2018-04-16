package dragrace;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RaceFrame extends javax.swing.JFrame {

    DisplayRace displayRace;
    CarFreeList freeList = new CarFreeList();
    CarList carList = new CarList();

    public RaceFrame() {
        initComponents();
        setVisible(true);
        setSize(550, 445);
        displayRace = new DisplayRace();

        // set slider values
        speedSlider.setMinimum(1);
        speedSlider.setMaximum(10);
        speedSlider.setValue(4);
        accSlider.setMinimum(1);
        accSlider.setMaximum(10);
        accSlider.setValue(4);
        nitroSlider.setMinimum(1);
        nitroSlider.setMaximum(10);
        nitroSlider.setValue(4);
        fuelSlider.setMinimum(1);
        fuelSlider.setMaximum(10);
        fuelSlider.setValue(4);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        goButton = new javax.swing.JButton();
        comboBox = new javax.swing.JComboBox();
        speedSlider = new javax.swing.JSlider();
        addButton = new javax.swing.JButton();
        list_label = new javax.swing.JLabel();
        accSlider = new javax.swing.JSlider();
        nitroSlider = new javax.swing.JSlider();
        fuelSlider = new javax.swing.JSlider();
        v4Option = new javax.swing.JRadioButton();
        v6Option = new javax.swing.JRadioButton();
        v8Option = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        speedLabel = new javax.swing.JLabel();
        accLabel = new javax.swing.JLabel();
        nitroLabel = new javax.swing.JLabel();
        fuelLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        goButton.setText("Go");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });
        getContentPane().add(goButton);
        goButton.setBounds(360, 330, 110, 40);

        comboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(comboBox);
        comboBox.setBounds(360, 100, 120, 22);

        speedSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                speedSliderStateChanged(evt);
            }
        });
        speedSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                speedSliderMousePressed(evt);
            }
        });
        getContentPane().add(speedSlider);
        speedSlider.setBounds(30, 90, 190, 20);

        addButton.setText("Add Car");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        getContentPane().add(addButton);
        addButton.setBounds(370, 140, 110, 40);

        list_label.setText("Car List");
        getContentPane().add(list_label);
        list_label.setBounds(400, 80, 60, 16);

        accSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                accSliderStateChanged(evt);
            }
        });
        getContentPane().add(accSlider);
        accSlider.setBounds(30, 156, 190, 30);

        nitroSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                nitroSliderStateChanged(evt);
            }
        });
        getContentPane().add(nitroSlider);
        nitroSlider.setBounds(30, 220, 190, 26);

        fuelSlider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                fuelSliderStateChanged(evt);
            }
        });
        getContentPane().add(fuelSlider);
        fuelSlider.setBounds(30, 280, 190, 26);

        v4Option.setText("V4");
        v4Option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v4OptionActionPerformed(evt);
            }
        });
        getContentPane().add(v4Option);
        v4Option.setBounds(30, 350, 50, 25);

        v6Option.setText("V6");
        v6Option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v6OptionActionPerformed(evt);
            }
        });
        getContentPane().add(v6Option);
        v6Option.setBounds(80, 350, 50, 25);

        v8Option.setText("V8");
        v8Option.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                v8OptionActionPerformed(evt);
            }
        });
        getContentPane().add(v8Option);
        v8Option.setBounds(130, 350, 50, 25);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel1.setText("Engine Size:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 320, 110, 30);

        jLabel2.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 18)); // NOI18N
        jLabel2.setText("Race Car Simulation");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 10, 250, 40);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel3.setText("Top Speed:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 60, 110, 30);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel4.setText("Acceleration:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 120, 110, 40);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel5.setText("Nitro:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 190, 110, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel6.setText("Fuel: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 250, 110, 30);

        speedLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        speedLabel.setText("10");
        getContentPane().add(speedLabel);
        speedLabel.setBounds(230, 80, 30, 40);

        accLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        accLabel.setText("10");
        getContentPane().add(accLabel);
        accLabel.setBounds(230, 150, 50, 40);

        nitroLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        nitroLabel.setText("10");
        getContentPane().add(nitroLabel);
        nitroLabel.setBounds(230, 210, 50, 50);

        fuelLabel.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        fuelLabel.setText("10");
        getContentPane().add(fuelLabel);
        fuelLabel.setBounds(230, 270, 50, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        displayRace.go();
    }//GEN-LAST:event_goButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // Get car infomation
        String car_name = JOptionPane.showInputDialog("Please input the name of the car: ");
        int speed = speedSlider.getValue();
        int acceleration = accSlider.getValue();
        int nitro = nitroSlider.getValue();
        int fuel = fuelSlider.getValue();

        int engine_size = 0;
        if (v4Option.isSelected()) {
            engine_size = 4;
        } else if (v6Option.isSelected()) {
            engine_size = 6;
        } else {
            engine_size = 8;
        }

        // Create the car object and store it in CarFreeList
        ImageIcon car_image = new ImageIcon(new ImageIcon(getClass().getResource("images/"+freeList.remove(0))).getImage());
        RaceCar race_car = new RaceCar(car_name, speed, acceleration, nitro, fuel, engine_size, car_image);

        // Now we want to draw the car on the panel 
        displayRace.addCar(race_car);

//        
//        System.out.println("speed: " + speed);
//        System.out.println("Acc: " + acceleration);
//        System.out.println("Engine Size: " + engine_size);
//        System.out.println(car_name);
    }//GEN-LAST:event_addButtonActionPerformed

    private void v6OptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v6OptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v6OptionActionPerformed

    private void v8OptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v8OptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v8OptionActionPerformed

    private void v4OptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_v4OptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_v4OptionActionPerformed

    private void speedSliderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_speedSliderMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_speedSliderMousePressed

    private void speedSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_speedSliderStateChanged
        speedLabel.setText("" + speedSlider.getValue());
    }//GEN-LAST:event_speedSliderStateChanged

    private void accSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_accSliderStateChanged
        accLabel.setText("" + accSlider.getValue());
    }//GEN-LAST:event_accSliderStateChanged

    private void nitroSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_nitroSliderStateChanged
        nitroLabel.setText("" + nitroSlider.getValue());
    }//GEN-LAST:event_nitroSliderStateChanged

    private void fuelSliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_fuelSliderStateChanged
        fuelLabel.setText("" + fuelSlider.getValue());
    }//GEN-LAST:event_fuelSliderStateChanged

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
            java.util.logging.Logger.getLogger(RaceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RaceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RaceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RaceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RaceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accLabel;
    private javax.swing.JSlider accSlider;
    private javax.swing.JButton addButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JComboBox comboBox;
    private javax.swing.JLabel fuelLabel;
    private javax.swing.JSlider fuelSlider;
    private javax.swing.JButton goButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel list_label;
    private javax.swing.JLabel nitroLabel;
    private javax.swing.JSlider nitroSlider;
    private javax.swing.JLabel speedLabel;
    private javax.swing.JSlider speedSlider;
    private javax.swing.JRadioButton v4Option;
    private javax.swing.JRadioButton v6Option;
    private javax.swing.JRadioButton v8Option;
    // End of variables declaration//GEN-END:variables

}
