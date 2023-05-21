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
    TextView textView;

    private ProgressBar mProgressBar;
    private TextView mLoadingText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progressBar2);

        button= (Button) findViewById(R.id.button);
        textView= (TextView) findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                int totalTime=10000;
                int interval=1000;
                new CountDownTimer(totalTime, interval){
                    public void onTick(long millisUntilFinished){
                        int remainingtime = totalTime - counter;
                        textView.setText(String.valueOf((totalTime/1000)-counter));
                        mProgressBar.setProgress((totalTime/1000)-counter);
                        counter++;
                    }
                    public  void onFinish(){
                        textView.setText("FINISH!!");
                    }
                }.start();
            }
        });
    }
}