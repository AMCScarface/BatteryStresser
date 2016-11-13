package com.example.sscata.myapplication;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;

/**
 * Created by sscata on 12/11/16.
 */

public class VibrationActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        // Vibrate for 400 milliseconds
        v.vibrate(10000);

        this.setContentView(R.layout.activity_vibration);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 13000);
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
