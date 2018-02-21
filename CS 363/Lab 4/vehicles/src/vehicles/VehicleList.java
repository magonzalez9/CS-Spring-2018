package vehicles;

import java.util.ArrayList;

/**
 * An ArrayList of Vehicles
 */
public class VehicleList extends ArrayList<AbstractVehicle> {

    private static final boolean DEBUG = true;
    
    public String toString() {
        String returnMe = "VehicleList: ";

        for (AbstractVehicle nextV : this) {
            returnMe += "\t" + nextV + " \n";
        }

        return returnMe;
    }
}
