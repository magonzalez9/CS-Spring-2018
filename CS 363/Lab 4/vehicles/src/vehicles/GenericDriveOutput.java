package vehicles;

/*
 * GenericDriveOutput.java
 *
 * Created on September 5, 2003, 10:54 AM
 */

/**
 *  A vanilla drive output
 *  Just copies the inputs to the outputs
 *  If you were implementing, say, the Love vehicle, you would subtract the inputs from 
 *  the default drive values here!
 */
public class GenericDriveOutput extends AbstractDriveOutput {
    
    /** Creates a new instance of MyDriveOutput */
    public GenericDriveOutput() {
    }
    
    public GenericDriveOutput(double left, double right) {
        this.setLeftWheelOutput(left);
        this.setRightWheelOutput(right);
    }
    
    public String toString() {
        return "myD" + super.toString();
    }
}
