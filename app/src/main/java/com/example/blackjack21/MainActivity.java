package com.example.blackjack21;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}

//Hello, and welcome to Blackjack, one player edition! The rules are simple.
//There are two players, one of which is the dealer AI. The other player is you! The goal
//is to win through getting a count as close as possible to 21, without going over 21.
//Suits don't affect the value of a card. Cards are worth the following: number cards
//have the same value as their numbers. Jacks are worth 11. Queens are worth 12.
//Kings are worth 13. Aces are worth either 1 or 11 by the player's choice. Each win
//amounts to one point. The exception is a natural blackjack, where your opening hand
//amounts to 21, and the dealer does not have a natural blackjack. In this case, you get
//double the amount of points. Finally, there is hitting and standing. You may choose to
//hit or stand so long as your cards add up to less than 21. When you hit, you draw a card.
//When you stand, you choose to hold your cards and reveal your cards, the dealer does the same.
//Think of standing like a duel button. At the end of the round, you may choose to either
//quit the app, or start another round. Good luck, have fun!