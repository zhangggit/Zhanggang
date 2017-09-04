package com.bwie.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button, button_jia, button_jian;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button_color);
        button_jia = (Button) findViewById(R.id.button_jia);
        button_jian = (Button) findViewById(R.id.button_jian);
        imageView = (ImageView) findViewById(R.id.imageview);

        final Animation animation = AnimationUtils.loadAnimation(this, R.anim.sel);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        animation.setInterpolator(linearInterpolator);
        imageView.startAnimation(animation);

        //加速
        button_jia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation.setInterpolator(new AccelerateInterpolator());
            }
        });
        //减速
        button_jian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                animation.setInterpolator(new DecelerateInterpolator());
            }
        });


    }
}
