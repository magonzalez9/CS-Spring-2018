/*
 * acceleration = meters per second^2
 * speed = distance / time
 * time = distance / speed; 
 * distance = speed * time; 
 */
package dragrace;

import javax.swing.ImageIcon;

public class RaceCar {

    // Car statistics
    private final String name;
    private final ImageIcon image;
    private int top_speed;
    private int acceleration;
    private double nitro;
    private double fuel;
    private double engine_size;
    private double track_distance;

    // Stats while moving
    private double distance_traveled = 0;
    private double current_speed;

    public RaceCar(String name, int speed, int acceleration, double nitro, double fuel, int engine_size, ImageIcon image) {
        this.name = name;
        this.top_speed = (speed - 1) * (200 - 120) / (10 - 1) + 120; // in mph
        this.acceleration = 60 / ((acceleration - 1) * (3 - 7) / (10 - 1) + 7);
        this.nitro = nitro;
        this.fuel = fuel;
        this.engine_size = engine_size;
        this.image = image;
    }

    public void setDistance(int distance) {
        track_distance = distance;
    }

    public void useNitro() {

    }

    public void editRaceCar(int speed, int acceleration, int nitro, int fuel, int engine_size) {
        this.top_speed = speed;
        this.acceleration = acceleration;
        this.nitro = nitro;
        this.fuel = fuel;
        this.engine_size = engine_size;
    }
    public double distanceTraveled() {
        return distance_traveled;
    }

    public ImageIcon getCarImage() {
        return this.image;
    }

    public double run() {

        if (!(current_speed >= top_speed)) {
            current_speed += acceleration;
        } else {
            current_speed = top_speed;
        }

        // if car has crossed the finish line, then deccelerate
        // else keep going!
        return distance_traveled += (current_speed * 0.44704) * (.05);  // meters per second

//            System.out.println("Speed after second " + i + ": " + current_speed);
//            System.out.println("Distance traveled " + i + ": " + distance_traveled);
    }

    public void reset() {
        distance_traveled = 0;
        current_speed = 0;
    }

    @Override
    public String toString() {
        return "RaceCar{" + "name=" + name + "," + ", top_speed=" + top_speed + ", acceleration=" + acceleration + ", nitro=" + nitro + ", fuel=" + fuel + ", engine_size=" + engine_size + ", current dis=" + distance_traveled + '}';
    }

    // for distance we have 1 - 1000 meters, For stats,  1 = (1609.34) meters and 1000 == 16093.4 meters and 
}
