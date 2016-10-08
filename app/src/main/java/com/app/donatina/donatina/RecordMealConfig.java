package com.app.donatina.donatina;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.spark.submitbutton.SubmitButton;

public class RecordMealConfig extends AppCompatActivity {
    private SubmitButton mNext;
    private EditText max_price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_meal_config);
        mNext = (SubmitButton) findViewById(R.id.bt_submit);
        mNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Handler().postDelayed(new Runnable() {
                    public static final String LOG_TAG = "MainActivity" ;

                    @Override
                    public void run() {
                        Intent myIntent = new Intent(RecordMealConfig.this, CardSwipeActivity.class);
                        RecordMealConfig.this.startActivity(myIntent);
                    }
                }, 2500);
            }
        });

        max_price = (EditText) findViewById(R.id.et_max_price);

        max_price.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable text) {
                // TODO Auto-generated method stub
                text.append("€");
            }
        });
    }
}
