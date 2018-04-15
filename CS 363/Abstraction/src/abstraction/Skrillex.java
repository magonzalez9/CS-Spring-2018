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
public class Skrillex implements SuperStar{

    @Override
    public void pay(int money) {
        System.out.println("Money" + money);
    }

    @Override
    public void hitSong() {
        System.out.println("First of the year");
    }

    @Override
    public void age() {
        System.out.println("27");
    }
   
}
