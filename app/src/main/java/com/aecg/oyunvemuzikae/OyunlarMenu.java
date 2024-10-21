package com.aecg.oyunvemuzikae;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.aecg.oyunvemuzikae.HafizaOyunu.MemoryMap;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulBaglama;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulBateri;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulDavul;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulDef;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulFlut;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulGitar;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulKanun;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulKeman;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulKsilafon;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulMetronom;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulObua;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulPiyano;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulTrombon;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulTrompet;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulUd;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulZil;
import com.aecg.oyunvemuzikae.ResimdenBul.ResimdenBulZurna;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulBaglama;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulBateri;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulDavul;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulDef;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulFlut;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulGitar;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulKanun;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulKeman;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulKsilafon;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulMetronom;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulObua;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulPiyano;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulTrombon;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulTrompet;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulUd;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulZil;
import com.aecg.oyunvemuzikae.SestenBul.SestenBulZurna;
import com.aecg.oyunvemuzikae.databinding.ActivityOyunlarMenuBinding;
import com.aecg.oyunvemuzikae.HizliYavasOyunu.HizliYavasPiyano;
import com.aecg.oyunvemuzikae.ui.MainActivity;

import java.util.ArrayList;
import java.util.Random;

