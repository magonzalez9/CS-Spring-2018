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

    // Save to disk example
    public static void main(String[] args) {
        Globals.init();   // create the Disk
        System.out.println("Globals = " + Globals.display());  // see Globals constants

        Disk theDisk = Globals.getTheDisk();  // the Disk lives in Globals
        BlockList inodeFreeList = theDisk.createFreeInodeList();
        BlockList blockFreeList = theDisk.createFreeDataBlockList();

        // see how the Disk displays when disk is empty
        System.out.println("Initially, theDisk = " + theDisk);

        /**
         * ***** Begin to add ****
         */
        Inode theInode = (Inode) theDisk.blocks[inodeFreeList.remove(0)];  // grab the first one
        theInode.setSize((short) 24);

        System.out.println("anInode with the size set to 2 and direct link to 4 = " + theInode);

        // Get a data block and write to it... this is the beginning of what the FileSystem will do
        short block_1 = blockFreeList.remove(0);
        DataBlock aDataBlock = (DataBlock) theDisk.blocks[block_1];
        byte[] data = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        aDataBlock.write(data);
        theInode.setDirectLink(block_1);

        // Add indirect block
        short indirect_block = blockFreeList.remove(0);
        DataBlock id = (DataBlock) theDisk.blocks[indirect_block];
        theInode.setIndirectLink(indirect_block);

        

        // Store stuff in inderect block
        short block_2 = blockFreeList.remove(0);
        DataBlock bDataBlock = (DataBlock) theDisk.blocks[block_2];
        id.setLink(0, block_2);
        byte[] data2 = {'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'};
        bDataBlock.write(data2);

        short block_3 = blockFreeList.remove(0);
        DataBlock cDataBlock = (DataBlock) theDisk.blocks[block_3];
        id.setLink(2, block_3);
        byte[] data3 = {'q', 'r', 's', 't', 'u', 'v', 'w', 'x'};
        cDataBlock.write(data3);
        
  

        //Print the inode and disk status
        System.out.println("\nWith one little file; theDisk = " + theDisk);
        //Globals.complain("I'm done!!");

        // Load Test
        System.out.println("LOAD DATA: " + theInode.load());
        
        //Load indirect?
        System.out.println("INDIRECT DATA: " + theDisk.blocks[theInode.getIndirectLink()].decodeLink((short)0));
        
        System.out.println(theDisk.blocks[theDisk.blocks[theInode.getIndirectLink()].decodeLink(0)].read());
        
        byte[] a = theDisk.blocks[theDisk.blocks[theInode.getIndirectLink()].decodeLink(0)].read();

               String buffer = "";
        for (int i = 0; i < a.length; i++) {
            buffer += (char) a[i] + "";
        }
        System.out.println("" + buffer);
    }

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
