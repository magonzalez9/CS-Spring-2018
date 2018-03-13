package virtualDisk;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author levenick
 */
public class StartHere {

    public static void main(String[] args) {
        Globals.init();
        // Run the GUI
        DiskEditor editor = new DiskEditor();
        editor.setVisible(true);
    }
}
