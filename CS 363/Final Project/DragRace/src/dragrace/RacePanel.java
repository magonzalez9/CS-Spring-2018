/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragrace;

import static dragrace.Controller.column;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class RacePanel extends javax.swing.JPanel {

    static CarList car_list = new CarList();
    Graphics g;

    public RacePanel() {
        initComponents();
        setLayout(null);
        setVisible(true);
        setSize(500, 500);

        // set Controller
        Controller c = new Controller(this);

    }

    @Override
    public void paintComponent(Graphics g) {
        if (g == null) {
            return;
        }

        super.paintComponent(g);

        // Draw the car as the user adds them
        drawCar(g);
        g.setColor(Color.WHITE);
        //System.out.println(column);
        // if cars reach dis distance then stop 
//        if (column >= 20) {
//            toggle();
//        }

    }

    // Draw cars as the user adds them
    void drawCar(Graphics g) {
        if (car_list.size() >= 1) {
            g.drawImage(car_list.get(0).getCarImage().getImage(), (int) car_list.get(0).getDistanceTraveled(), 20, 60, 30, null);
            System.out.println(car_list.get(0).getDistanceTraveled());
        }
        if (car_list.size() >= 2) {

            g.drawImage(car_list.get(1).getCarImage().getImage(), (int) car_list.get(1).getDistanceTraveled(), 80, 60, 30, null);
        }
        if (car_list.size() >= 3) {

            g.drawImage(car_list.get(2).getCarImage().getImage(), (int) car_list.get(2).getDistanceTraveled(), 140, 60, 30, null);
        }
        if (car_list.size() >= 4) {

            g.drawImage(car_list.get(3).getCarImage().getImage(), (int) car_list.get(3).getDistanceTraveled(), 200, 60, 30, null);
        }
        if (car_list.size() >= 5) {

            g.drawImage(car_list.get(4).getCarImage().getImage(), (int) car_list.get(4).getDistanceTraveled(), 260, 60, 30, null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    void go() {
        if (car_list.isEmpty()) {
            JOptionPane.showMessageDialog(null, "There is no cars added to the track!");
        } else {
            Controller.setCarList(car_list);
            Controller.move();
        }

    }

    void addCar(RaceCar car) {
        car_list.addCar(car);

//        System.out.println(car_list.get(0).toString());
//        System.out.println(car_list.size());
    }

    void toggle() {
        Controller.toggleRunning();
    }

    void reset() {
        for (int i = 0; i < car_list.size(); i++) {
            car_list.get(i).reset();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
