package com.lab1.hothands;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {
    public ImageView player1Card1, player1Card2, player1Card3, player1Card4, player1Card5, txsPlayer1Card1, txsPlayer1Card2;
    public ImageView player2Card1, player2Card2, player2Card3, player2Card4, player2Card5;
    public ImageView player3Card1, player3Card2, player3Card3, player3Card4, player3Card5;
    public ImageView dealerCard1, dealerCard2, dealerCard3, dealerCard4, dealerCard5;
    public ImageView txsPlayer2Card1, txsPlayer2Card2, txsPlayer3Card1, txsPlayer3Card2;
    public Player txsplayer1, player2, player3, pokerplayer1;
    public TextView holdem_pot_txt, holdem_plyr1_txt, holdem_plyr2_txt, holdem_plyr3_txt, txsBet, pokerBet;

    public int txsPotTtl, pokerPotTtl, numberOfPlayers = 3, betAmount, sideBet1, sideBet2, gamePhase;
    public Dealer dealerEmma, dealerBob;
    boolean txsAllIn, pokerAllIn, check;
    public TextView total_txt, plyr1_txt, plyr2_txt, plyr3_txt;

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
    public void pokerSetUp(View vw) {
        setContentView (R.layout.poker_game_setup);
    }

    // //Displays options for the user to choose form for the Texas Hold'em Game (Option1 New Game, Option2 Continue Game)
    public void holdemSetUp(View vw) {
        setContentView (R.layout.texas_holdem_setup);
    }

    @SuppressLint("SetTextI18n")

    //////////////////////////
    //    THE POKER GAME    //
    //////////////////////////
    public void pokerGameStart(View vw) {

        setContentView (R.layout.poker_game);
        dealerBob = new Dealer (true, 3);
        pokerplayer1 = new Player ("Kizzle");
        player2 = new Player ( );
        player3 = new Player ( );
        pokerplayer1.stillIn = true;
        player2.stillIn = true;
        player3.stillIn = true;
        betAmount = 0;
        pokerAllIn = false;
        pokerPotTtl = 0;
        check = false;

        total_txt = findViewById (R.id.pot_total);
        total_txt.setText ("$" + pokerPotTtl);
        plyr1_txt = findViewById (R.id.player_1_chips);
        plyr1_txt.setText ("$" + pokerplayer1.getChips ( ));
        plyr2_txt = findViewById (R.id.player_2_chips);
        plyr2_txt.setText ("$" + player2.getChips ( ));
        plyr3_txt = findViewById (R.id.player_3_chips);
        plyr3_txt.setText ("$" + player3.getChips ( ));

        for (int i = 0; i < 5; i++) {
            pokerplayer1.setCard (dealerBob.dealCard ( ));
            player2.setCard (dealerBob.dealCard ( ));
            player3.setCard (dealerBob.dealCard ( ));
        }

        player1Card1 = findViewById (R.id.first_card);
        player1Card1.setImageResource (pokerplayer1.getCardId (0));
        player1Card2 = findViewById (R.id.second_card);
        player1Card2.setImageResource (pokerplayer1.getCardId (1));
        player1Card3 = findViewById (R.id.third_card);
        player1Card3.setImageResource (pokerplayer1.getCardId (2));
        player1Card4 = findViewById (R.id.fourth_card);
        player1Card4.setImageResource (pokerplayer1.getCardId (3));
        player1Card5 = findViewById (R.id.fifth_card);
        player1Card5.setImageResource (pokerplayer1.getCardId (4));
    }
    public void poker25(View vw) {
        if (pokerplayer1.getChips ( ) >= 25) {
            betAmount += 25;
            pokerplayer1.reduce (25);
            pokerBet = findViewById (R.id.betDisplay);
            pokerBet.setText ("+ $" + betAmount);
            plyr1_txt = findViewById (R.id.player_1_chips);
            plyr1_txt.setText ("$" + pokerplayer1.getChips ( ));
        }
    }
    public void poker100(View vw) {
        if (pokerplayer1.getChips ( ) >= 100) {
            betAmount += 100;
            pokerplayer1.reduce (100);
            pokerBet = findViewById (R.id.betDisplay);
            pokerBet.setText ("+ $" + betAmount);
            plyr1_txt = findViewById (R.id.player_1_chips);
            plyr1_txt.setText ("$" + pokerplayer1.getChips ( ));
        }
    }

    public void poker1000(View vw) {
        if (pokerplayer1.getChips ( ) >= 1000) {
            betAmount += 1000;
            pokerplayer1.reduce (1000);
            pokerBet = findViewById (R.id.betDisplay);
            pokerBet.setText ("+ $" + betAmount);
            plyr1_txt = findViewById (R.id.player_1_chips);
            plyr1_txt.setText ("$" + pokerplayer1.getChips ( ));
        }
    }

    public void pokerAllIn(View vw) {
        if (pokerplayer1.getChips ( ) > 0) {
            betAmount += pokerplayer1.getChips ( );
            pokerplayer1.reduce (pokerplayer1.getChips ( ));
            pokerBet = findViewById (R.id.betDisplay);
            pokerBet.setText ("+ $" + betAmount);
            plyr1_txt = findViewById (R.id.player_1_chips);
            plyr1_txt.setText ("$" + pokerplayer1.getChips ( ));
            pokerAllIn = true;
        }
    }

    public void pokerCheck (View vw){
        pokerplayer1.check = true;
        this.pokerPlaceBet (vw);
    }

    public void pokerFold(View vw) {

        pokerplayer1.fold = true;
        if (player2.stillIn) {
            if (player2.getChips ( ) < 1000) {
                sideBet1 = player2.getChips ( );
                player2.reduce (sideBet1);
                pokerPotTtl += sideBet1;
            } else {
                player2.reduce (1000);
                pokerPotTtl += 1000;
            }
            total_txt = findViewById (R.id.pot_total);
            total_txt.setText ("$" + pokerPotTtl);

            plyr2_txt = findViewById (R.id.player_2_chips);
            plyr2_txt.setText ("$" + player2.getChips ( ));
        }
        if (player3.stillIn) {
            if (player3.getChips ( ) < 1000) {
                sideBet2 = player3.getChips ( );
                player3.reduce (sideBet2);
                pokerPotTtl += sideBet2;
            } else {
                player3.reduce (1000);
                pokerPotTtl += 1000;
            }
            total_txt = findViewById (R.id.pot_total);
            total_txt.setText ("$" + pokerPotTtl);

            plyr3_txt = findViewById (R.id.player_3_chips);
            plyr3_txt.setText ("$" + player3.getChips ( ));
        }
        pokerplayer1.stillIn = false;
        this.pokerPlaceBet (vw);

    }

    public void pokerPlaceBet(View vw) {
        if (betAmount > 0 || pokerAllIn || pokerplayer1.check == true || pokerplayer1.fold == true) {
            pokerPotTtl += betAmount;
            total_txt = findViewById (R.id.pot_total);
            total_txt.setText ("$" + pokerPotTtl);
            pokerBet = findViewById (R.id.betDisplay);
            pokerBet.setText (" ");
            if (player2.stillIn) {
                if (player2.getChips ( ) < betAmount) {
                    sideBet1 = player2.getChips ( );
                    player2.reduce (sideBet1);
                    pokerPotTtl += sideBet1;
                } else {
                    player2.reduce (betAmount);
                    pokerPotTtl += betAmount;
                }
                total_txt = findViewById (R.id.pot_total);
                total_txt.setText ("$" + pokerPotTtl);

                plyr2_txt = findViewById (R.id.player_2_chips);
                plyr2_txt.setText ("$" + player2.getChips ( ));
            }
            if (player3.stillIn) {
                if (player3.getChips ( ) < betAmount) {
                    sideBet2 = player3.getChips ( );
                    player3.reduce (sideBet2);
                    pokerPotTtl += sideBet2;
                } else {
                    player3.reduce (betAmount);
                    pokerPotTtl += betAmount;
                }
                total_txt = findViewById (R.id.pot_total);
                total_txt.setText ("$" + pokerPotTtl);

                plyr3_txt = findViewById (R.id.player_3_chips);
                plyr3_txt.setText ("$" + player3.getChips ( ));
            }
            betAmount = 0;

            if(pokerplayer1.fold == true)
               pokerplayer1.fold = false;
            else
                dealerBob.setPlayerScore (pokerplayer1);

            dealerBob.setPlayerScore (player2);
            dealerBob.setPlayerScore (player3);
            dealerBob.setStatus (pokerplayer1, player2, player3);

            player2Card1 = findViewById (R.id.ply2crd1);
            player2Card1.setImageResource (player2.getCardId (0));
            player2Card2 = findViewById (R.id.ply2crd2);
            player2Card2.setImageResource (player2.getCardId (1));
            player2Card3 = findViewById (R.id.ply2crd3);
            player2Card3.setImageResource (player2.getCardId (2));
            player2Card4 = findViewById (R.id.ply2crd4);
            player2Card4.setImageResource (player2.getCardId (3));
            player2Card5 = findViewById (R.id.ply2crd5);
            player2Card5.setImageResource (player2.getCardId (4));

            player3Card1 = findViewById (R.id.ply3crd1);
            player3Card1.setImageResource (player3.getCardId (0));
            player3Card2 = findViewById (R.id.ply3crd2);
            player3Card2.setImageResource (player3.getCardId (1));
            player3Card3 = findViewById (R.id.ply3crd3);
            player3Card3.setImageResource (player3.getCardId (2));
            player3Card4 = findViewById (R.id.ply3crd4);
            player3Card4.setImageResource (player3.getCardId (3));
            player3Card5 = findViewById (R.id.ply3crd5);
            player3Card5.setImageResource (player3.getCardId (4));

            plyr1_txt = findViewById (R.id.player_1_chips);
            plyr1_txt.setText (" " + pokerplayer1.getStatus ( ));

            plyr2_txt = findViewById (R.id.player_2_chips);
            plyr2_txt.setText (" " + player2.getStatus ( ));

            plyr3_txt = findViewById (R.id.player_3_chips);
            plyr3_txt.setText (" " + player3.getStatus ( ));

            if (player2.getChips ( ) < 1) {
                player2.stillIn = false;
                numberOfPlayers -= 1;
            }
            if (player3.getChips ( ) < 1) {
                player3.stillIn = false;
                numberOfPlayers -= 1;
            }
            new CountDownTimer (15000, 1000) {
                public void onTick(long millisUntilFinished) {
                }
                public void onFinish() {
                    dealerBob = new Dealer (true, numberOfPlayers);
                    if (pokerplayer1.getStatus ( ) == "Winner!") {
                        pokerplayer1.increase (pokerPotTtl);
                        pokerPotTtl = 0;
                    } else if (player2.getStatus ( ) == "Winner!") {
                        player2.increase (pokerPotTtl);
                        pokerPotTtl = 0;
                    } else {
                        player3.increase (pokerPotTtl);
                        pokerPotTtl = 0;
                    }

                    pokerplayer1.newRound ( );
                    for (int i = 0; i < 5; i++) {
                        pokerplayer1.setCard (dealerBob.dealCard ( ));
                    }
                    player1Card1 = findViewById (R.id.first_card);
                    player1Card1.setImageResource (pokerplayer1.getCardId (0));
                    player1Card2 = findViewById (R.id.second_card);
                    player1Card2.setImageResource (pokerplayer1.getCardId (1));
                    player1Card3 = findViewById (R.id.third_card);
                    player1Card3.setImageResource (pokerplayer1.getCardId (2));
                    player1Card4 = findViewById (R.id.fourth_card);
                    player1Card4.setImageResource (pokerplayer1.getCardId (3));
                    player1Card5 = findViewById (R.id.fifth_card);
                    player1Card5.setImageResource (pokerplayer1.getCardId (4));

                    if (player2.stillIn == true) {
                        player2.newRound ( );
                        player2Card1 = findViewById (R.id.ply2crd1);
                        player2Card1.setImageResource (R.drawable.saints_back_black);
                        player2Card2 = findViewById (R.id.ply2crd2);
                        player2Card2.setImageResource (R.drawable.saints_back_black);
                        player2Card3 = findViewById (R.id.ply2crd3);
                        player2Card3.setImageResource (R.drawable.saints_back_black);
                        player2Card4 = findViewById (R.id.ply2crd4);
                        player2Card4.setImageResource (R.drawable.saints_back_black);
                        player2Card5 = findViewById (R.id.ply2crd5);
                        player2Card5.setImageResource (R.drawable.saints_back_black);
                        for (int i = 0; i < 5; i++) {
                            player2.setCard (dealerBob.dealCard ( ));
                        }
                    }
                    if (player3.stillIn == true) {
                        player3.newRound ( );
                        player3Card1 = findViewById (R.id.ply3crd1);
                        player3Card1.setImageResource (R.drawable.saints_back_black);
                        player3Card2 = findViewById (R.id.ply3crd2);
                        player3Card2.setImageResource (R.drawable.saints_back_black);
                        player3Card3 = findViewById (R.id.ply3crd3);
                        player3Card3.setImageResource (R.drawable.saints_back_black);
                        player3Card4 = findViewById (R.id.ply3crd4);
                        player3Card4.setImageResource (R.drawable.saints_back_black);
                        player3Card5 = findViewById (R.id.ply3crd5);
                        player3Card5.setImageResource (R.drawable.saints_back_black);
                        for (int i = 0; i < 5; i++) {
                            player3.setCard (dealerBob.dealCard ( ));
                        }
                    }

                    plyr1_txt = findViewById (R.id.player_1_chips);
                    plyr1_txt.setText ("$" + pokerplayer1.getChips ( ));

                    plyr2_txt = findViewById (R.id.player_2_chips);
                    plyr2_txt.setText ("$" + player2.getChips ( ));

                    plyr3_txt = findViewById (R.id.player_3_chips);
                    plyr3_txt.setText ("$" + player3.getChips ( ));
                }

            }.start ( );
        }
    }

    //////////////////////////////////
    //    THE TEXAS HOLD'EM GAME    //
    //////////////////////////////////
    public void texasHoldemStart(View vw) {
        setContentView (R.layout.texas_holdem);
        gamePhase = 0;
        sideBet1 = 0;
        sideBet2 = 0;
        txsAllIn = false;
        dealerEmma = new Dealer (false, numberOfPlayers);
        txsPotTtl = 0;
        txsplayer1 = new Player ("Kizzle");
        player2 = new Player ( );
        player3 = new Player ( );
        txsplayer1.stillIn = true;
        player2.stillIn = true;
        player3.stillIn = true;
        betAmount = 0;
        //Pot screen data
        holdem_pot_txt = findViewById (R.id.holdem_pot);
        holdem_pot_txt.setText ("$" + txsPotTtl);
        //Player 1 screen data
        holdem_plyr1_txt = findViewById (R.id.holdem_player1_chips);
        holdem_plyr1_txt.setText ("$" + txsplayer1.getChips ( ));
        //Player 2 screen data
        holdem_plyr2_txt = findViewById (R.id.holdem_player2_chips);
        holdem_plyr2_txt.setText ("$" + player2.getChips ( ));
        //Player 3 screen data
        holdem_plyr3_txt = findViewById (R.id.holdem_player3_chips);
        holdem_plyr3_txt.setText ("$" + player3.getChips ( ));


        //Deals out all player Cards one at a time
        txsplayer1.setCard (dealerEmma.dealCard ( ));
        txsPlayer1Card1 = findViewById (R.id.txsSecond_card);
        txsPlayer1Card1.setImageResource (txsplayer1.getCardId (0));
        player2.setCard (dealerEmma.dealCard ( ));
        txsPlayer2Card1 = findViewById (R.id.txs_ply2_crd1);
        txsPlayer2Card1.setImageResource (R.drawable.saints_back_black);
        player3.setCard (dealerEmma.dealCard ( ));
        txsPlayer3Card1 = findViewById (R.id.txs_ply3_crd1);
        txsPlayer3Card1.setImageResource (R.drawable.saints_back_black);
        txsplayer1.setCard (dealerEmma.dealCard ( ));
        txsPlayer1Card2 = findViewById (R.id.txsFirst_card);
        txsPlayer1Card2.setImageResource (txsplayer1.getCardId (1));
        player2.setCard (dealerEmma.dealCard ( ));
        txsPlayer2Card2 = findViewById (R.id.txs_ply2_crd2);
        txsPlayer2Card2.setImageResource (R.drawable.saints_back_black);
        player3.setCard (dealerEmma.dealCard ( ));
        txsPlayer3Card2 = findViewById (R.id.txs_ply3_crd2);
        txsPlayer3Card2.setImageResource (R.drawable.saints_back_black);


    }

    public void texasHoldem25(View vw) {
        if (txsplayer1.getChips ( ) >= 25) {
            betAmount += 25;
            txsplayer1.reduce (25);
            txsBet = findViewById (R.id.txsRedBet);
            txsBet.setText ("- $" + betAmount);
            holdem_plyr1_txt = findViewById (R.id.holdem_player1_chips);
            holdem_plyr1_txt.setText ("$" + txsplayer1.getChips ( ));
        }
    }

    public void texasHoldem100(View vw) {
        if (txsplayer1.getChips ( ) >= 100) {
            betAmount += 100;
            txsplayer1.reduce (100);
            txsBet = findViewById (R.id.txsRedBet);
            txsBet.setText ("- $" + betAmount);
            holdem_plyr1_txt = findViewById (R.id.holdem_player1_chips);
            holdem_plyr1_txt.setText ("$" + txsplayer1.getChips ( ));
        }
    }

    public void texasHoldem1000(View vw) {
        if (txsplayer1.getChips ( ) >= 1000) {
            betAmount = betAmount + 1000;
            txsplayer1.reduce (1000);
            txsBet = findViewById (R.id.txsRedBet);
            txsBet.setText ("- $" + betAmount);
            holdem_plyr1_txt = findViewById (R.id.holdem_player1_chips);
            holdem_plyr1_txt.setText ("$" + txsplayer1.getChips ( ));
        }
    }

    public void texasCancelBet(View vw) {
        if (betAmount > 0) {
            txsplayer1.increase (betAmount);
            holdem_plyr1_txt = findViewById (R.id.holdem_player1_chips);
            holdem_plyr1_txt.setText ("$" + txsplayer1.getChips ( ));
            txsBet = findViewById (R.id.txsRedBet);
            txsBet.setText (" ");
            betAmount = 0;
        }
    }
    public void texasAllIn(View vw) {
        if (txsplayer1.getChips ( ) > 0) {
            betAmount += txsplayer1.getChips ( );
            txsplayer1.reduce (txsplayer1.getChips ( ));
            txsBet = findViewById (R.id.txsRedBet);
            txsBet.setText ("- $" + betAmount);
            holdem_plyr1_txt = findViewById (R.id.holdem_player1_chips);
            holdem_plyr1_txt.setText ("$" + txsplayer1.getChips ( ));
            txsAllIn = true;
        }
    }

    public void texasCheck (View vw){
        txsplayer1.check = true;
        this.texasPlaceBet (vw);
    }

    public void texasFold (View vw){
        txsplayer1.fold = true;
        if (player2.stillIn) {
            if (player2.getChips ( ) < 1000) {
                sideBet1 = player2.getChips ( );
                player2.reduce (sideBet1);
                txsPotTtl += sideBet1;
            } else {
                player2.reduce (1000);
                txsPotTtl += 1000;
            }
            holdem_pot_txt = findViewById (R.id.holdem_pot);
            holdem_pot_txt.setText ("$" + txsPotTtl);

            holdem_plyr2_txt = findViewById (R.id.holdem_player2_chips);
            holdem_plyr2_txt.setText ("$" + player2.getChips ( ));
        }
        if (player3.stillIn) {
            if (player3.getChips ( ) < 1000) {
                sideBet2 = player3.getChips ( );
                player3.reduce (sideBet2);
                txsPotTtl += sideBet2;
            } else {
                player3.reduce (1000);
                txsPotTtl += 1000;
            }
            total_txt = findViewById (R.id.pot_total);
            total_txt.setText ("$" + pokerPotTtl);

            holdem_plyr3_txt = findViewById (R.id.holdem_player3_chips);
            holdem_plyr3_txt.setText ("$" + player3.getChips ( ));
        }
    }


    public void texasPlaceBet(View vw) {
        if (betAmount > 0 || txsAllIn || txsplayer1.check == true) {
            txsPotTtl += betAmount;
            holdem_pot_txt = findViewById (R.id.holdem_pot);
            holdem_pot_txt.setText ("$" + txsPotTtl);
            txsBet = findViewById (R.id.txsRedBet);
            txsBet.setText (" ");

            if (player2.stillIn) {
                if (player2.getChips ( ) < betAmount) {
                    sideBet1 = player2.getChips ( );
                    player2.reduce (sideBet1);
                    txsPotTtl += sideBet1;
                } else {
                    player2.reduce (betAmount);
                    txsPotTtl += betAmount;
                }
                holdem_pot_txt = findViewById (R.id.holdem_pot);
                holdem_pot_txt.setText ("$" + txsPotTtl);
                holdem_plyr2_txt = findViewById (R.id.holdem_player2_chips);
                holdem_plyr2_txt.setText ("$" + player2.getChips ( ));
            }
            if (player3.stillIn) {
                if (player3.getChips ( ) < betAmount) {
                    sideBet2 = player3.getChips ( );
                    player3.reduce (sideBet2);
                    txsPotTtl += sideBet2;
                } else {
                    player3.reduce (betAmount);
                    txsPotTtl += betAmount;
                }
                holdem_pot_txt = findViewById (R.id.holdem_pot);
                holdem_pot_txt.setText ("$" + txsPotTtl);
                holdem_plyr3_txt = findViewById (R.id.holdem_player3_chips);
                holdem_plyr3_txt.setText ("$" + player3.getChips ( ));
            }
            betAmount = 0;
            gamePhase += 1;
        }
        if (gamePhase == 1) {
            dealerEmma.flop ( );
            //Dealer Hand
            dealerCard1 = findViewById (R.id.dealer_1);
            dealerCard1.setImageResource (dealerEmma.getCard (0));
            dealerCard2 = findViewById (R.id.dealer_2);
            dealerCard2.setImageResource (dealerEmma.getCard (1));
            dealerCard3 = findViewById (R.id.dealer_3);
            dealerCard3.setImageResource (dealerEmma.getCard (2));
        } else if (gamePhase == 2) {
            dealerEmma.turn ( );
            dealerCard4 = findViewById (R.id.dealer_4);
            dealerCard4.setImageResource (dealerEmma.getCard (3));
        } else if (gamePhase == 3) {
            dealerEmma.river ( );
            dealerCard5 = findViewById (R.id.dealer_5);
            dealerCard5.setImageResource (dealerEmma.getCard (4));
        } else {
            dealerEmma.setPlayerScore (txsplayer1);
            dealerEmma.setPlayerScore (player2);
            dealerEmma.setPlayerScore (player3);
            dealerEmma.setStatus (txsplayer1, player2, player3);

            txsPlayer2Card1 = findViewById (R.id.txs_ply2_crd1);
            txsPlayer2Card1.setImageResource (player2.getCardId (0));
            txsPlayer3Card1 = findViewById (R.id.txs_ply3_crd1);
            txsPlayer3Card1.setImageResource (player3.getCardId (0));
            txsPlayer2Card2 = findViewById (R.id.txs_ply2_crd2);
            txsPlayer2Card2.setImageResource (player2.getCardId (1));
            txsPlayer3Card2 = findViewById (R.id.txs_ply3_crd2);
            txsPlayer3Card2.setImageResource (player3.getCardId (1));

            holdem_plyr1_txt = findViewById (R.id.holdem_player1_chips);
            holdem_plyr1_txt.setText (" " + txsplayer1.getStatus ( ));

            holdem_plyr3_txt = findViewById (R.id.holdem_player3_chips);
            holdem_plyr3_txt.setText (player3.getStatus ( ));

            holdem_plyr2_txt = findViewById (R.id.holdem_player2_chips);
            holdem_plyr2_txt.setText (player2.getStatus ( ));
            gamePhase = 0;

            if (player2.getChips ( ) < 1) {
                player2.stillIn = false;
                numberOfPlayers -= 1;
            }
            if (player3.getChips ( ) < 1) {
                player3.stillIn = false;
                numberOfPlayers -= 1;
            }

            new CountDownTimer (15000, 1000) {
                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    dealerEmma = new Dealer (false, numberOfPlayers);
                    if (txsplayer1.getStatus ( ) == "Winner!") {
                        txsplayer1.increase (txsPotTtl);
                        txsPotTtl = 0;
                    } else if (player2.getStatus ( ) == "Winner!") {
                        player2.increase (txsPotTtl);
                        txsPotTtl = 0;
                    } else {
                        player3.increase (txsPotTtl);
                        txsPotTtl = 0;
                    }
                    txsplayer1.newRound ( );
                    for (int i = 0; i < 2; i++) {
                        txsplayer1.setCard (dealerEmma.dealCard ( ));
                    }
                    txsPlayer1Card1 = findViewById (R.id.txsFirst_card);
                    txsPlayer1Card1.setImageResource (txsplayer1.getCardId (0));
                    txsPlayer1Card2 = findViewById (R.id.txsSecond_card);
                    txsPlayer1Card2.setImageResource (txsplayer1.getCardId (1));

                    if (player2.stillIn == true) {
                        player2.newRound ( );
                        player2Card1 = findViewById (R.id.txs_ply2_crd1);
                        player2Card1.setImageResource (R.drawable.saints_back_black);
                        player2Card2 = findViewById (R.id.txs_ply2_crd2);
                        player2Card2.setImageResource (R.drawable.saints_back_black);
                        for (int i = 0; i < 2; i++) {
                            player2.setCard (dealerEmma.dealCard ( ));
                        }
                    }
                    if (player3.stillIn == true) {
                        player3.newRound ( );
                        player3Card1 = findViewById (R.id.txs_ply3_crd1);
                        player3Card1.setImageResource (R.drawable.saints_back_black);
                        player3Card2 = findViewById (R.id.txs_ply3_crd2);
                        player3Card2.setImageResource (R.drawable.saints_back_black);
                        for (int i = 0; i < 2; i++) {
                            player3.setCard (dealerEmma.dealCard ( ));
                        }
                    }

                    dealerCard1 = findViewById (R.id.dealer_1);
                    dealerCard1.setImageResource (R.drawable.blackspace);
                    dealerCard2 = findViewById (R.id.dealer_2);
                    dealerCard2.setImageResource (R.drawable.blackspace);
                    dealerCard3 = findViewById (R.id.dealer_3);
                    dealerCard3.setImageResource (R.drawable.blackspace);
                    dealerCard4 = findViewById (R.id.dealer_4);
                    dealerCard4.setImageResource (R.drawable.blackspace);
                    dealerCard5 = findViewById (R.id.dealer_5);
                    dealerCard5.setImageResource (R.drawable.blackspace);

                    holdem_pot_txt = findViewById (R.id.holdem_pot);
                    holdem_pot_txt.setText ("$" + txsPotTtl);

                    holdem_plyr1_txt = findViewById (R.id.holdem_player1_chips);
                    holdem_plyr1_txt.setText ("$" + txsplayer1.getChips ( ));

                    holdem_plyr3_txt = findViewById (R.id.holdem_player3_chips);
                    holdem_plyr3_txt.setText ("$" + player3.getChips ( ));

                    holdem_plyr2_txt = findViewById (R.id.holdem_player2_chips);
                    holdem_plyr2_txt.setText ("$" + player2.getChips ( ));
                }

            }.start ( );
        }
    }
}