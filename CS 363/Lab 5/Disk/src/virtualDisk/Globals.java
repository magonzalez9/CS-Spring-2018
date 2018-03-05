package virtualDisk;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Globals.java -- created on Feb 23, 2012, 9:14:11 AM A place for global
 * things... The Disk lives here!
 *
 * @author levenick
 */
public class Globals {

    private final static short BLOCK_LENGTH = 8;
    private final static short LINKS_PER_BLOCK = BLOCK_LENGTH / 2;  // since each link is 2 bytes
    private final static short NUMBER_OF_BLOCKS = 30;
    private final static short NUMBER_OF_INODES = 3;
    public static int MAX_TEXT_LENGTH = BLOCK_LENGTH * 5 + BLOCK_LENGTH * 4 * 4;

    private static Disk theDisk;

    public static short getLinksPerBlock() {
        return LINKS_PER_BLOCK;
    }

    public static short getBlockLength() {
        return BLOCK_LENGTH;
    }

    public static short getNumberOfBlocks() {
        return NUMBER_OF_BLOCKS;
    }

    public static short getNumberOfInodes() {
        return NUMBER_OF_INODES;
    }

    public static void init() {
        theDisk = new Disk();
    }

    public static void complain(String s) {
        JOptionPane.showMessageDialog(new JFrame(),
                s,
                "Complaint!",
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * @return the theDisk
     */
    public static Disk getTheDisk() {
        return theDisk;
    }

    static boolean debugging = true;

    static void debug(String s) {
        if (debugging) {
            System.out.print(s + "\n");
        }
    }

    static void fatalError(String s) {
        JOptionPane.showMessageDialog(new JFrame(),
                s,
                "FATAL ERROR!",
                JOptionPane.ERROR_MESSAGE);
        System.exit(999);
    }

    public static String display() {
        String returnMe = "I am the Globals";
        returnMe += "\n\tLINKS_PER_BLOCK=" + getLinksPerBlock();
        returnMe += "\n\tBLOCK_LENGTH=" + getBlockLength();
        returnMe += "\n\tNUMBER_OF_BLOCKS=" + getNumberOfBlocks();
        returnMe += "\n\tNUMBER_OF_INODES=" + getNumberOfInodes();
        returnMe += "\n\tMAX_TEXT_LENGTH=" + MAX_TEXT_LENGTH;

        return returnMe;
    }
}
