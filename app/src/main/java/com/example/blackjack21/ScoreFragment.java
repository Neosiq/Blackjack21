package com.example.blackjack21;

import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.blackjack21.R;

public class ScoreFragment extends Fragment {

    private TextView score;



    private void WireWidgets (View rootView) {


        score = rootView.findViewById(R.id.game_fragment_textview);

    }
}
