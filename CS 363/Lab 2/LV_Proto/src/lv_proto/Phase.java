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
    int pMax, pMin, hMax, hMin, pairSize, hRange, pRange, graphRange;
    
    public Phase() {
        initComponents();
        setLayout(null);
        setVisible(true);
        setPreferredSize(new Dimension(2000, 2000));
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
        graphRange = bottom - top;
        // Set axis points
        left = r.x + 40;
        top = (r.y + valueToPixels(hMin) + yOffset);
        right = left + r.width + valueToPixels(dp_list.size()); //valueToPixels
        bottom = top + r.height - 20;

        // Draw the axis
        g.drawLine(left, bottom, right, bottom); // x Axis
        g.drawLine(left, top, left, bottom); // y Axis
        g.drawLine(left, top, right, top); // top x Axis
    }
    
    public void paintXAxis(){
        Rectangle r = this.getVisibleRect();
        
    }

    public void drawTicks(Graphics g) {
        int hInc = hRange / 5;
        int pY = hMax;
        int pixelY;
        String tickValue;

        // Draw ticks and their values
        for (int y = hMin; y <= hMax; y += hInc) {
            pixelY = valueToPixels(pY) + yOffset;
            tickValue = "" + y;
            g.drawLine(30, pixelY, left, pixelY);
            g.drawString(tickValue, left - 40, pixelY);
            pY -= hInc;
        }
    }

    public int valueToPixels(int input) {
        return (input - hMin) * ((graphRange)) / (hRange);
    }

    public void paintCircles(Graphics g) {
        int xTraverse = left;
        int pY;
        int hY;

        int hGraphValue;
        int pGraphValue; 

        for (DataPair dataPair : dp_list) {
            hGraphValue = hMax - dataPair.h;
            pGraphValue = hMax - dataPair.p; 
            
            g.setColor(Color.RED);
            pY = valueToPixels(pGraphValue)+ yOffset;
            g.drawOval(xTraverse, pY, 5, 5);

            g.setColor(Color.GREEN);
            hY = valueToPixels((hGraphValue) + yOffset);
            g.drawOval(xTraverse, hY, 5, 5);
            
            // Move 5 to the right
            xTraverse += 2;
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
        pRange = pMax = pMin; 
        
        System.out.println("hMax: " + hMax);
        System.out.println("hMin: " + hMin);
        
        System.out.println("pMax: " + pMax);
        System.out.println("pMin: " + pMin);
        System.out.println(dp_list);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents
    void go(DataPairList list){
        this.dp_list = list; 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
