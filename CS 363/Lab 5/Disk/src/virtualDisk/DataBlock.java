package virtualDisk;

/**
 * DataBlock.java created by levenick on Oct 8, 2013 at 1:32:33 PM
 */
class DataBlock extends Block {

    public DataBlock() {
        super();
    }
    

    public String toString() {
        String returnMe = "DataBlock: ";
        returnMe += ifIWereData();
        returnMe += ifIWereIndirect();
        returnMe += ifIWereDoubleIndirect();

                return returnMe;
    } // toString()
    
    String ifIWereDoubleIndirect() {
        return "... if di...";
    }   
    String ifIWereIndirect() {
        return "... if i...";
    }   
    String ifIWereData() {
        String returnMe = " if data: ";
        
        for (int i=0; i<Globals.getBlockLength(); i++) {
            returnMe += (char) bytes[i];
        }
        
        return returnMe;
    }
}
