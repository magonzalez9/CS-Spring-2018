/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montehall;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author marco
 */
public class MonteHall {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //generate 3 random numbers from 1-3 

        Integer[] doors = new Integer[3];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = i;
        }

        Collections.shuffle(Arrays.asList(doors));
        System.out.println(Arrays.toString(doors));
        
        Scanner input = new Scanner(System.in); 
        System.out.println("Choose a door");
        int door = input.nextInt(); 
        
        System.out.println(" You chose door number " + door);
        System.out.println("The contents of this door is:" + doors[door-1]);
        
        

    }

}
