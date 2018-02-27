package vehicles;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 *
 * @author Dylan Miyashiro Feb 22, 2018 12:11:33 PM
 */
public class VehiclePanel extends javax.swing.JPanel {

    Controller theController;

    void reset() {
        theController = new Controller(this);
        setDelay();
        theController.start();
    }

    public VehiclePanel() {
        initComponents();
        setLayout(null);
        setSize(1500, 1500);
        reset();
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        theController.paint(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        runButt = new javax.swing.JButton();
        stepButt = new javax.swing.JButton();
        speedTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        resetButt = new javax.swing.JButton();
        clearButt = new javax.swing.JButton();
        sourceStrengthTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        sourceRadioButt = new javax.swing.JRadioButton();
        vehicleRadioButt = new javax.swing.JRadioButton();
        crossRButt = new javax.swing.JRadioButton();
        uncrossRButt = new javax.swing.JRadioButton();
        crossLoveRButt = new javax.swing.JRadioButton();
        uncrossLoveRButt = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        vehicleSizeTF = new javax.swing.JTextField();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        setLayout(null);

        runButt.setText("Run/Pause");
        runButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtActionPerformed(evt);
            }
        });
        add(runButt);
        runButt.setBounds(10, 10, 90, 23);

        stepButt.setText("Step");
        stepButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stepButtActionPerformed(evt);
            }
        });
        add(stepButt);
        stepButt.setBounds(10, 40, 90, 23);

        speedTF.setText("33");
        speedTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                speedTFActionPerformed(evt);
            }
        });
        add(speedTF);
        speedTF.setBounds(660, 10, 90, 20);

        jLabel1.setText("S P E E D :");
        add(jLabel1);
        jLabel1.setBounds(600, 10, 60, 20);

        resetButt.setText("Reset");
        resetButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtActionPerformed(evt);
            }
        });
        add(resetButt);
        resetButt.setBounds(10, 100, 90, 23);

        clearButt.setText("Clear");
        clearButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtActionPerformed(evt);
            }
        });
        add(clearButt);
        clearButt.setBounds(10, 70, 90, 23);

        sourceStrengthTF.setText("10000");
        add(sourceStrengthTF);
        sourceStrengthTF.setBounds(190, 40, 100, 20);

        jLabel3.setText("Strength:");
        add(jLabel3);
        jLabel3.setBounds(140, 40, 60, 20);

        buttonGroup1.add(sourceRadioButt);
        sourceRadioButt.setText("Create Sources:");
        sourceRadioButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceRadioButtActionPerformed(evt);
            }
        });
        add(sourceRadioButt);
        sourceRadioButt.setBounds(120, 10, 110, 20);

        buttonGroup1.add(vehicleRadioButt);
        vehicleRadioButt.setText("Create Vehicles:");
        add(vehicleRadioButt);
        vehicleRadioButt.setBounds(310, 10, 110, 20);

        buttonGroup2.add(crossRButt);
        crossRButt.setForeground(new java.awt.Color(204, 0, 0));
        crossRButt.setText("Crossed");
        add(crossRButt);
        crossRButt.setBounds(330, 30, 90, 23);

        buttonGroup2.add(uncrossRButt);
        uncrossRButt.setForeground(new java.awt.Color(0, 204, 0));
        uncrossRButt.setText("Uncrossed");
        add(uncrossRButt);
        uncrossRButt.setBounds(330, 50, 100, 23);

        buttonGroup2.add(crossLoveRButt);
        crossLoveRButt.setForeground(new java.awt.Color(0, 0, 255));
        crossLoveRButt.setText("Crossed (Love)");
        add(crossLoveRButt);
        crossLoveRButt.setBounds(330, 70, 110, 23);

        buttonGroup2.add(uncrossLoveRButt);
        uncrossLoveRButt.setForeground(new java.awt.Color(204, 204, 0));
        uncrossLoveRButt.setText("Uncrossed (Love)");
        add(uncrossLoveRButt);
        uncrossLoveRButt.setBounds(330, 90, 120, 23);

        jLabel2.setText("Vehicle Size:");
        add(jLabel2);
        jLabel2.setBounds(480, 10, 90, 20);

        vehicleSizeTF.setText("10");
        vehicleSizeTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleSizeTFActionPerformed(evt);
            }
        });
        add(vehicleSizeTF);
        vehicleSizeTF.setBounds(470, 30, 80, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void runButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtActionPerformed
        theController.toggleRunning();
    }//GEN-LAST:event_runButtActionPerformed

    private void stepButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stepButtActionPerformed
        theController.incStep();
    }//GEN-LAST:event_stepButtActionPerformed

    private void speedTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_speedTFActionPerformed
        setDelay();
    }//GEN-LAST:event_speedTFActionPerformed

    private void clearButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtActionPerformed
        theController.flushVehicles();
        theController.flushSources();
        repaint();
    }//GEN-LAST:event_clearButtActionPerformed

    private void resetButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtActionPerformed
        reset();
        repaint();
    }//GEN-LAST:event_resetButtActionPerformed

    private void sourceRadioButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceRadioButtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceRadioButtActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xInit = evt.getX();
        yInit = evt.getY();
        locat = new Point2D.Double(evt.getX(), evt.getY());
        if (sourceRadioButt.isSelected()) {
            theController.addSource(new LightSource(locat, getStrength()));
            repaint();
        } else if (vehicleRadioButt.isSelected()) {
            creatingVehicle = true;
        }
    }//GEN-LAST:event_formMousePressed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        if (creatingVehicle) {
            double orient = getOrientation(xInit, evt.getX(), yInit, evt.getY());
            AbstractVehicle proto;
            if (crossRButt.isSelected()) {
                proto = new ProtoVehicle(locat, orient, true);
                proto.size = getVehicleSize();
                theController.addVehicle(proto);
            } else if (uncrossRButt.isSelected()) {
                proto = new ProtoVehicle(locat, orient, false);
                proto.size = getVehicleSize();
                theController.addVehicle(proto);
            } else if (crossLoveRButt.isSelected()) {
                proto = new ProtoLoveVehicle(locat, orient, true);
                proto.size = getVehicleSize();
                theController.addVehicle(proto);
            } else if (uncrossLoveRButt.isSelected()) {
                proto = new ProtoLoveVehicle(locat, orient, false);
                proto.size = getVehicleSize();
                theController.addVehicle(proto);
            }
            creatingVehicle = false;
            repaint();
        }
    }//GEN-LAST:event_formMouseReleased

    private void vehicleSizeTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleSizeTFActionPerformed

    }//GEN-LAST:event_vehicleSizeTFActionPerformed

    Point2D.Double locat;
    boolean creatingVehicle = false;
    int xInit = 0;
    int yInit = 0;

    double getOrientation(int x1, int x2, int y1, int y2) {
        double mathOrient = Math.atan2(x2 - x1, y2 - y1);
        return (mathOrient - Math.PI / 2);
    }

    void setDelay() {
        try {
            theController.setDelay(Integer.parseInt(speedTF.getText()));
        } catch (Exception e) {
            System.out.println("Couldn't get int. Check input.");
        }
    }

    void setDelayTF() {
        speedTF.setText("" + theController.getDelay());
    }

    int getStrength() {
        try {
            return Integer.parseInt(sourceStrengthTF.getText());
        } catch (Exception e) {

            System.out.println("Couldn't get int. Check input. Used 10000.");
            return 10000;
        }
    }

    int getVehicleSize() {
        try {
            return Integer.parseInt(vehicleSizeTF.getText());
        } catch (Exception e) {

            System.out.println("Couldn't get int. Check input. Used 10000.");
            return 15;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton clearButt;
    private javax.swing.JRadioButton crossLoveRButt;
    private javax.swing.JRadioButton crossRButt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton resetButt;
    private javax.swing.JButton runButt;
    private javax.swing.JRadioButton sourceRadioButt;
    private javax.swing.JTextField sourceStrengthTF;
    private javax.swing.JTextField speedTF;
    private javax.swing.JButton stepButt;
    private javax.swing.JRadioButton uncrossLoveRButt;
    private javax.swing.JRadioButton uncrossRButt;
    private javax.swing.JRadioButton vehicleRadioButt;
    private javax.swing.JTextField vehicleSizeTF;
    // End of variables declaration//GEN-END:variables

}
