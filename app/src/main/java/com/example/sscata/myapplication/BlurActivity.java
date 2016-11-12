package com.example.sscata.myapplication;

/**
 * Created by sscata on 12/11/16.
 */

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.widget.ImageView;

public class BlurActivity extends Activity {

    // Call back when the activity is started, to initialize the view
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.setContentView(R.layout.activity_blur);

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
