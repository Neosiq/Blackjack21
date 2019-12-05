package com.example.blackjack21;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_start:
                    mTextMessage.setText(R.string.title_start);
                    return true;
                case R.id.navigation_game:
                    mTextMessage.setText(R.string.title_game);
                    Fragment fragment = null;
                    fragment = new GameFragment();
                    FragmentManager fm = getSupportFragmentManager();
                    if(fragment != null){
                        fm.beginTransaction().replace(R.id.container, fragment).commit();
                     }
                    return true;
                case R.id.navigation_scoreboard:
                    mTextMessage.setText(R.string.title_scoreboard);
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

//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        Fragment fragment = null;
//        fragment = new PythagoreanFragment();
//        if (id == R.id.nav_home) {
//
//        }
//
//
//        return true;
//
//
//    }

}

