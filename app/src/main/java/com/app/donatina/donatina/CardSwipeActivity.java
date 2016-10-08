package com.app.donatina.donatina;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
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
    private TextView mTvTotalMeals;
    private int mTotalMeals;
    private int i;

    @InjectView(R.id.card_stack_view)
    SwipeCardView swipeCardView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        mTotalMeals = 3;

        mBtLeft = (ShineButton) findViewById(R.id.left);
        mBtRigh = (ShineButton) findViewById(R.id.right);
        mTvTotalMeals = (TextView) findViewById(R.id.tv_top_text);
        updateTotalElements();

        ButterKnife.inject(this);

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

                mTotalMeals--;
                updateTotalElements();
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

    private void updateTotalElements() {
        if(mTotalMeals>0){
            mTvTotalMeals.setText("Faltam "+ mTotalMeals+" refeições");
        }else{
            makeToast(this, "Completo!!");
            Intent myIntent = new Intent(this, RecipesList.class);
            this.startActivity(myIntent);
    }
    }

    private void getDummyData(ArrayList<Card> al) {
        for(int i= 0; i<10;i++ ){
            Card card = new Card("Arroz de pato", "Almoço (50 min)", "http://24kassets.fichub.com/24kitchen_pt_pt/recipe/123859.660x372.jpg");
            this.al.add(card);
        }
    }

    static void makeToast(Context ctx, String s){
        Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show();
    }
}