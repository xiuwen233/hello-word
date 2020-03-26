package com.funtion.androidtestforstrong;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

/**
 * Created by Unionman on 2017/11/6.
 */

public class PVRactivity extends AppCompatActivity {
    private final String TAG = "PVRactivity";
    SurfaceView surfaceView ;
    SurfaceHolder surfaceHolder;
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);

        surfaceView = (SurfaceView)findViewById(R.id.surfaceview_id);

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Log.d(TAG,"creat");
                if(mediaPlayer != null) {
                    mediaPlayer.release();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Log.d(TAG,"change");
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                Log.d(TAG,"destroyed");
                if(mediaPlayer != null) {
                    mediaPlayer.release();
                }
            }
        });
       // mediaPlayer.seekTo();

    }



    private  void play(){
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setDisplay(surfaceHolder);
        try {
            mediaPlayer.setDataSource("data/videotest/videotest.mp4");
            mediaPlayer.prepare();

        } catch (IOException e) {
            Log.d(TAG,"the file video is wrong");
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
            }
        });

    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }
        super.onDestroy();
    }
}
