package com.lab1.hothands;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView card1, card2, card3, card4, card5, txsCard1, txsCard2;
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }
    public void mainMenu(View vw) {
        setContentView (R.layout.activity_main);
    }

    public void playButton(View vw) {
        setContentView (R.layout.game_mode);
    }

    public void pokerGame(View vw) {

        setContentView (R.layout.pokergame);
        card1 = findViewById (R.id.first_card);
        card1.setImageResource(R.drawable.card9h);
        card2 = findViewById (R.id.second_card);
        card2.setImageResource(R.drawable.card10h);
        card3 = findViewById (R.id.third_card);
        card3.setImageResource(R.drawable.card11h);
        card4 = findViewById (R.id.fourth_card);
        card4.setImageResource(R.drawable.card12h);
        card5 = findViewById (R.id.fifth_card);
        card5.setImageResource(R.drawable.card13h);
    }

    int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0;
    public void flipCard1(View vw){

        if(c1 == 0) {
            card1.setImageResource (R.drawable.saints_back_black);
            c1++;
        }
        else if(c1 == 1){
            card1.setImageResource (R.drawable.card9h);
            c1--;
        }
    };
    public void flipCard2(View vw){
        if(c2 == 0) {
            card2.setImageResource (R.drawable.saints_back_black);
            c2++;
        }
        else if(c2 == 1){
            card2.setImageResource (R.drawable.card10h);
            c2--;
        }
    };
    public void flipCard3(View vw){
        if(c3 == 0) {
            card3.setImageResource (R.drawable.saints_back_black);
            c3++;
        }
        else if(c3 == 1){
            card3.setImageResource (R.drawable.card11h);
            c3--;
        }
    };
    public void flipCard4(View vw){
        if(c4 == 0) {
            card4.setImageResource (R.drawable.saints_back_black);
            c4++;
        }
        else if(c4 == 1){
            card4.setImageResource (R.drawable.card12h);
            c4--;
        }
    };
    public void flipCard5(View vw){
        if(c5 == 0) {
            card5.setImageResource (R.drawable.saints_back_black);
            c5++;
        }
        else if(c5 == 1){
            card5.setImageResource (R.drawable.card13h);
            c5--;
        }
    };

    public void comingSoon(View vw) {
        setContentView (R.layout.coming_soon);
    }

    public void texasHoldem(View vw) {
        setContentView (R.layout.texas_holdem);
        txsCard1 = findViewById (R.id.txsFirst_card);
        txsCard1.setImageResource(R.drawable.card10c);
        txsCard2 = findViewById (R.id.txsSecond_card);
        txsCard2.setImageResource (R.drawable.card11c);

    }
    int crd1_cnt = 0, crd2_cnt = 0;
    public void flip1(View v){
        if(crd1_cnt == 0) {
            txsCard1.setImageResource (R.drawable.saints_back_black);
            crd1_cnt++;
        }
        else if(crd1_cnt == 1){
            txsCard1.setImageResource (R.drawable.card10c);
            crd1_cnt--;
        }
    };
    public void flip2(View vw){

        if(crd2_cnt == 0) {
            txsCard2.setImageResource (R.drawable.saints_back_black);
            crd2_cnt++;
        }
        else if(crd2_cnt == 1){
            txsCard2.setImageResource (R.drawable.card11c);
            crd2_cnt--;
        }
    }
}

