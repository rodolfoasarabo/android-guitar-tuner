package com.example.rodolfo.tuner;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator;

public class GaugeActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private TextView txtValue;
    private CircularProgressIndicator circularProgress;
    private int i = 0;

    private static int MAX_PROGRESS = 100;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gauge);

        txtValue = findViewById(R.id.txtValue);
        circularProgress = findViewById(R.id.circularProgress);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        circularProgress.setMaxProgress(MAX_PROGRESS);
        circularProgress.setCurrentProgress(0);
        circularProgress.setProgress(0, MAX_PROGRESS);
        alteraCor();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                circularProgress.setProgress(i,MAX_PROGRESS);
                alteraCor();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i--;
                circularProgress.setProgress(i,MAX_PROGRESS);
                alteraCor();
            }
        });

    }

    private void alteraCor(){

        txtValue.setText(String.valueOf(circularProgress.getProgress()));

        if (i != 0){
            circularProgress.setDotColor(getColor(android.R.color.holo_red_light));
            circularProgress.setProgressColor(getColor(android.R.color.holo_red_light));
            circularProgress.setTextColor(getColor(android.R.color.holo_red_dark));
            circularProgress.setProgressBackgroundColor(getColor(android.R.color.holo_red_dark));
        } else {
            circularProgress.setDotColor(getColor(android.R.color.holo_green_light));
            circularProgress.setProgressColor(getColor(android.R.color.holo_green_light));
            circularProgress.setTextColor(getColor(android.R.color.holo_green_dark));
            circularProgress.setProgressBackgroundColor(getColor(android.R.color.holo_green_dark));
        }
    }
}
