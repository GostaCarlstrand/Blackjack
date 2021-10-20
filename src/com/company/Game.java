package com.company;

public class Game {
    VisualCards cardWriter;
    Deck deck;
    Player player;
    Player dealer;
    Menu menu;
    int count = 3; //Used to increase the amount of cards that has been dealt
    boolean hasPlayerWonTheGame;
    boolean gameIsTie;


    public void initGame() {
        count = 3;
        deck = new Deck();
        player = new Player();
        dealer = new Player();
        menu = new Menu();
        cardWriter = new VisualCards();
        deck.initCards();           //Creating the objects cards
        deck.sortArrayDeckOfCards(deck.deckOfCards);//Creating a single array with all cards in order
        deck.shuffleDeckOfCards();

        //deck.displayShuffleDeckOfCards();   //DISPLAY all shuffle cards

    }
    public void gameLoop() {
        initGame();
        dealStartHand();
        gamePlaying();
        displayGameResult();
        wantToPlayAgain();

    }


    public void dealStartHand() {
        player.currentHand.add(deck.sortedDeckOfCards.get(0));
        dealer.currentHand.add(deck.sortedDeckOfCards.get(1));
        player.currentHand.add(deck.sortedDeckOfCards.get(2));
        player.currentHandValue = player.currentHand.get(0).value + player.currentHand.get(1).value;
        dealer.currentHandValue = dealer.currentHand.get(0).value;
    }

    public void dealAnotherCard(Player player) {
        player.currentHand.add(deck.sortedDeckOfCards.get(count));  //Take next card from deck
        player.currentHandValue += deck.sortedDeckOfCards.get(count).value;
        if (player.currentHandValue > 21 && deck.sortedDeckOfCards.get(count).isAce){
            player.currentHandValue -= 10;      //Reduces 10 to the value if next draw is Ace && total value is > 21
        }
        count += 1;
    }

    public void compareHands() {
        if (dealer.currentHandValue > 21) {     //Has dealer busted
            hasPlayerWonTheGame = true;
        } else if(player.currentHandValue > dealer.currentHandValue) {
            hasPlayerWonTheGame = true;
        } else if (dealer.currentHandValue == 17 && player.currentHandValue == 17) {
            hasPlayerWonTheGame = false;
        } else if (dealer.currentHandValue == 18 && player.currentHandValue == 18) {
            hasPlayerWonTheGame = false;
        } else if (dealer.currentHandValue == 19 && player.currentHandValue == 19) {
            hasPlayerWonTheGame = false;
        } else if (dealer.currentHandValue == 20 && player.currentHandValue == 20) {
            gameIsTie = true;
        } else if (dealer.currentHandValue == 21 && player.currentHandValue == 21) {
            gameIsTie = true;
        } else if (dealer.currentHandValue > player.currentHandValue) {
            hasPlayerWonTheGame = false;
        }
    }
    public void displayGameResult() {
        if (gameIsTie) {
            System.out.println("There is a draw, you got your money back");
        } else if(!hasPlayerWonTheGame){
            System.out.println("Sorry, you lost this game");
        } else if (hasPlayerWonTheGame) {
            System.out.println("Congratulations, you have won");
        }
    }

    public void quitGame() {
        System.exit(1);
    }

    public void playersTurn() {
        boolean playersTurn = true;
        while (playersTurn) {
            System.out.println("This is your hand: ");
            player.displayCurrentHand();
            System.out.println("You have " + player.currentHandValue);
            if (player.currentHandValue == 21 && (!dealer.currentHand.get(0).isAce)) {
                System.out.println("BLACKJACK, you have won");
                wantToPlayAgain();
            }
            String menuChoice = menu.menuInput();
            if (menuChoice.equalsIgnoreCase("Take")) {
                dealAnotherCard(player);
                System.out.println("Next card is: " + deck.sortedDeckOfCards.get(count-1).displayCard());

                if (player.currentHandValue > 21) {
                    System.out.println("Oops, you got, " + player.currentHandValue + " the game is over");
                    wantToPlayAgain();
                } else if (player.currentHandValue == 21) {
                    System.out.println("You got 21");
                    playersTurn = false;
                    break;
                }
            }
            else if (menuChoice.equalsIgnoreCase("Stop")) {
                playersTurn = false;
                break;
            }
            continue;
        }
    }

    public void dealersTurn() {
        System.out.println("Dealer has ");
        dealer.displayCurrentHand();
        boolean dealerRunning = true;
        while (dealerRunning) {
            dealAnotherCard(dealer);
            System.out.println("Next card is: " + deck.sortedDeckOfCards.get(count-1).displayCard());
            if (dealer.currentHandValue >= 17) {
                System.out.println("Dealer stops at: " + dealer.currentHandValue);
                dealerRunning = false;
                break;
            }

        }

    }

    public void wantToPlayAgain() {
            String menuChoice = menu.leaveGame();
            if (menuChoice.equalsIgnoreCase("yes")) {
                gameLoop();
            } else {
                quitGame();
            }
        }

    public void gamePlaying() {
            playersTurn();
            dealersTurn();
            compareHands();
        }
}
