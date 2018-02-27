package vehicles;

/** The abstract class all Sensors inherit from.
 *
 */

public abstract class AbstractSensors {

    protected SensorList theSensors;
    
    /** Creates a new instance of Sensors */
    public AbstractSensors() {
        theSensors = new SensorList();
    }
    
    public void addSensor(AbstractSensor s) {
        theSensors.add(s); 
    }

}
