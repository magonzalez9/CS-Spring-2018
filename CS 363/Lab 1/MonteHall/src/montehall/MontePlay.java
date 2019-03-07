/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package montehall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author marco
 */
public class MontePlay {

    List<Boolean> doors = new ArrayList<>(Arrays.asList(new Boolean[3]));
    Random randomNum = new Random();
    Random randomDoor = new Random();

    private int prizeDoor, chosenDoor, donkeyDoor;
    private int timesWon, timesLost;
    private boolean stay;
    private String resultString;

    public void setDonkeyDoor(int donkeyDoor) {
        this.donkeyDoor = donkeyDoor;
    }

    public void setStay(boolean stay) {
        this.stay = stay;
    }

    public String getResultString() {
        return resultString;
    }

    public boolean getStay() {
        return stay;
    }

    public int getPrizeDoor() {
        return prizeDoor;
    }

    public int getChosenDoor() {
        return chosenDoor;
    }

    public int getDonkeyDoor() {
        return donkeyDoor;
    }

    public int getTimesWon() {
        return timesWon;
    }

    public int getTimesLost() {
        return timesLost;
    }
    
    public List<Boolean> getDoors() {
        return doors;
    }

    public List<Boolean> selectDoor(int doorNumber) {
        Collections.fill(doors, false);
        prizeDoor = randomNum.nextInt(2 - 0 + 1) + 0;

        // Set winning door prize to true
        doors.set(prizeDoor, true);
//        //System.out.println(doors.toString());

        chosenDoor = doorNumber;
        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i) != true && i != chosenDoor) {
                donkeyDoor = i;
            }
        }
        return doors;
    }

    public String getGameResult() {

        if (stay == false) {
            if (doors.get(chosenDoor) == true) {
                resultString = "You switched and lost";
            } else {
                resultString = "You switched and won";
            }

        } else if (stay == true) {
            if (doors.get(chosenDoor) == true) {
                resultString = "You stayed and won";
            } else {
                resultString = "You stayed and lost";
            }
        }
        return resultString;
    }

    public void simulate(int iterations, int stayOrswitch) {
        timesWon = 0;
        timesLost = 0;
        for (int c = 1; c <= iterations; c++) {

            Collections.fill(doors, false);
            prizeDoor = randomNum.nextInt(2 - 0 + 1) + 0;
            chosenDoor = randomDoor.nextInt(2 - 0 + 1) + 0;

            // Set winning door prize to true
            doors.set(prizeDoor, true);
            donkeyDoor = 0;

            for (int i = 0; i < doors.size(); i++) {
                if (doors.get(i) != true && i != chosenDoor) {
                    donkeyDoor = i;
                }
            }

            // Stay or switch
            // 1 = switch | 0 = stay
            int doorSwitch = stayOrswitch;
            if (doorSwitch == 1) {
                if (doors.get(chosenDoor) == true) {
//                    //System.out.println("Switched You loose");
                    timesLost += 1;
                } else {
//                    //System.out.println("Switched You win!");
                    timesWon += 1;
                }

            } else if (doorSwitch == 0) {
                if (doors.get(chosenDoor) == true) {
//                    //System.out.println("Stay Woohoo you win ");
                    timesWon += 1;
                } else {
//                    //System.out.println("Stay You loose");
                    timesLost += 1;
                }
            }
        }
    }
}
