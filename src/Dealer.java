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
    //This is the begenning of the 5 card Poker logic: pretty simple implemintaion as such
    //1. Fiver cards are delt to each player
    //2. Betting round #1 =, begenning with the first active player to left of bing blind 
    //3. Draw (This where each player is given the opportunity to 'discard' any or all thier cards and recive new replacments
    //4. Betting round #2, begenning with the first active player
    //5. Showdown (a winner is determined if thier is more than one player in the pot)
     public void poker_first(Player p) {
        int[] index_to_remove = new int[-5];
        //create a text pop up window to display intermediate instructions to the screen
        //accept use input to identify card form user hand to discard and put them in index_to_remove
        for (int i = 0; i < 5; i++) {
            if (p.getHand ( ) == null || index_to_remove[i] < 0 || index_to_remove[i] >= p.getHand ( ).length) {
                // Create another array of size one less
                Card[] anotherArray = new Card[p.getHand ( ).length - 1];
                // Copy the elements except the index from original array to the other array
                for (int k = 0; k < p.getHand ( ).length; k++) {
                    // if the index is the removal element index
                    if (i == index_to_remove[i]) {
                        continue;
                    }

                    // if the index is not the removal element index
                    anotherArray[k++] = p.getHand ( )[i];
                }

            }
        }
    }

    public void take_bets() {
        for(int h = 0; h < players.length; h++)
            players[h].raise_check_fold_match ();

    }

    public void five_card_poker(){
        for (int j = 0; j < players.length; j++) {
            poker_first (players[j]);
        }
    }
}
}
