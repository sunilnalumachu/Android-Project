package com.example.sunil.drivingtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DifficultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficult);
        Button next = (Button) findViewById(R.id.button3);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuizEasyActivity.class);
                Toast.makeText(getBaseContext(), "All the best", Toast.LENGTH_LONG).show();
                startActivityForResult(myIntent, 0);
            }

        });
        Button next1 = (Button) findViewById(R.id.button4);
        next1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuizDifficultActivity.class);
                Toast.makeText(getBaseContext(), "All the best", Toast.LENGTH_LONG).show();
                startActivityForResult(myIntent, 0);
            }

        });
        Button next2 = (Button) findViewById(R.id.button5);
        next2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuizMediumActivity.class);
                Toast.makeText(getBaseContext(), "All the best", Toast.LENGTH_LONG).show();
                startActivityForResult(myIntent, 0);
            }

        });

    }
}
