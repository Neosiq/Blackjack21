package com.example.blackjack21;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.widget.Toast.LENGTH_SHORT;

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

    private int playerSum;
    private int dealerSum;
    private int hitTime;
    public static final String POINTS = "points";
    public static final int BACK = 14;





    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_game, container, false);
        wireWidgets(rootView);
        setListeners();
        gameStart();
        return rootView;
    }

    private void gameStart() {
        playerSum = 0;
        dealerSum = 0;
        hitTime = 0;
        int dealer1 = (int) (Math.random()*13 + 1);
        int dealer2 = (int) (Math.random()*13 + 1);
        int player1 = (int) (Math.random()*13 + 1);
        int player2 = (int) (Math.random()*13 + 1);
        playerSum = player1 + player2;
        dealerSum = dealer1 + dealer2;
        setCard(pcard1, player1);
        setCard(pcard2, player2);
    }

    private void setListeners() {
        hit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if (hitTime == 0) {
                   hitTime++;
                   int player3 = (int) (Math.random() * 13 + 1);
                   playerSum += player3;
                   setCard(pcard3, player3);
                   pcard3.setVisibility(View.VISIBLE);
                   int dealer3 = (int) (Math.random() * 13 + 1);
                   dealerSum += dealer3;
                   setCard(dcard3, dealer3);

                   if (hitCheck(dealerSum, playerSum) == -1 ) {
                       Toast.makeText(GameFragment.this.getContext(), "You have lost", LENGTH_SHORT ).show();
                       dcard3.setVisibility(View.VISIBLE);
                   }
                   if (hitCheck(dealerSum, playerSum) == 1) {
                       Toast.makeText(GameFragment.this.getContext(), "You have won", LENGTH_SHORT ).show();
                       dcard3.setVisibility(View.VISIBLE);
                   }

               }
               else {
                   int player4 = (int) (Math.random() * 13 + 1);
                   playerSum += player4;
                   setCard(pcard4, player4);
                   pcard4.setVisibility(View.VISIBLE);
                   int dealer4 = (int) (Math.random() * 13 + 1);
                   dealerSum += dealer4;
                   setCard(dcard4, dealer4);
                   hitCheck(dealerSum, playerSum);
                   if (hitCheck(dealerSum, playerSum) == -1 ) {
                       Toast.makeText(GameFragment.this.getContext(), "You have lost", LENGTH_SHORT ).show();
                       dcard3.setVisibility(View.VISIBLE);
                       dcard4.setVisibility(View.VISIBLE);
                   }
                   if (hitCheck(dealerSum, playerSum) == 1) {
                       Toast.makeText(GameFragment.this.getContext(), "You have won", LENGTH_SHORT ).show();
                       dcard3.setVisibility(View.VISIBLE);
                       dcard4.setVisibility(View.VISIBLE);
                   }
               }
            }
        });
        stand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
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

    private int standCheck(int dealer, int player) {
        int status = 0; //0 = game continues, -1 = dealer win, 1 = player win
        if (player > 21 && dealer < 21){
            status = -1;
        }
        else if (dealer > 21 && player < 21) {
            status = 1;
        }
        else if (dealer == 21 && player != 21) {
            status = -1;
        }
        else if (player == 21 && dealer != 21) {
            status = 1;
        }
        else if (21 - player < 21 - dealer) {
            status = 1;
        }
        else if (21 - player < 21 - dealer) {
            status = -1;
        }
        return status;
    }

    private int hitCheck(int dealer, int player) {
        int status = 0; //0 = game continues, -1 = dealer win, 1 = player win
        if (player > 21 && dealer < 21){
            status = -1;
        }
        else if (dealer > 21 && player < 21) {
            status = 1;
        }
        else if (dealer == 21 && player != 21) {
            status = -1;
        }
        else if (player == 21 && dealer != 21) {
            status = 1;
        }
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
        if (value == BACK)
            card.setImageResource(R.drawable.cardback);
    }


}
