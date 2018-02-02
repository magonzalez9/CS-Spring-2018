package lv_proto;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author marco
 */
public class Grapher extends javax.swing.JPanel {

    public Grapher() {
        initComponents();
        setLayout(null);
        setVisible(true);
        setPreferredSize(new Dimension(2000, 2000));
    }
    // Data
    DataPairList dp_list;
    int left, top, rows, right, bottom, max, pairSize;

    @Override
    public void paintComponent(Graphics g) {
        if (g == null) {
            return;
        }
        super.paintComponent(g);
        paintAxis(g);
        System.out.println("LEFT + " + left);

//        System.out.println("List: " + dp_list);
//        System.out.println(max);
    }

    public void paintAxis(Graphics g) {
        max = dp_list.getMax();
        pairSize = dp_list.size();

        Rectangle r = this.getVisibleRect();
        left = r.x + 20;
        top = r.y + 10;
        right = left + r.width + pairSize;
        bottom = top + r.height - 20;

        g.drawLine(left, bottom, right, bottom); //x line
        g.drawLine(left, top, left, bottom); //x 

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
