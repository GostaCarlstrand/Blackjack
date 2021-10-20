package com.company;

import java.util.ArrayList;

public class Player {
    ArrayList <Cards> currentHand = new ArrayList<>();
    int currentHandValue;

    public void displayCurrentHand() {
        for (int i = 0; i < currentHand.size(); i++) {
            System.out.println(currentHand.get(i).displayCard());
        }
    }



}

