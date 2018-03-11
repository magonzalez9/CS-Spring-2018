/*
Class FileSystem
   Saves and loads data (direct only)
 */
package virtualDisk;

import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class FileSystem {

    // Get disk and create the inode list and block list
    Disk theDisk = Globals.getTheDisk();  // the Disk lives in Globals
    BlockList inodeFreeList = theDisk.createFreeInodeList();
    BlockList blockFreeList = theDisk.createFreeDataBlockList();

    public FileSystem() {

    }

    public void save(File file, String data) {
        // Begin to add. 
        Inode theInode = (Inode) theDisk.blocks[inodeFreeList.remove(file.getInodeNumber())];  // grab the first one
        theInode.setSize((short) data.length());
        file.setInode(theInode);

        // Set array
        byte[][] inputData = new byte[30][8];

        // Helper variables to keep track of the amount of records to store in array
        int dataBlockCount = 0;
        int letterCount = 0;

        // Store the input data in array
        for (int i = 0; i < data.length(); i++) {
            inputData[dataBlockCount][letterCount] = (byte) data.charAt(i);
            letterCount++;
            if (letterCount == 8) {
                dataBlockCount += 1;
                letterCount = 0;
            }
        }

        for (byte val : inputData[0]) {
            System.out.println(val);
        }
        System.out.println("AGAIN----");
        for (byte val : inputData[1]) {
            System.out.println(val);
        }
        System.out.println("AGAIN----");
        for (byte val : inputData[2]) {
            System.out.println(val);
        }

        // Load to direct
        short block_1 = blockFreeList.remove(0);
        DataBlock aDataBlock = (DataBlock) theDisk.blocks[block_1];
        aDataBlock.write(inputData[0]);
        theInode.setDirectLink(block_1);

        // Set Indirect Block
        short indirect_block = blockFreeList.remove(0);
        DataBlock id = (DataBlock) theDisk.blocks[indirect_block];
        theInode.setIndirectLink(indirect_block);

        // Load data into indirect block
        int iBlock = 0;
        for (int i = 1; i <= 4; i++) {
            if (inputData[i][0] != 0) {
                short block = blockFreeList.remove(0);
                DataBlock dBlock = (DataBlock) theDisk.blocks[block];
                id.setLink(iBlock, block); // 0,2,4,6
                dBlock.write(inputData[i]);
                iBlock += 2;
            } else {
                break;
            }
        }

        // Load into double indirect block.
        short double_indirectBlock = blockFreeList.remove(0);
        DataBlock double_id = (DataBlock) theDisk.blocks[double_indirectBlock];
        theInode.setDoubleIndirectLink(double_indirectBlock);

        // Load data into indirect block
        int diBlock = 0;
        for (int i = 5; i <= 20; i++) {
            if (inputData[i][0] != 0) {
                short block = blockFreeList.remove(0);
                DataBlock dBlock = (DataBlock) theDisk.blocks[block];
                id.setLink(diBlock, block); // 0,2,4,6
                dBlock.write(inputData[i]);

                diBlock += 2;
                if (diBlock >= 6) {
                    diBlock = 0;
                }
            } else {
                break;
            }
        }

        // Add indirect block
//        
        // Store stuff in inderect block
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
        //Print the inode and disk status
        //System.out.println("\nWith one little file; theDisk = " + theDisk);
        //Globals.complain("I'm done!!");
        // Load Test
        System.out.println("LOADING DATA: " + theInode.load());
        //Load indirect data
//        byte[] a = theDisk.blocks[theDisk.blocks[theInode.getIndirectLink()].decodeLink(0)].read();
//        String buffer = "";
//        for (int i = 0; i < a.length; i++) {
//            buffer += (char) a[i] + "";
//        }
//        System.out.println("" + buffer);
        System.out.println(theDisk);
    }

    public String load(File file) {
        System.out.println(theDisk);
        return file.getInode().load();
    }

    public byte[] addArray(byte[] strings) {
        return strings;
    }
}
