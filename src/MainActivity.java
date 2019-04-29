package com.lab1.hothands;

import android.annotation.SuppressLint;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;
import java.util.concurrent.TimeUnit;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public ImageView player1Card1, player1Card2, player1Card3, player1Card4, player1Card5, txsPlayer1Card1, txsPlayer1Card2;
    public ImageView dealerCard1, dealerCard2, dealerCard3, dealerCard4, dealerCard5;
    public ImageView  txsPlayer2Card1,  txsPlayer2Card2,  txsPlayer3Card1,  txsPlayer3Card2;

    int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, crd1_cnt = 0, crd2_cnt = 0;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }
    /////////////////////////////
    //    Different Screens    //
    /////////////////////////////
    //Used as a way to display a coming soon message to the user for any feature that isn't complete
    public void comingSoon(View vw) {
        setContentView (R.layout.coming_soon);
    }
    //Home Screen: Just displays the Play button option to the user
    public void mainMenu(View vw) {
        setContentView (R.layout.activity_main);
    }
    //Displays the different game mode options to the user (features four game mode buttons and a back button)
    public void playButton(View vw) {
        setContentView (R.layout.game_mode);
    }
    //Displays options for the user to choose form for the Poker Game (Option1 New Game, Option2 Continue Game)
    public void pokerSetUp(View vw) { setContentView (R.layout.poker_game_setup); }
    // //Displays options for the user to choose form for the Texas Hold'em Game (Option1 New Game, Option2 Continue Game)
    public void holdemSetUp(View vw) { setContentView (R.layout.texas_holdem_setup);}
    @SuppressLint("SetTextI18n")

    //////////////////////////
    //    THE POKER GAME    //
    //////////////////////////
    public void pokerGame(View vw) {
        Dealer dealerBob = new Dealer(true, 3);
        setContentView (R.layout.poker_game);

        int total_chips = 0, plyr_1chips = 50000, plyr_2chips = 50000, plyr_3chips = 50000;
        String ttl_str, player1_str, player2_str, player3_str;
        ttl_str = Integer.toString (total_chips);
        player1_str = Integer.toString (plyr_1chips);
        player2_str = Integer.toString (plyr_2chips);
        player3_str = Integer.toString (plyr_3chips);

        TextView total_txt, plyr1_txt, plyr2_txt, plyr3_txt;
        total_txt = findViewById (R.id.pot_total);
        total_txt.setText ("$" + ttl_str);
        plyr1_txt = findViewById (R.id.player_1_chips);
        plyr1_txt.setText ("$" + player1_str);
        plyr2_txt = findViewById (R.id.player_2_chips);
        plyr2_txt.setText ("$" + player2_str);
        plyr3_txt = findViewById (R.id.player_3_chips);
        plyr3_txt.setText ("$" + player3_str);

        Card card1 = dealerBob.dealCard (), card2 = dealerBob.dealCard (), card3 = dealerBob.dealCard ();
        Card card4 = dealerBob.dealCard (), card5 = dealerBob.dealCard ();
        player1Card1 = findViewById (R.id.first_card);
        player1Card1.setImageResource (card1.getId ( ));
        player1Card2 = findViewById (R.id.second_card);
        player1Card2.setImageResource (card2.getId ( ));
        player1Card3 = findViewById (R.id.third_card);
        player1Card3.setImageResource (card3.getId ( ));
        player1Card4 = findViewById (R.id.fourth_card);
        player1Card4.setImageResource (card4.getId ( ));
        player1Card5 = findViewById (R.id.fifth_card);
        player1Card5.setImageResource (card5.getId ( ));
    }

    //////////////////////////////////
    //    THE TEXAS HOLD'EM GAME    //
    //////////////////////////////////
    public void texasHoldem(View vw) {
        setContentView (R.layout.texas_holdem);
        //Note: Most of these Parameters/Values are default for now, but will be dynamic in the future
        int total_chips = 0, numberOfPlayers = 3, betAmount = 0, smallBlind = 25, bigBlind = 50;
        ArrayList<Player> playersStillIn = new ArrayList<Player> ();
        Dealer dealerEmma = new Dealer (false, numberOfPlayers);

        //Control for all the text fields
        TextView holdem_pot_txt, holdem_plyr1_txt, holdem_plyr2_txt, holdem_plyr3_txt, raise;
        //Pot screen data
        holdem_pot_txt = findViewById (R.id.holdem_pot);
        holdem_pot_txt.setText ("$" + total_chips);
        //Player 1 screen data
        holdem_plyr1_txt = findViewById (R.id.holdem_player1_chips);
        holdem_plyr1_txt.setText ("$" + 50000);
        //Player 2 screen data
        holdem_plyr2_txt = findViewById (R.id.holdem_player2_chips);
        holdem_plyr2_txt.setText ("$" + 50000);
        //Player 3 screen data
        holdem_plyr3_txt = findViewById (R.id.holdem_plyr3_chips);
        holdem_plyr3_txt.setText ("$" + 50000);

        //Dealer Hand
        Card dlrCrd1, dlrCrd2, dlrCrd3, dlrCrd4, dlrCrd5;
        dealerCard1 = findViewById (R.id.dealer_1);
        dealerCard2 = findViewById (R.id.dealer_2);
        dealerCard3 = findViewById (R.id.dealer_3);
        dealerCard4 = findViewById (R.id.dealer_4);
        dealerCard5 = findViewById (R.id.dealer_5);

        Player player1 = new Player("Kizzle"), player2 = new Player(), player3 = new Player();
        //Deals out all player Cards one at a time
        player1.setCard (dealerEmma.dealCard ( ));
        txsPlayer1Card1 = findViewById (R.id.txsSecond_card);
        txsPlayer1Card1.setImageResource (player1.getCardId (0));

        player2.setCard (dealerEmma.dealCard ());
        txsPlayer2Card1 = findViewById (R.id.txs_ply2_crd1);
        txsPlayer2Card1.setImageResource (R.drawable.saints_back_black);

        player3.setCard (dealerEmma.dealCard ( ));
        txsPlayer3Card1 = findViewById (R.id.txs_ply3_crd1);
        txsPlayer3Card1.setImageResource (R.drawable.saints_back_black);

        player1.setCard (dealerEmma.dealCard ( ));
        txsPlayer1Card2 = findViewById (R.id.txsFirst_card);
        txsPlayer1Card2.setImageResource (player1.getCardId (1));
        playersStillIn.add (player1);

        player2.setCard (dealerEmma.dealCard ());
        txsPlayer2Card2 = findViewById (R.id.txs_ply2_crd2);
        txsPlayer2Card2.setImageResource (R.drawable.saints_back_black);
        playersStillIn.add (player2);

        player3.setCard (dealerEmma.dealCard ( ));
        txsPlayer3Card2 = findViewById (R.id.txs_ply3_crd2);
        txsPlayer3Card2.setImageResource (R.drawable.saints_back_black);
        playersStillIn.add (player3);

        boolean gameOver = (playersStillIn.size () == 1 || playersStillIn.get(0).getChips () > 0);
        int round = 1;
        while(!gameOver) {
            if (playersStillIn.get (0).getChips ( ) == 0)
                gameOver = true;
            else {
                //Checks which players have ran out of money and removes the ones who don't from PlayersStillIn Array
                for (int i = 1; i < playersStillIn.size ( ); i++) {
                    if (playersStillIn.get (i).getChips ( ) == 0) {
                        playersStillIn.remove (i);
                        playersStillIn.trimToSize ( );
                    }
                }
                gameOver = (playersStillIn.size ( ) == 1);
            }
        }
    }
}
