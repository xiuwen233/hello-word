package com.um.videodemo;

import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private String TAG = "demoVideo";
    private SurfaceView surfaceView;
    private TextView textView;
    private Button button;
    private Camera mCamera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = (SurfaceView)findViewById(R.id.surface_id);
        textView = (TextView)findViewById(R.id.text_id);

        button = (Button)findViewById(R.id.video_id);
        button.setOnClickListener(onClickListener);
        surfaceView.getHolder().setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {

            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
               // CameraController.getInstance().openCamera(holder);
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }

    /*private void initSurfaceView(){

       // mSurfaceView = (SurfaceView)findViewById(R.id.surfaceview);
        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                Log.i(TAG,"surfaceCreated");
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
                Log.i(TAG,"surfaceChanged format:"+format+" width:"+width+" height:"+height);

                CameraController.getInstance().openCamera(holder);
                CameraController.getInstance().setPreviewCallbackWithBuffer(new Camera.PreviewCallback() {
                    @Override
                    public void onPreviewFrame(byte[] data, Camera camera) {
                        Log.i(TAG,"onPreviewFrame");

                        //取出数据进行编码

                        //将buffer添加到到摄像头，重复利用
                        camera.addCallbackBuffer(data);
                    }
                });
            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                Log.i(TAG,"surfaceDestroyed");
                CameraController.getInstance().closeCamera();
            }
        });
    }*/

    private View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            switch (view.getId())
            {
                case R.id.video_id:
                    VideoTestShow();
                    break;
                default:
                    break;
            }
        }
    };


    private void VideoTestShow()
    {
        int cameraId = -1;
        int numberOfCameras = Camera.getNumberOfCameras();
        //奇怪不知道为什么获取信息会报错
       // for (int i = 0; i <= numberOfCameras; i++) {
        //    Camera.CameraInfo info = new Camera.CameraInfo();
        //    Log.d(TAG,"get camera info");
        //    Camera.getCameraInfo(i, info);
        //    Log.d(TAG,"get camera info over ");
            //if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
            //   cameraId = i;
            //   break;
            // }
        // }
        textView.setText("检测到摄像头设备有 "+ numberOfCameras + "个"  );
        if( numberOfCameras == 1)
        {
            mCamera = Camera.open(0);
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setPreviewFrameRate(5);
            parameters.setPictureFormat(PixelFormat.JPEG);
            mCamera.setParameters(parameters);
            try {
                mCamera.setPreviewDisplay(surfaceView.getHolder());
            } catch (IOException e) {
                e.printStackTrace();
            }
            mCamera.startPreview();
        }

       // mCamera = Camera.open(cameraId);
    }

}
