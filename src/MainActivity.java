package com.lab1.hothands;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }

    public void mainMenu(View vw) { setContentView (R.layout.activity_main);}

    public void playButton(View vw){
        setContentView (R.layout.game_mode);
    }

    public void pokerGame(View vw) { setContentView (R.layout.pokergame);}


}
