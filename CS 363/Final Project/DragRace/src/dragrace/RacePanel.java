/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragrace;

import static dragrace.Controller.column;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author marco
 */
public class RacePanel extends javax.swing.JPanel {

    static CarList car_list = new CarList();
    Graphics g;
    int devider = 30;

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

        //draw
        drawCar(g);

        g.setColor(Color.WHITE);
        // if cars reach dis distance then stop 
        if (column >= 1000) {
            toggle();
        }

    }

    // Draw cars as the user adds them
    void drawCar(Graphics g) {
        if (car_list.size() >= 1) {
            g.drawImage(car_list.get(0).drawImage().getImage(), column, 20, 60, 30, null);
        }
        if (car_list.size() >= 2) {

            g.drawImage(car_list.get(1).drawImage().getImage(), column, 80, 60, 30, null);
        }
        if (car_list.size() >= 3) {

            g.drawImage(car_list.get(2).drawImage().getImage(), column, 140, 60, 30, null);
        }
        if (car_list.size() >= 4) {

            g.drawImage(car_list.get(3).drawImage().getImage(), column, 200, 60, 30, null);
        }
        if (car_list.size() >= 5) {

            g.drawImage(car_list.get(4).drawImage().getImage(), column, 260, 60, 30, null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    void go() {
        Controller.move();
    }

    void addCar(RaceCar car) {
        car_list.addCar(car);

        System.out.println(car_list.get(0).toString());
        System.out.println(car_list.size());
    }

    void toggle() {
        Controller.toggleRunning();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
