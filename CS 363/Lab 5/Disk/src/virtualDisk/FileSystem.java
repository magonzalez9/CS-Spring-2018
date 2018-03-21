/*
 Class FileSystem
 Saves and loads data (direct only)
 */
package virtualDisk;

import java.util.Collections;
import javax.swing.JOptionPane;

/**
 *
 * @author marco
 */
public class FileSystem {

    // Get disk and create the inode list and block list
    Disk theDisk = Globals.getTheDisk();  // the Disk lives in Globals
    BlockList inodeFreeList = theDisk.createFreeInodeList();
    BlockList blockFreeList = theDisk.createFreeDataBlockList();
    int dataLength = 0;

    public FileSystem() {

    }

    public void save(File file, String data) {
        System.out.println("FIRST");
        System.out.println("Block: " + blockFreeList.toString());
        System.out.println("inodes: " + inodeFreeList.toString());
        // Begin to add. 
        short inode = inodeFreeList.remove(0);
        Inode theInode = (Inode) theDisk.blocks[inode];  // grab the first one

        theInode.setSize((short) data.length());
        file.setInode(theInode, data.length(), inode);

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

        
            // Save to direct
            short block_1 = blockFreeList.remove(0);
            file.addBlock(block_1); // Add here
            DataBlock aDataBlock = (DataBlock) theDisk.blocks[block_1];
            aDataBlock.write(inputData[0]);
            theInode.setDirectLink(block_1);


            if (data.length() > 8) {
                // Set Indirect Block if character count is greater than 8!
                short indirect_block = blockFreeList.remove(0);
                file.addBlock(indirect_block);
                DataBlock id = (DataBlock) theDisk.blocks[indirect_block];
                theInode.setIndirectLink(indirect_block);

                // Save data into indirect block
                int iBlock = 0;
                for (int i = 1; i <= 4; i++) {
                    if (inputData[i][0] != 0) {
                       
                            short block = blockFreeList.remove(0);
                            file.addBlock(block);
                            DataBlock dBlock = (DataBlock) theDisk.blocks[block];
                            id.setLink(iBlock, block); // 0,2,4,6
                            dBlock.write(inputData[i]);
                            iBlock += 2;
                    } else {
                        break;
                    }
                }
            }

            if (data.length() > 40) {
                // Create double indirect block if character length is greater than 40!
                short double_indirectBlock = blockFreeList.remove(0);
                DataBlock double_id = (DataBlock) theDisk.blocks[double_indirectBlock];
                file.addBlock(double_indirectBlock);
                theInode.setDoubleIndirectLink(double_indirectBlock);
                int db_count = 5;
                for (int i = 0; i <= 6; i += 2) {

                    // Create blocks pointing to double indirect block
                    short block_di = blockFreeList.remove(0);
                    DataBlock finalDiBlock = (DataBlock) theDisk.blocks[block_di];
                    file.addBlock(block_di);
                    double_id.setLink(i, block_di);
                    for (int j = 0; j <= 6; j += 2) {
                        if (inputData[db_count][0] != 0) {
                            // Create the actual data blocks and put data in them!
                            short double_dataBlock = blockFreeList.remove(0);
                            DataBlock fDataBlock = (DataBlock) theDisk.blocks[double_dataBlock];
                            file.addBlock(double_dataBlock);
                            finalDiBlock.setLink(j, double_dataBlock);
                            fDataBlock.write(inputData[db_count]);
                            db_count++;
                        } else {
                            db_count++;
                            break;
                        }
                    }
                }

            }

        // Display the disk for testing purposes
        System.out.println(theDisk);
        System.out.println("Block: " + blockFreeList.toString());
        System.out.println("inodes: " + inodeFreeList.toString());
        System.out.println("END");
        Collections.sort(inodeFreeList);
    }

    public void s(File file, String data) {

    }

    public String load(File file) {
        System.out.println(theDisk);
        return file.getInode().load();
    }

    public void delete(File file) {
        byte[] a = new byte[8];
        Globals.getTheDisk().blocks[file.getInodeNumber()].write(a);
        inodeFreeList.add((short) file.getInodeNumber());
        for (short i : file.getBlockList()) {
            byte[] b = new byte[8];
            Globals.getTheDisk().blocks[i].write(b);
            blockFreeList.add(i, i);
            System.out.println(blockFreeList.toString());
        }
        System.out.println(theDisk);
        Collections.sort(inodeFreeList);
        Collections.sort(blockFreeList);
    }
}
