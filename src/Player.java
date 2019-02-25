
package com.lab1.hothands;

import java.util.Scanner;

public class Player {

    private int count;
    private String name;
    private Card[] hand ;
    private int money;
    private boolean is_in, check, fold;

    public Player(){
        name = "NO NAME";
        hand = new Card [5];
        money = -1;
    }
    //This  is for texas holdem: Player receives two cards to start
    public Player(String _name, Card one, Card two){
        name = _name;
        hand[0] = one;
        hand[1] = two;
        count = 2;
    }
    // This is for 5 card poker: Player gets five cards to start
    public Player(String _name, Card one, Card two, Card three, Card four, Card five){
        name = _name;
        hand[0] = one;
        hand[1] = two;
        hand[2] = three;
        hand[3] = four;
        hand[4] = five;
        count = 5;
    };

    // returns the players cards
    public Card[] getHand(){return hand;}


    // Allows the player to see card
    //TO DO: Make it display as a card image on the screen
    public void peek_hand(){
        for(int i = 0 ; i < hand.length; i++)
        {
            hand[i].print();
            System.out.println();
        }
    }
    //Adds a card to the players hand
    public void setHand(Card c){hand[count++] = c;}
    //Returns payers name
    public String getName(){return name;}
    //Sets players name
    public void setName(){
        System.out.println("Please Enter Your Name");
        Scanner keyboard = new Scanner(System.in);
        name = keyboard.nextLine();
        while(name == " "){
            name = keyboard.nextLine();
        }
    }
    //Displays a single card
    //TO DO: implement in one function with printHand() also display a card image
    public void print(int i){hand[i].print();}

}
