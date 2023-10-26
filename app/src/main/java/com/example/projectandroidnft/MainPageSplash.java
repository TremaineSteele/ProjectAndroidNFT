package com.example.projectandroidnft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainPageSplash extends AppCompatActivity {
    private static final int SPLASH_DUR = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page_splash);

        //need a handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //create Intent

                Intent intent = new Intent(MainPageSplash.this, LogInActivity.class);
                startActivity(intent);
                finish();

            }
        },SPLASH_DUR);

    }
}