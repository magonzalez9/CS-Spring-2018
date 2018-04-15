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
public abstract class Wrestler {

    //Methods
    public void paymentForWork(int hours) {
        System.out.println("Payment:" + hours);
    }

    public abstract void themeMusic();
    public abstract void finisher();
    
}
