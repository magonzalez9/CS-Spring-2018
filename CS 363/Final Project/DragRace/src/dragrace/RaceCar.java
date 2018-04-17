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
    private String name;
    private final int top_speed;
    private final int acceleration;
    private final double nitro;
    private final double fuel;
    private final double engine_size;
    public ImageIcon image;

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

    public double run() {

        if (!(current_speed >= top_speed)) {
            current_speed += acceleration;
        } else {
            current_speed = top_speed;
        }
        return distance_traveled += (current_speed * 0.44704);  // meters per second

//            System.out.println("Speed after second " + i + ": " + current_speed);
//            System.out.println("Distance traveled " + i + ": " + distance_traveled);
    }

    public void useNitro() {

    }

    public double distanceTraveled() {
        return distance_traveled;
    }

    public ImageIcon drawImage() {
        return this.image;
    }

    public void reset() {
        distance_traveled = 0;
        current_speed = 0;
    }

    @Override
    public String toString() {
        return "RaceCar{" + "name=" + name + "," + ", top_speed=" + top_speed + ", acceleration=" + acceleration + ", nitro=" + nitro + ", fuel=" + fuel + ", engine_size=" + engine_size + ", current dis=" + distance_traveled + '}';
    }

}
