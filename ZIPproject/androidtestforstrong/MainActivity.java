package com.funtion.androidtestforstrong;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private  final String TAG = "MainActivity";
    private  int n = 0;
    private  Button btn_act ;
    private  Button btn_back ;
    private  ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_act = (Button) findViewById(R.id.first_btn1);
        btn_back = (Button) findViewById(R.id.first_back);
        progressBar = (ProgressBar)findViewById(R.id.progress_main);

        btn_act.setOnClickListener(onClickListener);
        btn_back.setOnClickListener(onClickListener);

//        String ss = "tygugfyg.yet";
//        String [] sc = ss.split("\\.");
//        if(ss.indexOf(".") != -1){
//            Log.d(TAG, "666666666666666666:");
//        }
//        Log.d(TAG, sc[1]);
        //thread.start();
        Timer timer = new Timer();
        timer.schedule(timerTask,0,1000);
        long sun = 1256428l;
        Date date2 = new Date(sun);
        String nametest = "hahhaha6hhahah";
        Log.d(TAG,"test " + nametest.substring(0,8));

        SimpleDateFormat tu = new SimpleDateFormat("HH:mm:ss");
        String  sb =tu.format(date2);
//        Date dat=new Date(sun);
//        GregorianCalendar gc = new GregorianCalendar();
//        gc.setTime(dat);
//        SimpleDateFormat tu = new SimpleDateFormat("HH:mm:ss");
//        String sb = tu.format(gc.getTime());
//        int time = 1256428;
//        int HH = time / (1000*60*60) ;
//        Log.d(TAG,  " HH   " + HH);
//        int hh = time - HH*1000*60*60;
//        int MM = hh / (1000*60);
//        Log.d(TAG,  " MM   " + MM);
//        int mm = hh -  MM*1000*60;
//        Log.d(TAG,  " mm   " + mm);
//        int SS = mm / 1000;
//        Log.d(TAG,  "   SS " + SS);
//        String h = HH >= 10 ? String.valueOf(HH) : "0" + HH;
//        String m = MM >= 10 ? String.valueOf(MM) : "0" + MM;
//        String s = SS >= 10 ? String.valueOf(SS) : "0" + SS;
//
//        String formattime = h +":" + m + ":" + s ;
//
//        Log.d(TAG,  "88888    " + sb);
        //SetP();
        //progressBar.getProgress();
       // Log.d(TAG,  "88888    " + progressBar.getProgress());
        timer.cancel();
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch( v.getId() ){
                case R.id.first_btn1:
                    Intent intent = new Intent(MainActivity.this, Secongctivity.class);
                    String string = "hello TWO";
                    intent.putExtra("data",string);
                    startActivity(intent);
                    break;
                case R.id.first_back:
                    Intent int23 = new Intent(MainActivity.this, Secongctivity.class);
                    startActivityForResult(int23, 1);
                    break;

            }
        }
    };

    private Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            Log.d(TAG,"   "+ n++);
        }
    });

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Log.d(TAG,"   "+ n++);
            Message msg = Message.obtain() ;
            msg.what =1;
            msg.obj = "hahahah";
            handler.sendMessage(msg);
        }
    };

    private void SetP(){
        int mm = 55;
        //for(; mm < 100 ; mm++){
            progressBar.setProgress(mm);
       // }
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    Log.d(TAG , msg.obj.toString());
                    break;

            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //MenuInflater inflater = getMenuInflater();
        MenuInflater  inflater = getMenuInflater();
        inflater.inflate(R.menu.firstactivity, menu);
        return  true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        switch ( item_id){
            case R.id.add_item :
                {
                Log.d(TAG, "隐式intent");
                // Toast.makeText(MainActivity.this, "加入",Toast.LENGTH_LONG).show();
                /* 隐式intent */
                Intent intent1 = new Intent();
                intent1.setAction("com.funtion.androidtestforstrong.SECONG_START");
                startActivity(intent1);
                }
                break;
            case R.id.delte_item:
               // Toast.makeText(MainActivity.this, "删除",Toast.LENGTH_LONG).show();

                break;
        }
        return  true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String getdatasec = data.getStringExtra("Second_name");
                    Log.d(TAG, "来自second的数据"+ getdatasec);
                }
                break;
            default:
                break;
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }


}
