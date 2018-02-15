/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendmain;

import java.awt.Graphics;

/**
 *
 * @author Marco
 */
public class Pendulum {

    protected int xPivot;
    protected int yPivot;
    protected double theta;
    protected double vTheta;
    protected double length;
    double force;

    public Pendulum() {
    }   //empty default constructor

    public Pendulum(int x, int y, double theta, double vTheta, double length) {   //initializing constructor
        this();   // invoke the default constructor
        this.xPivot = x;
        this.yPivot = y;
        this.theta = theta;
        this.vTheta = vTheta;
        this.length = length;
    }

    Pendulum(int x, int y, int mouseX, int mouseY) {
        this();   // invoke the default constructor
        this.xPivot = x;
        this.yPivot = y;
        vTheta = 0;
        length = Math.hypot(x - mouseX, y - mouseY);
        theta = Math.atan2(mouseX - x, mouseY - y);
    }

    void paint(Graphics g) {
        double displayTheta = theta + Math.PI * 3 / 2;   //down, I hope!
        int xEnd = xEnd(displayTheta);
        int yEnd = yEnd(displayTheta);
        g.drawLine(xPivot, yPivot, xEnd, yEnd);
        g.fillOval(xEnd - 5, yEnd - 5, 10, 10);
    }

    int xEnd(double theta) {
        return (int) (xPivot + length * Math.cos(theta));
    }

    int yEnd(double theta) {
        return (int) (yPivot - length * Math.sin(theta));
    }

    void step() {
        vTheta -= (force + Math.sin(theta)) / length;
        theta += vTheta;
    }

    public int getX() {
        return xPivot;
    }

    public int getY() {
        return yPivot;
    }

    public double getTheta() {
        return theta;
    }

    public double getVTheta() {
        return vTheta;
    }

    public double getLength() {
        return length;
    }

    public void setX(int x) {
        this.xPivot = x;
    }

    public void setY(int y) {
        this.yPivot = y;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }

    public void setVTheta(double vTheta) {
        this.vTheta = vTheta;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String toString() {
        String returnMe = "Pend: ";
        returnMe += "\tx=" + getX();
        returnMe += " y=" + getY();
        returnMe += " theta=" + getTheta();
        returnMe += " vTheta=" + getVTheta();
        returnMe += " length=" + getLength();
        return returnMe;
    } // toString()

    void setForce(double f) {
        force = f;
    }

}  // Pendulum
