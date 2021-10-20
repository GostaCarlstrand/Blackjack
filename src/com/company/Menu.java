package com.company;

import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);


    public String menuInput () {
        System.out.println("What would you like to do? ");
        System.out.print("Take/Stop:");
        String menuChoice = input.nextLine();
        return menuChoice;
    }

    public String leaveGame() {
        System.out.println("Want you play again? ");
        System.out.println("Type yes/no");
        String menuChoice = input.nextLine();
        return menuChoice;
    }
}


