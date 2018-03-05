package virtualDisk;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Disk.java created by levenick on Oct 8, 2013 at 12:19:25 PM
 */
public class Disk {

    Block[] blocks;

    public Disk() {
        blocks = new Block[Globals.getNumberOfBlocks()];
    }

    public BlockList createFreeInodeList() {
        BlockList inodeFreeList = new BlockList();
        for (short i = 0; i < Globals.getNumberOfInodes(); i++) {
            blocks[i] = new Inode();
            inodeFreeList.add(i);
        }
        return inodeFreeList;
    }

    public BlockList createFreeDataBlockList() {
        BlockList blockFreeList = new BlockList();
        for (short i = Globals.getNumberOfInodes(); i < Globals.getNumberOfBlocks(); i++) {
            blocks[i] = new DataBlock();
            blockFreeList.add(i);
        }
        return blockFreeList;
    }

    public void write(short blockNum, byte[] data) {
        if (data.length > Globals.getBlockLength()) {
            Globals.complain("Oops! That array is too big! data.length=" + data.length);
        }

        blocks[blockNum].write(data);
    }

    /**
     * Convert the String to an array of bytes and write them to the blockNumber
     *
     * @param blockNumber
     * @param s
     */
    private void write(Short blockNumber, String s) {
        byte[] data = new byte[Globals.getBlockLength()];
        for (int i = 0; i < s.length(); i++) {
            data[i] = (byte) s.charAt(i);
        }
        write(blockNumber, data);
    }

    public byte[] read(short blockNum) {
        if (blockNum >= Globals.getNumberOfBlocks()) {
            Globals.complain("Ack! Too big!! blockNum=" + blockNum);
        }

        return blocks[blockNum].read();
    }

    public String toString() {
        String returnMe = "I am a Disk";

        for (int i = 0; i < Globals.getNumberOfBlocks(); i++) {
            returnMe += "\n\t#" + i + ": " + blocks[i].toString();
        }

        return returnMe;
    }

    public static void main(String[] args) {
        Globals.init();   // create the Disk
        System.out.println("Globals = " + Globals.display());  // see Globals constants
        
        Disk theDisk = Globals.getTheDisk();  // the Disk lives in Globals
        BlockList inodeFreeList = theDisk.createFreeInodeList();
        BlockList blockFreeList = theDisk.createFreeDataBlockList();

        // see how the Disk displays
        System.out.println("Initially... theDisk = " + theDisk);

        // see if the Inode works at all... remember the free lists contain numbers, not blocks!
        Inode theInode = (Inode) theDisk.blocks[inodeFreeList.remove(0)];  // grab the first one
        theInode.setSize((short) 2);
        theInode.setDirectLink((short) 4);
        System.out.println("anInode with the size set to 2 and direct link to 4 = " + theInode);

        // assuming that worked, time to 
        // try out getting a data block and writing to it... this is the beginning of what the FileSystem will do
        short blockNumber = blockFreeList.remove(0);
        DataBlock aDataBlock = (DataBlock) theDisk.blocks[blockNumber];
        byte[] data = {'a', 'b', 'c', 'd'};
        aDataBlock.write(data);
        theInode.setSize((short) data.length);
        theInode.setDirectLink(blockNumber);
        System.out.println("...and now... theInode = " + theInode);

        System.out.println("abcd?? I hope! " + aDataBlock);
        System.out.println("\nWith one little file; theDisk = " + theDisk);
        Globals.complain("I'm done!!");
    }

    /**
     * An example of using a JOptionPane
     * @return the filename
     */
    String getFN() {
        String s = (String) JOptionPane.showInputDialog(
                new JFrame(),
                "Enter filename",
                "File name, please!",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "foo");

        //If a string was returned, say so.
        if ((s != null) && (s.length() > 0)) {
            return s;
        }
        return null;
    }
}
