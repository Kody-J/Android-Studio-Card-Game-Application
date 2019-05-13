/*
The dealer has the most important role. The dealer handles all the cards,
tracks the rules, determines validity, and determines who wins
*/

package com.lab1.hothands;
import java.util.*;
import java.util.Random;

public class Dealer extends Deck {
    //Consists of a deck, card count, a name, an knowledge of the game rules, and player
    private int chips_in_pot, plyr_1chips, plyr_2chips, plyr_3chips, player_count, card_count;
    private Random rand;
    private Deck theD;
    private int dealerScore;
    private ArrayList<Card> dealerCards;
    private ArrayList<Player> playersInHand;
    private boolean isPoker;

    public Dealer(boolean is_poker_data, int player_data) {
        dealerCards = new ArrayList<> ( );
        playersInHand = new ArrayList<> ( );
        rand = new Random ( );
        theD = new Deck ( );
        shuffle ( );
        shuffle ( );
        isPoker = is_poker_data;
        card_count = theD.getNumOcards ( );
        player_count = player_data;
        dealerScore = 0;
    }

    public void shuffle() {
        Card tempCard;
        int randIndexToSwap1, randIndexToSwap2;
        for (int i = 0; i < 25; i++) {
            randIndexToSwap1 = rand.nextInt (26);
            randIndexToSwap2 = rand.nextInt (26) + 26;
            Collections.swap (theD.getDeck ( ), randIndexToSwap1, randIndexToSwap2);
        }
    }

    public Card dealCard() {
        Card tempCard = theD.getDeck ( ).get (theD.getDeck ( ).size ( ) - 1);
        theD.getDeck ( ).remove (theD.getDeck ( ).size ( ) - 1);
        theD.getDeck ( ).trimToSize ( );
        return tempCard;
    }

    public void burnCard() {
        theD.getDeck ( ).remove (theD.getDeck ( ).size ( ) - 1);
        theD.getDeck ( ).trimToSize ( );
    }

    //This is for Texas Hold'em: Burns a card, then dealer takes three card to turn over for the players
    public ArrayList<Card> flop() {
        burnCard ( );
        for (int i = 0; i < 3; i++) {
            dealerCards.add (dealCard ( ));
            card_count--;
        }
        return dealerCards;
    }

    //This is for Texas Hold'em: Burns a card, then dealer takes one card to turn over for players
    public ArrayList<Card> turn() {
        burnCard ( );
        card_count -= 2;
        dealerCards.add (dealCard ( ));
        return dealerCards;
    }

    //This is for Texas Holdem: Burns a card, then dealer takes one card to turn over for players
    public ArrayList<Card> river() {
        burnCard ( );
        dealerCards.add (dealCard ( ));
        return dealerCards;
    }

    public int getCard(int index) {
        return dealerCards.get (index).getId ( );
    }

    public void setDealerScore(Player p) {


    }

    public void setPlayerScore(Player p) {

        char tempSuite = ' ';
        int[] playerHand = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int count = 0, zValue = 0, suiteCount = 0;

        for (int i = 0; i < p.getHand ().size (); i++) {
            playerHand[p.getCard (i).getValue () - 2] += 1;
            if (p.getCard (i).getSuit ( ) != tempSuite) {
                tempSuite = p.getCard (i).getSuit ( );
                suiteCount = 1;
            } else
                suiteCount += 1;
        }
        if(dealerCards.size () > 4) {
            for (int j = 0; j < 5; j++) {
                playerHand[dealerCards.get (j).getValue ( ) - 2] += 1;
                if (dealerCards.get (j).getSuit ( ) != tempSuite) {
                    tempSuite = dealerCards.get (j).getSuit ( );
                    suiteCount = 1;
                } else
                    suiteCount += 1;
            }
        }
        //Crunch the players raw score (before weighted values)
        for (int k = 0; k < playerHand.length; k++) {
            if (playerHand[k] == 0)
                count = 0;
            else if (playerHand[k] == 1) {
                p.increaseScore (k + 2);
                count += 1;
            } else if (playerHand[k] == 2) {
                p.pairCount += 1;
                p.increaseScore (2 * (k + 2));
                count += 1;
            } else if (playerHand[k] == 3) {
                p.threeOkind = true;
                p.increaseScore (3 * (k + 2));
                count = 0;
            } else {
                p.fourOkind = true;
                p.increaseScore (4 * (k + 2));
                count += 1;
            }
        }
        //Calculate the weighted value and add that to player score (zValue)
        if (suiteCount == 5) {
            if (count == 5)
                zValue = 823;
            else
                zValue = 333;
        } else if (p.fourOkind)
            zValue = 767;
        else if (p.pairCount == 1 && p.threeOkind)
            zValue = 393;
        else if (count == 5)
            zValue = 273;
        else if (p.threeOkind)
            zValue = 206;
        else if (p.pairCount > 0)
            zValue = (60 * p.pairCount);
        p.score += zValue;
    }

    public void setStatus(Player p1, Player p2, Player p3){

        if(p1.getScore () > p2.getScore () && p1.getScore () > p3.getScore ()) {
            if(p1.getScore () == 0)
                p1.setStatus ("Fold");
            else
                p1.setStatus ("Winner!");
            p2.setStatus ("Loser");
            p3.setStatus ("Loser");
        }
        else if(p2.stillIn == true && p2.getScore () > p1.getScore () && p2.getScore () > p3.getScore ()) {
            p2.setStatus ("Winner!");
            if(p1.getScore () == 0)
                p1.setStatus ("Fold");
            else
                p1.setStatus ("Winner!");
            p3.setStatus ("Loser");
        }
        else if(p3.stillIn == true && p3.getScore () > p1.getScore () && p3.getScore () > p2.getScore ()){
            p3.setStatus ("Winner!");
            if(p1.getScore () == 0)
                p1.setStatus ("Fold");
            else
                p1.setStatus ("Winner!");
            p2.setStatus ("Loser");
        }
    }


    //This is the begenning of the 5 card Poker logic: pretty simple implemintaion as such
    //1. Five cards are dealt to each player
    //2. Betting round #1 =, begenning with the first active player to left of bing blind
    //3. Draw (This where each player is given the opportunity to 'discard' any or all thier cards and recive new replacments
    //4. Betting round #2, begenning with the first active player
    //5. Showdown (a winner is determined if th there is more than one player in the pot)

}