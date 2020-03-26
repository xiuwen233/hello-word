package com.funtion.androidtestforstrong;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class test extends Activity {

   LinearLayout linearLayout;
    private ProgressBar progressBar ;
    private TextView text1 ;
    private TextView text2 ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
       progressBar = (ProgressBar)findViewById(R.id.pro_bi);
       linearLayout = (LinearLayout) findViewById(R.id.linear_pvr);
        text1 = (TextView)findViewById(R.id.start_id_big);
        text2 = (TextView)findViewById(R.id.end_time);
        text2.setText("56");
        //progressBar.getProgress();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_DPAD_UP:
                linearLayout.setVisibility(View.GONE);
                break;
            case KeyEvent.KEYCODE_DPAD_LEFT:
                linearLayout.setVisibility(View.VISIBLE);
                timer.start();
                break;
            case KeyEvent.KEYCODE_DPAD_RIGHT:
                linearLayout.setVisibility(View.VISIBLE);
                timer.start();
                break;
        }
        return super.onKeyDown(keyCode, event);
    }


    CountDownTimer timer = new CountDownTimer(2000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            progressBar.setProgress(60);
            linearLayout.setVisibility(View.GONE);
        }
    };


    //    private Thread thread = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            Log.d("6666666")
//
//        }
//    });
}
