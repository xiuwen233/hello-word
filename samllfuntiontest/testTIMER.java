package com.um.test20191225fp;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button btn_one ;
    private Button btn_two;
    private Button btn_three;
    private Threadtest threadtest;
    private final String TAG = "NUMTEST";


    @SuppressLint("HandlerLeak")
    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    Toast.makeText(MainActivity.this,"This is you",Toast.LENGTH_LONG).show();
                    break;
                case 2:
                    Toast.makeText(MainActivity.this,"messg 9s 2",Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;
            }
        }
    };


    public int num = 3;

    public Timer timer = new Timer();
    public TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            num--;
            try {
                int len  = 2/num;
                Log.d(TAG,"len is "+ len);
            }catch (ArithmeticException e){
                e.printStackTrace();
                Log.d(TAG,"denominator");
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_one = findViewById(R.id.first_start);
        btn_two = findViewById(R.id.second_start);

        btn_one.setOnClickListener(onClickListener);
        btn_two.setOnClickListener(onClickListener);
        btn_three.setOnClickListener(onClickListener);

       // timer.schedule(timerTask,1000,3000);
    }


    private  View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.first_start:
                    First_start();
                    break;
                case R.id.second_start:
                    Second_start();
                    break;
                case  R.id.stop_id:
                    ReStarted();
                    break;
                default:
                    break;
            }
        }
    };

    public void First_start(){
        threadtest = new Threadtest();
        threadtest.set_str("first");
        threadtest.start();
        //thread.start();
    }


    public void Second_start(){
        threadtest = new Threadtest();
        threadtest.set_str("Second");
        threadtest.start();
    }

    public Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while(true) {
                if(!threadtest.get_stats()){
                    Second_start();
                    break;
                }
            }
        }
    });



    public void ReStarted(){
        threadtest.stop_thread();
        threadtest.start();
    }



}
