package com.example.samsung.tracnghiem.Control;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.samsung.tracnghiem.R;

public class Setting_activity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final SharedPreferences sharedPreferences = getSharedPreferences("Score", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final Button sound = (Button) findViewById(R.id.play_sound);
        Button reset = (Button) findViewById(R.id.reset);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (sharedPreferences.getInt("Sound", 0) == 0) {
            sound.setText("Tắt nhạc");
            mediaPlayer = MediaPlayer.create(this, R.raw.abc);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        } else
            sound.setText("Chơi nhạc");
        sound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sound.getText().equals("Chơi nhạc")) {
                    editor.putInt("Sound", 0).commit();
                    sound.setText("Tắt nhạc");

                    mediaPlayer = MediaPlayer.create(Setting_activity.this, R.raw.abc);
                    mediaPlayer.start();
                    mediaPlayer.setLooping(true);
                } else if (sound.getText().equals("Tắt nhạc")) {
                    editor.putInt("Sound", 1).commit();
                    sound.setText("Chơi nhạc");
                    mediaPlayer.stop();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putInt("Technology", 0);
                editor.putInt("Sports", 0);
                editor.putInt("Music", 0);
                editor.putInt("General", 0);
                editor.putInt("Movie", 0);
                editor.putInt("Literality", 0);
                editor.putInt("Geography", 0);
                editor.putInt("Maths", 0);
                editor.putInt("Physics", 0);
                editor.putInt("History", 0);
                editor.commit();
                Snackbar.make(v,"Highscore Reseted Successfully",Snackbar.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        //finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.start();
    }

}

