package com.company;

import java.util.Scanner;

public class Menu {
    Scanner stringInput = new Scanner(System.in);
    Scanner intInput = new Scanner(System.in);




    public int placeBet() {
        int betAmount = intInput.nextInt();
        return betAmount;
    }


    public String menuInput () {
        System.out.println("What would you like to do? ");
        System.out.print("Take/Stop:");
        String menuChoice = stringInput.nextLine();
        return menuChoice;
    }

    public String leaveGame() {
        System.out.println("Want you play again? ");
        System.out.println("Type yes/no");
        String menuChoice = stringInput.nextLine();
        return menuChoice;
    }
}


