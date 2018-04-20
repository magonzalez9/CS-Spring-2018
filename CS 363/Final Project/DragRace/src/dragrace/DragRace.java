/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragrace;

import java.io.File;
import java.net.URL;

/**
 *
 * @author marco
 */
public class DragRace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RaceFrame r = new RaceFrame();
        r.setVisible(true);

//         //set things
        double top_speed = 100;
        double track_distance = 2;

        //current vars
        double acceleration = 60 / 8;
        double current_speed = 0;
        double distance_traveled = 0;
        
        System.out.println(acceleration);

//        for (double i = 1; i < 60; i++) { // 60 seconds
//            if (!(current_speed >= top_speed)) {
//                current_speed += acceleration;
//            } else {
//                current_speed = top_speed;
//            }
//            distance_traveled += (current_speed * 0.44704) ;  // meters per second
//
//            System.out.println("Speed after second " + i + ": " + current_speed);
//            System.out.println("Distance traveled " + i + ": " + distance_traveled);
//        }
        

    }

}
