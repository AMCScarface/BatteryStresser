package com.example.sscata.myapplication;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Handler;

/**
 * Our OpenGL program's main activity
 */
public class MyGLActivity extends Activity {

    private GLSurfaceView glView;   // Use GLSurfaceView

    // Call back when the activity is started, to initialize the view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        glView = new GLSurfaceView(this);           // Allocate a GLSurfaceView
        glView.setRenderer(new MyGLRenderer(this)); // Use a custom renderer
        this.setContentView(glView);                // This activity sets to GLSurfaceView

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 120000);
    }

    // Call back when the activity is going into the background
    @Override
    protected void onPause() {
        super.onPause();
        glView.onPause();
    }

    // Call back after onPause()
    @Override
    protected void onResume() {
        super.onResume();
        glView.onResume();
    }
}
