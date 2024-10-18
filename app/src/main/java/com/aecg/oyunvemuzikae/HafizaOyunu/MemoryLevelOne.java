package com.aecg.oyunvemuzikae.HafizaOyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.aecg.oyunvemuzikae.MainActivity;
import com.aecg.oyunvemuzikae.R;
import com.aecg.oyunvemuzikae.databinding.ActivityMemoryLevelOneBinding;

import java.util.Random;

public class MemoryLevelOne extends AppCompatActivity {
        private ActivityMemoryLevelOneBinding binding;
        int r;
        int b1 = 0;
        int b2 = 0;
    private  View decorView;
        int selectedimg,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17;
         int dogrucevapsure;
        MediaPlayer mediaPlayerdogrucevap;

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemoryLevelOneBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        decorView=getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            @Override
            public void onSystemUiVisibilityChange(int i) {
                if(i==0){
                    decorView.setSystemUiVisibility(hideSystemBars());
                }
            }
        });
        mediaPlayerdogrucevap = MediaPlayer.create(this,R.raw.dogrucingil);
        dogrucevapsure = mediaPlayerdogrucevap.getDuration();

        setContentView(view);
        Bundle extras = getIntent().getExtras();
        int intentpicker = (Integer) extras.get("LVL1");
        if(intentpicker==1){
            binding.mlo.setText("1");
        }
        else if(intentpicker==2){
            binding.mlo.setText("2");
        }
        else if(intentpicker==3){
            binding.mlo.setText("3");
        }
        else if(intentpicker==4){
            binding.mlo.setText("4");
        }
        else if(intentpicker==5){
            binding.mlo.setText("5");
        }
        binding.mlvl1card.setEnabled(false);
        binding.mlvl1card2.setEnabled(false);
        Handler handler = new Handler();
        Runnable runable = new Runnable() {
            @Override
            public void run() {
                randomimagepicker();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.mlvl1img1.setImageResource(R.drawable.questionmark2);
                        binding.mlvl1img2.setImageResource(R.drawable.questionmark2);
                        binding.mlvl1card.setEnabled(true);
                        binding.mlvl1card2.setEnabled(true);
                    }
                },1000);
            }
        };handler.postDelayed(runable,1000);
        binding.Geritusumlvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(MemoryLevelOne.this, MemoryMap.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.Anasayfayadonmlvl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(MemoryLevelOne.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });

        binding.mlvl1card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b1++;
                binding.mlvl1img1.setImageResource(selectedimg);
                if(b2>0){
                    binding.mlvl1card.setEnabled(false);
                    binding.mlvl1card2.setEnabled(false);
                    Bundle extras = getIntent().getExtras();
                    int intentpicker = (Integer) extras.get("LVL1");
                    sestrue();
                    mediaPlayerdogrucevap.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if(intentpicker==1){
                                Intent intent = new Intent(MemoryLevelOne.this, MemoryLevelOne.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.putExtra("LVL1", 2);
                                startActivity(intent);
                                finish();
                            }
                            else if(intentpicker==2){
                                Intent intent = new Intent(MemoryLevelOne.this, MemoryLevelOne.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.putExtra("LVL1", 3);
                                startActivity(intent);
                                finish();
                            }
                            else if(intentpicker==3){
                                Intent intent = new Intent(MemoryLevelOne.this, MemoryLevelOne.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.putExtra("LVL1", 4);
                                startActivity(intent);
                                finish();
                            }
                            else if(intentpicker==4){
                                Intent intent = new Intent(MemoryLevelOne.this, MemoryLevelOne.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.putExtra("LVL1", 5);
                                startActivity(intent);
                                finish();
                            }
                            else if(intentpicker==5){
                                Intent intent = new Intent(MemoryLevelOne.this, MemoryLevelTwo.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.putExtra("LVL2", 1);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });

                }
            }
        });
        binding.mlvl1card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                b2++;
                binding.mlvl1img2.setImageResource(selectedimg);
                if(b1>0){
                    binding.mlvl1card.setEnabled(false);
                    binding.mlvl1card2.setEnabled(false);
                    Bundle extras = getIntent().getExtras();
                    int intentpicker = (Integer) extras.get("LVL1");
                    sestrue();
                    mediaPlayerdogrucevap.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            if(intentpicker==1){
                                Intent intent = new Intent(MemoryLevelOne.this, MemoryLevelOne.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.putExtra("LVL1", 2);
                                startActivity(intent);
                                finish();
                            }
                            else if(intentpicker==2){
                                Intent intent = new Intent(MemoryLevelOne.this, MemoryLevelOne.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.putExtra("LVL1", 3);
                                startActivity(intent);
                                finish();
                            }
                            else if(intentpicker==3){
                                Intent intent = new Intent(MemoryLevelOne.this, MemoryLevelOne.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.putExtra("LVL1", 4);
                                startActivity(intent);
                                finish();
                            }
                            else if(intentpicker==4){
                                Intent intent = new Intent(MemoryLevelOne.this, MemoryLevelOne.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.putExtra("LVL1", 5);
                                startActivity(intent);
                                finish();
                            }
                            else if(intentpicker==5){
                                Intent intent = new Intent(MemoryLevelOne.this, MemoryLevelTwo.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                                intent.putExtra("LVL2", 1);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });

                }
            }
        });
    }
    public void randomimagepicker(){
        img1 =R.drawable.ic_enstruman_baglama;
        img2 =R.drawable.ic_enstruman_bateri;
        img3 =R.drawable.ic_enstruman_davul;
        img4 =R.drawable.ic_enstruman_def;
        img5 =R.drawable.ic_enstruman_flut;
        img6 =R.drawable.ic_enstruman_gitar;
        img7 =R.drawable.ic_enstruman_kanun;
        img8 =R.drawable.ic_enstruman_keman;
        img9 =R.drawable.ic_enstruman_ksilofon;
        img10 =R.drawable.ic_enstruman_metronom;
        img11 =R.drawable.ic_enstruman_obua;
        img12 =R.drawable.ic_enstruman_piyano;
        img13 =R.drawable.ic_enstruman_trombon;
        img14 =R.drawable.ic_enstruman_trompet;
        img15 =R.drawable.ic_enstruman_ud;
        img16 =R.drawable.ic_enstruman_zil;
        img17 =R.drawable.ic_enstruman_zurna;
        Random generator = new Random();
        r = generator.nextInt(17);
        if(r==0){
            binding.mlvl1img1.setImageResource(img1);
            binding.mlvl1img2.setImageResource(img1);
            selectedimg = img1;
        }
        if(r==1){
            binding.mlvl1img1.setImageResource(img2);
            binding.mlvl1img2.setImageResource(img2);
            selectedimg = img2;
        }
        if(r==2){
            binding.mlvl1img1.setImageResource(img3);
            binding.mlvl1img2.setImageResource(img3);
            selectedimg = img3;
        }
        if(r==3){
            binding.mlvl1img1.setImageResource(img4);
            binding.mlvl1img2.setImageResource(img4);
            selectedimg = img4;
        }
        if(r==4){
            binding.mlvl1img1.setImageResource(img5);
            binding.mlvl1img2.setImageResource(img5);
            selectedimg = img5;
        }
        if(r==5){
            binding.mlvl1img1.setImageResource(img6);
            binding.mlvl1img2.setImageResource(img6);
            selectedimg = img6;
        }
        if(r==6){
            binding.mlvl1img1.setImageResource(img7);
            binding.mlvl1img2.setImageResource(img7);
            selectedimg = img7;
        }
        if(r==7){
            binding.mlvl1img1.setImageResource(img8);
            binding.mlvl1img2.setImageResource(img8);
            selectedimg = img8;
        }
        if(r==8){
            binding.mlvl1img1.setImageResource(img9);
            binding.mlvl1img2.setImageResource(img9);
            selectedimg = img9;
        }
        if(r==9){
            binding.mlvl1img1.setImageResource(img10);
            binding.mlvl1img2.setImageResource(img10);
            selectedimg = img10;
        }
        if(r==10){
            binding.mlvl1img1.setImageResource(img11);
            binding.mlvl1img2.setImageResource(img11);
            selectedimg = img11;
        }
        if(r==11){
            binding.mlvl1img1.setImageResource(img12);
            binding.mlvl1img2.setImageResource(img12);
            selectedimg = img12;
        }
        if(r==12){
            binding.mlvl1img1.setImageResource(img13);
            binding.mlvl1img2.setImageResource(img13);
            selectedimg = img13;
        }
        if(r==13){
            binding.mlvl1img1.setImageResource(img14);
            binding.mlvl1img2.setImageResource(img14);
            selectedimg = img14;
        }
        if(r==14){
            binding.mlvl1img1.setImageResource(img15);
            binding.mlvl1img2.setImageResource(img15);
            selectedimg = img15;
        }
        if(r==15){
            binding.mlvl1img1.setImageResource(img16);
            binding.mlvl1img2.setImageResource(img16);
            selectedimg = img16;
        }
        if(r==16){
            binding.mlvl1img1.setImageResource(img17);
            binding.mlvl1img2.setImageResource(img17);
            selectedimg = img17;
        }
    }
    private void seskes(){

        if(mediaPlayerdogrucevap!=null){
            mediaPlayerdogrucevap.stop();
            mediaPlayerdogrucevap.release();
            mediaPlayerdogrucevap = null;
        }
    }

    private void sestrue(){
        if(mediaPlayerdogrucevap.isPlaying()){
            mediaPlayerdogrucevap.pause();
            mediaPlayerdogrucevap.seekTo(0);
        }
        mediaPlayerdogrucevap.start();
    }
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