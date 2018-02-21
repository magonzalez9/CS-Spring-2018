package vehicles;

import java.util.ArrayList;

/**
 * The list of Sources (for the whole world)
 *
 */

public class SourceList extends ArrayList<AbstractSource> {

    private static final boolean DEBUG = true;

    /**
     * Creates a new instance of SourceList
     */
    public SourceList() {
        super();
    }

    public String toString() {
        String returnMe = "SourceList: ";

        for (AbstractSource nextS : this) {
            returnMe += "\t" + nextS + " \n";
        }

        return returnMe;
    }
}
