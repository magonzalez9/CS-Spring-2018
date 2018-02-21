package vehicles;

/** The abstract class every Sensor inherits from. */
public abstract class AbstractSensor {
    protected boolean crossed;
    
    public boolean getCrossed() {return crossed;}
    public void setCrossed(boolean c) {crossed = c;}
    abstract public String mySource();
}
