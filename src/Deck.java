package com.lab1.hothands;

public class Deck extends Card {

    //Deck consists of 52 cards
    private Card deck[];


    //Creates a ordered deck
    public Deck(){
        int numOcards = 0;
        deck = new Card[52];
        char suite = ' ';
        for(int i = 0; i < 4; i++){
            switch (i){
                case 0: {
                    suite = 'c';
                    break;
                }
                case 1: {
                    suite = 'd';
                    break;
                }
                case 2: {
                    suite = 'h';
                    break;
                }
                case 3: {
                    suite = 's';
                    break;
                }
            }
            for(int j = 2; j < 15; j++){
                Card tempCard = new Card(j, suite);
                deck[numOcards] = tempCard;
                numOcards += 1;

            }
        }
    }

    // Returns a deck
    public Card[] getDeck() {
        return deck;
    }

    // Returns the size of the deck
    public int getNumOcards() {
        return deck.length;
    }

    public void removeCard(){
        Card tempDeck[] = new Card[deck.length-1];
        for(int i = 0; i < (deck.length - 1); i++){
            tempDeck[i] = deck[i];
        }
        deck = tempDeck;
    }

    public Card getCard(){
        if(deck.length > 0) {
            Card tempDeck [] = new Card[deck.length - 1];
            for(int i = 0; i < deck.length - 1; i++){
                tempDeck[i] = deck[i];
            }
            Card tempCard = deck[deck.length -1];
            deck = tempDeck;
            return tempCard;
        }
        else{
            Card nullCard = new Card();
            return nullCard;
        }

    }
}
