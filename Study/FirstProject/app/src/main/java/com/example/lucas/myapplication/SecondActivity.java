package com.example.lucas.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    private static final String TOTAL_COUNT = "total_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        showRandomNumber();
    }

    public void showRandomNumber(){
        TextView value = findViewById(R.id.randomValue),
                 heading = findViewById(R.id.randomView);


        Integer count = getIntent().getIntExtra(TOTAL_COUNT,0);

        if (count>0) {
            Random rnd = new Random();
            value.setText(String.format(Locale.ENGLISH,
                    "%d", rnd.nextInt(count)));
        }

        heading.setText(getString(R.string.random_heading, count));
    }

    public void retryMe(View view){
        this.showRandomNumber();
    }
}
