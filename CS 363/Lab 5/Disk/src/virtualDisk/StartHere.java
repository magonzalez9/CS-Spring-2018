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
        DiskEditor editor = new DiskEditor();
        editor.setVisible(true);

        for (int i = 0; i <= 6; i += 2) {
            System.out.println(i);
        }

    }

    static void playWithStrings() {
        String s = "willamette!";
        String will = s.substring(0, 4);
        String tail = s.substring(4);
        System.out.println("will = " + will);
        System.out.println("tail = " + tail);

    }

    private static void testToString() {
        byte[] alpha = {'a', 'b', 'c', 'd'};
        byte[] beta = {1, 2, 3, 97};
        System.out.println("alpha first");
        outputAsLetters(alpha);
        outputAsNumbers(alpha);
        System.out.println("\nbeta second");
        outputAsLetters(beta);
        outputAsNumbers(beta);
        System.exit(12345);

    }

    static void outputAsLetters(byte[] data) {
        String buffer = "letters ";
        for (int i = 0; i < data.length; i++) {
            buffer += (char) data[i] + "LETTER";
        }
        System.out.println("" + buffer);
    }

    private static void outputAsNumbers(byte[] data) {
        String buffer = "without casting... ";
        for (int i = 0; i < data.length; i++) {
            buffer += data[i] + " ";
        }
        System.out.println("" + buffer);
    }

//    public static void runSimulation() {
//        Globals.init();   // create the Disk
//        System.out.println("Globals = " + Globals.display());  // see Globals constants
//
//        Disk theDisk = Globals.getTheDisk();  // the Disk lives in Globals
//        BlockList inodeFreeList = theDisk.createFreeInodeList();
//        BlockList blockFreeList = theDisk.createFreeDataBlockList();
//
//        // see how the Disk displays when disk is empty
//        System.out.println("Initially, theDisk = " + theDisk);
//
//        /**
//         * ***** Begin to add ****
//         */
//        Inode theInode = (Inode) theDisk.blocks[inodeFreeList.remove(0)];  // grab the first one
//        theInode.setSize((short) 24);
//
//        System.out.println("anInode with the size set to 2 and direct link to 4 = " + theInode);
//
//        // Get a data block and write to it... this is the beginning of what the FileSystem will do
//        short block_1 = blockFreeList.remove(0);
//        DataBlock aDataBlock = (DataBlock) theDisk.blocks[block_1];
//        byte[] data = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
//        aDataBlock.write(data);
//        theInode.setDirectLink(block_1);
//
//        // Add indirect block
//        short indirect_block = blockFreeList.remove(0);
//        DataBlock id = (DataBlock) theDisk.blocks[indirect_block];
//        theInode.setIndirectLink(indirect_block);
//
//        // Store stuff in inderect block
//        short block_2 = blockFreeList.remove(0);
//        DataBlock bDataBlock = (DataBlock) theDisk.blocks[block_2];
//        id.setLink(0, block_2);
//        byte[] data2 = {'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'};
//        bDataBlock.write(data2);
//
//        short block_3 = blockFreeList.remove(0);
//        DataBlock cDataBlock = (DataBlock) theDisk.blocks[block_3];
//        id.setLink(2, block_3);
//        byte[] data3 = {'q', 'r', 's', 't', 'u', 'v', 'w', 'x'};
//        cDataBlock.write(data3);
//
//        //Print the inode and disk status
//        System.out.println("\nWith one little file; theDisk = " + theDisk);
//        //Globals.complain("I'm done!!");
//
//        // Load the direct data
//        System.out.println("LOAD DATA: " + theInode.load());
//
//        //Load indirect data (this will need to be impletented somewhere in the filesystem or inode class whatever floats my boat)
//        byte[] a = theDisk.blocks[theDisk.blocks[theInode.getIndirectLink()].decodeLink(0)].read();
//
//        String buffer = "";
//        for (int i = 0; i < a.length; i++) {
//            buffer += (char) a[i] + "";
//        }
//        System.out.println("" + buffer);
//    }
}
