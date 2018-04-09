/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dragrace;

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
        r.setSize(1000,500);
        // set things
        double top_speed = 100; 
        double track_distance = 2; 
        
        
        //current vars
        double acceleration = 2; 
        double speed = 0;
        double distance = 0;
        
        for (int i = 0; i < 60; i++) { // 60 seconds
            if (speed != top_speed) {
                speed += acceleration; 
            }
            distance = speed * i;  // meters
            
            System.out.println("Distance covered at second " + i +": "+ distance);
        }
   }
    
}
