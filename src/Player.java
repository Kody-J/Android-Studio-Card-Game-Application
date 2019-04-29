package com.lab1.hothands;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private ArrayList<Card> hand;
    private int chips;
    private boolean bet, check, fold, call;

    public Player() {
        name = "A/I";
        hand = new ArrayList<Card> ();
        chips = 50000; //each new player gets 50k in chips
    }

    //This  is for texas holdem: Player receives two cards to start
    public Player(String nameData){
        name = nameData;
        chips = 50000;
        hand = new ArrayList<Card>();
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
    public int getChips(){return chips;}
    public void setCard(Card c) {
        hand.add(c);
    }
    //Returns payers name
    public String getName() {
        return name;
    }

    public int getCardId(int i){
        return hand.get (i).getId ();
    }
}
