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

public class ScoreFragment extends Fragment {

    private TextView scoreText;
    private int scoreEarned;
    private int score;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_score, container, false);

        wireWidgets(rootView);
        return rootView;
    }

    private void winCalculation(boolean status){
        Intent lastIntent = getActivity().getIntent();

        scoreEarned = lastIntent.getIntExtra(GameFragment.POINTS, 0);
        score += scoreEarned;
        scoreText.setText(String.valueOf(score));
    }

    private void wireWidgets (View rootView) {
        scoreText = rootView.findViewById(R.id.game_fragment_textview);
    }
}
