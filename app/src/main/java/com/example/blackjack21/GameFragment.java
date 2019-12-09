package com.example.blackjack21;

import android.content.Intent;
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
        gameStart();
        return rootView;
    }

    private void gameStart() {
        int dealer1 = (int) (Math.random()*13 + 1);
        int dealer2 = (int) (Math.random()*13 + 1);
        int player1 = (int) (Math.random()*13 + 1);
        int player2 = (int) (Math.random()*13 + 1);
        setCard(pcard1, player1);
        setCard(pcard2, player2);

    }

    private void hit() {

    }
    private void stand() {

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

    private int checkWin(int dealer, int player) {
        int status = false;
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

        Intent targetIntent =
                new Intent (GameFragment.this, ScoreFragment.class);
        targetIntent.putExtra(POINTS, status);
        startActivity(targetIntent);
        return status;
    }

    private void setCard(ImageView card, int value) {
        if (value == 1)
        card.setImageResource(R.drawable.spadeace);
        if (value == 2)
            card.setImageResource(R.drawable.spade2);
        if (value == 3)
            card.setImageResource(R.drawable.spade3);
        if (value == 4)
            card.setImageResource(R.drawable.spade4);
        if (value == 5)
            card.setImageResource(R.drawable.spade5);
        if (value == 6)
            card.setImageResource(R.drawable.spade6);
        if (value == 7)
            card.setImageResource(R.drawable.spade7);
        if (value == 8)
            card.setImageResource(R.drawable.spade8);
        if (value == 9)
            card.setImageResource(R.drawable.spade9);
        if (value == 10)
            card.setImageResource(R.drawable.spade10);
        if (value == 11)
            card.setImageResource(R.drawable.spadejack);
        if (value == 12)
            card.setImageResource(R.drawable.spadequeen);
        if (value == 13)
            card.setImageResource(R.drawable.spadeking);
    }


}
