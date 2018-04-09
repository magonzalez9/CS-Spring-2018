/*
* acceleration = meters per second^2
* speed = distance / time
* time = distance / speed; 
* distance = speed * time; 
 */
package dragrace;

public class RaceCar {

    private final double top_speed;
    private final double acceleration;
    private final double nitro;
    private final double fuel;
    private final double engine_size;
    private double distance;
    private double current_speed;
    

    public RaceCar(double speed, double acceleration, double nitro, double fuel, double engine_size) {
        this.top_speed = speed;
        this.acceleration = acceleration;
        this.nitro = nitro;
        this.fuel = fuel;
        this.engine_size = engine_size;
    }

    public void run() {

    }

    public void useNitro() {

    }
}
