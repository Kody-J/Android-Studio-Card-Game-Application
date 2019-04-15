package com.lab1.hothands;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView player1card1, player1card2, player1card3, player1card4, player1card5;
    ImageView player1txsCard1, player1txsCard2, dlrCard1, dlrCard2, dlrCard3, dlrCard4, dlrCard5;
    int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, crd1_cnt = 0, crd2_cnt = 0;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    //Used as a way to display a coming soon message to the user for any feature that isn't complete
    public void comingSoon(View vw) {
        setContentView (R.layout.coming_soon);
    }

    //Home Screen: Just displays the Play button option to the user
    public void mainMenu(View vw) {
        setContentView (R.layout.activity_main);
    }
    //Displays the different game mode options to the user (features four game mode buttons and aback button)
    public void playButton(View vw) {
        setContentView (R.layout.game_mode);
    }
    public void pokerSetUp(View vw) { setContentView (R.layout.poker_game_setup); }
    // Logic for the 5 card poker Game and necessary functions
    @SuppressLint("SetTextI18n")
    public void pokerGame(View vw) {
        Dealer theD;
        String card;

        setContentView (R.layout.poker_game);

        int total_chips = 0, plyr_1chips = 50000, plyr_2chips = 50000, plyr_3chips = 50000;
        String ttl_str, plyr1_str, plyr2_str, plyr3_str;
        ttl_str = Integer.toString (total_chips);
        plyr1_str = Integer.toString (plyr_1chips);
        plyr2_str = Integer.toString (plyr_2chips);
        plyr3_str = Integer.toString (plyr_3chips);

        TextView total_txt, plyr1_txt, plyr2_txt, plyr3_txt;
        total_txt = findViewById (R.id.pot_total);
        total_txt.setText ("$"+ttl_str);
        plyr1_txt = findViewById (R.id.player_1_chips);
        plyr1_txt.setText ("$"+plyr1_str);
        plyr2_txt = findViewById (R.id.player_2_chips);
        plyr2_txt.setText ("$"+plyr2_str);
        plyr3_txt = findViewById (R.id.player_3_chips);
        plyr3_txt.setText ("$"+plyr3_str);

        ImageView player2card1, player2card2, player2card3 , player2card4, player2card5;
        player2card1 = findViewById (R.id.ply2crd1);
        player2card2 = findViewById (R.id.ply2crd2);
        player2card3 = findViewById (R.id.ply2crd3);
        player2card4 = findViewById (R.id.ply2crd4);
        player2card5 = findViewById (R.id.ply2crd5);

        ImageView player3card1, player3card2, player3card3, player3card4, player3card5;
        player3card1 = findViewById (R.id.ply3crd1);
        player3card2 = findViewById (R.id.ply3crd2);
        player3card3 = findViewById (R.id.ply3crd3);
        player3card4 = findViewById (R.id.ply3crd4);
        player3card5 = findViewById (R.id.ply3crd5);

        player1card1 = findViewById (R.id.first_card);
        player1card2 = findViewById (R.id.second_card);
        player1card3 = findViewById (R.id.third_card);
        player1card4 = findViewById (R.id.fourth_card);
        player1card5 = findViewById (R.id.fifth_card);

    }

    //Used to turn over the First card in the users hand for 5 card poker
    public void flipCard1(View vw) {
        if (c1 == 0) {
            player1card1.setImageResource (R.drawable.saints_back_black);
            c1++;
        } else if (c1 == 1) {
            player1card1.setImageResource (R.drawable.card9h);
            c1--;
        }
    }
    //Used to turn over the Second card in the users hand for 5 card poker
    public void flipCard2(View vw) {
        if (c2 == 0) {
            player1card2.setImageResource (R.drawable.saints_back_black);
            c2++;
        } else if (c2 == 1) {
            player1card2.setImageResource (R.drawable.card10h);
            c2--;
        }
    }
    //Used to turn over the Third card in the users hand for 5 card poker
    public void flipCard3(View vw) {
        if (c3 == 0) {
            player1card3.setImageResource (R.drawable.saints_back_black);
            c3++;
        } else if (c3 == 1) {
            player1card3.setImageResource (R.drawable.card11h);
            c3--;
        }
    }
    //Used to turn over the Fourth card in the users hand for 5 card poker
    public void flipCard4(View vw) {
        if (c4 == 0) {
            player1card4.setImageResource (R.drawable.saints_back_black);
            c4++;
        } else if (c4 == 1) {
            player1card4.setImageResource (R.drawable.card12h);
            c4--;
        }
    }

    //Used to turn over the Last card in the users hand for 5 card poker
    public void flipCard5(View vw) {
        if (c5 == 0) {
            player1card5.setImageResource (R.drawable.saints_back_black);
            c5++;
        } else if (c5 == 1) {
            player1card5.setImageResource (R.drawable.card13h);
            c5--;
        }
    }

    public void holdemSetUp(View vw) { setContentView (R.layout.texas_holdem_setup); }
    //Logic for the Texas Holdem game and necessary functions
    public void texasHoldem(View vw) {
        setContentView (R.layout.texas_holdem);

        int total_chips = 0, plyr_1chips = 50000, plyr_2chips = 50000, plyr_3chips = 50000;

        TextView holdem_pot_txt, holdem_plyr1_txt, holdem_plyr2_txt, holdem_plyr3_txt;
        holdem_pot_txt = findViewById (R.id.holdem_pot);
        holdem_pot_txt.setText ("$"+total_chips);
        holdem_plyr1_txt = findViewById (R.id.holdem_player1_chips);
        holdem_plyr1_txt.setText ("$"+plyr_1chips);
        holdem_plyr2_txt = findViewById (R.id.holdem_player2_chips);
        holdem_plyr2_txt.setText ("$"+plyr_2chips);
        holdem_plyr3_txt = findViewById (R.id.holdem_plyr3_chips);
        holdem_plyr3_txt.setText ("$"+plyr_3chips);


        //User Hand
        player1txsCard1 = findViewById (R.id.txsFirst_card);
        player1txsCard1.setImageResource (R.drawable.blackspace);
        player1txsCard2 = findViewById (R.id.txsSecond_card);
        player1txsCard2.setImageResource (R.drawable.blackspace);
        //Dealer Hand
        dlrCard1 = findViewById (R.id.dealer_1);
        dlrCard1.setImageResource (R.drawable.saints_back_black);
        dlrCard2 = findViewById (R.id.dealer_2);
        dlrCard2.setImageResource (R.drawable.saints_back_black);
        dlrCard3 = findViewById (R.id.dealer_3);
        dlrCard3.setImageResource (R.drawable.saints_back_black);
        dlrCard4 = findViewById (R.id.dealer_4);
        dlrCard4.setImageResource (R.drawable.blackspace);
        dlrCard5 = findViewById (R.id.dealer_5);
        dlrCard5.setImageResource (R.drawable.blackspace);

    }
    //Used to flip over the First card in the users hand in Texas Holdem
    public void flip1(View v) {
        if (crd1_cnt == 0) {
            player1txsCard1.setImageResource (R.drawable.saints_back_black);
            crd1_cnt++;
        } else if (crd1_cnt == 1) {
            player1txsCard1.setImageResource (R.drawable.card10c);
            crd1_cnt--;
        }
    }

    //Used to flip over the Second card in the users hand in Texas Holdem
    public void flip2(View vw) {
        //View temp = vw;
        if (crd2_cnt == 0) {
            player1txsCard2.setImageResource (R.drawable.saints_back_black);
            crd2_cnt++;
        } else if (crd2_cnt == 1) {
            player1txsCard2.setImageResource (R.drawable.card11c);
            crd2_cnt--;
        }
    }
}
