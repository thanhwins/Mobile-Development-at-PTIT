package com.example.samsung.tracnghiem.Control;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.samsung.tracnghiem.Model.Geography;
import com.example.samsung.tracnghiem.Model.Physics;
import com.example.samsung.tracnghiem.Model.technology;
import com.example.samsung.tracnghiem.Model.History;
import com.example.samsung.tracnghiem.Model.Literality;
import com.example.samsung.tracnghiem.Model.general;
import com.example.samsung.tracnghiem.Model.Music;
import com.example.samsung.tracnghiem.Model.maths;
import com.example.samsung.tracnghiem.Model.Movie;
import com.example.samsung.tracnghiem.Model.sports;
import com.example.samsung.tracnghiem.R;
import com.github.lzyzsd.circleprogress.DonutProgress;

import java.util.ArrayList;
import java.util.Collections;

public class Questions extends AppCompatActivity {
    DonutProgress donutProgress;
    int variable = 0;
    TextView ques;
    Button OptA, OptB, OptC, OptD;
    Button play_button;
    String get;
    //Objects of different classes
    Geography Geography;
    sports Sports;
    History History;
    technology Technology;
    Physics Physics;
    Literality Literality;
    general General;
    Music Music;
    maths Maths;
    Movie Movie;
    public int visibility = 0, c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0, c7 = 0, c8 = 0, c9 = 0, c10 = 0, i, j = 0, k = 0, l = 0;
    String global = null, Ques, Opta, Optb, Optc, Optd;
    ArrayList<Integer> list = new ArrayList<Integer>();
    Toast toast;
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer1;
    public  int num=0;

    private  static final String TAG = "Check stop working";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences shared = getSharedPreferences("Score", Context.MODE_PRIVATE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();//recieving the intent send by the Navigation activity
        get = intent.getStringExtra(Navigation_Activity.Message);//converting that intent message to string using the getStringExtra() method
        toast = new Toast(this);
        //attribute of the circular progress bar
        donutProgress = (DonutProgress) findViewById(R.id.donut_progress);
        donutProgress.setMax(100);
        donutProgress.setFinishedStrokeColor(Color.parseColor("#FFFB385F"));
        donutProgress.setTextColor(Color.parseColor("#FFFB385F"));
        donutProgress.setKeepScreenOn(true);
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        //To play background sound
        if (sp.getInt("Sound", 0) == 0) {
            mediaPlayer = MediaPlayer.create(this, R.raw.abc);
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }

        //Now the linking of all the datbase files with the Question activity
        Geography = new Geography(this);
        Geography.createDatabase();
        Geography.openDatabase();
        Geography.getWritableDatabase();

        Physics = new Physics(this);
        Physics.createDatabase();
        Physics.openDatabase();
        Physics.getWritableDatabase();

        Technology = new technology(this);
        Technology.createDatabase();
        Technology.openDatabase();
        Technology.getWritableDatabase();

        History = new History(this);
        History.createDatabase();
        History.openDatabase();
        History.getWritableDatabase();

        Literality = new Literality(this);
        Literality.createDatabase();
        Literality.openDatabase();
        Literality.getWritableDatabase();

        General = new general(this);
        General.createDatabase();
        General.openDatabase();
        General.getWritableDatabase();

        Music = new Music(this);
        Music.createDatabase();
        Music.openDatabase();
        Music.getWritableDatabase();

        Maths = new maths(this);
        Maths.createDatabase();
        Maths.openDatabase();
        Maths.getWritableDatabase();

        Movie = new Movie(this);
        Movie.createDatabase();
        Movie.openDatabase();
        Movie.getWritableDatabase();

        Sports = new sports(this);
        Sports.createDatabase();
        Sports.openDatabase();
        Sports.getWritableDatabase();
        //Till here we are linking the database file
        OptA = (Button) findViewById(R.id.OptionA);
        OptB = (Button) findViewById(R.id.OptionB);
        OptC = (Button) findViewById(R.id.OptionC);
        OptD = (Button) findViewById(R.id.OptionD);
        ques = (TextView) findViewById(R.id.Questions);
        play_button = (Button) findViewById(R.id.play_button);//Play button to start the game

    }


