package com.example.blackjack21;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {

    //instance variables: dealer & player textview
    private TextView dealer;
    private TextView player;
    //dealer's cards
    private ImageView dcard1;
    private ImageView dcard2;
    private ImageView dcard3;
    private ImageView dcard4;
    // player's cards
    private ImageView pcard1;
    private ImageView pcard2;
    private ImageView pcard3;
    private ImageView pcard4;
    // buttons: hit and stand
    private Button hit;
    private Button stand;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        wireWidgets(rootView);
        return rootView;
    }


    private void wireWidgets (View rootView) {
        dealer = rootView.findViewById(R.id.game_fragment_dealer_textview);
        player = rootView.findViewById(R.id.game_fragment_player_textview);
        dcard1 = rootView.findViewById(R.id.game_fragment_dealer_card1);
        dcard2 = rootView.findViewById(R.id.game_fragment_dealer_card2);
        dcard3 = rootView.findViewById(R.id.game_fragment_dealer_card3);
        dcard4 = rootView.findViewById(R.id.game_fragment_dealer_card4);
        pcard1 = rootView.findViewById(R.id.game_fragment_player_card1);
        pcard2 = rootView.findViewById(R.id.game_fragment_player_card2);
        pcard3 = rootView.findViewById(R.id.game_fragment_player_card3);
        pcard4 = rootView.findViewById(R.id.game_fragment_player_card4);
        hit = rootView.findViewById(R.id.game_fragment_hit);
        stand = rootView.findViewById(R.id.game_fragment_stand);
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
