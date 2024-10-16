package com.aecg.oyunvemuzikae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;

import com.aecg.oyunvemuzikae.Sesler.InsanSesler;
import com.aecg.oyunvemuzikae.Sesler.SesMenu;
import com.aecg.oyunvemuzikae.databinding.ActivityMainBinding;
import com.aecg.oyunvemuzikae.databinding.ActivityMuziklerBinding;

public class Muzikler extends AppCompatActivity {
    private ActivityMuziklerBinding binding;
    private  View decorView;
    MediaPlayer merhaba;
    MediaPlayer ucboyutlucisimler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMuziklerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        merhaba = MediaPlayer.create(this, R.raw.merhabasarkisi);
        ucboyutlucisimler = MediaPlayer.create(this,R.raw.ucboyutlucisimler);

        decorView=getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if(i==0){
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        binding.ucboyutimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hayvansesdurdur(ucboyutlucisimler,merhaba);
                hayvansesbaslatma(ucboyutlucisimler,merhaba);
            }
        });
        binding.merhabaimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hayvansesdurdur(ucboyutlucisimler,merhaba);
                hayvansesbaslatma(merhaba,ucboyutlucisimler);
            }
        });
        binding.Geritususesmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hayvansesdurdur(ucboyutlucisimler,merhaba);
                Intent intent = new Intent(Muzikler.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.Anasayfayadonsesmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hayvansesdurdur(ucboyutlucisimler,merhaba);
                Intent intent = new Intent(Muzikler.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.karaokeimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hayvansesdurdur(ucboyutlucisimler,merhaba);
                Intent intent = new Intent(Muzikler.this, MrbKareoke.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.alkisimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hayvansesdurdur(ucboyutlucisimler,merhaba);
                Intent intent = new Intent(Muzikler.this, AlkisVeTahta.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.cardd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hayvansesdurdur(ucboyutlucisimler,merhaba);
                Intent intent = new Intent(Muzikler.this, GeriSaymaVid.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.sesmenuscrollgeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.sesmenuscroll.arrowScroll(ScrollView.FOCUS_LEFT);
            }
        });
        binding.sesmenuscrollileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.sesmenuscroll.arrowScroll(ScrollView.FOCUS_RIGHT);

            }
        });
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
    public void hayvansesbaslatma(MediaPlayer playingone, MediaPlayer b){
        if(b.isPlaying()==true){
            b.pause();
            b.seekTo(0);
            playingone.start();
        }
        else{
            playingone.seekTo(0);
            playingone.start();
        }
    }
    public void hayvansesdurdur(MediaPlayer a,MediaPlayer b){
        if(a.isPlaying()==true){
            a.pause();
            a.seekTo(0);
        } else if (b.isPlaying()==true) {
            b.pause();
            b.seekTo(0);
        }
        else{}
    }
    @Override
    protected void onPause() {
        hayvansesdurdur(ucboyutlucisimler,merhaba);


        super.onPause();
    }

    @Override
    protected void onStop() {
        hayvansesdurdur(ucboyutlucisimler,merhaba);

        super.onStop();
    }
}