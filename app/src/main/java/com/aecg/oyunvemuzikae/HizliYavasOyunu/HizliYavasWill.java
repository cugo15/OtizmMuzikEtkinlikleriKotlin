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
import com.aecg.oyunvemuzikae.databinding.ActivityHizliYavasWillBinding;

import java.util.Random;

public class HizliYavasWill extends AppCompatActivity {
    private ActivityHizliYavasWillBinding binding;
    Boolean hizlihizliwill = false;
    Boolean hizliyavaswill = false;
    Boolean yavashizliwill = false;
    Boolean yavasyavaswill = false;
    Animation animation;
    Animation animationzoom;
    Animation feyd;
    MediaPlayer mediaPlayerdogrucevap;
    MediaPlayer mediaPlayeryanliscevap;
    MediaPlayer hizlisoru;
    MediaPlayer yavassoru;
    MediaPlayer ikincisoru;
    MediaPlayer hizlitempolu;
    MediaPlayer yavastempolu;
    MediaPlayer yavasmuzk;
    MediaPlayer hizlimuzk;
    private View decorView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHizliYavasWillBinding.inflate(getLayoutInflater());
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
        hizlisoru = MediaPlayer.create(this,R.raw.hizliolanibul);

        yavassoru = MediaPlayer.create(this, R.raw.yavasolanibul);

        ikincisoru = MediaPlayer.create(this,R.raw.ikincmuzik);

        hizlitempolu = MediaPlayer.create(this,R.raw.hizlitempo);

        yavastempolu = MediaPlayer.create(this,R.raw.yavastempo);
        //yavaşyok

        yavasmuzk = MediaPlayer.create(this, R.raw.willyavas);

        hizlimuzk = MediaPlayer.create(this, R.raw.willhizli);

        animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink_ani);
        mediaPlayeryanliscevap = MediaPlayer.create(this,R.raw.yanliscevap);
        mediaPlayerdogrucevap = MediaPlayer.create(this,R.raw.tebriklerdogrucevap);
        animationzoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        feyd = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeanim);
        binding.cvphy.startAnimation(feyd);

        int dogrucevapsure = mediaPlayerdogrucevap.getDuration();
        int yavasmuzksure = yavasmuzk.getDuration();
        int hizlimuzksure = hizlimuzk.getDuration();

        binding.Anasayfayadonwilloyunu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(HizliYavasWill.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.Geritusuwilloyunu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(HizliYavasWill.this, OyunlarMenu.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        Random random = new Random();
        int r = random.nextInt(4);
        if(r==0){
            //hizli müzikle baslayan
            binding.willsoru.setText("Hızlı olan müziği bulabilir misin ?");
            hizlihizliwill = true;
            hizliyavaswill = false;
        }
        if(r==1){
            //yavasla baslayan
            binding.willsoru.setText("Hızlı olan müziği bulabilir misin ?");
            hizliyavaswill = true;
            hizlihizliwill = false;
        }
        if(r==2){
            //hizli müzikle baslayan
            binding.willsoru.setText("Yavaş olan müziği bulabilir misin ?");
            yavashizliwill = true;
            yavasyavaswill = false;
        }
        if(r==3){
            //yavaş müzikle baslayan
            binding.willsoru.setText("Yavaş olan müziği bulabilir misin ?");
            yavasyavaswill = true;
            yavashizliwill = false;
        }
        if(hizlihizliwill==true){
            binding.will1cimuzik.setEnabled(false);
            binding.will2cimuzik.setEnabled(false);
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
                                                    binding.will1cimuzik.setEnabled(true);
                                                    binding.will2cimuzik.setEnabled(true);
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
            binding.will1cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.will1cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                    binding.will2cimuzik.setClickable(false);
                    binding.will1cimuzik.setClickable(false);
                    binding.cvphy.startAnimation(animationzoom);
                    mediaPlayerdogrucevap.start();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            seskes();
                            Intent intent = new Intent(HizliYavasWill.this, HizliYavasOff.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(intent);
                        }
                    },dogrucevapsure);

                }
            });
            binding.will2cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.will2cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    sesfalse();
                }
            });

        }
        if(hizliyavaswill==true){
            binding.will1cimuzik.setEnabled(false);
            binding.will2cimuzik.setEnabled(false);
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
                                                    binding.will1cimuzik.setEnabled(true);
                                                    binding.will2cimuzik.setEnabled(true);
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
            binding.will2cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.will2cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                    binding.will2cimuzik.setClickable(false);
                    binding.will1cimuzik.setClickable(false);
                    binding.cvphy.startAnimation(animationzoom);

                    mediaPlayerdogrucevap.start();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            seskes();
                            Intent intent = new Intent(HizliYavasWill.this, HizliYavasOff.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(intent);
                        }
                    },dogrucevapsure);

                }
            });
            binding.will1cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.will1cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    sesfalse();
                }
            });
        }
        if(yavashizliwill==true){
            binding.will1cimuzik.setEnabled(false);
            binding.will2cimuzik.setEnabled(false);
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
                                                    binding.will1cimuzik.setEnabled(true);
                                                    binding.will2cimuzik.setEnabled(true);
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
            binding.will2cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.will2cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                    binding.will2cimuzik.setClickable(false);
                    binding.will1cimuzik.setClickable(false);
                    binding.cvphy.startAnimation(animationzoom);

                    mediaPlayerdogrucevap.start();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            seskes();
                            Intent intent = new Intent(HizliYavasWill.this, HizliYavasOff.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(intent);
                        }
                    },dogrucevapsure);

                }
            });
            binding.will1cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.will1cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    sesfalse();
                }
            });
        }
        if(yavasyavaswill==true){


            binding.will1cimuzik.setEnabled(false);
            binding.will2cimuzik.setEnabled(false);
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
                                                    binding.will1cimuzik.setEnabled(true);
                                                    binding.will2cimuzik.setEnabled(true);
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
            binding.will1cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.will1cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.green)));
                    binding.will2cimuzik.setClickable(false);
                    binding.will1cimuzik.setClickable(false);
                    binding.cvphy.startAnimation(animationzoom);

                    mediaPlayerdogrucevap.start();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            seskes();
                            Intent intent = new Intent(HizliYavasWill.this, HizliYavasOff.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(intent);
                        }
                    },dogrucevapsure);

                }
            });
            binding.will2cimuzik.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    binding.will2cimuzik.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.red)));
                    sesfalse();
                }
            });
        }
    }
    public void seskes() {
        if(hizlisoru!=null){
            hizlisoru.stop();
            hizlisoru.seekTo(0);
            hizlisoru.release();
            hizlisoru = null;
        }
        if(yavassoru!=null){
            yavassoru.stop();
            yavassoru.seekTo(0);
            yavassoru.release();
            yavassoru = null;
        }
        if(ikincisoru!=null){
            ikincisoru.stop();
            ikincisoru.seekTo(0);
            ikincisoru.release();
            ikincisoru = null;
        }
        if(hizlitempolu!=null){
            hizlitempolu.stop();
            hizlitempolu.seekTo(0);
            hizlitempolu.release();
            hizlitempolu = null;
        }
        if(yavastempolu!=null){
            yavastempolu.stop();
            yavastempolu.seekTo(0);
            yavastempolu.release();
            yavastempolu = null;
        }
        if(hizlimuzk!=null){
            hizlimuzk.stop();
            hizlimuzk.seekTo(0);
            hizlimuzk.release();
            hizlimuzk = null;
        }
        if(yavasmuzk!=null){
            yavasmuzk.stop();
            yavasmuzk.seekTo(0);
            yavasmuzk.release();
            yavasmuzk = null;
        }
        if(mediaPlayerdogrucevap!=null){
            mediaPlayerdogrucevap.stop();
            mediaPlayerdogrucevap.seekTo(0);
            mediaPlayerdogrucevap.release();
            mediaPlayerdogrucevap = null;
        }
        if(mediaPlayeryanliscevap!=null){
            mediaPlayeryanliscevap.stop();
            mediaPlayeryanliscevap.seekTo(0);
            mediaPlayeryanliscevap.release();
            mediaPlayeryanliscevap = null;
        }
    }
    private void sesfalse(){
        if(mediaPlayeryanliscevap.isPlaying()){
            mediaPlayeryanliscevap.pause();
            mediaPlayeryanliscevap.seekTo(0);
        }
        if(mediaPlayerdogrucevap.isPlaying()){
            mediaPlayerdogrucevap.pause();
            mediaPlayerdogrucevap.seekTo(0);
        }
        mediaPlayeryanliscevap.start();
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