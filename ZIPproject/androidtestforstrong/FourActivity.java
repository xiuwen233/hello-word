package com.funtion.androidtestforstrong;

import android.app.Activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class FourActivity extends Activity {

    private final String TAG = "FourActivity";

    private Button btn1;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        btn1 = (Button)findViewById(R.id.save_four);
        btn2 = (Button)findViewById(R.id.print_fourbt);

        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
    }


    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.save_four:
                    SharedPreferences.Editor editor = getSharedPreferences("hello",MODE_PRIVATE).edit();
                    editor.putInt("age",34);
                    editor.putString("name","la fear");
                    editor.putBoolean("man",true);
                    editor.apply();
                    break;
                case R.id.print_fourbt:
                    SharedPreferences prer = getSharedPreferences("hello",MODE_PRIVATE);
                    String name = prer.getString("name","");
                    int age = prer.getInt("age",0);
                    Boolean man = prer.getBoolean("man" , false);
                    Log.d(TAG, "name " + name);
                    Log.d(TAG, " age " + age);
                    Log.d(TAG, "man  " + man);
                    break;
            }
        }
    };
}
