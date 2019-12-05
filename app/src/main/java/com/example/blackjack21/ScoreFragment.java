package com.example.blackjack21;

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

    private TextView score;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_score, container, false);

        wireWidgets(rootView);
        return rootView;
    }

    private void wireWidgets (View rootView) {
        score = rootView.findViewById(R.id.game_fragment_textview);
    }
}
