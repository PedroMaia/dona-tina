package com.app.donatina.donatina;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    //TODO remove in the end
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Intent myIntent = new Intent(this, CardSwipeActivity.class);
        //Intent myIntent = new Intent(this, HomeScreen.class);

        Intent myIntent = new Intent(this, HomeScreen.class);
        this.startActivity(myIntent);
    }
}
