package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Deck {
    Cards card;
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    Cards[][] deckOfCards = new Cards[4][13];
    ArrayList<Cards> sortedDeckOfCards = new ArrayList<Cards>();
    String[] names = {"Jack", "Queen", "King", "Ace"};


    public void initCards() {
        for (int i = 0; i <= 3; i++) {
            String suit = suits[i];
            for (int a = 0; a < 9; a++) {
                card = new Cards(suit, (a + 2));      //assign suit and value (index + 2)
                card.setName(String.valueOf(a + 2));  ////assign name to be displayed (index + 2)
                deckOfCards[i][a] = card;         //place in deckOfCars [i] = suit , [a-1] = index
            }
            int count = 0;      //To reach index of name list
            for (int a = 9; a < 13; a++) {
                card = new Cards(suit, (10));
                card.setName(names[count]);
                deckOfCards[i][a] = card;
                count += 1;
                if (a == 12) {
                    card.isAce = true;
                    card.setValue(11);
                }
            }
        }
    }

    public ArrayList<Cards> sortArrayDeckOfCards(Cards[][] deckOfCards) { //From multidimensional to single arraylist
        for (int i = 0; i < deckOfCards.length; i++) {
            for (int a = 0; a < deckOfCards[i].length; a++) {
                sortedDeckOfCards.add(deckOfCards[i][a]);
            }
        }
        return sortedDeckOfCards;
    }

    public ArrayList<Cards> shuffleDeckOfCards() {
        Collections.shuffle(sortedDeckOfCards);
        return sortedDeckOfCards;
    }

}
