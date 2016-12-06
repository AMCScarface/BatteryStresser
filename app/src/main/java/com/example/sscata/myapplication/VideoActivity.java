package com.example.sscata.myapplication;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.VideoView;

/**
 * Created by sscata on 13/11/16.
 */

public class VideoActivity extends Activity {

    private VideoView myVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_video);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        myVideoView = (VideoView) findViewById(R.id.videoView);
        myVideoView.requestFocus();
        myVideoView.start();

        myVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.nebula));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 35000);
    }

    // Call back when the activity is going into the background
    @Override
    protected void onPause() {
        super.onPause();
    }

    // Call back after onPause()
    @Override
    protected void onResume() {
        super.onResume();
    }
}
