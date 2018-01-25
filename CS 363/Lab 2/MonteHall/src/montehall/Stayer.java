package montehall;

/**
 *
 * @author marco
 */
public class Stayer implements Contestant {
    
    private int doorNum; 
    
    public Stayer (int doorNum){
        doorNum = this.doorNum; 
    }
    
    @Override
    public int guess(int doorNum) {
        return doorNum;
    }

    @Override
    public boolean change() {
        return false;
    }

}
