/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstraction;

/**
 *
 * @author marco
 */
public class Darude implements SuperStar{
    
    public void pay(int money){
        System.out.println("money:" + money);
    }
    
    public void hitSong() {
        System.out.println("Sandstorm");
    }
    
    public void age(){
        System.out.println("35");
    }


}
