package virtualDisk;

/**
 * Inode.java
 *
 * @author levenick
 */
public class Inode extends Block {

    public Inode() {
        super();
    }

    public short getSize() {
        return decodeLink(0);
    }

    public short getDirectLink() {
        return decodeLink(2);
    }

    public short getIndirectLink() {
        return decodeLink(4);
    }

    public short getDoubleIndirectLink() {
        return decodeLink(6);
    }

    public void setSize(short size) {
        setLink(0, size);
    }

    public void setDirectLink(short directLink) {
        setLink(2, directLink);
    }

    public void setIndirectLink(short indirectLink) {
        setLink(4, indirectLink);
    }

    public void setDoubleIndirectLink(short doubleIndirectLink) {
        setLink(6, doubleIndirectLink);
    }

    public String toString() {
        String returnMe = "Inode: ";
        returnMe += "\tsize=" + getSize();
        returnMe += "\tdirectLink=" + getDirectLink();
        short indirectBlock = getIndirectLink();
        if (indirectBlock == 0) {
            returnMe += " \n\t\tno indirects!";
        } else {
            returnMe += "\n\t\ttime to write the rest of this!";
        }
        return returnMe;
    } // toString()

    String load() {
        // always direct... 
        String returnMe = "";

        returnMe += makeString(Globals.getTheDisk().read(getDirectLink()));  // read the direct link

        //if there's an indirect link...
        for (int i = 0; i <= 6; i += 2) {
            byte[] a = Globals.getTheDisk().blocks[Globals.getTheDisk().blocks[getIndirectLink()].decodeLink(i)].read();

            String buffer = "";
            for (int c = 0; c < a.length; c++) {
                buffer += (char) a[c] + "";
            }
            System.out.println("" + buffer);
            returnMe += buffer;
        }

        //if there's a double indirect link...
        for (int i = 0; i <= 6; i += 2) {
            byte[] a = Globals.getTheDisk().blocks[Globals.getTheDisk().blocks[getDoubleIndirectLink()].decodeLink(i)].read();
            String buffer = "";
            for (int c = 0; c < a.length; c++) {
                buffer += (char) a[c] + "";
            }
            System.out.println("" + buffer);
            returnMe += buffer;
        }
        return returnMe;
    }

    private String makeString(byte[] data) {
        String returnMe = "";

        for (int i = 0; i < data.length; i++) {
            returnMe += (char) data[i];
        }

        return returnMe;
    }

}  // Inode
