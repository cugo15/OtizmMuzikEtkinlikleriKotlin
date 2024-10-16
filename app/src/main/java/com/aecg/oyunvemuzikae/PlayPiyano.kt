package com.aecg.oyunvemuzikae;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

import com.aecg.oyunvemuzikae.R;
import com.aecg.oyunvemuzikae.databinding.ActivityMainBinding;
import com.aecg.oyunvemuzikae.databinding.ActivityPlayPiyanoBinding;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PlayPiyano extends AppCompatActivity  {

    private ActivityPlayPiyanoBinding binding;
    int c =0;
    int d =0;
    private  View decorView;

    //recordpath
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPlayPiyanoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        decorView=getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if(i==0){
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });
        binding.pianoscro.setScrolling(false);
        tumdiez();

        final MediaPlayer mediaPlayerk1 = MediaPlayer.create(this, R.raw.kirmizi3_1);
        final MediaPlayer mediaPlayerk2 = MediaPlayer.create(this, R.raw.kirmizi3_2);
        final MediaPlayer mediaPlayerk3 = MediaPlayer.create(this,R.raw.kirmizi3_3);
        final MediaPlayer mediaPlayerk4 = MediaPlayer.create(this,R.raw.kirmizi3_4);
        final MediaPlayer mediaPlayerk5 = MediaPlayer.create(this,R.raw.kirmizi3_5);
        final MediaPlayer mediaPlayerk6 = MediaPlayer.create(this,R.raw.kirmizi3_6);
        final MediaPlayer mediaPlayerk7 = MediaPlayer.create(this,R.raw.kirmizi3_7);
        final MediaPlayer mediaPlayerk8 = MediaPlayer.create(this,R.raw.kirmizi3_8);
        final MediaPlayer mediaPlayerk9 = MediaPlayer.create(this,R.raw.kirmizi3_9);
        final MediaPlayer mediaPlayerk10 = MediaPlayer.create(this, R.raw.kirmizi3_10);
        final MediaPlayer mediaPlayerk11 = MediaPlayer.create(this, R.raw.kirmizi3_11);
        final MediaPlayer mediaPlayerk12 = MediaPlayer.create(this, R.raw.kirmizi3_12);
        final MediaPlayer mediaPlayers1 = MediaPlayer.create(this, R.raw.sari2_1);
        final MediaPlayer mediaPlayers2 = MediaPlayer.create(this, R.raw.sari2_2);
        final MediaPlayer mediaPlayers3 = MediaPlayer.create(this,R.raw.sari2_3);
        final MediaPlayer mediaPlayers4 = MediaPlayer.create(this,R.raw.sari2_4);
        final MediaPlayer mediaPlayers5 = MediaPlayer.create(this,R.raw.sari2_5);
        final MediaPlayer mediaPlayers6 = MediaPlayer.create(this,R.raw.sari2_6);
        final MediaPlayer mediaPlayers7 = MediaPlayer.create(this,R.raw.sari2_7);
        final MediaPlayer mediaPlayers8 = MediaPlayer.create(this,R.raw.sari2_8);
        final MediaPlayer mediaPlayers9 = MediaPlayer.create(this,R.raw.sari2_9);
        final MediaPlayer mediaPlayers10 = MediaPlayer.create(this, R.raw.sari2_10);
        final MediaPlayer mediaPlayers11 = MediaPlayer.create(this, R.raw.sari2_11);
        final MediaPlayer mediaPlayers12 = MediaPlayer.create(this, R.raw.sari2_12);
        final MediaPlayer mediaPlayerm1 = MediaPlayer.create(this, R.raw.mavi4_1);
        final MediaPlayer mediaPlayerm2 = MediaPlayer.create(this, R.raw.mavi4_2);
        final MediaPlayer mediaPlayerm3 = MediaPlayer.create(this,R.raw.mavi4_3);
        final MediaPlayer mediaPlayerm4 = MediaPlayer.create(this,R.raw.mavi4_4);
        final MediaPlayer mediaPlayerm5 = MediaPlayer.create(this,R.raw.mavi4_5);
        final MediaPlayer mediaPlayerm6 = MediaPlayer.create(this,R.raw.mavi4_6);
        final MediaPlayer mediaPlayerm7 = MediaPlayer.create(this,R.raw.mavi4_7);
        final MediaPlayer mediaPlayerm8 = MediaPlayer.create(this,R.raw.mavi4_8);
        final MediaPlayer mediaPlayerm9 = MediaPlayer.create(this,R.raw.mavi4_9);
        final MediaPlayer mediaPlayerm10 = MediaPlayer.create(this, R.raw.mavi4_10);
        final MediaPlayer mediaPlayerm11 = MediaPlayer.create(this, R.raw.mavi4_11);
        final MediaPlayer mediaPlayerm12 = MediaPlayer.create(this, R.raw.mavi4_12);
        final MediaPlayer mediaPlayermor1 = MediaPlayer.create(this, R.raw.mor5_1);
        final MediaPlayer mediaPlayermor2 = MediaPlayer.create(this, R.raw.mor5_2);
        final MediaPlayer mediaPlayermor3 = MediaPlayer.create(this,R.raw.mor5_3);
        final MediaPlayer mediaPlayermor4 = MediaPlayer.create(this,R.raw.mor5_4);
        final MediaPlayer mediaPlayermor5 = MediaPlayer.create(this,R.raw.mor5_5);
        final MediaPlayer mediaPlayermor6 = MediaPlayer.create(this,R.raw.mor5_6);
        final MediaPlayer mediaPlayermor7 = MediaPlayer.create(this,R.raw.mor5_7);
        final MediaPlayer mediaPlayermor8 = MediaPlayer.create(this,R.raw.mor5_8);
        final MediaPlayer mediaPlayermor9 = MediaPlayer.create(this,R.raw.mor5_9);
        final MediaPlayer mediaPlayermor10 = MediaPlayer.create(this, R.raw.mor5_10);
        final MediaPlayer mediaPlayermor11 = MediaPlayer.create(this, R.raw.mor5_11);
        final MediaPlayer mediaPlayermor12 = MediaPlayer.create(this, R.raw.mor5_12);
        final MediaPlayer mediaPlayery1 = MediaPlayer.create(this, R.raw.yesil6_1);
        final MediaPlayer mediaPlayery2 = MediaPlayer.create(this, R.raw.yesil6_2);
        final MediaPlayer mediaPlayery3 = MediaPlayer.create(this,R.raw.yesil6_3);
        final MediaPlayer mediaPlayery4 = MediaPlayer.create(this,R.raw.yesil6_4);
        final MediaPlayer mediaPlayery5 = MediaPlayer.create(this,R.raw.yesil6_5);
        final MediaPlayer mediaPlayery6 = MediaPlayer.create(this,R.raw.yesil6_6);
        final MediaPlayer mediaPlayery7 = MediaPlayer.create(this,R.raw.yesil6_7);
        final MediaPlayer mediaPlayery8 = MediaPlayer.create(this,R.raw.yesil6_8);
        final MediaPlayer mediaPlayery9 = MediaPlayer.create(this,R.raw.yesil6_9);
        final MediaPlayer mediaPlayery10 = MediaPlayer.create(this, R.raw.yesil6_10);
        final MediaPlayer mediaPlayery11 = MediaPlayer.create(this, R.raw.yesil6_11);
        final MediaPlayer mediaPlayery12 = MediaPlayer.create(this, R.raw.yesil6_12);
        final MediaPlayer mediaPlayerp1 = MediaPlayer.create(this, R.raw.c7);

        binding.oyunmenudon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(PlayPiyano.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });

        //final MediaPlayer mediaPlayersarif3di

        binding.pianoscro.post(new Runnable() {
            @Override
            public void run() {
            seekpiyanobagla(binding.p15);
            }
        });
        binding.pianoseek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                seekbag2(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        binding.incsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                binding.pianoseek.post(new Runnable() {
                    @Override
                    public void run() {
                        int i = binding.pianoseek.getProgress();
                        incsize();
                        seekbag2(i);
                    }
                });

            }
        });
        binding.decsize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.pianoseek.post(new Runnable() {
                    @Override
                    public void run() {
                        int i = binding.pianoseek.getProgress();
                        decsize();
                        seekbag2(i-1);
                    }
                });
            }
        });
        binding.doremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(binding.p1.getText().equals("")){
                    notatodoremi();
                }

                else if(binding.p1.getText().equals("Do2")){
                    notabos();
                }
                else if(binding.p1.getText().equals("C2")){
                    notatodoremi();
                }
            }
        });
        binding.cdef.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.p1.getText().equals("")){
                    notacdef();
                }
                else if(binding.p1.getText().equals("C2")){
                    notabos();
                }
                else if(binding.p1.getText().equals("Do2")){
                    notacdef();
                }
            }
        });

        binding.rainbow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                c++;
                if(c%2==0){
                    //beyaz
                    beyazlat();
                    notabos();
                }
                else if(c%2!=0){
                    //renkli
                    renklendir();
                }
            }
        });


        binding.p1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers1);
                return false;
            }
        });

        binding.b1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers2);
                return false;
            }
        });

        binding.p2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
            ondown(motionEvent,mediaPlayers3);
                return false;
            }
        });

        binding.b2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers4);
                return false;
            }
        });
        binding.p3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers5);
                return false;
            }
        });
        binding.p4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers6);
                return false;
            }
        });
        binding.b3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers7);
                return false;
            }
        });
        binding.p5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers8);
                return false;
            }
        });
        binding.b4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers9);
                return false;
            }
        });
        binding.p6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers10);
                return false;
            }
        });
        binding.b5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers11);
                return false;
            }
        });
        binding.p7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayers12);
                return false;
            }
        });
        binding.p8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk1);
                return false;
            }
        });
        binding.b6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk2);
                return false;
            }
        });
        binding.p9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk3);
                return false;
            }
        });
        binding.b7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk4);
                return false;
            }
        });
        binding.p10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk5);
                return false;
            }
        });
        binding.p11.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk6);
                return false;
            }
        });
        binding.b8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk7);
                return false;
            }
        });
        binding.p12.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk8);
                return false;
            }
        });
        binding.b9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk9);
                return false;
            }
        });
        binding.p13.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk10);
                return false;
            }
        });
        binding.b10.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk11);
                return false;
            }
        });
        binding.p14.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerk12);
                return false;
            }
        });



        binding.p15.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm1);
                return false;
            }
        });
        binding.b11.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm2);
                return false;
            }
        });
        binding.p16.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm3);
                return false;
            }
        });
        binding.b12.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm4);
                return false;
            }
        });
        binding.p17.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm5);
                return false;
            }
        });
        binding.p18.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm6);
                return false;
            }
        });
        binding.b13.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm7);
                return false;
            }
        });
        binding.p19.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm8);
                return false;
            }
        });
        binding.b14.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm9);
                return false;
            }
        });
        binding.p20.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm10);
                return false;
            }
        });
        binding.b15.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm11);
                return false;
            }
        });
        binding.p21.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerm12);
                return false;
            }
        });

        binding.p22.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor1);
                return false;
            }
        });
        binding.b16.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor2);
                return false;
            }
        });
        binding.p23.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor3);
                return false;
            }
        });
        binding.b17.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor4);
                return false;
            }
        });
        binding.p24.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor5);
                return false;
            }
        });
        binding.p25.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor6);
                return false;
            }
        });
        binding.b18.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor7);
                return false;
            }
        });
        binding.p26.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor8);
                return false;
            }
        });
        binding.b19.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor9);
                return false;
            }
        });
        binding.p27.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor10);
                return false;
            }
        });
        binding.b20.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor11);
                return false;
            }
        });
        binding.p28.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayermor12);
                return false;
            }
        });
        binding.p29.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery1);
                return false;
            }
        });
        binding.b21.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery2);
                return false;
            }
        });
        binding.p30.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery3);
                return false;
            }
        });
        binding.b22.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery4);
                return false;
            }
        });
        binding.p31.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery5);
                return false;
            }
        });
        binding.p32.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery6);
                return false;
            }
        });
        binding.b23.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery7);
                return false;
            }
        });
        binding.p33.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery8);
                return false;
            }
        });
        binding.b24.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery9);
                return false;
            }
        });
        binding.p34.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery10);
                return false;
            }
        });
        binding.b25.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery11);
                return false;
            }
        });
        binding.p35.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayery12);
                return false;
            }
        });
        binding.p36.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ondown(motionEvent,mediaPlayerp1);
                return false;
            }
        });
    }

    private void seskes() {

    }



    public void ondown (MotionEvent event, MediaPlayer ses){
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if(ses.isPlaying()){
                ses.pause();
                ses.seekTo(0);
            }
            ses.start();
        }
        if(event.getAction() == MotionEvent.ACTION_MOVE){
        }
    }
    public void seekpiyanobagla(Button a){
        binding.pianolayout.post(new Runnable() {
            @Override
            public void run() {
                int x,y;
                x = a.getLeft();
                y = a.getTop();
                binding.pianoscro.scrollTo(x,y);
            }
        });
    }
    public void diezilkboyut(Button diez){
        binding.p1.post(new Runnable() {
            @Override
            public void run() {
                int height = (binding.p1.getHeight()*3)/5;
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) diez.getLayoutParams();
                params.height = height;
                diez.setLayoutParams(params);
            }
        });
    }
    public void tumdiez(){
        diezilkboyut(binding.b1);diezilkboyut(binding.b2);diezilkboyut(binding.b3);diezilkboyut(binding.b4);
        diezilkboyut(binding.b5);diezilkboyut(binding.b6);diezilkboyut(binding.b7);diezilkboyut(binding.b8);
        diezilkboyut(binding.b9);diezilkboyut(binding.b10);diezilkboyut(binding.b11);diezilkboyut(binding.b12);
        diezilkboyut(binding.b13);diezilkboyut(binding.b14);diezilkboyut(binding.b15);diezilkboyut(binding.b16);
        diezilkboyut(binding.b17);diezilkboyut(binding.b18);diezilkboyut(binding.b19);diezilkboyut(binding.b20);
        diezilkboyut(binding.b21);diezilkboyut(binding.b22);diezilkboyut(binding.b23);diezilkboyut(binding.b24);
        diezilkboyut(binding.b25);
    }
    public void increasesizep(Button buttonp){
        binding.p1.post(new Runnable() {
            @Override
            public void run() {
                int widthp = buttonp.getWidth()+9;
                RelativeLayout.LayoutParams paramsp = (RelativeLayout.LayoutParams) buttonp.getLayoutParams();
                paramsp.width = widthp;
                buttonp.setLayoutParams(paramsp);
            }
        });
    }
    public void increasesizeb(Button buttonb){
        binding.p1.post(new Runnable() {
            @Override
            public void run() {
                int widthb = buttonb.getWidth()+6;
                RelativeLayout.LayoutParams paramsb = (RelativeLayout.LayoutParams) buttonb.getLayoutParams();
                paramsb.width = widthb;
                buttonb.setLayoutParams(paramsb);
            }
        });
    }
    public void decsizep(Button buttonp){
        binding.p1.post(new Runnable() {
            @Override
            public void run() {
                int widthp = buttonp.getWidth()-9;
                RelativeLayout.LayoutParams paramsp = (RelativeLayout.LayoutParams) buttonp.getLayoutParams();
                paramsp.width = widthp;
                buttonp.setLayoutParams(paramsp);
            }
        });
    }
    public void decsizeb(Button buttonb){
        binding.p1.post(new Runnable() {
            @Override
            public void run() {
                int widthb = buttonb.getWidth()-6;
                RelativeLayout.LayoutParams paramsb = (RelativeLayout.LayoutParams) buttonb.getLayoutParams();
                paramsb.width = widthb;
                buttonb.setLayoutParams(paramsb);
            }
        });
    }
    public void incsize(){
        increasesizeb(binding.b1);increasesizeb(binding.b2);increasesizeb(binding.b3);increasesizeb(binding.b4);
        increasesizeb(binding.b5);increasesizeb(binding.b6);increasesizeb(binding.b7);increasesizeb(binding.b8);
        increasesizeb(binding.b9);increasesizeb(binding.b10);increasesizeb(binding.b11);increasesizeb(binding.b12);
        increasesizeb(binding.b13);increasesizeb(binding.b14);increasesizeb(binding.b15);increasesizeb(binding.b16);
        increasesizeb(binding.b17);increasesizeb(binding.b18);increasesizeb(binding.b19);increasesizeb(binding.b20);
        increasesizeb(binding.b21);increasesizeb(binding.b22);increasesizeb(binding.b23);increasesizeb(binding.b24);
        increasesizeb(binding.b25);

        increasesizep(binding.p1);increasesizep(binding.p2);increasesizep(binding.p3);increasesizep(binding.p4);
        increasesizep(binding.p5);increasesizep(binding.p6);increasesizep(binding.p7);increasesizep(binding.p8);
        increasesizep(binding.p9);increasesizep(binding.p10);increasesizep(binding.p11);increasesizep(binding.p12);
        increasesizep(binding.p13);increasesizep(binding.p14);increasesizep(binding.p15);increasesizep(binding.p16);
        increasesizep(binding.p17);increasesizep(binding.p18);increasesizep(binding.p19);increasesizep(binding.p20);
        increasesizep(binding.p21);increasesizep(binding.p22);increasesizep(binding.p23);increasesizep(binding.p24);
        increasesizep(binding.p25);increasesizep(binding.p26);increasesizep(binding.p27);increasesizep(binding.p28);increasesizep(binding.p29);
        increasesizep(binding.p31);increasesizep(binding.p32);increasesizep(binding.p33);increasesizep(binding.p34);
        increasesizep(binding.p30);increasesizep(binding.p35);increasesizep(binding.p36);
    }
    public void decsize(){
        decsizeb(binding.b1);decsizeb(binding.b2);decsizeb(binding.b3);decsizeb(binding.b4);
        decsizeb(binding.b5);decsizeb(binding.b6);decsizeb(binding.b7);decsizeb(binding.b8);
        decsizeb(binding.b9);decsizeb(binding.b10);decsizeb(binding.b11);decsizeb(binding.b12);
        decsizeb(binding.b13);decsizeb(binding.b14);decsizeb(binding.b15);decsizeb(binding.b16);
        decsizeb(binding.b17);decsizeb(binding.b18);decsizeb(binding.b19);decsizeb(binding.b20);
        decsizeb(binding.b21);decsizeb(binding.b22);decsizeb(binding.b23);decsizeb(binding.b24);
        decsizeb(binding.b25);

        decsizep(binding.p1);decsizep(binding.p2);decsizep(binding.p3);decsizep(binding.p4);
        decsizep(binding.p5);decsizep(binding.p6);decsizep(binding.p7);decsizep(binding.p8);
        decsizep(binding.p9);decsizep(binding.p10);decsizep(binding.p11);decsizep(binding.p12);
        decsizep(binding.p13);decsizep(binding.p14);decsizep(binding.p15);decsizep(binding.p16);
        decsizep(binding.p17);decsizep(binding.p18);decsizep(binding.p19);decsizep(binding.p20);
        decsizep(binding.p21);decsizep(binding.p22);decsizep(binding.p23);decsizep(binding.p24);
        decsizep(binding.p25);decsizep(binding.p26);decsizep(binding.p27);decsizep(binding.p28);decsizep(binding.p29);
        decsizep(binding.p31);decsizep(binding.p32);decsizep(binding.p33);decsizep(binding.p34);
        decsizep(binding.p30);decsizep(binding.p35);decsizep(binding.p36);
    }
    public void seekbag2(int i){
        if(i==0){seekpiyanobagla(binding.p1);}
        if(i==1){seekpiyanobagla(binding.p2);}
        if(i==2){seekpiyanobagla(binding.p3);}
        if(i==3){seekpiyanobagla(binding.p4);}
        if(i==4){seekpiyanobagla(binding.p5);}
        if(i==5){seekpiyanobagla(binding.p6);}
        if(i==6){seekpiyanobagla(binding.p7);}
        if(i==7){seekpiyanobagla(binding.p8);}
        if(i==8){seekpiyanobagla(binding.p9);}
        if(i==9){seekpiyanobagla(binding.p10);}
        if(i==10){seekpiyanobagla(binding.p11);}
        if(i==11){seekpiyanobagla(binding.p12);}
        if(i==12){seekpiyanobagla(binding.p13);}
        if(i==13){seekpiyanobagla(binding.p14);}
        if(i==14){seekpiyanobagla(binding.p15);}
        if(i==15){seekpiyanobagla(binding.p16);}
        if(i==16){seekpiyanobagla(binding.p17);}
        if(i==17){seekpiyanobagla(binding.p18);}
        if(i==18){seekpiyanobagla(binding.p19);}
        if(i==19){seekpiyanobagla(binding.p20);}
        if(i==20){seekpiyanobagla(binding.p21);}
        if(i==21){seekpiyanobagla(binding.p22);}
        if(i==22){seekpiyanobagla(binding.p23);}
        if(i==23){seekpiyanobagla(binding.p24);}
        if(i==24){seekpiyanobagla(binding.p25);}
        if(i==25){seekpiyanobagla(binding.p26);}
        if(i==26){seekpiyanobagla(binding.p27);}
        if(i==27){seekpiyanobagla(binding.p28);}
        if(i==28){seekpiyanobagla(binding.p29);}
        if(i==29){seekpiyanobagla(binding.p30);}
        if(i==30){seekpiyanobagla(binding.p31);}
        if(i==31){seekpiyanobagla(binding.p32);}
        if(i==32){seekpiyanobagla(binding.p33);}
        if(i==33){seekpiyanobagla(binding.p34);}
        if(i==34){seekpiyanobagla(binding.p35);}
        if(i==35){seekpiyanobagla(binding.p36);}
        if(i==36){seekpiyanobagla(binding.p36);}
    }
    public void notatodoremi(){
        binding.p1.setText("Do2");
        binding.p2.setText("Re2");
        binding.p3.setText("Mi2");
        binding.p4.setText("Fa2");
        binding.p5.setText("Sol2");
        binding.p6.setText("La2");
        binding.p7.setText("Si2");

        binding.p8.setText("Do3");
        binding.p9.setText("Re3");
        binding.p10.setText("Mi3");
        binding.p11.setText("Fa3");
        binding.p12.setText("Sol3");
        binding.p13.setText("La3");
        binding.p14.setText("Si3");

        binding.p15.setText("Do4");
        binding.p16.setText("Re4");
        binding.p17.setText("Mi4");
        binding.p18.setText("Fa4");
        binding.p19.setText("Sol4");
        binding.p20.setText("La4");
        binding.p21.setText("Si4");

        binding.p22.setText("Do5");
        binding.p23.setText("Re5");
        binding.p24.setText("Mi5");
        binding.p25.setText("Fa5");
        binding.p26.setText("Sol5");
        binding.p27.setText("La5");
        binding.p28.setText("Si5");

        binding.p29.setText("Do6");
        binding.p30.setText("Re6");
        binding.p31.setText("Mi6");
        binding.p32.setText("Fa6");
        binding.p33.setText("Sol6");
        binding.p34.setText("La6");
        binding.p35.setText("Si6");

        binding.p36.setText("Do7");
    }
    public void notacdef(){
        binding.p1.setText("C2");
        binding.p2.setText("D2");
        binding.p3.setText("E2");
        binding.p4.setText("F2");
        binding.p5.setText("G2");
        binding.p6.setText("A2");
        binding.p7.setText("B2");

        binding.p8.setText("C3");
        binding.p9.setText("D3");
        binding.p10.setText("E3");
        binding.p11.setText("F3");
        binding.p12.setText("G3");
        binding.p13.setText("A3");
        binding.p14.setText("B3");

        binding.p15.setText("C4");
        binding.p16.setText("D4");
        binding.p17.setText("E4");
        binding.p18.setText("F4");
        binding.p19.setText("G4");
        binding.p20.setText("A4");
        binding.p21.setText("B4");

        binding.p22.setText("C5");
        binding.p23.setText("D5");
        binding.p24.setText("E5");
        binding.p25.setText("F5");
        binding.p26.setText("G5");
        binding.p27.setText("A5");
        binding.p28.setText("B5");

        binding.p29.setText("C6");
        binding.p30.setText("D6");
        binding.p31.setText("E6");
        binding.p32.setText("F6");
        binding.p33.setText("G6");
        binding.p34.setText("A6");
        binding.p35.setText("B6");

        binding.p36.setText("C7");
    }
    public void notabos(){
        binding.p1.setText("");
        binding.p2.setText("");
        binding.p3.setText("");
        binding.p4.setText("");
        binding.p5.setText("");
        binding.p6.setText("");
        binding.p7.setText("");

        binding.p8.setText("");
        binding.p9.setText("");
        binding.p10.setText("");
        binding.p11.setText("");
        binding.p12.setText("");
        binding.p13.setText("");
        binding.p14.setText("");

        binding.p15.setText("");
        binding.p16.setText("");
        binding.p17.setText("");
        binding.p18.setText("");
        binding.p19.setText("");
        binding.p20.setText("");
        binding.p21.setText("");

        binding.p22.setText("");
        binding.p23.setText("");
        binding.p24.setText("");
        binding.p25.setText("");
        binding.p26.setText("");
        binding.p27.setText("");
        binding.p28.setText("");

        binding.p29.setText("");
        binding.p30.setText("");
        binding.p31.setText("");
        binding.p32.setText("");
        binding.p33.setText("");
        binding.p34.setText("");
        binding.p35.setText("");

        binding.p36.setText("");
    }
    public void renklendir(){
        binding.p1.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_kirmizi));
        binding.p2.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_yesil));
        binding.p3.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_mor));
        binding.p4.setBackgroundDrawable(getDrawable(R.drawable.key_pressed_sari));
        binding.p5.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_mavi));
        binding.p6.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_pembe));
        binding.p7.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_gri));

        binding.p8.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_kirmizi));
        binding.p9.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_yesil));
        binding.p10.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_mor));
        binding.p11.setBackgroundDrawable(getDrawable(R.drawable.key_pressed_sari));
        binding.p12.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_mavi));
        binding.p13.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_pembe));
        binding.p14.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_gri));

        binding.p15.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_kirmizi));
        binding.p16.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_yesil));
        binding.p17.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_mor));
        binding.p18.setBackgroundDrawable(getDrawable(R.drawable.key_pressed_sari));
        binding.p19.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_mavi));
        binding.p20.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_pembe));
        binding.p21.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_gri));

        binding.p22.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_kirmizi));
        binding.p23.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_yesil));
        binding.p24.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_mor));
        binding.p25.setBackgroundDrawable(getDrawable(R.drawable.key_pressed_sari));
        binding.p26.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_mavi));
        binding.p27.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_pembe));
        binding.p28.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_gri));

        binding.p29.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_kirmizi));
        binding.p30.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_yesil));
        binding.p31.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_mor));
        binding.p32.setBackgroundDrawable(getDrawable(R.drawable.key_pressed_sari));
        binding.p33.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_mavi));
        binding.p34.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_pembe));
        binding.p35.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_gri));

        binding.p36.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector_kirmizi));

    }
    public void beyazlat(){
        binding.p1.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p2.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p3.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p4.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p5.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p6.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p7.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));

        binding.p8.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p9.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p10.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p11.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p12.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p13.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p14.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));

        binding.p15.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p16.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p17.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p18.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p19.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p20.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p21.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
  //pressed_and_normal_selector_yesil
        binding.p22.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p23.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p24.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p25.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p26.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p27.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p28.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));

        binding.p29.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p30.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p31.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p32.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p33.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p34.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
        binding.p35.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));

        binding.p36.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector));
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            decorView.setSystemUiVisibility(hideSystemBars());
        }
    }

    private int hideSystemBars(){
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN |
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
                View.SYSTEM_UI_FLAG_FULLSCREEN |
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
    }
}