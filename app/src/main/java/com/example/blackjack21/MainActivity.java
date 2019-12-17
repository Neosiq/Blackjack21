package com.example.blackjack21;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String POINTS = "points";
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_start:
                    Fragment fragment = null;
                    fragment = new StartFragment();
                    FragmentManager fm = getSupportFragmentManager();
                    if(fragment != null){
                        fm.beginTransaction().replace(R.id.container, fragment).commit();
                    }
                    return true;
                case R.id.navigation_game:
                    fragment = new GameFragment();
                    FragmentManager fmg = getSupportFragmentManager();
                    if(fragment != null){
                        Log.d("MainActivity", "onNavigationItemSelected: game");
                        fmg.beginTransaction().replace(R.id.container, fragment).commit();
                     }
                    return true;
                case R.id.navigation_scoreboard:
                    fragment = new ScoreFragment();
                    FragmentManager fms = getSupportFragmentManager();
                    if(fragment != null){
                        fms.beginTransaction().replace(R.id.container, fragment).commit();
                    }
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
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        sharedPref.edit().putInt(POINTS, 0).apply();

        Fragment fragment = null;
        fragment = new StartFragment();
        FragmentManager fm = getSupportFragmentManager();
        if(fragment != null){
            fm.beginTransaction().replace(R.id.container, fragment).commit();
        }
    }
}

