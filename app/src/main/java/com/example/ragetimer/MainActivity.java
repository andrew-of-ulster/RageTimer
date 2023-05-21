package com.example.ragetimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int counter;
    Button button;
    TextView minsRemaining;
    TextView secsRemaining;

    private ProgressBar mProgressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);

        button= (Button) findViewById(R.id.button);
        minsRemaining= (TextView) findViewById(R.id.textMins);
        secsRemaining= (TextView) findViewById(R.id.textSecs);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                counter=0;
                int totalTime=1800000;
                 totalTime=90000;
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
                        counter++;
                    }
                    public  void onFinish(){
                        minsRemaining.setText("£");
                        secsRemaining.setText("£");
                        mProgressBar.setProgress(0);
                    }
                }.start();
            }
        });
    }
}