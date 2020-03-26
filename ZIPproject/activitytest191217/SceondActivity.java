package com.um.activitytest191217;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class SceondActivity extends AppCompatActivity {

    private Button btn1_sec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sceond);

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("SecondActivity",data);

        btn1_sec = (Button) findViewById(R.id.sec_btn1);
        btn1_sec.setOnClickListener(onClickListener);
    }


   public View.OnClickListener onClickListener = new View.OnClickListener() {
       @Override
       public void onClick(View view) {
           switch (view.getId()){
               case R.id.sec_btn1:
                   click_return();
                   break;
               default:
                   break;
           }
       }
   };

    public void  click_return(){
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }


}
