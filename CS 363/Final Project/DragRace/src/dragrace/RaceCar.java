/*
* acceleration = meters per second^2
* speed = distance / time
* time = distance / speed; 
* distance = speed * time; 
 */
package dragrace;

public class RaceCar {

    private final int top_speed;
    private final int acceleration;
    private final double nitro;
    private final double fuel;
    private final double engine_size;
    private double distance_traveled = 1;
    private double current_speed;

    public RaceCar(int speed, int acceleration, double nitro, double fuel, double engine_size) {
        this.top_speed = (speed - 1) * (200 - 120) / (10 - 1) + 120; // in mph
        this.acceleration =  60/((acceleration - 1) * (3 - 7) / (10 - 1) + 7);
        this.nitro = nitro;
        this.fuel = fuel;
        this.engine_size = engine_size;
    }

    public void run() {

    }

    public void useNitro() {

    }

    public double milesToMeters(double miles) {
        return miles * 0.000621371192;
    }

    public double metersToMiles(double meters) {
        return meters * 1609.344;
    }

    public double mphToMetersPerHour(double mph) {
        return mph * 0.44704;
    }

    public String toString() {
        return "Speed: " + top_speed + "\n Acceleration: " + acceleration;
    }

}
