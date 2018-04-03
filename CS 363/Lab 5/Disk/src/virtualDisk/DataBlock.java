package virtualDisk;

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
        return "  double_indirect  ";//... if di...
    }   
    String ifIWereIndirect() {
        return "  indirect  "; //... if i...
    }   
    String ifIWereData() {
        String returnMe = " if data: ";
        
        for (int i=0; i<Globals.getBlockLength(); i++) {
            returnMe += (char) bytes[i];
        }
        
        return returnMe;
    }
}
