package com.lab1.hothands;

public class Card {
    //TO DO: MAKE A DYNAMIC CARD IMAGE
    // A card consists of a value and a suite
    private int value;
    private char suit;

    public Card() {
        value = -1;
        suit = ' ';

    }

    public Card(Integer s, Integer v) {
        setSuit (s);
        value = v;
    }

    public int getSuit() {
        return suit;
    }

    public int getVal() {
        return value;
    }
    //Cards are generated through an iterative process. Their numbers correspond to a suite as their
    // being created
    public void setSuit(Integer to_suit) {

        switch (to_suit) {
            case (0):
                suit = 'H';
                break;
            case (1):
                suit = 'D';
                break;
            case (2):
                suit = 'S';
                break;
            case (3):
                suit = 'C';
                break;
        }
    }
// The values are numeric values until this point where the ACE, KING, QUEEN, AND JACK are
// generated for the user
//TO DO: Make cards image print to screend
    public void printVal() {
        if (value > 0 && value < 10)
            System.out.print (value + 1);
        else {
            switch (value) {
                case (0):
                    System.out.print ("Ace");
                    break;
                case (10):
                    System.out.print ("Jack");
                    break;
                case (11):
                    System.out.print ("Queen");
                    break;
                case (12):
                    System.out.print ("King");
                    break;
            }
        }
    }

    public void print() {

        printVal ( );
        System.out.println (" of " + suit);
    }
}
