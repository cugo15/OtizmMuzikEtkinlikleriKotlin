package com.aecg.oyunvemuzikae.Sesler;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ScrollView;

import com.aecg.oyunvemuzikae.MainActivity;
import com.aecg.oyunvemuzikae.R;
import com.aecg.oyunvemuzikae.databinding.ActivityInsanSeslerBinding;

public class InsanSesler extends AppCompatActivity {
    private ActivityInsanSeslerBinding binding;
    Animation animationzoom;
    private  View decorView;
      MediaPlayer mediaPlayererkek;
      MediaPlayer mediaPlayererkekcocuk;
      MediaPlayer mediaPlayerkadin;
      MediaPlayer mediaPlayerkizcocuk;
      MediaPlayer mediaPlayerkalabalikortam;
      MediaPlayer mediaPlayerbebek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInsanSeslerBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
           mediaPlayererkek = MediaPlayer.create(this, R.raw.erkekses);
           mediaPlayererkekcocuk = MediaPlayer.create(this,R.raw.cocukses);
           mediaPlayerkadin = MediaPlayer.create(this,R.raw.kadin);
           mediaPlayerkizcocuk = MediaPlayer.create(this,R.raw.kizcocukses);
           mediaPlayerkalabalikortam = MediaPlayer.create(this,R.raw.sehir);
           mediaPlayerbebek = MediaPlayer.create(this,R.raw.bebek);
        animationzoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_inshort);
        decorView=getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if(i==0){
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        binding.Geritusuinsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hayvansesdurdur(mediaPlayerbebek,mediaPlayerkalabalikortam,mediaPlayererkek,mediaPlayererkekcocuk,mediaPlayerkizcocuk,mediaPlayerkadin);
                Intent intent = new Intent(InsanSesler.this, SesMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.Anasayfayadoninsan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hayvansesdurdur(mediaPlayerbebek,mediaPlayerkalabalikortam,mediaPlayererkek,mediaPlayererkekcocuk,mediaPlayerkizcocuk,mediaPlayerkadin);
                Intent intent = new Intent(InsanSesler.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.insanscrollgeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.insanscroll.arrowScroll(ScrollView.FOCUS_LEFT);

            }
        });
        binding.insanscrollileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.insanscroll.arrowScroll(ScrollView.FOCUS_RIGHT);

            }
        });
        binding.bebekcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.bebekcard.startAnimation(animationzoom);
                hayvansesbaslatma(mediaPlayerbebek,mediaPlayerkalabalikortam,mediaPlayererkek,mediaPlayererkekcocuk,mediaPlayerkizcocuk,mediaPlayerkadin);

            }
        });

        binding.erkekcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.erkekcard.startAnimation(animationzoom);
                hayvansesbaslatma(mediaPlayererkek,mediaPlayerbebek,mediaPlayerkalabalikortam,mediaPlayererkekcocuk,mediaPlayerkizcocuk,mediaPlayerkadin);

            }
        });

        binding.erkekcocukcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.erkekcocukcard.startAnimation(animationzoom);
                hayvansesbaslatma(mediaPlayererkekcocuk,mediaPlayerbebek,mediaPlayererkek,mediaPlayerkalabalikortam,mediaPlayerkizcocuk,mediaPlayerkadin);

            }
        });

        binding.kizcocukcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.kizcocukcard.startAnimation(animationzoom);
                hayvansesbaslatma(mediaPlayerkizcocuk,mediaPlayerbebek,mediaPlayererkek,mediaPlayererkekcocuk,mediaPlayerkalabalikortam,mediaPlayerkadin);

            }
        });

        binding.kadincard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.kadincard.startAnimation(animationzoom);
                hayvansesbaslatma(mediaPlayerkadin,mediaPlayerbebek,mediaPlayererkek,mediaPlayererkekcocuk,mediaPlayerkizcocuk,mediaPlayerkalabalikortam);

            }
        });


    }
    public void hayvansesbaslatma(MediaPlayer playingone, MediaPlayer b, MediaPlayer c, MediaPlayer d, MediaPlayer e, MediaPlayer f){
        if(b.isPlaying()==true){
            b.pause();
            b.seekTo(0);
            playingone.start();
        } else if (c.isPlaying()==true) {
            c.pause();
            c.seekTo(0);
            playingone.start();
        }
        else if (d.isPlaying()==true) {
            d.pause();
            d.seekTo(0);
            playingone.start();
        }
        else if (e.isPlaying()) {
            e.pause();
            e.seekTo(0);
            playingone.start();
        }
        else if (f.isPlaying()) {
            f.pause();
            f.seekTo(0);
            playingone.start();
        }
        else{
            playingone.seekTo(0);
            playingone.start();
        }
    }
    public void hayvansesdurdur(MediaPlayer a,MediaPlayer b,MediaPlayer c,MediaPlayer d,MediaPlayer e, MediaPlayer f){
        if(a.isPlaying()==true){
            a.pause();
            a.seekTo(0);
        } else if (b.isPlaying()==true) {
            b.pause();
            b.seekTo(0);
        } else if (c.isPlaying()==true) {
            c.pause();
            c.seekTo(0);
        }
        else if (d.isPlaying()==true) {
            d.pause();
            d.seekTo(0);}
        else if (e.isPlaying()==true){
            e.pause();
            e.seekTo(0);
        }
        else if (e.isPlaying()==true){
            f.pause();
            f.seekTo(0);
        }
        else{}
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
    @Override
    protected void onPause() {
        hayvansesdurdur(mediaPlayerbebek,mediaPlayerkalabalikortam,mediaPlayererkek,mediaPlayererkekcocuk,mediaPlayerkizcocuk,mediaPlayerkadin);


        super.onPause();
    }

    @Override
    protected void onStop() {
        hayvansesdurdur(mediaPlayerbebek,mediaPlayerkalabalikortam,mediaPlayererkek,mediaPlayererkekcocuk,mediaPlayerkizcocuk,mediaPlayerkadin);

        super.onStop();
    }
}