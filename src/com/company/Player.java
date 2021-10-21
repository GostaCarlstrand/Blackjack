package com.company;

import java.util.ArrayList;

public class Player {
    ArrayList <Cards> currentHand = new ArrayList<>();
    int currentHandValue;
    int walletBalance;


    public void displayCurrentHand() {
        for (int i = 0; i < currentHand.size(); i++) {
            System.out.println(currentHand.get(i).displayCard());
        }
    }

    public void displayWalletBalance() {
        System.out.print("You have this amount of money: ");
        System.out.println(walletBalance);
    }

    public void setWalletBalance(int bet) {
        this.walletBalance -= bet;
    }


}

