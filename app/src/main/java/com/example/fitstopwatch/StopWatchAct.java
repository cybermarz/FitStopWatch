package com.example.fitstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

public class StopWatchAct extends AppCompatActivity {

    Animation roundingalone;
    ImageView ivarrow;
    Button btn, btnstop;
    Chronometer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);



        //Find Variables
        ivarrow = findViewById(R.id.ivarrow);
        btn = findViewById(R.id.btn2);
        btnstop = findViewById(R.id.btn3);
        timer = findViewById(R.id.timer);

        //Load Animation
        btnstop.setAlpha(0);
        roundingalone = AnimationUtils.loadAnimation(this, R.anim.roundingalone);



        // Pass Animation
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivarrow.startAnimation(roundingalone);
                btnstop.animate().alpha(1).translationY(-180).setDuration(300).start();
                btn.animate().alpha(0).setDuration(300).start();
                //Timer
                timer.setBase(SystemClock.elapsedRealtime());
                timer.start();
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //stop animation
                ivarrow.clearAnimation();
                btn.animate().alpha(1).translationY(-80).setDuration(300).start();
                btnstop.animate().alpha(0).setDuration(300).start();
                //stop timer
                timer.stop();
            }
        });




    }
}