package com.lab1.hothands;

import java.util.Collections;
import java.util.Vector;

public class Deck extends Card {

    //Deck consists of 52 cards
    private Vector deck = new Vector (52);

    //Creates a ordered deck
    public Deck(){
        for(Integer i = 0; i < 4; i++){
            for(Integer j = 0; j < 13; j++){
                Card tempCard = new Card(i, j);
                deck.add(tempCard);
            }
        }
    }


    public void swap(int a, int b){
        Collections.swap(deck, a, b);
    }

    // Returns a deck
    public Vector getDeck(){
        return deck;
    }

    // Prints the deck
    //TO DO: Make print card image to screen
    public void printdeck(){
        for(int i = 0; i < 52; i++){
            Card temp = new Card();
            temp = (Card) deck.get(i);
            temp.print();
            System.out.println();
        }
    }
    // Returns the size of the deck
    public int getSize() {
        return deck.size();
    }

}
