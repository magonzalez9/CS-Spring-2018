package lv_proto;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author marco
 */
public class Grapher extends javax.swing.JPanel {

    DataPairList dp_list;
    int left, top, rows, right, bottom, hMax, hMin, pairSize, hRange, graphRange;

    public Grapher() {
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
        super.paintComponent(g);
        paintAxis(g);
        drawTicks(g);
    }

    public void paintAxis(Graphics g) {
        pairSize = dp_list.size();

        Rectangle r = this.getVisibleRect();
        left = r.x + 40;
        top = r.y + 10;
        right = left + r.width + pairSize;
        bottom = top + r.height - 30;

        g.drawLine(left, bottom, right, bottom); //x line
        g.drawLine(left, top, left, bottom); //y
    }

    public void drawTicks(Graphics g) {
        hMax = dp_list.getMax();
        hMin = dp_list.getMin();
        hRange = hMax - hMin;
        
        int hInc = hRange/5; 
        int yVal = 0; 
        int sy = hMax; 
        String tickValue = ""; 
        
        for (int y = hMin; y <= hMax; y+=hInc) {
            yVal = valueToPixels(y); 
            tickValue = "" + y;  
            System.out.println(valueToPixels(y));
            g.drawOval((left-10), valueToPixels(y), 5, 5);
            g.drawString(tickValue, left-40, valueToPixels(sy));
            sy -= hInc; 
            
            if (sy < 0){
                g.drawString(tickValue, left-40, valueToPixels(1500));
            }
            System.out.println("SY: " + sy + " - " + hInc);
            
        }
    }

    public int valueToPixels(int input) {
        return (input - hMin) * ((bottom)) / (hRange);
    }

    public void paintCircles(Graphics g) {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 549, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    void go(DataPairList list) {
        this.dp_list = list;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
