/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualDisk;

import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class File {

    private String name;

    private final int inode_number;
    private Inode inode;
    private int dataLength;
     ArrayList<Short> blockCount = new ArrayList<Short>();

    public File(String name, int InodeNumb) {
        this.name = name;
        this.inode_number = InodeNumb;
    }

    public void setInode(Inode inode, int dataLength) {
        this.inode = inode;
        inode.setDataLength(dataLength);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getInodeNumber() {
        return inode_number;
    }

    public Inode getInode() {
        return inode;
    }
    
    public void addBlock(short i){
        blockCount.add(i);
    }
    
    public ArrayList<Short> getBlockList(){
        return blockCount; 
    }

}
