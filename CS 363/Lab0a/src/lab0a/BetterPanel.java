package lab0a;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

/**
 *
 * @author levenick Jan 18, 2018 3:25:55 PM
 */
public class BetterPanel extends javax.swing.JPanel {
    private int cols = 0; 
    public BetterPanel() {
        initComponents();
        setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.yellow, 5),
                "lovely title", TitledBorder.CENTER, 0));
        setLayout(null);
        setVisible(true);
        setPreferredSize(new Dimension(2000, 2000));
    }
    
    int left, top, rows, right, bottom;
    public void paintComponent(Graphics g) {
        if (g == null || list==null) {
            return;
        }
       //g.fillOval(100, 100, 100, 100);
        super.paintComponent(g);
        
        // here's how I started paintComponent...
        Rectangle r = this.getVisibleRect();
        left = r.x + 15;
        top = r.y + 15;
        rows = list.length / cols + 1;
        //System.out.println("rows = " + rows);

        right = left + r.width - 30;
        bottom = top + r.height - 30;
        
        drawGrid(g);
        drawValues(g);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    
 
    private void drawGrid(Graphics g) {
        for (int i = 0; i < cols+1; i++) {
            g.drawLine(left+(i*20), top, (left+(i*20)), top+((rows)*(20)));
        }
        for (int i = 0; i < rows+1; i++) {
            g.drawLine(left, top+((i)*(20)), left+((cols)*20), top+((i)*(20)));
        }
    }

   
    private void drawValues(Graphics g){ 
        int xText = 20;
        int yText = 30;
        int colNum = 1;
        for (String nextS : list) {
            g.drawString(nextS, xText, yText);
            if (colNum<this.cols) {
                xText+=20;
                colNum++;
            } else{
                xText = 20;
                yText += 20;
                colNum=1;
            }
        }
    }
    String[] list;
    
    void go(int cols, String text) {
//        //System.out.println("text = " + text);
//        //System.out.println("cols = " + cols);
        this.cols = cols; 
        list = text.split("\\s+");
        for (String s : list) {
            //System.out.println("s = " + s);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
