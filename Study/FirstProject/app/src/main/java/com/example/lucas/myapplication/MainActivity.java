package com.example.lucas.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final String TOTAL_COUNT = "total_count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toastMe(View view){
        Toast myToast = Toast.makeText(this,
                "This is a Toast message",
                Toast.LENGTH_LONG);
        myToast.show();
    }

    public void countMe(View view){
        TextView txtView = findViewById(R.id.textView);

        txtView.setText(String.format(Locale.ENGLISH,
                "%d", this.getCount() + 1));
    }

    public void randomMe(View view){
        Intent randomIntent = new Intent(this, SecondActivity.class);
        randomIntent.putExtra(TOTAL_COUNT, this.getCount());
        startActivity(randomIntent);
    }

    private Integer getCount(){
        TextView countTextView = findViewById(R.id.textView);
        String countString = countTextView.getText().toString();

        return Integer.parseInt(countString);
    }
}


