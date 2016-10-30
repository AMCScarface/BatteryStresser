package com.example.sscata.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    CheckBox vibration, gputest, rendering;
    RadioButton duration;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vibration = (CheckBox) findViewById(R.id.cb_vibration);
        gputest = (CheckBox) findViewById(R.id.cb_gputest);
        rendering = (CheckBox) findViewById(R.id.cb_rendering);

        duration = (RadioButton) findViewById(R.id.rb_full);

        start = (Button) findViewById(R.id.bt_start);

        start.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String cat = "";
                if(vibration.isChecked())
                {
                    cat += "vib=on ";
                }

                if(gputest.isChecked())
                {
                    cat += "gpu=on ";
                }

                if(rendering.isChecked())
                {
                    cat += "ren=on ";
                }

                if(duration.isChecked())
                {
                    cat += ">>>>full OK<<<<<";
                }


                Toast.makeText(MainActivity.this, cat, Toast.LENGTH_SHORT).show();
                //else
                //{
                //    Toast.makeText(MainActivity.this,"First checkbox Unchecked", Toast.LENGTH_SHORT).show();
                //}

            }
        });
    }

}
