package montehall;

/**
 *
 * @author marco
 */
public class Switcher implements Contestant {
    private int doorNum; 
    
    public Switcher (int doorNum){
        doorNum = this.doorNum; 
    }
    @Override
    public int guess(int doorNum){
        return doorNum; 
    }
    
    @Override public boolean change(){
        return true; 
    }
    
}
