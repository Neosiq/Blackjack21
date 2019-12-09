package com.example.blackjack21;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {

    private TextView dealer;
    private TextView player;
    private int dealerCards;
    private int playerCards;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        wireWidgets(rootView);
        gameStart();
        return rootView;
    }

    private void gameStart() {
        dealerCards = 0;
        playerCards = 0;


    }

    private void wireWidgets (View rootView) {
        dealer = rootView.findViewById(R.id.game_fragment_dealer_textview);
        player = rootView.findViewById(R.id.game_fragment_player_textview);
    }

    private boolean checkWin(int dealer, int player) {
        boolean status = false;
        if (player > 21 && dealer < 21){
            status = false;
        }
        else if (dealer > 21 && player < 21) {
            status = true;
        }
        else if (dealer == 21 && player != 21) {
            status = false;
        }
        else if (player == 21 && dealer != 21) {
            status = true;
        }
        else if (21 - player < 21 - dealer) {
            status = true;
        }
        else if (21 - player < 21 - dealer) {
            status = false;
        }
        return status;
    }



}
