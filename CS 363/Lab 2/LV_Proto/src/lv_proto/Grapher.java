package lv_proto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

/**
 *
 * @author marco
 */
public class Grapher extends javax.swing.JPanel {

    DataPairList dp_list;
    int max;
    int min;

    public Grapher() {
        initComponents();
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.YELLOW, 5),
                "Grapher", TitledBorder.CENTER, 0));
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
        g.fillOval(100, 100, 100, 100);

        System.out.println("List: " +dp_list);
        System.out.println(dp_list.getMax());
        

    }

    public void paintAxis(Graphics g) {

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
