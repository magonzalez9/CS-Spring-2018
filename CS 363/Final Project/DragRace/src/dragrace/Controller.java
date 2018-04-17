package dragrace;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Controller extends JComponent {

    static JPanel panel;
    static int column = 1; // Track size will probably be from 1 - 1100
    static int row = 195;
    static boolean running = true;
    static CarList car_list;

    Controller(JPanel panel) {
        Controller.panel = panel;
    }

    public static void setCarList(CarList list) {
        Controller.car_list = list;
    }

    static Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                while (true) {
                    if (running) {
                        panel.repaint();

                        // get car list and execute the run() method
                        if (car_list.size() >= 1) {
                            car_list.get(0).run();
                        }
                        if (car_list.size() >= 2) {

                            car_list.get(1).run();
                        }
                        if (car_list.size() >= 3) {

                            car_list.get(2).run();
                        }
                        if (car_list.size() >= 4) {

                            car_list.get(3).run();
                        }
                        if (car_list.size() >= 5) {

                            car_list.get(4).run();
                        }

                        column += 1; // this will be the distance covered determined by our stats 
                    }
                    thread.sleep(100);

                }

            } catch (java.lang.InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    };

    public static void toggleRunning() {
        if (thread.isAlive()) {
            running = !running;
        }

    }

    public static void move() {
        if (!thread.isAlive()) {
            thread.start();
        } else if (thread.isAlive()) {
            toggleRunning();
        }
        //column = 3;
    }

    public double milesToMeters(double miles) {
        return miles * 0.000621371192;
    }

    public double metersToMiles(double meters) {
        return meters * 1609.344;
    }

    public double mphToMetersPerHour(double mph) {
        return mph * 0.44704;
    }
}
