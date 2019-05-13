
package com.lab1.hothands;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name, status;
    private ArrayList<Card> hand;
    private int chips;
    public int pairCount, score;
    public boolean stillIn, highCard, pair, twoPair, threeOkind, check, allIn, fold;
    public boolean straight, flush, fullHouse, fourOkind, straightFlush, royalFlush;

    public Player() {
        name = "A/I";
        hand = new ArrayList<> ();
        chips = 50000; //each new player gets 50k in chips
        pairCount = 0;
        score = 0;
        highCard = false;
        pair = false;
        twoPair = false;
        threeOkind = false;
        straight = false;
        flush = false;
        fullHouse = false;
        fourOkind = false;
        straightFlush = false;
        royalFlush = false;
        stillIn = false;
        check = false;
        allIn = false;
        fold = false;
        status = " ";
    }

    //This  is for texas holdem: Player receives two cards to start
    public Player(String nameData){
        name = nameData;
        chips = 50000;
        hand = new ArrayList<Card>();
        chips = 50000; //each new player gets 50k in chips
        pairCount = 0;
        score = 0;
        highCard = false;
        pair = false;
        twoPair = false;
        threeOkind = false;
        straight = false;
        flush = false;
        fullHouse = false;
        fourOkind = false;
        straightFlush = false;
        royalFlush = false;
        stillIn = false;
        status = " ";
        check = false;
        allIn = false;
        fold = false;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
    public int getChips(){return chips;}
    public void setCard(Card c) {
        hand.add(c);
    }
    public String getName() {
        return name;
    }
    public Card getCard (int i) {return hand.get (i);}
    public int getCardId(int i){
        return hand.get (i).getId ();
    }
    public void reduce (int loss){ chips -= loss; }
    public void increase (int win) {chips += win; }
    public int getScore(){ return score;}
    public void increaseScore(int data) { score += data; }
    public void setStatus (String sts) { status = sts;}
    public String getStatus () {return status;}

    public void newRound() {
        pairCount = 0;
        score = 0;
        highCard = false;
        pair = false;
        twoPair = false;
        threeOkind = false;
        straight = false;
        flush = false;
        fullHouse = false;
        fourOkind = false;
        straightFlush = false;
        royalFlush = false;
        stillIn = true;
        status = " ";
        check = false;
        allIn = false;
        fold = false;
        hand = new ArrayList<> ();
    }
}