package vehicles;

import java.awt.*;
import java.awt.geom.*;

/**
 * The abstract class every Source inherits from.
 *
 */
public abstract class AbstractSource { 

    /**
     * Where is the Source?
     */
    protected Point2D.Double location;
    /**
     * Where is the Source?
     */
    protected double intensity;

    public Point2D.Double getLocation() {
        return location;
    }

    public void setLocation(Point2D.Double l) {
        location = l;
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double i) {
        intensity = i;
    }

    /**
     * Displays the Source
     */
    abstract public void paint(Graphics g);
}
