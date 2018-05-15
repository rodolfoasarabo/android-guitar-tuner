package com.example.rodolfo.tuner;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.pawelkleczkowski.customgauge.CustomGauge;

public class GauceActivity extends AppCompatActivity {

    private CustomGauge gauge;
    private Button btn1;
    private Button btn2;
    private TextView txtGauge;
    private int i = 50;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gauge);

        gauge = findViewById(R.id.gauge);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        txtGauge = findViewById(R.id.txtGauge);

        gauge.setValue(51);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        i++;
                        try{
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    gauge.setValue(i);
                                    if (i>50){
                                        gauge.setStrokeColor(getColor(R.color.colorAccent));
                                    } else {
                                        gauge.setStrokeColor(getColor(R.color.colorPrimary));
                                    }
                                    txtGauge.setText(String.valueOf(gauge.getValue()));
                                }
                            });
                            Thread.sleep(50);
                        } catch (Exception ex){
                            Log.e("Error", ex.getMessage());
                        }
                    }
                }.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(){
                    @Override
                    public void run() {
                        i--;
                        try{
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    gauge.setValue(i);
                                    if (i>50){
                                        gauge.setStrokeColor(getColor(R.color.colorAccent));
                                    } else {
                                        gauge.setStrokeColor(getColor(R.color.colorPrimary));
                                    }
                                    txtGauge.setText(String.valueOf(gauge.getValue()));
                                }
                            });
                            Thread.sleep(50);
                        } catch (Exception ex){
                            Log.e("Error", ex.getMessage());
                        }
                    }
                }.start();
            }
        });

    }
}
