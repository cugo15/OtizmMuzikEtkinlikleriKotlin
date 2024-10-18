package com.aecg.oyunvemuzikae.HafizaOyunu;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import com.aecg.oyunvemuzikae.MainActivity;
import com.aecg.oyunvemuzikae.R;
import com.aecg.oyunvemuzikae.databinding.ActivityMemoryLevelTwoBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MemoryLevelTwo extends AppCompatActivity {
    private ActivityMemoryLevelTwoBinding binding;
    Integer[] cardsArray = {101, 102, 201, 202};
    int r, r2, selectedimg, selectedimg2, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16, img17;
    Handler handler;
    int firstcard, secondcard;
    int clickedfirst, clickedsecond;
    private  View decorView;
    int cardNumber = 1;
    MediaPlayer mediaPlayeryanliscevap;
    MediaPlayer mediaPlayerdogrucevap;
    int dogrucevapsure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemoryLevelTwoBinding.inflate(getLayoutInflater());
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
        mediaPlayeryanliscevap = MediaPlayer.create(this,R.raw.yanliscevap);
        mediaPlayerdogrucevap = MediaPlayer.create(this,R.raw.dogrucingil);
        dogrucevapsure = mediaPlayerdogrucevap.getDuration();
        Bundle extras = getIntent().getExtras();
        int intentpicker = (Integer) extras.get("LVL2");
        if(intentpicker==1){
            binding.mlt.setText("6");
        }
        else if(intentpicker==2){
            binding.mlt.setText("7");
        }
        else if(intentpicker==3){
            binding.mlt.setText("8");
        }
        else if(intentpicker==4){
            binding.mlt.setText("9");
        }
        else if(intentpicker==5){
            binding.mlt.setText("10");
        }
        binding.iv11.setEnabled(false);
        binding.iv12.setEnabled(false);
        binding.iv21.setEnabled(false);
        binding.iv22.setEnabled(false);
        binding.openforsecondlv2.setEnabled(false);
        randomimg();
        Handler handler = new Handler();
        Runnable runable = new Runnable() {
            @Override
            public void run() {

                if (cardsArray[0] == 101) {
                    binding.iv11.setImageResource(selectedimg);
                } else if (cardsArray[0] == 102) {
                    binding.iv11.setImageResource(selectedimg2);
                } else if (cardsArray[0] == 201) {
                    binding.iv11.setImageResource(selectedimg);
                } else if (cardsArray[0] == 202) {
                    binding.iv11.setImageResource(selectedimg2);
                }

                if (cardsArray[1] == 101) {
                    binding.iv12.setImageResource(selectedimg);
                } else if (cardsArray[1] == 102) {
                    binding.iv12.setImageResource(selectedimg2);
                } else if (cardsArray[1] == 201) {
                    binding.iv12.setImageResource(selectedimg);
                } else if (cardsArray[1] == 202) {
                    binding.iv12.setImageResource(selectedimg2);
                }

                if (cardsArray[2] == 101) {
                    binding.iv21.setImageResource(selectedimg);
                } else if (cardsArray[2] == 102) {
                    binding.iv21.setImageResource(selectedimg2);
                } else if (cardsArray[2] == 201) {
                    binding.iv21.setImageResource(selectedimg);
                } else if (cardsArray[2] == 202) {
                    binding.iv21.setImageResource(selectedimg2);
                }

                if (cardsArray[3] == 101) {
                    binding.iv22.setImageResource(selectedimg);
                } else if (cardsArray[3] == 102) {
                    binding.iv22.setImageResource(selectedimg2);
                } else if (cardsArray[3] == 201) {
                    binding.iv22.setImageResource(selectedimg);
                } else if (cardsArray[3] == 202) {
                    binding.iv22.setImageResource(selectedimg2);
                }


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.iv11.setImageResource(R.drawable.questionmark2);
                        binding.iv12.setImageResource(R.drawable.questionmark2);
                        binding.iv21.setImageResource(R.drawable.questionmark2);
                        binding.iv22.setImageResource(R.drawable.questionmark2);
                        binding.iv11.setEnabled(true);
                        binding.iv12.setEnabled(true);
                        binding.iv21.setEnabled(true);
                        binding.iv22.setEnabled(true);
                        binding.openforsecondlv2.setEnabled(true);
                    }
                }, 1000);
            }
        };
        handler.postDelayed(runable, 1000);
        binding.iv11.setTag("0");
        binding.iv12.setTag("1");
        binding.iv21.setTag("2");
        binding.iv22.setTag("3");
        Collections.shuffle(Arrays.asList(cardsArray));


        binding.openforsecondlv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.openforsecondlv2.setEnabled(false);
                if(binding.iv11.getVisibility() != View.INVISIBLE){
                    binding.iv11.setEnabled(false);
                    if (cardsArray[0] == 101) {
                        binding.iv11.setImageResource(selectedimg);
                    } else if (cardsArray[0] == 102) {
                        binding.iv11.setImageResource(selectedimg2);
                    } else if (cardsArray[0] == 201) {
                        binding.iv11.setImageResource(selectedimg);
                    } else if (cardsArray[0] == 202) {
                        binding.iv11.setImageResource(selectedimg2);
                    }
                }
                if(binding.iv12.getVisibility() != View.INVISIBLE){
                    binding.iv12.setEnabled(false);
                    if (cardsArray[1] == 101) {
                        binding.iv12.setImageResource(selectedimg);
                    } else if (cardsArray[1] == 102) {
                        binding.iv12.setImageResource(selectedimg2);
                    } else if (cardsArray[1] == 201) {
                        binding.iv12.setImageResource(selectedimg);
                    } else if (cardsArray[1] == 202) {
                        binding.iv12.setImageResource(selectedimg2);
                    }
                }
                if(binding.iv21.getVisibility() != View.INVISIBLE){
                    binding.iv21.setEnabled(false);
                    if (cardsArray[2] == 101) {
                        binding.iv21.setImageResource(selectedimg);
                    } else if (cardsArray[2] == 102) {
                        binding.iv21.setImageResource(selectedimg2);
                    } else if (cardsArray[2] == 201) {
                        binding.iv21.setImageResource(selectedimg);
                    } else if (cardsArray[2] == 202) {
                        binding.iv21.setImageResource(selectedimg2);
                    }
                }
                if(binding.iv22.getVisibility() != View.INVISIBLE){
                    binding.iv22.setEnabled(false);
                    if (cardsArray[3] == 101) {
                        binding.iv22.setImageResource(selectedimg);
                    } else if (cardsArray[3] == 102) {
                        binding.iv22.setImageResource(selectedimg2);
                    } else if (cardsArray[3] == 201) {
                        binding.iv22.setImageResource(selectedimg);
                    } else if (cardsArray[3] == 202) {
                        binding.iv22.setImageResource(selectedimg2);
                    }
                }
                Handler handler = new Handler();
                Runnable runable = new Runnable() {
                    @Override
                    public void run() {
                        if(binding.iv11.getVisibility() != View.INVISIBLE){
                            binding.iv11.setImageResource(R.drawable.questionmark2);
                            binding.iv11.setEnabled(true);
                        }
                        if(binding.iv12.getVisibility() != View.INVISIBLE){
                            binding.iv12.setImageResource(R.drawable.questionmark2);
                            binding.iv12.setEnabled(true);
                        }
                        if(binding.iv21.getVisibility() != View.INVISIBLE){
                            binding.iv21.setImageResource(R.drawable.questionmark2);
                            binding.iv21.setEnabled(true);

                        }
                        if(binding.iv22.getVisibility() != View.INVISIBLE){
                            binding.iv22.setImageResource(R.drawable.questionmark2);
                            binding.iv22.setEnabled(true);
                        }
                        binding.openforsecondlv2.setEnabled(true);
                    }
                };
                handler.postDelayed(runable, 1000);
            }
        });




        binding.Geritusumlvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(MemoryLevelTwo.this, MemoryMap.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });

        binding.Anasayfayadonmlvl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(MemoryLevelTwo.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });

        binding.iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(binding.iv11, theCard);
            }
        });

        binding.iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(binding.iv12, theCard);
            }
        });

        binding.iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(binding.iv21, theCard);
            }
        });

        binding.iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(binding.iv22, theCard);
            }
        });
    }

    private void randomimg() {
        ArrayList<Integer> pics = new ArrayList<>();
        img1 = R.drawable.ic_enstruman_baglama;
        img2 = R.drawable.ic_enstruman_bateri;
        img3 = R.drawable.ic_enstruman_davul;
        img4 = R.drawable.ic_enstruman_def;
        img5 = R.drawable.ic_enstruman_flut;
        img6 = R.drawable.ic_enstruman_gitar;
        img7 = R.drawable.ic_enstruman_kanun;
        img8 = R.drawable.ic_enstruman_keman;
        img9 = R.drawable.ic_enstruman_ksilofon;
        img10 = R.drawable.ic_enstruman_metronom;
        img11 = R.drawable.ic_enstruman_obua;
        img12 = R.drawable.ic_enstruman_piyano;
        img13 = R.drawable.ic_enstruman_trombon;
        img14 = R.drawable.ic_enstruman_trompet;
        img15 = R.drawable.ic_enstruman_ud;
        img16 = R.drawable.ic_enstruman_zil;
        img17 = R.drawable.ic_enstruman_zurna;
        pics.add(img1);
        pics.add(img2);
        pics.add(img3);
        pics.add(img4);
        pics.add(img5);
        pics.add(img6);
        pics.add(img7);
        pics.add(img8);
        pics.add(img9);
        pics.add(img10);
        pics.add(img11);
        pics.add(img12);
        pics.add(img13);
        pics.add(img14);
        pics.add(img15);
        pics.add(img16);
        pics.add(img17);
        Random generator = new Random();
        r = generator.nextInt(17);
        selectedimg = pics.get(r);
        pics.remove(r);
        r2 = generator.nextInt(16);
        selectedimg2 = pics.get(r2);
    }

    private void doStuff(ImageView iv, int card) {
        //hangi resim seçildi ve geçici olarak kaydedildi

        if (cardsArray[card] == 101) {
            iv.setImageResource(selectedimg);
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(selectedimg2);
        } else if (cardsArray[card] == 201) {
            iv.setImageResource(selectedimg);
        } else if (cardsArray[card] == 202) {
            iv.setImageResource(selectedimg2);
        }

        if (cardNumber == 1) {
            firstcard = cardsArray[card];
            if (firstcard > 200) {
                firstcard = firstcard - 100;
            }
            cardNumber = 2;
            clickedfirst = card;
            binding.openforsecondlv2.setEnabled(false);
            iv.setEnabled(false);

        } else if (cardNumber == 2) {
            secondcard = cardsArray[card];
            if (secondcard > 200) {
                secondcard = secondcard - 100;

            }
            cardNumber = 1;
            clickedsecond = card;
            binding.iv11.setEnabled(false);
            binding.iv12.setEnabled(false);
            binding.iv21.setEnabled(false);
            binding.iv22.setEnabled(false);
            binding.openforsecondlv2.setEnabled(false);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 500);
        }
    }

    private void calculate() {
        if (firstcard == secondcard) {
            if (clickedfirst == 0) {
                Drawable a = binding.iv11.getDrawable();
                binding.iv11.setVisibility(View.INVISIBLE);
                binding.trueiv11.setImageDrawable(a);
                binding.trueiv11.setVisibility(View.VISIBLE);
                binding.iv11card.setBackgroundResource(R.drawable.border);

            } else if (clickedfirst == 1) {
                Drawable a = binding.iv12.getDrawable();
                binding.iv12.setVisibility(View.INVISIBLE);
                binding.trueiv12.setImageDrawable(a);
                binding.trueiv12.setVisibility(View.VISIBLE);
                binding.iv12card.setBackgroundResource(R.drawable.border);

            } else if (clickedfirst == 2) {
                Drawable a = binding.iv21.getDrawable();
                binding.iv21.setVisibility(View.INVISIBLE);
                binding.trueiv21.setImageDrawable(a);
                binding.trueiv21.setVisibility(View.VISIBLE);
                binding.iv21card.setBackgroundResource(R.drawable.border);

            } else if (clickedfirst == 3) {
                Drawable a = binding.iv22.getDrawable();
                binding.iv22.setVisibility(View.INVISIBLE);
                binding.trueiv22.setImageDrawable(a);
                binding.trueiv22.setVisibility(View.VISIBLE);
                binding.iv22card.setBackgroundResource(R.drawable.border);

            }

            if (clickedsecond == 0) {
                Drawable a = binding.iv11.getDrawable();
                binding.iv11.setVisibility(View.INVISIBLE);
                binding.trueiv11.setImageDrawable(a);
                binding.trueiv11.setVisibility(View.VISIBLE);
                binding.iv11card.setBackgroundResource(R.drawable.border);


            } else if (clickedsecond == 1) {
                Drawable a = binding.iv12.getDrawable();
                binding.iv12.setVisibility(View.INVISIBLE);
                binding.trueiv12.setImageDrawable(a);
                binding.trueiv12.setVisibility(View.VISIBLE);
                binding.iv12card.setBackgroundResource(R.drawable.border);
            } else if (clickedsecond == 2) {
                Drawable a = binding.iv21.getDrawable();
                binding.iv21.setVisibility(View.INVISIBLE);
                binding.trueiv21.setImageDrawable(a);
                binding.trueiv21.setVisibility(View.VISIBLE);
                binding.iv21card.setBackgroundResource(R.drawable.border);

            } else if (clickedsecond == 3) {
                Drawable a = binding.iv22.getDrawable();
                binding.iv22.setVisibility(View.INVISIBLE);
                binding.trueiv22.setImageDrawable(a);
                binding.trueiv22.setVisibility(View.VISIBLE);
                binding.iv22card.setBackgroundResource(R.drawable.border);

            }
        } else {
            sesfalse();
            binding.iv11.setImageResource(R.drawable.questionmark2);
            binding.iv12.setImageResource(R.drawable.questionmark2);
            binding.iv21.setImageResource(R.drawable.questionmark2);
            binding.iv22.setImageResource(R.drawable.questionmark2);
        }
        binding.iv11.setEnabled(true);
        binding.iv12.setEnabled(true);
        binding.iv21.setEnabled(true);
        binding.iv22.setEnabled(true);
        binding.openforsecondlv2.setEnabled(true);
        checkEnd();
    }

    private void checkEnd() {
        if (binding.iv11.getVisibility() == View.INVISIBLE &&
                binding.iv12.getVisibility() == View.INVISIBLE &&
                binding.iv21.getVisibility() == View.INVISIBLE &&
                binding.iv22.getVisibility() == View.INVISIBLE) {
            sestrue();
            Bundle extras = getIntent().getExtras();
            int intentpicker = (Integer) extras.get("LVL2");
            mediaPlayerdogrucevap.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                    if (intentpicker == 1) {
                        Intent intent = new Intent(MemoryLevelTwo.this, MemoryLevelTwo.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("LVL2", 2);
                        startActivity(intent);
                        finish();
                    } else if (intentpicker == 2) {
                        Intent intent = new Intent(MemoryLevelTwo.this, MemoryLevelTwo.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("LVL2", 3);
                        startActivity(intent);
                        finish();
                    } else if (intentpicker == 3) {
                        Intent intent = new Intent(MemoryLevelTwo.this, MemoryLevelTwo.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("LVL2", 4);
                        startActivity(intent);
                        finish();
                    } else if (intentpicker == 4) {
                        Intent intent = new Intent(MemoryLevelTwo.this, MemoryLevelTwo.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("LVL2", 5);
                        startActivity(intent);
                        finish();
                    } else if (intentpicker == 5) {
                        Intent intent = new Intent(MemoryLevelTwo.this, MemoryLevelThree.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("LVL3", 1);
                        startActivity(intent);
                        finish();
                    }
                }
            });
        }
    }
    private void sestrue(){
        if(mediaPlayerdogrucevap.isPlaying()){
            mediaPlayerdogrucevap.pause();
            mediaPlayerdogrucevap.seekTo(0);
        }
        if(mediaPlayeryanliscevap.isPlaying()){
            mediaPlayeryanliscevap.pause();
            mediaPlayeryanliscevap.seekTo(0);
        }
        mediaPlayerdogrucevap.start();
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

    private void seskes(){
        if(mediaPlayeryanliscevap!=null){
            mediaPlayeryanliscevap.stop();
            mediaPlayeryanliscevap.release();
            mediaPlayeryanliscevap = null;
        }
        if(mediaPlayerdogrucevap!=null){
            mediaPlayerdogrucevap.stop();
            mediaPlayerdogrucevap.release();
            mediaPlayerdogrucevap = null;
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
}