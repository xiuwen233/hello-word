package com.funtion.test_zhujian_1010;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
//import android.os.SystemProperties;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    private long time =-1;
    boolean finish_flag = false;
    private Handler takechannel = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1 :
                    if(time ){
                        Log.i("hahah","hhahh");
                    }else{
                        timer.onFinish();
                        finish_flag = false;
                    }
                    break;
                case 2 :
                    timer.onFinish();
                    finish_flag = false;
            }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences.Editor editor = (SharedPreferences.Editor) getSharedPreferences("hahh",0);
        editor.putInt("hdhh",238);
        //editor.apply();

      //  private  CountDownTimer timer =  new CountDownTimer(10000, 1000);
             timer.start();
             timer.onFinish();
             timer.cancel();
  String str = "223";
        try{

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
        int a = Integer.parseInt(str);
        /*String str = "123";
        try {
            int a = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }*/
    }
    CountDownTimer timer = new CountDownTimer(10000,1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            finish_flag =false;
            time = millisUntilFinished;
        }

        @Override
        public void  onFinish() {
            if(time == 0){
                Log.i("start","start");
            }

        }
    };
    public  class  test23 extends Service{
        @Override
        public void onCreate() {
            // SystemProperties
            //SystemProperties.get
            super.onCreate();
        }

        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }
    }



}
