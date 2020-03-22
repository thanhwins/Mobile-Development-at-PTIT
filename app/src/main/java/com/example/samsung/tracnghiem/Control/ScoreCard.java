package com.example.samsung.tracnghiem.Control;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.samsung.tracnghiem.R;

public class ScoreCard extends AppCompatActivity {
    TextView a1, a2, a3, a4, a5, a6, a7, a8, a9, a10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_card);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences sharedPreferences = getSharedPreferences("Score", Context.MODE_PRIVATE);
        a1 = (TextView) findViewById(R.id.Technology);
        a2 = (TextView) findViewById(R.id.sports);
        a3 = (TextView) findViewById(R.id.Music);
        a4 = (TextView) findViewById(R.id.general);
        a5 = (TextView) findViewById(R.id.Movie);
        a6 = (TextView) findViewById(R.id.Literality);
        a7 = (TextView) findViewById(R.id.Geography);
        a8 = (TextView) findViewById(R.id.maths);
        a9 = (TextView) findViewById(R.id.Physics);
        a10 = (TextView) findViewById(R.id.History);
        try {
            a1.setText("" + sharedPreferences.getInt("Technology", 0));
            a2.setText("" + sharedPreferences.getInt("Sports", 0));
            a3.setText("" + sharedPreferences.getInt("Music", 0));
            a4.setText("" + sharedPreferences.getInt("General", 0));
            a5.setText("" + sharedPreferences.getInt("Movie", 0));
            a6.setText("" + sharedPreferences.getInt("Literality", 0));
            a7.setText("" + sharedPreferences.getInt("Geography", 0));
            a8.setText("" + sharedPreferences.getInt("Maths", 0));
            a9.setText("" + sharedPreferences.getInt("Physics", 0));
            a10.setText("" + sharedPreferences.getInt("History", 0));
        } catch (Exception e) {
            Toast.makeText(ScoreCard.this, "" + e, Toast.LENGTH_SHORT).show();
        }
    }

}
