package com.lab1.hothands;

import android.widget.ImageView;

public class Card {
    //TO DO: MAKE A DYNAMIC CARD IMAGE
    // A card consists of a value and a suite
    private int value;
    private char suite;
    private String id;

    public Card (){
        value = -1;
        suite = ' ';
        id = "card";
    }

    public Card(int dataVal, char dataSuite) {
        value = dataVal;
        suite = dataSuite;
        id = "card";

    }
    public char getSuit() {
        return suite;
    }
    public int getValue () { return value;}
    public String getId () { return ( id + Integer.toString (value) + suite);}
}
