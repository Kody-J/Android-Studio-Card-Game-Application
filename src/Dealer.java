/*
The dealer has the most important role. The dealer handles all the cards,
tracks the rules, determines validity, and determines who wins
*/

package com.lab1.hothands;
import java.util.*;
import java.util.Random;

public class Dealer extends Deck{
    //Consists of a deck, card count, a name, an knowledge of the game rules, and player
    private int chips_in_pot, plyr_1chips, plyr_2chips, plyr_3chips, player_count, card_count;
    private Random rand;
    private Deck theD;
    private ArrayList<Card> dealerCards;
    private boolean isPoker;


    public Dealer(boolean is_poker_data, int player_data) {

        rand = new Random();
        theD = new Deck ();
        //Shuffle the deck at least 3 times
        shuffle();
        shuffle();
        shuffle();
        isPoker = is_poker_data;
        card_count = theD.getNumOcards( );
        player_count = player_data;
    }

    public  void shuffle(){
        Card tempCard;
        int randIndexToSwap1, randIndexToSwap2;
        for(int i = 0; i < 25; i++){
            randIndexToSwap1 = rand.nextInt(26);
            randIndexToSwap2 = rand.nextInt(26)+ 26;
            Collections.swap(theD.getDeck (), randIndexToSwap1,randIndexToSwap2);
        }
    }
    public Card dealCard(){
        Card tempCard = theD.getDeck().get (theD.getDeck ().size()-1);
        theD.getDeck ().remove (theD.getDeck ().size ()-1);
        theD.getDeck ().trimToSize ();
        return tempCard;
    }

    public void burnCard(){
        theD.getDeck ().remove(theD.getDeck ().size() -1);
        theD.getDeck ().trimToSize ();
    }

    //This is for Texas Hold'em: Burns a card, then dealer takes three card to turn over for the players
    public ArrayList<Card> flop() {
        burnCard();
        for (int i = 0; i < 3; i++) {
            dealerCards.add(dealCard ());
            card_count--;
        }
        return dealerCards;
    }

    //This is for Texas Hold'em: Burns a card, then dealer takes one card to turn over for players
    public ArrayList<Card> turn() {
       burnCard ();
       card_count -= 2;
       dealerCards.add (dealCard ());
       return dealerCards;
    }

    //This is for Texas Holdem: Burns a card, then dealer takes one card to turn over for players
    public ArrayList<Card> river() {
        burnCard ();
        dealerCards.add (dealCard ());
        return dealerCards;
    }

    //This is the begenning of the 5 card Poker logic: pretty simple implemintaion as such
    //1. Five cards are dealt to each player
    //2. Betting round #1 =, begenning with the first active player to left of bing blind
    //3. Draw (This where each player is given the opportunity to 'discard' any or all thier cards and recive new replacments
    //4. Betting round #2, begenning with the first active player
    //5. Showdown (a winner is determined if th there is more than one player in the pot)

}
