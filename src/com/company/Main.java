package com.company;

import java.util.Collection;
import java.util.Collections;

public class Main {
    /*
    Index cards - value :
    0 = 2
    1 = 3
    2 = 4
    3 = 5
    4 = 6
    5 = 7
    6 = 8
    7= 9
    8 = 10
    9 = 10/Jack
    10 = 10/Queen
    11 = 10/King
    12 = 1/11 Ace
    */
    public static void main(String[] args) {
	Game newGame = new Game();
    newGame.initGame();
    newGame.gameLoop();


    }
}
