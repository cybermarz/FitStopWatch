package com.example.fitstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation focus, btgone, btgtwo;
    ImageView ivsplash;
    TextView tvheader1, tvheader2;
    Button btn;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivsplash = findViewById(R.id.ivsplash);
        tvheader1 = findViewById(R.id.tvheader1);
        tvheader2 = findViewById(R.id.tvheader2);
        btn = findViewById(R.id.btn);

        // Load Animation
        focus = AnimationUtils.loadAnimation(context, R.anim.focus);
        btgone = AnimationUtils.loadAnimation(context,R.anim.btgone);
        btgtwo = AnimationUtils.loadAnimation(context,R.anim.btgtwo);

        // Pass Animation
        ivsplash.startAnimation(focus);
        tvheader1.startAnimation(btgone);
        tvheader2.startAnimation(btgone);
        btn.startAnimation(btgtwo);

        // Pass Event

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(MainActivity.this, StopWatchAct.class);
                a.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(a);
            }
        });


    }
}