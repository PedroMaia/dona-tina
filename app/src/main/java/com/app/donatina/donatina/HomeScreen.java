package com.app.donatina.donatina;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        new Handler().postDelayed(new Runnable() {
            public static final String LOG_TAG = "MainActivity" ;

            @Override
            public void run() {
                Intent myIntent = new Intent(HomeScreen.this, RecordMealConfig.class);
                HomeScreen.this.startActivity(myIntent);
            }
        }, 2000);
    }
}
