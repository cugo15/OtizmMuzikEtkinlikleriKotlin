package com.aecg.oyunvemuzikae.HizliYavasOyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.aecg.oyunvemuzikae.ui.MainActivity;
import com.aecg.oyunvemuzikae.OyunlarMenu;
import com.aecg.oyunvemuzikae.R;
import com.aecg.oyunvemuzikae.databinding.ActivityHizliYavasTrompetBinding;

import java.util.Random;

public class HizliYavasTrompet extends AppCompatActivity {
    private ActivityHizliYavasTrompetBinding binding;
    Boolean hizlihizlipiyano = false;
    Boolean hizliyavaspiyano = false;
    Boolean yavashizlipiyano = false;
    Boolean yavasyavaspiyano = false;
    Animation animation;
    Animation animationzoom;
    MediaPlayer mediaPlayerdogrucevap;
    MediaPlayer mediaPlayeryanliscevap;
    MediaPlayer hizlisoru;
    MediaPlayer yavassoru;
    MediaPlayer ikincisoru;
    MediaPlayer hizlitempolu;
    MediaPlayer yavastempolu;
    MediaPlayer yavasmuzk;
    MediaPlayer hizlimuzk;
    private  View decorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHizliYavasTrompetBinding.inflate(getLayoutInflater());
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
        animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink_ani);
        animationzoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);


        mediaPlayeryanliscevap = MediaPlayer.create(this,R.raw.yanliscevap);
        mediaPlayerdogrucevap = MediaPlayer.create(this,R.raw.tebriklerdogrucevap);

        hizlisoru = MediaPlayer.create(this,R.raw.hizliolanibul);

        yavassoru = MediaPlayer.create(this, R.raw.yavasolanibul);

        ikincisoru = MediaPlayer.create(this,R.raw.ikincmuzik);

        hizlitempolu = MediaPlayer.create(this,R.raw.hizlitempo);

        yavastempolu = MediaPlayer.create(this,R.raw.yavastempo);

        yavasmuzk = MediaPlayer.create(this, R.raw.yavastrompetses);

        hizlimuzk = MediaPlayer.create(this, R.raw.hizlitrompetses);

        int dogrucevapsure = mediaPlayerdogrucevap.getDuration();
        int yavasmuzksure = yavasmuzk.getDuration();
        int hizlimuzksure = hizlimuzk.getDuration();

        binding.Anasayfayadontrompetoyunu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(HizliYavasTrompet.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.Geritusutrompetoyunu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(HizliYavasTrompet.this, OyunlarMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        Random random = new Random();
        int r = random.nextInt(4);
        if(r==0){
            //hizli müzikle baslayan
            binding.trompetsoru.setText("Hızlı olan müziği bulabilir misin ?");
            hizlihizlipiyano = true;
            hizliyavaspiyano = false;
        }
        if(r==1){
            //yavasla baslayan
            binding.trompetsoru.setText("Hızlı olan müziği bulabilir misin ?");
            hizliyavaspiyano = true;
            hizlihizlipiyano = false;
        }
        if(r==2){
            //hizli müzikle baslayan
            binding.trompetsoru.setText("Yavaş olan müziği bulabilir misin ?");
            yavashizlipiyano = true;
            yavasyavaspiyano = false;
        }
        if(r==3){
            //yavaş müzikle baslayan
            binding.trompetsoru.setText("Yavaş olan müziği bulabilir misin ?");
            yavasyavaspiyano = true;
            yavashizlipiyano = false;
        }
        if(hizlihizlipiyano==true){
            binding.trompet1cimuzik.setEnabled(false);
            binding.trompet2cimuzik.setEnabled(false);
            hizlisoru.start();
            hizlisoru.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    hizlimuzk.start();
                    Handler handlerhizlihizli = new Handler();
                    Runnable runablehizlihizli = new Runnable() {
                        @Override
                        public void run() {
                            binding.imageView3.setVisibility(View.VISIBLE);
                            binding.imageView3.startAnimation(animation);
                        }
                    };handlerhizlihizli.postDelayed(runablehizlihizli,3000);
                    hizlimuzk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            binding.imageView3.clearAnimation();
                            binding.imageView3.setVisibility(View.GONE);
                            ikincisoru.start();
                            ikincisoru.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    yavasmuzk.start();
                                    Handler handlerhizlihizli = new Handler();
                                    Runnable runablehizlihizli = new Runnable() {
                                        @Override
                                        public void run() {
                                            binding.imageView2.setVisibility(View.VISIBLE);
                                            binding.imageView2.startAnimation(animation);
                                        }
                                    };handlerhizlihizli.postDelayed(runablehizlihizli,3000);
                                    yavasmuzk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mediaPlayer) {
                                            binding.imageView2.clearAnimation();
                                            binding.imageView2.setVisibility(View.GONE);
                                            hizlitempolu.start();
                                            hizlitempolu.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                @Override
                                                public void onCompletion(MediaPlayer mediaPlayer) {
                                                    binding.trompet1cimuzik.setEnabled(true);
                                                    binding.trompet2cimuzik.setEnabled(true);
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });

            binding.imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hizlimuzk.seekTo(hizlimuzksure);
                    binding.imageView3.clearAnimation();
                    binding.imageView3.setVisibility(View.GONE);
                }
            });
            binding.imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    yavasmuzk.seekTo(yavasmuzksure);
                    binding.imageView2.clearAnimation();
                    binding.imageView2.setVisibility(View.GONE);
                }
            });
            binding.trompet1cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.trompet1cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                    binding.trompet2cimuzik.setClickable(false);
                    binding.trompet1cimuzik.setClickable(false);

                    binding.cvphy.startAnimation(animationzoom);
                    mediaPlayerdogrucevap.start();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            seskes();
                            Intent intent = new Intent(HizliYavasTrompet.this, HizliYavasMozart.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(intent);
                        }
                    },dogrucevapsure);

                }
            });
            binding.trompet2cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.trompet2cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
            });

        }
        if(hizliyavaspiyano==true){
            binding.trompet1cimuzik.setEnabled(false);
            binding.trompet2cimuzik.setEnabled(false);
            hizlisoru.start();
            hizlisoru.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    yavasmuzk.start();
                    Handler handlerhizlihizli = new Handler();
                    Runnable runablehizlihizli = new Runnable() {
                        @Override
                        public void run() {
                            binding.imageView3.setVisibility(View.VISIBLE);
                            binding.imageView3.startAnimation(animation);
                        }
                    };handlerhizlihizli.postDelayed(runablehizlihizli,3000);
                    yavasmuzk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            binding.imageView3.clearAnimation();
                            binding.imageView3.setVisibility(View.GONE);
                            ikincisoru.start();
                            ikincisoru.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    hizlimuzk.start();
                                    Handler handlerhizlihizli = new Handler();
                                    Runnable runablehizlihizli = new Runnable() {
                                        @Override
                                        public void run() {
                                            binding.imageView2.setVisibility(View.VISIBLE);
                                            binding.imageView2.startAnimation(animation);
                                        }
                                    };handlerhizlihizli.postDelayed(runablehizlihizli,3000);
                                    hizlimuzk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mediaPlayer) {
                                            binding.imageView2.clearAnimation();
                                            binding.imageView2.setVisibility(View.GONE);
                                            hizlitempolu.start();
                                            hizlitempolu.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                @Override
                                                public void onCompletion(MediaPlayer mediaPlayer) {
                                                    binding.trompet1cimuzik.setEnabled(true);
                                                    binding.trompet2cimuzik.setEnabled(true);
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });

            binding.imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    yavasmuzk.seekTo(yavasmuzksure);
                    binding.imageView3.clearAnimation();
                    binding.imageView3.setVisibility(View.GONE);
                }
            });
            binding.imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hizlimuzk.seekTo(hizlimuzksure);
                    binding.imageView2.clearAnimation();
                    binding.imageView2.setVisibility(View.GONE);
                }
            });
            binding.trompet2cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.trompet2cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                    binding.trompet2cimuzik.setClickable(false);
                    binding.trompet1cimuzik.setClickable(false);
                    binding.cvphy.startAnimation(animationzoom);

                    mediaPlayerdogrucevap.start();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            seskes();
                            Intent intent = new Intent(HizliYavasTrompet.this, HizliYavasMozart.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(intent);
                        }
                    },dogrucevapsure);

                }
            });
            binding.trompet1cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.trompet1cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
            });
        }
        if(yavashizlipiyano==true){
            binding.trompet1cimuzik.setEnabled(false);
            binding.trompet2cimuzik.setEnabled(false);
            yavassoru.start();
            yavassoru.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    hizlimuzk.start();
                    Handler handlerhizlihizli = new Handler();
                    Runnable runablehizlihizli = new Runnable() {
                        @Override
                        public void run() {
                            binding.imageView3.setVisibility(View.VISIBLE);
                            binding.imageView3.startAnimation(animation);
                        }
                    };handlerhizlihizli.postDelayed(runablehizlihizli,3000);
                    hizlimuzk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            binding.imageView3.clearAnimation();
                            binding.imageView3.setVisibility(View.GONE);
                            ikincisoru.start();
                            ikincisoru.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    yavasmuzk.start();
                                    Handler handlerhizlihizli = new Handler();
                                    Runnable runablehizlihizli = new Runnable() {
                                        @Override
                                        public void run() {
                                            binding.imageView2.setVisibility(View.VISIBLE);
                                            binding.imageView2.startAnimation(animation);
                                        }
                                    };handlerhizlihizli.postDelayed(runablehizlihizli,3000);
                                    yavasmuzk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mediaPlayer) {
                                            binding.imageView2.clearAnimation();
                                            binding.imageView2.setVisibility(View.GONE);
                                            yavastempolu.start();
                                            yavastempolu.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                @Override
                                                public void onCompletion(MediaPlayer mediaPlayer) {
                                                    binding.trompet1cimuzik.setEnabled(true);
                                                    binding.trompet2cimuzik.setEnabled(true);
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });

            binding.imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hizlimuzk.seekTo(hizlimuzksure);
                    binding.imageView3.clearAnimation();
                    binding.imageView3.setVisibility(View.GONE);
                }
            });
            binding.imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    yavasmuzk.seekTo(yavasmuzksure);
                    binding.imageView2.clearAnimation();
                    binding.imageView2.setVisibility(View.GONE);
                }
            });
            binding.trompet2cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.trompet2cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                    binding.trompet2cimuzik.setClickable(false);
                    binding.trompet1cimuzik.setClickable(false);
                    binding.cvphy.startAnimation(animationzoom);

                    mediaPlayerdogrucevap.start();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            seskes();
                            Intent intent = new Intent(HizliYavasTrompet.this, HizliYavasMozart.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(intent);
                        }
                    },dogrucevapsure);

                }
            });
            binding.trompet1cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.trompet1cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
            });
        }
        if(yavasyavaspiyano==true){


            binding.trompet1cimuzik.setEnabled(false);
            binding.trompet2cimuzik.setEnabled(false);
            yavassoru.start();
            yavassoru.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    yavasmuzk.start();
                    Handler handlerhizlihizli = new Handler();
                    Runnable runablehizlihizli = new Runnable() {
                        @Override
                        public void run() {
                            binding.imageView3.setVisibility(View.VISIBLE);
                            binding.imageView3.startAnimation(animation);
                        }
                    };handlerhizlihizli.postDelayed(runablehizlihizli,3000);
                    yavasmuzk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            binding.imageView3.clearAnimation();
                            binding.imageView3.setVisibility(View.GONE);
                            ikincisoru.start();
                            ikincisoru.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    hizlimuzk.start();
                                    Handler handlerhizlihizli = new Handler();
                                    Runnable runablehizlihizli = new Runnable() {
                                        @Override
                                        public void run() {
                                            binding.imageView2.setVisibility(View.VISIBLE);
                                            binding.imageView2.startAnimation(animation);
                                        }
                                    };handlerhizlihizli.postDelayed(runablehizlihizli,3000);
                                    hizlimuzk.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                        @Override
                                        public void onCompletion(MediaPlayer mediaPlayer) {
                                            binding.imageView2.clearAnimation();
                                            binding.imageView2.setVisibility(View.GONE);
                                            yavastempolu.start();
                                            yavastempolu.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                                @Override
                                                public void onCompletion(MediaPlayer mediaPlayer) {
                                                    binding.trompet1cimuzik.setEnabled(true);
                                                    binding.trompet2cimuzik.setEnabled(true);
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            });

            binding.imageView3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    yavasmuzk.seekTo(yavasmuzksure);
                    binding.imageView3.clearAnimation();
                    binding.imageView3.setVisibility(View.GONE);
                }
            });
            binding.imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    hizlimuzk.seekTo(hizlimuzksure);
                    binding.imageView2.clearAnimation();
                    binding.imageView2.setVisibility(View.GONE);
                }
            });
            binding.trompet1cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.trompet1cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                    binding.trompet2cimuzik.setClickable(false);
                    binding.trompet1cimuzik.setClickable(false);
                    binding.cvphy.startAnimation(animationzoom);
                    mediaPlayerdogrucevap.start();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            seskes();
                            Intent intent = new Intent(HizliYavasTrompet.this, HizliYavasMozart.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(intent);
                        }
                    },dogrucevapsure);

                }
            });
            binding.trompet2cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.trompet2cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                }
            });
        }
    }
    public void seskes() {
        if(hizlisoru!=null){
            hizlisoru.stop();
            hizlisoru.release();
            hizlisoru = null;
        }
        if(yavassoru!=null){
            yavassoru.stop();
            yavassoru.release();
            yavassoru = null;
        }
        if(ikincisoru!=null){
            ikincisoru.stop();
            ikincisoru.release();
            ikincisoru = null;
        }
        if(hizlitempolu!=null){
            hizlitempolu.stop();
            hizlitempolu.release();
            hizlitempolu = null;
        }
        if(yavastempolu!=null){
            yavastempolu.stop();
            yavastempolu.release();
            yavastempolu = null;
        }
        if(hizlimuzk!=null){
            hizlimuzk.stop();
            hizlimuzk.release();
            hizlimuzk = null;
        }
        if(yavasmuzk!=null){
            yavasmuzk.stop();
            yavasmuzk.release();
            yavasmuzk = null;
        }
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
    @Override
    protected void onPause() {
        seskes();

        super.onPause();
    }

    @Override
    protected void onStop() {
        seskes();
        super.onStop();
    }
}