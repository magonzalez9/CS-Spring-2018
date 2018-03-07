/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualDisk;

/**
 *
 * @author marco
 */
public class File {

    private final String name;
    private final int inode_number;

    public File(String name, int InodeNumb) {
        this.name = name;
        this.inode_number = InodeNumb;
    }

    public String getName() {
        return name;
    }

    public int getInodeNumber() {
        return inode_number;
    }
}
