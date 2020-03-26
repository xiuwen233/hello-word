package com.funtion.androidtestforstrong;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class PvrPlayerActivity extends Activity {

    private MediaPlayer mediaPlayer ;
    private SurfaceView surfaceView ;
    int p = 4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_player);
        surfaceView = (SurfaceView)findViewById(R.id.surfaceview_id);
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_NORMAL);
        surfaceView.getHolder().setKeepScreenOn(true);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if(p>6){
                    mediaPlayer.seekTo(p);
                    p =0;
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.setDisplay(surfaceView.getHolder());
        try {
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.start();
    }

    @Override
    protected void onPause() {
        if(mediaPlayer.isPlaying()){
            p = mediaPlayer.getCurrentPosition();
            mediaPlayer.stop();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        //mediaPlayer.isPlaying()
        if(mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        super.onDestroy();
    }
}
