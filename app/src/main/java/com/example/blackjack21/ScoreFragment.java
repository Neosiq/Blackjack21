package com.example.blackjack21;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
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
    private TextView scoreText;
    private int scoreEarned;
    private int score;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_score, container, false);
        wireWidgets(rootView);
        winCalculation();
        return rootView;
    }

    private void winCalculation(){
        // score goes here
        if (getArguments() != null)
            scoreEarned = this.getArguments().getInt(POINTS);
            score += scoreEarned;
            scoreText.setText("Score: " + score);
    }

    private void wireWidgets (View rootView) {
        scoreText = rootView.findViewById(R.id.game_fragment_textview);
    }
}
