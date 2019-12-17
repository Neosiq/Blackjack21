package com.example.blackjack21;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.blackjack21.R;

import static com.example.blackjack21.GameFragment.GAMED;

public class ScoreFragment extends Fragment {

    private static final String POINTS = "points";
    private static final String POINTSSAVED = "pointssaved";
    private TextView scoreText;
    private int scoreEarned;
    private int score;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_score, container, false);
        wireWidgets(rootView);
        score = 0;
        winCalculation();
        return rootView;
    }

    private void winCalculation() {
        // score goes here
        SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        score = sharedPref.getInt(POINTS, 0);
        scoreEarned = sharedPref.getInt(POINTSSAVED, 0);
        score += scoreEarned;
        editor.putInt(POINTS, score);
        editor.commit();
        scoreText.setText("Score: " + score);
        sharedPref.edit().putInt(POINTSSAVED, 0).apply();
    }

    private void wireWidgets(View rootView) {
        scoreText = rootView.findViewById(R.id.game_fragment_textview);
    }
}
