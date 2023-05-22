package com.example.ragetimer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public int counter;
    ImageButton button;
    TextView minsRemainingTens;
    TextView secsRemainingTens;
    TextView minsRemainingOnes;
    TextView secsRemainingOnes;
    TextView hiddenMins;
    TextView hiddenSecs;
    TextView colon;
    ProgressBar mProgressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);

        button= (ImageButton) findViewById(R.id.button);
        minsRemainingTens= (TextView) findViewById(R.id.textMinTens);
        secsRemainingTens= (TextView) findViewById(R.id.textSecTens);
        minsRemainingOnes= (TextView) findViewById(R.id.textMinOnes);
        secsRemainingOnes= (TextView) findViewById(R.id.textSecOnes);
        colon= (TextView) findViewById(R.id.colon);
        hiddenMins = (TextView) findViewById(R.id.textMinOnes2);
        hiddenSecs = (TextView) findViewById(R.id.textSecOnes2);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        Log.w("Details",width+"");
        float mySize = width/2;
        minsRemainingTens.setTextSize(TypedValue.COMPLEX_UNIT_PX, mySize);
        secsRemainingTens.setTextSize(TypedValue.COMPLEX_UNIT_PX, mySize);
        minsRemainingOnes.setTextSize(TypedValue.COMPLEX_UNIT_PX, mySize);
        secsRemainingOnes.setTextSize(TypedValue.COMPLEX_UNIT_PX, mySize);
        colon.setTextSize(TypedValue.COMPLEX_UNIT_PX, mySize);
        hiddenMins.setTextSize(TypedValue.COMPLEX_UNIT_PX, mySize);
        hiddenSecs.setTextSize(TypedValue.COMPLEX_UNIT_PX, mySize);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                minsRemainingTens.setTextColor(0xAA008000);
                secsRemainingTens.setTextColor(0xAA008000);
                minsRemainingOnes.setTextColor(0xAA008000);
                secsRemainingOnes.setTextColor(0xAA008000);
                colon.setTextColor(0xAA008000);
                mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.custom_progressbar));

                button.setVisibility(View.INVISIBLE);
                counter=0;
                int totalTime=1800000;
                 totalTime=69000;
                int interval=1000;
                int totalSecs = totalTime/interval;
                mProgressBar.setMax(totalSecs);
                new CountDownTimer(totalTime, interval){
                    public void onTick(long millisUntilFinished){
                        int remainingSeconds = totalSecs - counter;
                        mProgressBar.setProgress(remainingSeconds);


                        int remainingMins = remainingSeconds/60;
                        int remainingMinsTens = remainingMins/10;
                        String displayNum = String.valueOf(remainingMinsTens);
                        if(remainingMinsTens<1){
                            displayNum = "0";
                        }
                        minsRemainingTens.setText(displayNum);

                        int remainingMinsOnes = remainingMins - (remainingMinsTens*10);
                        displayNum = String.valueOf(remainingMinsOnes);
                        minsRemainingOnes.setText(displayNum);

                        int remainderOfSeconds = remainingSeconds-(remainingMins*60);
                        int remainderOfSecondsTens = remainderOfSeconds/10;
                        displayNum = String.valueOf(remainderOfSecondsTens);
                        if(remainderOfSeconds<10) {
                            displayNum = "0";
                        }
                        secsRemainingTens.setText(displayNum);

                        int remainderOfSecondsOnes = remainderOfSeconds - (remainderOfSecondsTens*10);
                        displayNum = String.valueOf(remainderOfSecondsOnes);
                        secsRemainingOnes.setText(displayNum);

                        if(remainingSeconds<60){
                            minsRemainingTens.setTextColor(0xAAe4000f);
                            secsRemainingTens.setTextColor(0xAAe4000f);
                            minsRemainingOnes.setTextColor(0xAAe4000f);
                            secsRemainingOnes.setTextColor(0xAAe4000f);
                            colon.setTextColor(0xAAe4000f);
                            mProgressBar.setProgressDrawable(getResources().getDrawable(R.drawable.red_custom_progressbar));
                        }

                        counter++;
                    }
                    public  void onFinish(){
                        minsRemainingTens.setText("£");
                        secsRemainingTens.setText("£");
                        minsRemainingOnes.setText("£");
                        secsRemainingOnes.setText("£");
                        mProgressBar.setProgress(0);
                        button.setVisibility(View.VISIBLE);
                    }
                }.start();
            }
        });
    }
}