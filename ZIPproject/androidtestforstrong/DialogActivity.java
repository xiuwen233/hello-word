package com.funtion.androidtestforstrong;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends Activity {

    private Button  btnok;
    private Button  btncancel;

    private TextView videostartbt ;
    private TextView videoendbt;

    private EditText editText;
    private String str = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        btnok = (Button)findViewById(R.id.dialog_pvr_okbtn);
        btncancel = (Button ) findViewById(R.id.dialog_pvr_nobtn);
        editText = (EditText)findViewById(R.id.dialog_pvr_edit);

        videoendbt = (TextView)findViewById(R.id.pvr_start_time);
        videostartbt = (TextView)findViewById(R.id.pvr_end_time);
        btncancel.setOnClickListener(onClickListener);
        btnok.setOnClickListener(onClickListener);
        videostartbt.setText("ggrgwgwg");



    }
    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.dialog_pvr_okbtn:
                   str = editText.getText().toString();
                    if(str.isEmpty()){
                        Toast.makeText(DialogActivity.this,"please input something or cancel",Toast.LENGTH_SHORT).show();
                    }else {
                        Intent intent2 = new Intent();
                        intent2.putExtra("Get_rename",str);
                        setResult(RESULT_OK,intent2);
                        finish();
                    }
                    break;
                case R.id.dialog_pvr_nobtn:
                    finish();
                    break;
            }
        }
    };
}
