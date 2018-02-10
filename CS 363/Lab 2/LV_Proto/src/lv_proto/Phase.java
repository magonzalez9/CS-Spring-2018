/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv_proto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author marco
 */
public class Phase extends javax.swing.JPanel {

    DataPairList dp_list;
    int yOffset = 10, left, top, rows, right, bottom;
    int pMin, pMax, hMax, hMin, pairSize, hRange, pRange, yGraphRange, xGraphRange;

    public Phase() {
        initComponents();
        setLayout(null);
        setVisible(true);
        setPreferredSize(new Dimension(3000, 3000));
    }

    @Override
    public void paintComponent(Graphics g) {
        if (g == null) {
            return;
        }
        setValues();

        super.paintComponent(g);
        paintAxis(g);
        drawTicks(g);
        paintCircles(g);
    }

    public void paintAxis(Graphics g) {
        Rectangle r = this.getVisibleRect();
        yGraphRange = bottom - top;
        xGraphRange = right - left;

        System.out.println("YRange: " + yGraphRange);
        System.out.println("XRange " + xGraphRange);

        // Set axis points
        left = r.x + 40;
        top = (r.y + yOffset);
        right = r.width - (top + 20); //valueToPixels
        bottom = top + r.height - 30;

        // Draw the axis
        g.drawLine(left, bottom, right, bottom); // x Axis
        g.drawLine(left, top, left, bottom); // y Axis
        g.drawLine(left, top, right, top); // top x Axis
    }

    public void drawTicks(Graphics g) {
        int hInc = hRange / 5;
        int hY = hMax;
        int pixelY;
        String tickValue;

        // Draw ticks and their values for H
        for (int y = hMin; y <= hMax; y += hInc) {
            pixelY = valueToPixels(hY, 'y') + yOffset;
            tickValue = "" + y;
            g.drawLine(30, pixelY, left, pixelY);
            g.drawString(tickValue, left - 40, pixelY);
            hY -= hInc;
        }
        int pInc = pRange / 5;
        int pX = pMax;
        int pixelX;
        String pValue;
        System.out.println(dp_list);
        // Draw ticks and their values for P
        for (int y = pMax; y >= pMin; y -= pInc) {
            pixelX = valueToPixels(pX, 'x') + left;
            pValue = "" + y;
            g.drawLine(pixelX, valueToPixels(hMax, 'y') + yOffset, pixelX, valueToPixels(hMax, 'y') + 15);
            g.drawString(pValue, pixelX - 10, valueToPixels(hMax, 'y') + 25);
            pX -= pInc;
        }
    }

    public int valueToPixels(int input, char axis) {
        if (axis == 'y') {
            return (input - hMin) * ((yGraphRange) - 0) / (hRange - 0) + 0;
        } else {
            return (input - pMin) * ((xGraphRange) - 0) / (pRange - 0) + 0;
        }
    }

    public void paintCircles(Graphics g) {
        int hGraphValue;
        int pX;
        int hY;

        for (DataPair dataPair : dp_list) {
            hGraphValue = hMax - dataPair.h;
            pX = valueToPixels(dataPair.p, 'x') + left;
            hY = valueToPixels(hGraphValue, 'y') + yOffset;

            g.setColor(Color.RED);
            g.drawOval(pX, hY, 5, 5);

        }

        System.out.println(dp_list);

    }

    public void setValues() {
        dp_list.getMax();
        dp_list.getMin();
        pairSize = dp_list.size();
        pMax = dp_list.getpMax();
        pMin = dp_list.getpMin();
        hMax = dp_list.gethMax();
        hMin = dp_list.gethMin();
        hRange = hMax - hMin;
        pRange = pMax - pMin;

        System.out.println("hMax: " + hMax);
        System.out.println("hMin: " + hMin);
        System.out.println("pMax: " + pMax);
        System.out.println("pMin: " + pMin);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    void go(DataPairList list) {
        this.dp_list = list;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
