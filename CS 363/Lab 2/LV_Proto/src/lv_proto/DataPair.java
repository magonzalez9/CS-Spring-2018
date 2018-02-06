/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lv_proto;

/**
 *
 * @author marco
 */
public class DataPair {

    protected int h;
    protected int p;

    public DataPair() {
    }   //empty default constructor

    public DataPair(int h, int p) {   //initializing constructor
        this();   // invoke the default constructor
        this.h = h;
        this.p = p;
    }

    public int getH() {
        return h;
    }

    public int getP() {
        return p;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setP(int p) {
        this.p = p;
    }

    public String toString() {
        String returnMe = "";
        returnMe += "h=" + getH();
        returnMe += " p=" + getP();
        return returnMe;
    } // toString()

}
