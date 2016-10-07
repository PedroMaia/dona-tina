package com.app.donatina.donatina;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.sackcentury.shinebuttonlib.ShineButton;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import in.arjsna.swipecardlib.SwipeCardView;

/**
 * @author Pedro Maia <pedromaia@nutrium.io>
 * @version 1.0
 * @since 07/10/2016.
 */

public class CardSwipeActivity extends Activity {

    private ArrayList<Card> al;
    private CardsAdapter arrayAdapter;
    private ShineButton mBtRigh;
    private ShineButton mBtLeft;

    private int i;

    @InjectView(R.id.card_stack_view)
    SwipeCardView swipeCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mBtLeft = (ShineButton) findViewById(R.id.left);
        mBtRigh = (ShineButton) findViewById(R.id.right);

        mBtRigh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swipeCardView.throwRight();
            }
        });

        mBtLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swipeCardView.throwLeft();
            }
        });

        //new buttons

        ButterKnife.inject(this);


        al = new ArrayList<>();
        getDummyData(al);
        arrayAdapter = new CardsAdapter(this, al );


        swipeCardView.setAdapter(arrayAdapter);
        swipeCardView.setFlingListener(new SwipeCardView.OnCardFlingListener() {
            @Override
            public void onCardExitLeft(Object dataObject) {
                mBtLeft.setChecked(true);

                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        mBtLeft.setChecked(false);
                    }}, 800);
            }

            @Override
            public void onCardExitRight(Object dataObject) {
                mBtRigh.setChecked(true);

                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        mBtRigh.setChecked(false);
                    }}, 800);
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
                // Ask for more data here
//                al.add("XML ".concat(String.valueOf(i)));
//                arrayAdapter.notifyDataSetChanged();
//                Log.d("LIST", "notified");
//                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
                View view = swipeCardView.getSelectedView();
//                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
//                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }

            @Override
            public void onCardExitTop(Object dataObject) {
            }

            @Override
            public void onCardExitBottom(Object dataObject) {

            }
        });


        // Optionally add an OnItemClickListener
        swipeCardView.setOnItemClickListener(
                new SwipeCardView.OnItemClickListener() {
                    @Override
                    public void onItemClicked(int itemPosition, Object dataObject) {
                        Card card = (Card) dataObject;
                        makeToast(CardSwipeActivity.this, card.name);
                    }
                });

    }

    private void getDummyData(ArrayList<Card> al) {
        Card card = new Card();
        card.name = "Card1";
        card.imageId = R.drawable.food_demo;
        al.add(card);

        Card card2 = new Card();
        card2.name = "Card2";
        card2.imageId = R.drawable.food_demo;
        al.add(card2);
        Card card3 = new Card();
        card3.name = "Card3";
        card3.imageId = R.drawable.food_demo;
        al.add(card3);
        Card card4 = new Card();
        card4.name = "Card4";
        card4.imageId = R.drawable.food_demo;
        al.add(card4);
        Card card5 = new Card();
        card5.name = "Card5";
        card5.imageId = R.drawable.food_demo;
        al.add(card5);
        Card card56 = new Card();
        card56.name = "Card6";
        card56.imageId = R.drawable.food_demo;
        al.add(card56);
        Card card7 = new Card();
        card7.name = "Card7";
        card7.imageId = R.drawable.food_demo;
        al.add(card7);
        Card card8 = new Card();
        card8.name = "Card8";
        card8.imageId = R.drawable.food_demo;
        al.add(card8);
        Card card9 = new Card();
        card9.name = "Card9";
        card9.imageId = R.drawable.food_demo;
        al.add(card9);
        Card card10 = new Card();
        card10.name = "Card10";
        card10.imageId = R.drawable.food_demo;
        al.add(card10);
        Card card11 = new Card();
        card11.name = "Card11";
        card11.imageId = R.drawable.food_demo;
        al.add(card11);
    }

    static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }
/*
    @OnClick(R.id.left)
    public void left() {
        swipeCardView.throwLeft();
    }*/
/*
    @OnClick(R.id.right)
    public void right() {
        swipeCardView.throwRight();
    }*/
}