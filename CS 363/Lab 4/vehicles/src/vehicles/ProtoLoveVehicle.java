/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehicles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

/**
 *
 * @author Dylan Miyashiro
 */
public class ProtoLoveVehicle extends AbstractVehicle{
    
     /** Creates a new instance of ProtoVehicle */
    public ProtoLoveVehicle() {
        super();
    }

    /** Create a Vehicle
     * @param location Where is the vehicle
     * @param orientation Which direction is the vehicle pointed.
     * @param crossed true if the outputs are crossed
     */
    public ProtoLoveVehicle(Point2D.Double location, double orientation, boolean crossed) {
        this();
        this.location = location;
        this.orientation = orientation;
        LightSensor theSensor = new LightSensor();
        theSensor.setCrossed(crossed);
        addSensor(theSensor);
    }

  /** Paint this vehicle.  Just a circle, a line for the direction and 2 lines for the
     * sensors.
     * @param g the screen
     */
    public void paint(Graphics g) {
        int x = (int) getX();
        int y = (int) getY();
        g.setColor(Color.black);

        g.drawOval(x - size / 2, y - size / 2, size, size);

        if (mySensors.theSensors.get(0).getCrossed()) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.yellow);
        }
        Point2D.Double left = leftSensorLocation();
        g.drawLine(x, y, (int) left.getX(), (int) left.getY());
        Point2D.Double right = rightSensorLocation();
        g.drawLine(x, y, (int) right.getX(), (int) right.getY());
    }

    /** To string
     * @return la la la
     */
    public String toString() {
        return "ProtoVehicle: location=" + getLocation() + " orientation=" + getOrientation();
    }
    
    @Override
    public AbstractDriveOutput step(AbstractWorld theWorld) {
        double right = 10-theWorld.getStimulusStrength(rightSensorLocation());
        double left = 10-theWorld.getStimulusStrength(leftSensorLocation());

        if (mySensors.theSensors.size() > 1) {
            System.out.println("okay... time to generalize ProtoVehicle:step to sum all the drives!!");
            assert (false);
        }

        // only one sensor...
        for (AbstractSensor nextSensor : mySensors.theSensors) {
            if (nextSensor.getCrossed()) {
                return new GenericDriveOutput(right, left);  // backwards
            }
        }
        return new GenericDriveOutput(left, right);
    }
    
        private Point2D.Double rightSensorLocation() {
        double dx = getSize() * Math.cos(getOrientation() - Math.PI / 4);
        double dy = -getSize() * Math.sin(getOrientation() - Math.PI / 4);
        return new Point2D.Double(getX() + dx * 2, getY() + dy * 2);
    }

    /** Calculate where the left sensor is.
     * @return The location of the left sensor
     */
    private Point2D.Double leftSensorLocation() {
        double dx = getSize() * Math.cos(getOrientation() + Math.PI / 4);
        double dy = -getSize() * Math.sin(getOrientation() + Math.PI / 4);
        return new Point2D.Double(getX() + dx * 2, getY() + dy * 2);
    }

    
}
