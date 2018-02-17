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
public class Model {

    public static final double M = 100000;
    PendulumList list;

    Model() {
        list = new PendulumList();
    }

    void step() {

//        for (int i = 0; i < list.size(); i++) {
//            Pendulum next = list.get(i);
//            next.setForce(calcForce(next, next.getLeft()) - calceForce(next, next.getRight()));
//        }
        Pendulum p1 = list.get(0);
        Pendulum p2 = list.get(1);
        Pendulum p3 = list.get(2);
        Pendulum p4 = list.get(3);
        Pendulum p5 = list.get(4);

        p1.setForce(-calcForce(p1, p2));
        p2.setForce(calcForce(p2, p1) - calcForce(p3, p2));
        p3.setForce(calcForce(p3, p2) - calcForce(p4, p3));
        p4.setForce(calcForce(p4, p3) - calcForce(p5, p4));
        p5.setForce(calcForce(p5, p4));

        for (Pendulum nextP : list) {
            nextP.step();
        }
    }

    double calcForce(Pendulum p1, Pendulum p2) {
        if (p1 == null || p2 == null) {
            return 0;
        }
        return M / distanceThing(p1, p2);
    }

    double distanceThing(Pendulum p1, Pendulum p2) {
        double d = Math.hypot(p1.xEnd(p1.getTheta()) - p2.xEnd(p2.getTheta()),
                p1.yEnd(p1.getTheta()) - p2.yEnd(p2.getTheta()));

        return Math.pow(d, 4);
    }

    private void paintPends(Graphics g) {
        for (Pendulum nextPendulum : list) {
            nextPendulum.paint(g);
        }
    }

    void paint(Graphics g) {
        paintPends(g);
    }

    void add(Pendulum pendulum) {
        list.add(pendulum);
    }

}
