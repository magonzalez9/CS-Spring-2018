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
public class Abstraction {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Abstract
        Wrestler kane = new Kane();
        Wrestler stone = new StoneCold();

        kane.paymentForWork(0);
        kane.finisher();

        // Interface
        SuperStar darude = new Darude();
        SuperStar skrillex = new Skrillex();

        skrillex.age();
        darude.pay(120000000);
        char a = 'a';

        String b = "";
        for (int i = 0; i < 5; i++) {
            b+= a;
        }
    }

}
