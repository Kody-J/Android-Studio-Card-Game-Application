/*
The dealer has the most important role. The dealer handles all the cards,
tracks the rules, determines validity, and determines who wins
*/
package com.lab1.hothands;

public class Dealer {
    //Consists of a deck, card count, a name, an knowledge of the game rules, and player

    private Deck the_d;
    private int cardCount;
    private String name;
    private int handCount;
    private Card [] dealerHand = new Card[5];
    private boolean is_poker;
    private Player[] players;

    public Dealer(){
        the_d = new Deck();
        cardCount = the_d.getSize();
        name = " DEALER  ";
        handCount = 0;
    }

    public void deal_cards( Player _p, int num){
        if (!is_poker) {
            for (int i = 0; i < 2; i++) {
                Card temp = new Card ();
                temp = (Card) the_d.getDeck().lastElement();
                _p.setHand(temp);
            }
        }
        else {
            for (int i = 0; i < 5; i++) {
                Card temp = new Card();
                temp = (Card) the_d.getDeck().lastElement();
            }
        }
    }

    public void removeCard()
    {
        the_d.getDeck().removeElementAt(cardCount-1);
        cardCount -= 1;
    }

    public Card getCard(){
        Card temp = new Card();
        temp = (Card) the_d.getDeck().get (cardCount -1);
        cardCount -= 1;
        return temp;

    }

    //This is for Texas Holdem: Burns a card, then dealer takes three card to turn over for the players
    //TO DO: Print/ Display Card graphics
    public void flop()
    {
        removeCard();
        Card temp;
        for (int i = 0; i < 3; i++) {
            temp = getCard();
            dealerHand[i] = temp;
            cardCount-= 1;
            handCount += 1;
        }
    }
//This is for Texas Holdem: Burns a card, then dealer takes one card to turn over for players
    public void turn ()
    {
        removeCard();
        Card temp = new Card();
        temp = getCard ();
        dealerHand[3] = temp;
        handCount++;
        cardCount--;
    }
//This is for Texas Holdem: Burns a card, then dealer takes one card to turn over for players
    public void river()
    {
        removeCard();
        Card temp = getCard();
        dealerHand[4] = temp;
        handCount++;
        cardCount--;
    }

    public void setPlayers(Player [] p) {
        players = p;
    }

    public void print_hand()
    {
        for (int i = 0; i < handCount; i++) {
            dealerHand[i].print();
        }
    }
}
