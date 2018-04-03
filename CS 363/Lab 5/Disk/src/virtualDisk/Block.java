package virtualDisk;

/**
 * Block.java created by levenick on Oct 8, 2013 at 12:33:16 PM
 */
public abstract class Block {

    byte[] bytes;

    public Block() {
        bytes = new byte[Globals.getBlockLength()];
    }

    void write(byte[] data) {
        if (data.length > Globals.getBlockLength()) {
            Globals.fatalError("Ack! too long! " + data.length);
        }

        System.arraycopy(data, 0, bytes, 0, data.length);
        for (int i = data.length; i < Globals.getBlockLength(); i++) {  // pad with spaces
            bytes[i] = ' ';
        }
    }

    byte[] read() {
        return bytes;
    }

    protected short decodeLink(int i) {
        int fix = bytes[i + 1];  // fix up 2s complement... gah!
        if (fix < 0) {
            fix += 256;
        }
        return (short) (256 * bytes[i] + fix);
    }

    protected void setLink(int i, short x) {
        bytes[i + 1] = (byte) (x % 256);
        bytes[i] = (byte) (x >> 8);
    }

    public String toString() {
        String returnMe = "I am a Block (and am abstract!!), this should never display!";

        return returnMe;
    }

    public static void main(String[] args) {
        Block b = new DataBlock();
        for (int i = 0; i < 4; i++) {
            b.setLink(i * 2, (short) (i * 10));
        }

        for (int i = 0; i < 8; i++) {
            System.out.println("b.bytes[" + i + "] = " + b.bytes[i]);
        }
        for (int i = 0; i < 4; i++) {
            System.out.println("b.decodeLink(" + i * 2 + ") = " + b.decodeLink(i * 2));
        }
    }
}
