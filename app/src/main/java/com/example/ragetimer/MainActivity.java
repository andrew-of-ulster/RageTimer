package com.example.ragetimer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int counter;
    ImageButton button;
    TextView minsRemaining;
    TextView secsRemaining;
    TextView colon;
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);

        button= (ImageButton) findViewById(R.id.button);
        minsRemaining= (TextView) findViewById(R.id.textMins);
        secsRemaining= (TextView) findViewById(R.id.textSecs);
        colon= (TextView) findViewById(R.id.colon);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                minsRemaining.setTextColor(0xAA008000);
                secsRemaining.setTextColor(0xAA008000);
                colon.setTextColor(0xAA008000);
                mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.custom_progressbar));

                button.setVisibility(View.INVISIBLE);
                counter=0;
                int totalTime=1800000;
                 totalTime=61000;
                int interval=1000;
                int totalSecs = totalTime/interval;
                mProgressBar.setMax(totalSecs);
                new CountDownTimer(totalTime, interval){
                    public void onTick(long millisUntilFinished){
                        int remainingSeconds = totalSecs - counter;
                        mProgressBar.setProgress(remainingSeconds);

                        int remainingMins = remainingSeconds/60;
                        String displayNum = String.valueOf(remainingMins);
                        if(remainingMins<10){
                            displayNum = "0"+displayNum;
                        }
                        minsRemaining.setText(displayNum);

                        int remainderOfSeconds = remainingSeconds-(remainingMins*60);
                        displayNum = String.valueOf(remainderOfSeconds);
                        if(remainderOfSeconds<10) {
                            displayNum = "0" + displayNum;
                        }
                        secsRemaining.setText(displayNum);

                        if(remainingSeconds<60){
                            minsRemaining.setTextColor(0xAAe4000f);
                            secsRemaining.setTextColor(0xAAe4000f);
                            colon.setTextColor(0xAAe4000f);
                            mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.red_custom_progressbar));
                        }

                        counter++;
                    }
                    public  void onFinish(){
                        minsRemaining.setText("£");
                        secsRemaining.setText("£");
                        mProgressBar.setProgress(0);
                        button.setVisibility(View.VISIBLE);
                    }
                }.start();
            }
        });
    }
}