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
public class Kane extends Wrestler {
    
    public Kane(){
    }

    @Override
    public void themeMusic() {
        System.out.println("Kane MUSIC");
    }

    @Override
    public void finisher() {
        System.out.println("Choke Slam");
    }
    
    
}
