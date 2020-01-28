package com.lab1.hothands;

import android.widget.ImageView;

public class Card {
    // A card consists of a value and a suite and an Id for a drawable image
    private int value;
    private char suite;
    private int id;

    public Card (){
        value = -1;
        suite = ' ';
        int id;
    }

    public Card(int dataVal, char dataSuite, int dataId) {
        value = dataVal;
        suite = dataSuite;
        id = dataId;
    }
 
    public char getSuit() { return suite; }
    public int getValue () { return value;}
    public int getId () { return ( id);}
}
