package com.alexurangareyes.mysqlite;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class IntroActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    private Runnable afterExe;

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        handler.postDelayed(new Runnable() {
            public void run() {

                YoYo.with(Techniques.Tada).duration(1000).playOn(findViewById(R.id.image_logo));
                //mediaPlayer.start();
                handler.postDelayed(afterExe, 1500);
            }
        }, 1500);

        afterExe = new Runnable() {
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        };

    }
}
