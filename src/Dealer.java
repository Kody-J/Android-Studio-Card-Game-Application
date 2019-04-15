/*
The dealer has the most important role. The dealer handles all the cards,
tracks the rules, determines validity, and determines who wins
*/

package com.lab1.hothands;

import java.util.Random;


public class Dealer extends Deck {
    //Consists of a deck, card count, a name, an knowledge of the game rules, and player

    Random rand;
    private Deck theD;
    private String name;
    private int handCount, cardCount, playerCount;


    public Dealer(char pokerOrHoldem) {

        rand = new Random();
        name = "DEALER";
        theD = new Deck ();
        this.shuffle ();
        cardCount = theD.getNumOcards ( );
        playerCount = 2;
    }

    public  void shuffle(){
        Card tempCard;
        int randIndexToSwap1, randIndexToSwap2;
        for(int i = 0; i < 25; i++){
            randIndexToSwap1 = rand.nextInt(27);
            tempCard = theD.getDeck ()[randIndexToSwap1];
            randIndexToSwap2 = rand.nextInt(27)+ 25;
            theD.getDeck ()[randIndexToSwap1] = theD.getDeck ()[randIndexToSwap2];
            theD.getDeck ()[randIndexToSwap2] = tempCard;
        }
    }

    public Card drawCard(){
        cardCount --;
        return theD.getCard ();
    }

    public void burnCard(){
        cardCount --;
        theD.removeCard ();
    }

    //This is for Texas Hold'em: Burns a card, then dealer takes three card to turn over for the players
    //TO DO: Print/ Display Card graphics
    public Card[] flop() {
        Card cardsToFlop [] = new Card[3];
        burnCard();
        for (int i = 0; i < 3; i++) {
            cardsToFlop[i] = theD.getCard ();
            cardCount--;
        }
        return cardsToFlop;
    }

    //This is for Texas Hold'em: Burns a card, then dealer takes one card to turn over for players
    public Card turn() {
       burnCard ();
       cardCount -= 2;
       return drawCard ();
    }

    //This is for Texas Holdem: Burns a card, then dealer takes one card to turn over for players
    public Card river() {
        burnCard ();
        cardCount -= 2;
        return drawCard ();
    }

    //This is the begenning of the 5 card Poker logic: pretty simple implemintaion as such
    //1. Five cards are dealt to each player
    //2. Betting round #1 =, begenning with the first active player to left of bing blind
    //3. Draw (This where each player is given the opportunity to 'discard' any or all thier cards and recive new replacments
    //4. Betting round #2, begenning with the first active player
    //5. Showdown (a winner is determined if th there is more than one player in the pot)
    public void poker_first(Player p) {
        int[] index_to_remove = new int[-5];
        //TO DO: create a text pop up window to display intermediate instructions to the screen
        //accept use input to identify card form user hand to discard and put them in index_to_remove
        for (int i = 0; i < 5; i++) {
            if (p.getHand ( ) == null || index_to_remove[i] < 0 || index_to_remove[i] >= p.getHand ( ).length) {
                // Create another array of size one less
                Card[] anotherArray = new Card[p.getHand ( ).length - 1];

                // Copy the elements except the index from original array to the other array
                for (int k = 0; k < p.getHand ( ).length; k++) {

                    // if the index is the removal element index
                    if (i == index_to_remove[i]) {
                        continue;
                    }

                    // if the index is not the removal element index
                    anotherArray[k++] = p.getHand ( )[i];
                }

            }
        }
    }
}
