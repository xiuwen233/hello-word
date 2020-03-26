package com.um.activitytest191217;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity {

    private final  String TAG = "FirstActivity";
    private Button btn1;
    private Button btn2_normal;
    private Button btn3_dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Log.d(TAG,"onCreate");
        btn1 = (Button) findViewById(R.id.btn_one);
        btn2_normal = (Button) findViewById(R.id.first_bt2);
        btn3_dialog = (Button) findViewById(R.id.first_bt3);
        btn1.setOnClickListener(onClickListener);
        btn2_normal.setOnClickListener(onClickListener);
        btn3_dialog.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_one:
                    //Toast.makeText(MainActivity.this,"you clicked Button 1",Toast.LENGTH_SHORT).show();
                    send_data_activity();
                    break;
                case R.id.first_bt2:
                    btn2_clik();
                    break;
                case R.id.first_bt3:
                    btn3_clik();
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //return super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(MainActivity.this,"you clicked ADD",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(MainActivity.this,"you clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void button1_clicked(){
        Intent intent = new Intent(MainActivity.this,SceondActivity.class);
        startActivity(intent);
    }

    public void button1_yinsetintent_clicked(){
        Intent intent  = new Intent("com.example.activitytest.ACTION_START");
        intent.addCategory("com.example.activitytest.MY_CATEGORY");
        startActivity(intent);
    }


    public void button_call_url(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }


    public void tel_clicked(){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:10086"));
        startActivity(intent);
    }


    public void send_data_activity(){
        Intent intent = new Intent(MainActivity.this,SceondActivity.class);
        String datt = "Hello SecondActivity";
        intent.putExtra("extra_data",datt);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String returnData = data.getStringExtra("data_return");
                    Log.d(TAG,returnData);
                }
                break;
            default:
                break;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



    private void btn2_clik(){
        Intent intent = new Intent(MainActivity.this,NormalActivity.class);
        startActivity(intent);
    }

    private void btn3_clik(){
        Intent intent = new Intent(MainActivity.this,DialogActivity.class);
        startActivity(intent);

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
}
