package com.example.sunil.drivingtest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        TextView t=(TextView)findViewById(R.id.textResult);
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
        if (score>=3)
        {
            t.setText("Congratulations you are qualified, your score is: "+score);
        }
        else {
            t.setText("Disqualify better luck next time,your score is: " +score);
        }

    };

}






