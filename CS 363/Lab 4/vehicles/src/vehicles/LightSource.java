package vehicles;

/*
 * LightSource.java
 *
 * Created on September 11, 2003, 12:32 PM
 */

import java.awt.geom.Point2D;
import java.awt.*;

/**
 * The only type of Source we have; Light
 * @author  levenick
 */
public class LightSource extends AbstractSource {
    int width=16;
    int offset = width/2;
    
    /** Creates a new instance of LightSource */
    public LightSource() {
    }
    
    public LightSource(Point2D.Double location, double strength) {
        setIntensity(strength);
        setLocation(location);
    }
    
    /** 
     * Draws a little oval to stand for a light.
     * @param g, for guess! Um... no...
     */
    public void paint(Graphics g) {
        int x = (int)getLocation().getX();
        int y = (int)getLocation().getY();
        g.setColor(new Color(200, 150, 200));
        g.fillOval(x-offset, y-offset, width, width);
    }
    
}
