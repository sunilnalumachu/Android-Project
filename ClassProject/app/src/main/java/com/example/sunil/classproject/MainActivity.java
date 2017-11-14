package com.example.sunil.classproject;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Build;
import android.renderscript.Script;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn,btn1,btn2;
    ProgressBar sk ;
    int ProgressBar=0;
    int n=0;
    private static final int SHORT_DELAY = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button)findViewById(R.id.button1);
        btn1=(Button)findViewById(R.id.button2);
        btn2=(Button)findViewById(R.id.button3);
        sk=(ProgressBar)findViewById(R.id.progressBar);


        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sk.setProgress(0);
                Toast.makeText(getBaseContext(), "ZERO", Toast.LENGTH_SHORT).show();
                btn.setEnabled(false);
                btn2.setEnabled(true);

                sk.setProgress(0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                if (n > 0) {
                    n = n - 5;
                    sk.setProgress(n);
                    btn1.setEnabled(true);

                } else {
                    Toast.makeText(getBaseContext(), "DecreaseD", Toast.LENGTH_SHORT).show();
                    btn2.setEnabled(false);
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(n < 100)  {
                    n=n+5;
                    sk.setProgress(n);
                    btn2.setEnabled(true);
                    btn.setEnabled(true);
                }
               else
                {
                    Toast.makeText(getBaseContext(), "IncreaseD", Toast.LENGTH_SHORT).show();
                    btn1.setEnabled(false);

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

