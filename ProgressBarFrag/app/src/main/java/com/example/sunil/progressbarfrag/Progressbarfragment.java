package com.example.sunil.progressbarfrag;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


/**
 * Created by Sunil on 6/27/2016.
 */
public class Progressbarfragment extends Fragment {
    Button btn, btn1, btn2;
    android.widget.ProgressBar sk;
    int ProgressBar = 0;
    int n = 0;
    private static final int SHORT_DELAY = 2000;
    private GoogleApiClient client;

    private LayoutInflater mMenuInflater;


    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.progressbarfragment, parent, false);

        btn = (Button) v.findViewById(R.id.button1);
        btn1 = (Button) v.findViewById(R.id.button2);
        btn2 = (Button) v.findViewById(R.id.button3);
        sk = (ProgressBar) v.findViewById(R.id.progressBar);


        btn.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                sk.setProgress(0);
                Toast.makeText(getActivity(), "ZERO", Toast.LENGTH_SHORT).show();
                btn.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.INVISIBLE);
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
                    btn1.setVisibility(View.VISIBLE);

                } else {
                    Toast.makeText(getActivity(), "DecreaseD", Toast.LENGTH_SHORT).show();
                    btn2.setVisibility(View.INVISIBLE);
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (n < 100) {
                    n = n + 5;
                    sk.setProgress(n);
                    btn2.setVisibility(View.VISIBLE);
                    btn.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getActivity(), "IncreaseD", Toast.LENGTH_SHORT).show();
                    btn1.setVisibility(View.INVISIBLE);

                }
            }
        });

        return v;
    }



    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.progressbarfragment, (ViewGroup) menu);
        return true;
    }


    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public Button getBtn1() {
        return btn1;
    }

    public void setBtn1(Button btn1) {
        this.btn1 = btn1;
    }

    public Button getBtn2() {
        return btn2;
    }

    public void setBtn2(Button btn2) {
        this.btn2 = btn2;
    }

    public android.widget.ProgressBar getSk() {
        return sk;
    }

    public void setSk(android.widget.ProgressBar sk) {
        this.sk = sk;
    }

    public int getProgressBar() {
        return ProgressBar;
    }

    public void setProgressBar(int progressBar) {
        ProgressBar = progressBar;
    }

    public LayoutInflater getMenuInflater() {

        return mMenuInflater;
    }
}


