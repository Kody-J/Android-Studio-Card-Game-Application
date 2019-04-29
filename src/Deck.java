package com.lab1.hothands;
import java.util.*;

public class Deck extends Card {

    //Deck consists of 52 cards
    private ArrayList<Card> deck;

    //Creates a ordered deck
    public Deck(){
        deck = new ArrayList<Card>();
        deck.add(new Card(2, 'd', R.drawable.card2d));
        deck.add(new Card(2, 'c', R.drawable.card2c));
        deck.add(new Card (2, 'h', R.drawable.card2h));
        deck.add(new Card (2, 's', R.drawable.card2s));

        deck.add(new Card(3, 'd', R.drawable.card3d));
        deck.add(new Card(3, 'c', R.drawable.card3c));
        deck.add(new Card (3, 'h', R.drawable.card3h));
        deck.add(new Card (3, 's', R.drawable.card3s));

        deck.add(new Card(4, 'd', R.drawable.card4d));
        deck.add(new Card(4, 'c', R.drawable.card4c));
        deck.add(new Card (4, 'h', R.drawable.card4h));
        deck.add(new Card (4, 's', R.drawable.card4s));

        deck.add(new Card(5, 'd', R.drawable.card5d));
        deck.add(new Card(5, 'c', R.drawable.card5c));
        deck.add(new Card (5, 'h', R.drawable.card5h));
        deck.add(new Card (5, 's', R.drawable.card5s));

        deck.add(new Card(6, 'd', R.drawable.card6d));
        deck.add(new Card(6, 'c', R.drawable.card6c));
        deck.add(new Card (6, 'h', R.drawable.card6h));
        deck.add(new Card (6, 's', R.drawable.card6s));

        deck.add(new Card(7, 'd', R.drawable.card7d));
        deck.add(new Card(7, 'c', R.drawable.card7c));
        deck.add(new Card (7, 'h', R.drawable.card7h));
        deck.add(new Card (7, 's', R.drawable.card7s));

        deck.add(new Card(8, 'd', R.drawable.card8d));
        deck.add(new Card(8, 'c', R.drawable.card8c));
        deck.add(new Card (8, 'h', R.drawable.card8h));
        deck.add(new Card (8, 's', R.drawable.card8s));

        deck.add(new Card(9, 'd', R.drawable.card9d));
        deck.add(new Card(9, 'c', R.drawable.card9c));
        deck.add(new Card (9, 'h', R.drawable.card9h));
        deck.add(new Card (9, 's', R.drawable.card9s));

        deck.add(new Card(10, 'd', R.drawable.card10d));
        deck.add(new Card(10, 'c', R.drawable.card10c));
        deck.add(new Card (10, 'h', R.drawable.card10h));
        deck.add(new Card (10, 's', R.drawable.card10s));

        deck.add(new Card(11, 'd', R.drawable.card11d));
        deck.add(new Card(11, 'c', R.drawable.card11c));
        deck.add(new Card (11, 'h', R.drawable.card11h));
        deck.add(new Card (11, 's', R.drawable.card11s));

        deck.add(new Card(12, 'd', R.drawable.card12d));
        deck.add(new Card(12, 'c', R.drawable.card12c));
        deck.add(new Card (12, 'h', R.drawable.card12h));
        deck.add(new Card (12, 's', R.drawable.card12s));

        deck.add(new Card(13, 'd', R.drawable.card13d));
        deck.add(new Card(13, 'c', R.drawable.card13c));
        deck.add(new Card (13, 'h', R.drawable.card13h));
        deck.add(new Card (13, 's', R.drawable.card13s));

        deck.add (new Card(14, 'd', R.drawable.card14d));
        deck.add(new Card(14, 'c', R.drawable.card14c));
        deck.add(new Card (14, 'h', R.drawable.card14h));
        deck.add(new Card (14, 's', R.drawable.card14s));

    }

    // Returns a deck
    public ArrayList<Card> getDeck() {
        return deck;
    }

    // Returns the size of the deck
    public int getNumOcards() {
        return deck.size ();
    }

}
