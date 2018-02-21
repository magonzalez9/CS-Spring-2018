package vehicles;

import java.util.ArrayList;

/**
 * The list of Sensors (for a Vehicle)
 *
 */

public class SensorList extends ArrayList<AbstractSensor> {    
        
    public String toString() {
        String returnMe = "SensorList: ";

        for (AbstractSensor nextS : this) {
            returnMe += "\t" + nextS + " \n";
        }

        return returnMe;
    }
}