    public void onClick(View v) {//When this method is executed then there will be new question came and also same method for play button
        final SharedPreferences shared = getSharedPreferences("Score", Context.MODE_PRIVATE);
        k++;
        if(k==20)
        {
            toast.cancel();
            Log.d(TAG,"Thanh.......");
            SharedPreferences.Editor editor = shared.edit();
            editor.putInt("Questions", k-1).commit();
            if (get.equals("c1") && shared.getInt("Technology", 0) < l)
                editor.putInt("Technology", l * 10).apply();
            else if (get.equals("c2") && shared.getInt("Sports", 0) < l)
                editor.putInt("Sports", l * 10).apply();
            else if (get.equals("c3") && shared.getInt("Music", 0) < l)
                editor.putInt("Music", l * 10).apply();
            else if (get.equals("c4") && shared.getInt("General", 0) < l)
                editor.putInt("General", l * 10).apply();
            else if (get.equals("c5") && shared.getInt("Movie", 0) < l)
                editor.putInt("Movie", l * 10).apply();
            else if (get.equals("c6") && shared.getInt("Literality", 0) < l)
                editor.putInt("Literality", l * 10).apply();
            else if (get.equals("c7") && shared.getInt("Geography", 0) < l)
                editor.putInt("Geography", l * 10).apply();
            else if (get.equals("c8") && shared.getInt("Maths", 0) < l)
                editor.putInt("Maths", l * 10).apply();
            else if (get.equals("c9") && shared.getInt("Physics", 0) < l)
                editor.putInt("Physics", l * 10).apply();
            else if (get.equals("c10") && shared.getInt("History", 0) < l)
                editor.putInt("History", l * 10).apply();
            donutProgress.setProgress(0);
            Intent intent = new Intent(Questions.this, Result.class);
            intent.putExtra("correct", l);
            intent.putExtra("attemp", k-1);
            startActivity(intent);
            finish();
        }
        if (visibility == 0) {
            //showing the buttons which were previously invisible
            OptA.setVisibility(View.VISIBLE);
            OptB.setVisibility(View.VISIBLE);
            OptC.setVisibility(View.VISIBLE);
            OptD.setVisibility(View.VISIBLE);
            play_button.setVisibility(View.GONE);
            donutProgress.setVisibility(View.VISIBLE);
            visibility = 1;
            num++;

            new CountDownTimer(50000, 1000) {//countdowntimer
                int i = 100;

                @Override
                public void onTick(long millisUntilFinished) {
                    i = i - 2;
                    donutProgress.setProgress(i);


                }

                @Override
                public void onFinish() {
                    toast.cancel();
                    SharedPreferences.Editor editor = shared.edit();//here we are saving the data when the countdown timer will finish and it is saved in shared prefrence file that is defined in onCreate method as score
                    editor.putInt("Questions", k).commit();
                    if (get.equals("c1") && shared.getInt("Technology", 0) < l)
                        editor.putInt("Technology", l * 10).apply();
                    else if (get.equals("c2") && shared.getInt("Sports", 0) < l)
                        editor.putInt("Sports", l * 10).apply();
                    else if (get.equals("c3") && shared.getInt("Music", 0) < l)
                        editor.putInt("Music", l * 10).apply();
                    else if (get.equals("c4") && shared.getInt("General", 0) < l)
                        editor.putInt("General", l * 10).apply();
                    else if (get.equals("c5") && shared.getInt("Movie", 0) < l)
                        editor.putInt("Movie", l * 10).apply();
                    else if (get.equals("c6") && shared.getInt("Literality", 0) < l)
                        editor.putInt("Literality", l * 10).apply();
                    else if (get.equals("c7") && shared.getInt("Geography", 0) < l)
                        editor.putInt("Geography", l * 10).apply();
                    else if (get.equals("c8") && shared.getInt("Maths", 0) < l)
                        editor.putInt("Maths", l * 10).apply();
                    else if (get.equals("c9") && shared.getInt("Physics", 0) < l)
                        editor.putInt("Physics", l * 10).apply();
                    else if (get.equals("c10") && shared.getInt("History", 0) < l)
                        editor.putInt("History", l * 10).apply();
                    donutProgress.setProgress(0);
                    if (variable == 0) {
                        Intent intent = new Intent(Questions.this, Result.class);
                        intent.putExtra("correct", l);
                        intent.putExtra("attemp", k-1);
                        startActivity(intent);
                        finish();
                    }
                }



            }.start();
        }

        if (global != null) {
            if (global.equals("A")) {

                if (v.getId() == R.id.OptionA) {
                    //Here we use the snackbar because if we use the toast then they will be stacked an user cannot idetify which questions answer is it showing
                    Snackbar.make(v, "         Chính xác ☺", Snackbar.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
                    if (sp.getInt("Sound", 0) == 0) {
                        mediaPlayer = MediaPlayer.create(this, R.raw.nhacdung);
                        mediaPlayer.start();
                    }

                    l++;
                } else {
                    Snackbar.make(v, "Sai rồi (╥﹏╥)\t      Đáp án đúng : " + Opta + "", Snackbar.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);

                    if (sp.getInt("Sound", 0) == 0  && mediaPlayer!=null) {
                        mediaPlayer.release();
                        mediaPlayer=null;
                        mediaPlayer = MediaPlayer.create(this, R.raw.nhacsai);
                        mediaPlayer.start();
                    }
                }

            } else if (global.equals("B")) {

                if (v.getId() == R.id.OptionB) {
                    Snackbar.make(v, "          Chính xác ☺", Snackbar.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
                    if (sp.getInt("Sound", 0) == 0) {
                        mediaPlayer = MediaPlayer.create(this, R.raw.nhacdung);
                        mediaPlayer.start();
                    }
                    l++;
                } else {
                    SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);

                    if (sp.getInt("Sound", 0) == 0  && mediaPlayer!=null) {
                        mediaPlayer.release();
                        mediaPlayer=null;
                        mediaPlayer = MediaPlayer.create(this, R.raw.nhacsai);
                        mediaPlayer.start();
                    }
                    Snackbar.make(v, "Sai rồi (╥﹏╥)\t      Đáp án đúng : " + Optb + "", Snackbar.LENGTH_SHORT).show();
                }

            } else if (global.equals("C")) {

                if (v.getId() == R.id.OptionC) {

                    Snackbar.make(v, "         Chính xác ☺", Snackbar.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
                    if (sp.getInt("Sound", 0) == 0) {
                        mediaPlayer = MediaPlayer.create(this, R.raw.nhacdung);
                        mediaPlayer.start();
                    }

                    l++;

                } else {
                    SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);

                    if (sp.getInt("Sound", 0) == 0  && mediaPlayer!=null) {
                        mediaPlayer.release();
                        mediaPlayer=null;
                        mediaPlayer = MediaPlayer.create(this, R.raw.nhacsai);
                        mediaPlayer.start();
                    }
                    Snackbar.make(v, "Sai rồi (╥﹏╥)\t      Đáp án đúng : " + Optc + "", Snackbar.LENGTH_SHORT).show();
                }

            } else if (global.equals("D")) {

                if (v.getId() == R.id.OptionD) {
                    Snackbar.make(v, "        Chính xác ☺", Snackbar.LENGTH_SHORT).show();
                    SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
                    if (sp.getInt("Sound", 0) == 0) {
                        mediaPlayer = MediaPlayer.create(this, R.raw.nhacdung);
                        mediaPlayer.start();
                    }

                    l++;
                } else {
                    SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);

                    if (sp.getInt("Sound", 0) == 0  && mediaPlayer!=null) {
                        mediaPlayer.release();
                        mediaPlayer=null;
                        mediaPlayer = MediaPlayer.create(this, R.raw.nhacsai);
                        mediaPlayer.start();
                    }
                    Snackbar.make(v, "Sai rồi (╥﹏╥)\t      Đáp án đúng : " + Optd + "", Snackbar.LENGTH_SHORT).show();


                }
            }
        }
        if (get.equals("c1")) {

            if (c1 == 0) {
                for (i = 1; i <= 30; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c1 = 1;
            }


            Ques = Technology.readQuestion(list.get(j));
            Opta = Technology.readOptionA(list.get(j));
            Optb = Technology.readOptionB(list.get(j));
            Optc = Technology.readOptionC(list.get(j));
            Optd = Technology.readOptionD(list.get(j));
            global = Technology.readAnswer(list.get(j++));
        } else if (get.equals("c2")) {
            if (c2 == 0) {
                for (i = 1; i <= 25; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c2 = 1;
            }
            Ques = Sports.readQuestion(list.get(j));
            Opta = Sports.readOptionA(list.get(j));
            Optb = Sports.readOptionB(list.get(j));
            Optc = Sports.readOptionC(list.get(j));
            Optd = Sports.readOptionD(list.get(j));
            global = Sports.readAnswer(list.get(j++));

        } else if (get.equals("c3")) {
            if (c3 == 0) {
                for (i = 1; i <= 25; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c3 = 1;
            }
            Ques = Music.readQuestion(list.get(j));
            Opta = Music.readOptionA(list.get(j));
            Optb = Music.readOptionB(list.get(j));
            Optc = Music.readOptionC(list.get(j));
            Optd = Music.readOptionD(list.get(j));
            global = Music.readAnswer(list.get(j++));
        } else if (get.equals("c4")) {
            if (c4 == 0) {
                for (i = 1; i <= 25; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c4 = 1;
            }
            Ques = General.readQuestion(list.get(j));
            Opta = General.readOptionA(list.get(j));
            Optb = General.readOptionB(list.get(j));
            Optc = General.readOptionC(list.get(j));
            Optd = General.readOptionD(list.get(j));
            global = General.readAnswer(list.get(j++));
        } else if (get.equals("c5")) {
            if (c5 == 0) {
                for (i = 1; i <= 30; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c5 = 1;
            }
            Ques = Movie.readQuestion(list.get(j));
            Opta = Movie.readOptionA(list.get(j));
            Optb = Movie.readOptionB(list.get(j));
            Optc = Movie.readOptionC(list.get(j));
            Optd = Movie.readOptionD(list.get(j));
            global = Movie.readAnswer(list.get(j++));
        } else if (get.equals("c6")) {
            if (c6 == 0) {
                for (i = 1; i <= 27; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c6 = 1;
            }
            Ques = Literality.readQuestion(list.get(j));
            Opta = Literality.readOptionA(list.get(j));
            Optb = Literality.readOptionB(list.get(j));
            Optc = Literality.readOptionC(list.get(j));
            Optd = Literality.readOptionD(list.get(j));
            global = Literality.readAnswer(list.get(j++));

        } else if (get.equals("c7")) {
            if (c7 == 0) {
                for (i = 1; i <= 22; i++) {
                    list.add(new Integer(i));
                }
                //Collections.shuffle(list);
                c7 = 1;
            }
            Ques = Geography.readQuestion(list.get(j));
            Opta = Geography.readOptionA(list.get(j));
            Optb = Geography.readOptionB(list.get(j));
            Optc = Geography.readOptionC(list.get(j));
            Optd = Geography.readOptionD(list.get(j));
            global = Geography.readAnswer(list.get(j++));
        } else if (get.equals("c8")) {
            if (c8 == 0) {
                for (i = 1; i <= 26; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c8 = 1;
            }
            Ques = Maths.readQuestion(list.get(j));
            Opta = Maths.readOptionA(list.get(j));
            Optb = Maths.readOptionB(list.get(j));
            Optc = Maths.readOptionC(list.get(j));
            Optd = Maths.readOptionD(list.get(j));
            global = Maths.readAnswer(list.get(j++));
        } else if (get.equals("c9")) {
            if (c9 == 0) {
                for (i = 1; i <= 35; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c9 = 1;
            }
            Ques = Physics.readQuestion(list.get(j));
            Opta = Physics.readOptionA(list.get(j));
            Optb = Physics.readOptionB(list.get(j));
            Optc = Physics.readOptionC(list.get(j));
            Optd = Physics.readOptionD(list.get(j));
            global = Physics.readAnswer(list.get(j++));
        } else if (get.equals("c10")) {
            if (c10 == 0) {
                for (i = 1; i <= 30; i++) {
                    list.add(new Integer(i));
                }
                Collections.shuffle(list);
                c10 = 1;
            }
            Ques = History.readQuestion(list.get(j));
            Opta = History.readOptionA(list.get(j));
            Optb = History.readOptionB(list.get(j));
            Optc = History.readOptionC(list.get(j));
            Optd = History.readOptionD(list.get(j));
            global = History.readAnswer(list.get(j++));
        }
        ques.setText("" + Ques);
        OptA.setText(Opta);
        OptB.setText(Optb);
        OptC.setText(Optc);
        OptD.setText(Optd);
    }

    @Override
    protected void onPause() {
        super.onPause();
        variable = 1;
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        variable = 1;
        SharedPreferences sp = getSharedPreferences("Score", Context.MODE_PRIVATE);
        if (sp.getInt("Sound", 0) == 0)
            mediaPlayer.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        variable = 1;
        finish();
    }
}
