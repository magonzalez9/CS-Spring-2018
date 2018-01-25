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
import java.util.Scanner;

/**
 *
 * @author marco
 */
public class MontePlay {

    private int prizeDoor, chosenDoor, donkeyDoor;
    List<Boolean> doors = new ArrayList<>(Arrays.asList(new Boolean[3]));
    Random randomNum = new Random();

    public MontePlay() {

    }

    public List<Boolean> selectDoor(int doorNumber) {
        Collections.fill(doors, false);
        prizeDoor = randomNum.nextInt(2 - 0 + 1) + 0;

        // Set winning door prize to true
        doors.set(prizeDoor, true);
//        System.out.println(doors.toString());

        chosenDoor = doorNumber;
        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i) != true && i != chosenDoor) {
                donkeyDoor = i;
            }
        }
        return doors; 
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

    public void playGame() {
        Collections.fill(doors, false);
        int prizeDoor = randomNum.nextInt(2 - 0 + 1) + 0;

        // Set winning door prize to true
        doors.set(prizeDoor, true);
        System.out.println(doors.toString());

        System.out.println("Select a door");
        Scanner input = new Scanner(System.in);
        int chosenDoor = input.nextInt();
        int donkeyDoor = 0;

        for (int i = 0; i < doors.size(); i++) {
            if (doors.get(i) != true && i != chosenDoor) {
                donkeyDoor = i;
            }
        }

        System.out.println("You selected door number: " + chosenDoor);
        System.out.println("There is a donkey behind door number: " + donkeyDoor);
        System.out.println("Would you like to switch doors? ");

        int doorSwitch = input.nextInt();
        if (doorSwitch == 1) {
            Contestant stayer = new Stayer(chosenDoor);
        }

        if (doorSwitch == 1) {
            if (doors.get(chosenDoor) == true) {
                System.out.println("You loose");
            } else {
                System.out.println("You win!");
            }

        } else if (doorSwitch == 0) {
            if (doors.get(chosenDoor) == true) {
                System.out.println("Woohoo you win ");
            } else {
                System.out.println("You loose");
            }
        }
    }
}
