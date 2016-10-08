package com.app.donatina.donatina;

/**
 * @author Pedro Maia <pedromaia@nutrium.io>
 * @version 1.0
 * @since 07/10/2016.
 */


import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import in.arjsna.swipecardlib.SwipePageView;

public class PageSwipeActivity extends Activity {

    private ArrayList<Card> al;
    private PageAdapter arrayAdapter;

    @InjectView(R.id.page_swipe_view)
    SwipePageView flingContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_swipe);
        ButterKnife.inject(this);


        al = new ArrayList<>();
        getDummyData(al);
        arrayAdapter = new PageAdapter(this, al );


        flingContainer.setAdapter(arrayAdapter);
        flingContainer.setFlingListener(new SwipePageView.OnPageFlingListener() {
            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter) {
            }

            @Override
            public void onScroll(float scrollProgressPercent) {
            }

            @Override
            public void onTopCardExit(Object dataObject) {
            }

            @Override
            public void onBottomCardExit(Object dataObject) {
            }
        });
        flingContainer.setOnItemClickListener(new SwipePageView.OnItemClickListener() {
            @Override
            public void onItemClicked(int itemPosition, Object dataObject) {
            }
        });


    }
    private void getDummyData(ArrayList<Card> al) {

    }
}
