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
}
