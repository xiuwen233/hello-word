package com.funtion.androidtestforstrong;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Unionman on 2017/10/26.
 */

public class Secongctivity extends AppCompatActivity {
   private final String TAG = "Secongctivity";

    private  Button btn2 ;
    private  Button btn1;
    private  Button btn3;
    private  Button btn4;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secongactivity);

        Intent start_ine = new Intent();
        String getdata = start_ine.getStringExtra("data");
        Log.d(TAG, "从上一个activity过来的数据"+getdata);

        btn1 = (Button) findViewById(R.id.second_btn1);
        btn2 = (Button) findViewById(R.id.second_btn2);
        btn3 = (Button) findViewById(R.id.dialog_second);
        btn4 = (Button) findViewById(R.id.second_btn3);

        btn2.setOnClickListener(onClickListener) ;
         btn1.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);


    }

     private  View.OnClickListener onClickListener = new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             switch (v.getId()){
                 case R.id.second_btn1:
                     Intent intent2 = new Intent();
                     intent2.putExtra("Second_name","你好啊");
                     setResult(RESULT_OK,intent2);
                     finish();
                     break;
                 case R.id.second_btn2:
                      /* 要去注册VIEW，最好指定scheme的类型 */
                     Intent intent = new Intent(Intent.ACTION_VIEW);
                     intent.setData(Uri.parse("http://www.baidu.com"));
                     startActivity(intent);
                     break;
                 case R.id.dialog_second:
                     Intent intent1 = new Intent(Secongctivity.this,DialogActivity.class);
                     startActivity(intent1);
                     break;
                 case R.id.second_btn3:
                     Intent intent4 = new Intent();
                     intent4.setAction("com.funtion.androidtestforstrong.START_ACT");
                     startActivity(intent4);
                     break;
             }
         }
     };

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"on start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"on resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"on pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"on stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"on destroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"on Restart");
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//    }
}
