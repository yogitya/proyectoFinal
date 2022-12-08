package com.example.partituras;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Splash_Screen_Activity extends AppCompatActivity {

    private static int SPLASH = 3000;
    Animation animation;
    private ImageView imageView;
    private TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //ID's
        imageView = findViewById(R.id.imageView);
        appName = findViewById(R.id.appName);

        animation = AnimationUtils.loadAnimation(this,R.anim.animation);
        appName.setAnimation(animation);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent intent = new Intent(Splash_Screen_Activity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH);
    }

}