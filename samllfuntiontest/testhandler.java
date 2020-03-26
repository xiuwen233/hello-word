package com.um.testhandle1108;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView = null;
    private Button bt1 = null;
    private Button bt2 = null;
    private Button bt3 = null;


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 1:
                    setTextone();
                    break;
                case 2:
                    setTexttwo();
                    break;
                case 3:
                    setTestthree();
                    break;
                default:
                    break;
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.test_show);
        bt1 = findViewById(R.id.sendone_bt);
        bt2 = findViewById(R.id.send_two);
        bt3 = findViewById(R.id.send_three);


        bt1.setOnClickListener(onClickListener);
        bt2.setOnClickListener(onClickListener);
        bt3.setOnClickListener(onClickListener);


    }

    public View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.sendone_bt:
                    Message message = Message.obtain();
                    message.what = 1;
                    handler.sendMessage(message);
                    break;
                case R.id.send_two:
                    Message p2 = Message.obtain();
                    p2.what = 2;
                    handler.sendMessage(p2);
                    break;
                case R.id.send_three:
                    Message p3 = Message.obtain();
                    p3.what = 3;
                    handler.sendMessage(p3);
                    break;
                default:
                    break;
            }

        }
    };


    public void setTextone() {
        textView.setText("Th is one");
    }

    public void setTexttwo(){
        textView.setText("This is two");
    }

    public void setTestthree(){
        textView.setText("This is three");
    }
}
