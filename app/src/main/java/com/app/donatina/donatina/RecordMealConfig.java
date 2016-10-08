package com.app.donatina.donatina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RecordMealConfig extends AppCompatActivity {
    private Button mNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_meal_config);
        mNext = (Button) findViewById(R.id.bt_submit);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(RecordMealConfig.this, CardSwipeActivity.class);
                RecordMealConfig.this.startActivity(myIntent);
            }
        });

    }
}