public class OyunlarMenu extends AppCompatActivity {
    private ActivityOyunlarMenuBinding binding;
    private  View decorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOyunlarMenuBinding.inflate(getLayoutInflater());
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
        binding.oyunmenuscrollgeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.oyunmenuscroll.arrowScroll(ScrollView.FOCUS_LEFT);
            }
        });
        binding.oyunmenuscrollileri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.oyunmenuscroll.arrowScroll(ScrollView.FOCUS_RIGHT);

            }
        });

        binding.Anasayfayadonoyunmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OyunlarMenu.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.Geritusuoyunmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OyunlarMenu.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });


       /*
       //deneme sayfasini ac
       binding.resimdenbulimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OyunlarMenu.this, ResimdenBulBaglama.class);
                startActivity(intent);
            }
        });*/


    

        binding.memorygamecard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OyunlarMenu.this, MemoryMap.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });

       binding.resimdenbulimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Class> activitylist = new ArrayList<>();
                activitylist.add(ResimdenBulBaglama.class);
                activitylist.add(ResimdenBulBateri.class);
                activitylist.add(ResimdenBulDavul.class);
                activitylist.add(ResimdenBulDef.class);
                activitylist.add(ResimdenBulFlut.class);
                activitylist.add(ResimdenBulKeman.class);
                activitylist.add(ResimdenBulKsilafon.class);
                activitylist.add(ResimdenBulMetronom.class);
                activitylist.add(ResimdenBulObua.class);
                activitylist.add(ResimdenBulPiyano.class);
                activitylist.add(ResimdenBulTrombon.class);
                activitylist.add(ResimdenBulTrompet.class);
                activitylist.add(ResimdenBulZil.class);
                activitylist.add(ResimdenBulZurna.class);
                activitylist.add(ResimdenBulGitar.class);
                activitylist.add(ResimdenBulUd.class);
                activitylist.add(ResimdenBulKanun.class);
                Random r = new Random();
                int number = r.nextInt(16);
                if(number ==0){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulBaglama.class);
                    activitylist.remove(ResimdenBulBaglama.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==1){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulBateri.class);
                    activitylist.remove(ResimdenBulBateri.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==2){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulDavul.class);
                    activitylist.remove(ResimdenBulDavul.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==3){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulDef.class);
                    activitylist.remove(ResimdenBulDef.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==4){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulFlut.class);
                    activitylist.remove(ResimdenBulFlut.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==5){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulKeman.class);
                    activitylist.remove(ResimdenBulKeman.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==6){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulKsilafon.class);
                    activitylist.remove(ResimdenBulKsilafon.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==7){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulMetronom.class);
                    activitylist.remove(ResimdenBulMetronom.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==8){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulObua.class);
                    activitylist.remove(ResimdenBulObua.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==9){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulPiyano.class);
                    activitylist.remove(ResimdenBulPiyano.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==10){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulTrombon.class);
                    activitylist.remove(ResimdenBulTrombon.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==11){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulTrompet.class);
                    activitylist.remove(ResimdenBulTrompet.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==12){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulZil.class);
                    activitylist.remove(ResimdenBulZil.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==13){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulZurna.class);
                    activitylist.remove(ResimdenBulZurna.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==14){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulBaglama.class);
                    activitylist.remove(ResimdenBulBaglama.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==15){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulUd.class);
                    activitylist.remove(ResimdenBulUd.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
                if(number ==16){
                    Intent intent = new Intent(OyunlarMenu.this, ResimdenBulKanun.class);
                    activitylist.remove(ResimdenBulUd.class);
                    intent.putExtra("ACTIVITY_LIST", activitylist);
                    startActivity(intent);
                }
            }
        });

       binding.sestenbulimg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               ArrayList<Class> activitylist2 = new ArrayList<>();
               activitylist2.add(SestenBulBaglama.class);
               activitylist2.add(SestenBulBateri.class);
               activitylist2.add(SestenBulDavul.class);
               activitylist2.add(SestenBulDef.class);
               activitylist2.add(SestenBulFlut.class);
               activitylist2.add(SestenBulKeman.class);
               activitylist2.add(SestenBulKsilafon.class);
               activitylist2.add(SestenBulMetronom.class);
               activitylist2.add(SestenBulObua.class);
               activitylist2.add(SestenBulPiyano.class);
               activitylist2.add(SestenBulTrombon.class);
               activitylist2.add(SestenBulTrompet.class);
               activitylist2.add(SestenBulZil.class);
               activitylist2.add(SestenBulZurna.class);
               activitylist2.add(SestenBulGitar.class);
               activitylist2.add(SestenBulUd.class);
               activitylist2.add(SestenBulKanun.class);
               Random r = new Random();
               int number = r.nextInt(16);
               if(number ==0){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulBaglama.class);
                   activitylist2.remove(SestenBulBaglama.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==1){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulBateri.class);
                   activitylist2.remove(SestenBulBateri.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==2){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulDavul.class);
                   activitylist2.remove(SestenBulDavul.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==3){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulDef.class);
                   activitylist2.remove(SestenBulDef.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==4){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulFlut.class);
                   activitylist2.remove(SestenBulFlut.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==5){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulKeman.class);
                   activitylist2.remove(SestenBulKeman.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==6){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulKsilafon.class);
                   activitylist2.remove(SestenBulKsilafon.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==7){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulMetronom.class);
                   activitylist2.remove(SestenBulMetronom.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==8){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulObua.class);
                   activitylist2.remove(SestenBulObua.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==9){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulPiyano.class);
                   activitylist2.remove(SestenBulPiyano.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==10){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulTrombon.class);
                   activitylist2.remove(SestenBulTrombon.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==11){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulTrompet.class);
                   activitylist2.remove(SestenBulTrompet.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==12){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulZil.class);
                   activitylist2.remove(SestenBulZil.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==13){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulZurna.class);
                   activitylist2.remove(SestenBulZurna.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==14){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulBaglama.class);
                   activitylist2.remove(SestenBulBaglama.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==15){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulUd.class);
                   activitylist2.remove(SestenBulUd.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
               if(number ==16){
                   Intent intent = new Intent(OyunlarMenu.this, SestenBulKanun.class);
                   activitylist2.remove(SestenBulUd.class);
                   intent.putExtra("ACTIVITY_LIST2", activitylist2);
                   startActivity(intent);
               }
           }
       });


        binding.hizliyavasimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OyunlarMenu.this, HizliYavasPiyano.class);
                startActivity(intent);
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
}