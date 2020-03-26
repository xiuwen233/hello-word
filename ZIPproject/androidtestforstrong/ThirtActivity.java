package com.funtion.androidtestforstrong;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ThirtActivity extends Activity {

    private final String TAG =" ThirtActivity";
    private ArrayList<HashMap<String,Object>>  listdata;

    private Handler handler;
    private Button  btn;
    private Button jiabtn;
    private SimpleAdapter listitem;
    ListView listView ;


    ArrayList<String> filename ;
    ArrayList<String> filedata ;
    ArrayList<String> filesize ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirt);

        listView = (ListView)findViewById(R.id.three_listv);
        btn = (Button)findViewById(R.id.three_bt);
        jiabtn = (Button)findViewById(R.id.three_tof_bt);
        listdata = new ArrayList<HashMap<String, Object>>();

        btn.setOnClickListener(onClickListener);
        jiabtn.setOnClickListener(onClickListener);

        GetVideoFileName("system/etc");

        handler = new Handler();
       // runnable.run();

        //title = getResources().getStringArray(R.array.test_list_title);
        //content = getResources().getStringArray(R.array.test_list_source);

        for(int i = 0; i < filename.size(); i++ ) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("FileName",filename.get(i));
            map.put("FileData",filedata.get(i));
            map.put("FileSize",filesize.get(i));
            listdata.add(map);
        }

         listitem =  new SimpleAdapter(ThirtActivity.this,listdata
                   ,R.layout.file_ergodic, new String[]{"FileName","FileData","FileSize"},
                    new int[]{R.id.file_name_id,R.id.file_data_id,R.id.file_size_id});

        listView.setAdapter(listitem);
        ScaleAnimation sa = new ScaleAnimation(0 ,1, 1,1);
       // sa.setDuration(2000);
        //RotateAnimation sa = new RotateAnimation(67,56,34);
        sa.setDuration(2000);
        listView.setAnimation(sa);


       // listView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ThirtActivity.this,
//                android.R.layout.simple_list_item_1,data);
//        listView.setAdapter(adapter);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
             Log.d(TAG,"" +position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, position+" "+listView.getId());
                Toast.makeText(ThirtActivity.this,listView.getSelectedItemPosition()+"",Toast.LENGTH_SHORT).show();

            }
        });





    }

//    private  Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//            if(mediaPlayer.isPlaying()){
//                handler.postDelayed(this, 1000);
//                 long livetime = mediaPlayer.getCurrentPosition();
//            }
//        }
//
//    };
    private View.OnClickListener onClickListener = new View.OnClickListener() {
     @Override
      public void onClick(View v) {
         switch (v.getId()){
             case R.id.three_bt:
                 Intent intent = new Intent(ThirtActivity.this,FourActivity.class);
                 startActivity(intent);
                 break;
             case R.id.three_tof_bt:
                      for(int i = 0; i < 5;i++){
                          HashMap<String, Object> map = new HashMap<String, Object>();
                          map.put("FileName","ni hao");
                          map.put("FileData","oh no");
                          map.put("FileSize","100");
                          listdata.add(map);
                      }
                      listitem.notifyDataSetChanged();
                 break;
         }

       }
    };


    private  void save () {
        String data = "hahahhha";
        Log.d(TAG,"save.success");
        data.length();
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    public  void GetVideoFileName(String fileAbsolutePath) {
        filename = new ArrayList<String>();
        filedata = new ArrayList<String>();
        filesize = new ArrayList<String>();
        File file = new File(fileAbsolutePath);
        File[] subFile = file.listFiles();

        for (int iFileLength = 0; iFileLength < subFile.length; iFileLength++) {
            // 判断是否为文件夹
            if (!subFile[iFileLength].isDirectory()) {
                String filename1 = subFile[iFileLength].getName();
                // 判断是否为MP4结尾
                //  if (filename.trim().toLowerCase().endsWith(".mp4")) {
                filename.add(filename1);
                File f = new File(fileAbsolutePath+"/"+filename1);

                String time = new SimpleDateFormat("yyyy-MM-dd HH:mm")
                        .format(new Date(f.lastModified()));
                filedata.add(time);
                String filesiza = ShowLongFileSzie(f.length());
                filesize.add(filesiza);
                Log.d(TAG, filename1+"    " +time  +  "      " +filesiza);
                //}
            }
        }
        //return vecFile;
    }

    public String ShowLongFileSzie(Long length) {
        if (length >= 1048576) {
            return (length / 1048576) + "MB";
        } else if (length >= 1024) {
            return (length / 1024) + "KB";
        } else if (length < 1024) {
            return length + "B";
        } else {
            return "0KB";
        }
    }


}
