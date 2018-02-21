package vehicles;

/*
 * ProtoWorld.java
 *
 * Created on September 11, 2003, 11:59 AM
 */
import java.awt.*;
import java.awt.geom.Point2D;

/**
 * A prototype world for testing purposes
 *
 * @author levenick
 */
public class ProtoWorld extends AbstractWorld {

    private static Image offScreenImage;    // workspace for painting
    private static Graphics offG;           // it's graphic context

    /**
     * @param aOffScreenImage the offScreenImage to set
     */
    public static void setOffScreenImage(Image aOffScreenImage) {
        offScreenImage = aOffScreenImage;
    }

    /**
     * @param aOffG the offG to set
     */
    public static void setOffG(Graphics aOffG) {
        offG = aOffG;
    }
    boolean debugging = false;

    /**
     * Creates a new instance of ProtoWorld
     */
    public ProtoWorld() {
        for (int x = 0; x < 10; x++) {
            //addVehicle(new ProtoVehicle(new Point2D.Double(400, 800), Math.PI/2, randBool()));
            addVehicle(new ProtoVehicle(new Point2D.Double(600 + rand(100) + x / 10, 600 + rand(100) + x / 10), 3 * Math.PI / 4, randBool()));
        }
        addSource(new LightSource(new Point2D.Double(300, 300), 16550));
        //addSource(new LightSource(new Point2D.Double(320,300),100));
        addSource(new LightSource(new Point2D.Double(500, 300), 8770));
        //addSource(new LightSource(new Point2D.Double(500,320),100));
        addSource(new LightSource(new Point2D.Double(300, 500), 6650));
        //addSource(new LightSource(new Point2D.Double(300,520),200));
        addSource(new LightSource(new Point2D.Double(500, 500), 18670));
        addSource(new LightSource(new Point2D.Double(567, 345), 186700));   // so bright!!
        //addSource(new LightSource(new Point2D.Double(520,500),200));
//        addSource(new LightSource(new Point2D.Double(600,300),10000));
//        addSource(new LightSource(new Point2D.Double(300,600),10000));
//        addSource(new LightSource(new Point2D.Double(200,400),10000));
//        addSource(new LightSource(new Point2D.Double(300,100),10000));
//        addSource(new LightSource(new Point2D.Double(300,200),10000));
//        addSource(new LightSource(new Point2D.Double(300,400),10000));
//        for (int i=0; i<10; i++) {
//            addSource(new LightSource(new Point2D.Double(50+i*77,250),10000));
//
//        }
    }

    int rand(int max) {
        return (int) (max * Math.random());
    }

    private boolean randBool() {
        return Math.random() < 0.9;         // 9 times in 10 is true
    }

    public void addSource(AbstractSource nuSource) {
        theSourceList.add(nuSource);
    }

    /**
     * Adds a vehicle to the world
     *
     * @param nuVehicle the vehicle to add
     */
    public void addVehicle(AbstractVehicle nuVehicle) {
        theVehicleList.add(nuVehicle);
    }

    /**
     * Returns the light stimulus strength
     *
     * @param where the point to return the brightness at
     */
    public double getStimulusStrength(Point2D.Double where) {
        double sum = 0;

        for (AbstractSource nextLightSource : theSourceList) {
            double d = where.distance(nextLightSource.getLocation());
            sum += nextLightSource.getIntensity() / (d * d);
        }

        return sum;
    }

    /**
     * Simulates one step by sending step to each Vehicle (this calculates the
     * force delivered to each wheel (and is returned in theOutput).
     *
     * Then, moveIt is invoked to calculate how far, and in what direction the
     * Vehicle moves... this is because if it were in mud, or going uphill it
     * would move less than if it were in space... or so the author apparently
     * thought...
     */
    public void step() {
        for (AbstractVehicle nextVehicle : theVehicleList) {
            AbstractDriveOutput theOutput = nextVehicle.step(this);
            moveIt(nextVehicle, theOutput);
        }
    }

    private void moveIt(AbstractVehicle theVehicle, AbstractDriveOutput theOutput) {
        if (debugging) {
            System.out.println("Applying " + theOutput + " to  " + theVehicle);
        }
        double leftOutput = theOutput.getLeftWheelOutput();
        double rightOutput = theOutput.getRightWheelOutput();
        double direction = theVehicle.getOrientation();

        double distance = (leftOutput + rightOutput) / 2;
        double dx = distance * Math.cos(direction);
        double dy = -distance * Math.sin(direction);
        double x = theVehicle.getLocation().getX();
        double y = theVehicle.getLocation().getY();
        theVehicle.setLocation(new Point2D.Double(x + dx, y + dy));

        double deltaDirection = ((rightOutput - leftOutput) / theVehicle.getSize()) * (Math.PI / 8);
        theVehicle.setOrientation(direction + deltaDirection);
    }

    public String toString() {
        return "ProtoWorld";
    }

    /**
     * Paints the world! Paints to the offscreen image, and then draws that (for
     * smoother graphics)
     *
     * @param g - the Graphics context...
     */
    public void paint(Graphics g) {
        offG.setColor(Color.white);
        offG.fillRect(0, 0, 1000, 1000);            // clear 1000x1000 pixels... shouldn't those 1000s be constants??
        for (AbstractSource nextLightSource : theSourceList) {
            nextLightSource.paint(offG);
        }
        for (AbstractVehicle nextVehicle : theVehicleList) {
            nextVehicle.paint(offG);
        }
        g.drawImage(offScreenImage, 0, 0, null);
    }

}
