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
import com.aecg.oyunvemuzikae.databinding.ActivityMemoryLevelFourBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MemoryLevelFour extends AppCompatActivity {
    private ActivityMemoryLevelFourBinding binding;
    Integer[] cardsArray = {101,102,103,104,201,202,203,204};
    int r,r2,r3,r4,selectedimg,selectedimg2,selectedimg3,selectedimg4
            ,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17;
    MediaPlayer mediaPlayeryanliscevap;
    MediaPlayer mediaPlayerdogrucevap;
    Handler handler;
    private  View decorView;
    int firstcard,secondcard;
    int clickedfirst,clickedsecond;
    int cardNumber=1;
    int dogrucevapsure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMemoryLevelFourBinding.inflate(getLayoutInflater());
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
        int intentpicker = (Integer) extras.get("LVL4");
        if(intentpicker==1){
            binding.mlf.setText("16");
        }
        else if(intentpicker==2){
            binding.mlf.setText("17");
        }
        else if(intentpicker==3){
            binding.mlf.setText("18");
        }
        else if(intentpicker==4){
            binding.mlf.setText("19");
        }
        else if(intentpicker==5){
            binding.mlf.setText("20");
        }
        binding.iv11.setEnabled(false);
        binding.iv12.setEnabled(false);
        binding.iv21.setEnabled(false);
        binding.iv22.setEnabled(false);
        binding.iv31.setEnabled(false);
        binding.iv32.setEnabled(false);
        binding.iv41.setEnabled(false);
        binding.iv42.setEnabled(false);
        binding.openforsecondlv4.setEnabled(false);
        randomimg();
        Handler handler = new Handler();
        Runnable runable = new Runnable() {
            @Override
            public void run() {

                if (cardsArray[0] == 101) {
                    binding.iv11.setImageResource(selectedimg);
                } else if (cardsArray[0] == 102) {
                    binding.iv11.setImageResource(selectedimg2);
                }else if (cardsArray[0] == 103) {
                    binding.iv11.setImageResource(selectedimg3);
                }else if (cardsArray[0] == 104) {
                    binding.iv11.setImageResource(selectedimg4);
                } else if (cardsArray[0] == 201) {
                    binding.iv11.setImageResource(selectedimg);
                } else if (cardsArray[0] == 202) {
                    binding.iv11.setImageResource(selectedimg2);
                }else if (cardsArray[0] == 203) {
                    binding.iv11.setImageResource(selectedimg3);
                }
                else if (cardsArray[0] == 204) {
                    binding.iv11.setImageResource(selectedimg4);
                }


                if (cardsArray[1] == 101) {
                    binding.iv12.setImageResource(selectedimg);
                } else if (cardsArray[1] == 102) {
                    binding.iv12.setImageResource(selectedimg2);
                }else if (cardsArray[1] == 103) {
                    binding.iv12.setImageResource(selectedimg3);
                }else if (cardsArray[1] == 104) {
                    binding.iv12.setImageResource(selectedimg4);
                } else if (cardsArray[1] == 201) {
                    binding.iv12.setImageResource(selectedimg);
                } else if (cardsArray[1] == 202) {
                    binding.iv12.setImageResource(selectedimg2);
                }else if (cardsArray[1] == 203) {
                    binding.iv12.setImageResource(selectedimg3);
                }
                else if (cardsArray[1] == 204) {
                    binding.iv12.setImageResource(selectedimg4);
                }

                if (cardsArray[2] == 101) {
                    binding.iv21.setImageResource(selectedimg);
                } else if (cardsArray[2] == 102) {
                    binding.iv21.setImageResource(selectedimg2);
                }else if (cardsArray[2] == 103) {
                    binding.iv21.setImageResource(selectedimg3);
                }else if (cardsArray[2] == 104) {
                    binding.iv21.setImageResource(selectedimg4);
                }  else if (cardsArray[2] == 201) {
                    binding.iv21.setImageResource(selectedimg);
                } else if (cardsArray[2] == 202) {
                    binding.iv21.setImageResource(selectedimg2);
                }else if (cardsArray[2] == 203) {
                    binding.iv21.setImageResource(selectedimg3);
                }
                else if (cardsArray[2] == 204) {
                    binding.iv21.setImageResource(selectedimg4);
                }

                if (cardsArray[3] == 101) {
                    binding.iv22.setImageResource(selectedimg);
                } else if (cardsArray[3] == 102) {
                    binding.iv22.setImageResource(selectedimg2);
                }else if (cardsArray[3] == 103) {
                    binding.iv22.setImageResource(selectedimg3);
                }else if (cardsArray[3] == 104) {
                    binding.iv22.setImageResource(selectedimg4);
                }
                else if (cardsArray[3] == 201) {
                    binding.iv22.setImageResource(selectedimg);
                } else if (cardsArray[3] == 202) {
                    binding.iv22.setImageResource(selectedimg2);
                }else if (cardsArray[3] == 203) {
                    binding.iv22.setImageResource(selectedimg3);
                }else if (cardsArray[3] == 204) {
                    binding.iv22.setImageResource(selectedimg4);
                }



                if (cardsArray[4] == 101) {
                    binding.iv31.setImageResource(selectedimg);
                } else if (cardsArray[4] == 102) {
                    binding.iv31.setImageResource(selectedimg2);
                }else if (cardsArray[4] == 103) {
                    binding.iv31.setImageResource(selectedimg3);
                }else if (cardsArray[4] == 104) {
                    binding.iv31.setImageResource(selectedimg4);
                }  else if (cardsArray[4] == 201) {
                    binding.iv31.setImageResource(selectedimg);
                } else if (cardsArray[4] == 202) {
                    binding.iv31.setImageResource(selectedimg2);
                }else if (cardsArray[4] == 203) {
                    binding.iv31.setImageResource(selectedimg3);
                }else if (cardsArray[4] == 204) {
                    binding.iv31.setImageResource(selectedimg4);
                }


                if (cardsArray[5] == 101) {
                    binding.iv32.setImageResource(selectedimg);
                } else if (cardsArray[5] == 102) {
                    binding.iv32.setImageResource(selectedimg2);
                }else if (cardsArray[5] == 103) {
                    binding.iv32.setImageResource(selectedimg3);
                }else if (cardsArray[5] == 104) {
                    binding.iv32.setImageResource(selectedimg4);
                } else if (cardsArray[5] == 201) {
                    binding.iv32.setImageResource(selectedimg);
                } else if (cardsArray[5] == 202) {
                    binding.iv32.setImageResource(selectedimg2);
                }else if (cardsArray[5] == 203) {
                    binding.iv32.setImageResource(selectedimg3);
                }else if (cardsArray[5] == 204) {
                    binding.iv32.setImageResource(selectedimg4);
                }


                if (cardsArray[6] == 101) {
                    binding.iv41.setImageResource(selectedimg);
                } else if (cardsArray[6] == 102) {
                    binding.iv41.setImageResource(selectedimg2);
                }else if (cardsArray[6] == 103) {
                    binding.iv41.setImageResource(selectedimg3);
                }else if (cardsArray[6] == 104) {
                    binding.iv41.setImageResource(selectedimg4);
                } else if (cardsArray[6] == 201) {
                    binding.iv41.setImageResource(selectedimg);
                } else if (cardsArray[6] == 202) {
                    binding.iv41.setImageResource(selectedimg2);
                }else if (cardsArray[6] == 203) {
                    binding.iv41.setImageResource(selectedimg3);
                }else if (cardsArray[6] == 204) {
                    binding.iv41.setImageResource(selectedimg4);
                }


                if (cardsArray[7] == 101) {
                    binding.iv42.setImageResource(selectedimg);
                } else if (cardsArray[7] == 102) {
                    binding.iv42.setImageResource(selectedimg2);
                }else if (cardsArray[7] == 103) {
                    binding.iv42.setImageResource(selectedimg3);
                }else if (cardsArray[7] == 104) {
                    binding.iv42.setImageResource(selectedimg4);
                } else if (cardsArray[7] == 201) {
                    binding.iv42.setImageResource(selectedimg);
                } else if (cardsArray[7] == 202) {
                    binding.iv42.setImageResource(selectedimg2);
                }else if (cardsArray[7] == 203) {
                    binding.iv42.setImageResource(selectedimg3);
                }else if (cardsArray[7] == 204) {
                    binding.iv42.setImageResource(selectedimg4);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        binding.iv11.setImageResource(R.drawable.questionmark2);
                        binding.iv12.setImageResource(R.drawable.questionmark2);
                        binding.iv21.setImageResource(R.drawable.questionmark2);
                        binding.iv22.setImageResource(R.drawable.questionmark2);
                        binding.iv31.setImageResource(R.drawable.questionmark2);
                        binding.iv32.setImageResource(R.drawable.questionmark2);
                        binding.iv41.setImageResource(R.drawable.questionmark2);
                        binding.iv42.setImageResource(R.drawable.questionmark2);
                        binding.iv11.setEnabled(true);
                        binding.iv12.setEnabled(true);
                        binding.iv21.setEnabled(true);
                        binding.iv22.setEnabled(true);
                        binding.iv31.setEnabled(true);
                        binding.iv32.setEnabled(true);
                        binding.iv41.setEnabled(true);
                        binding.iv42.setEnabled(true);
                        binding.openforsecondlv4.setEnabled(true);
                    }
                },1000);
            }
        };handler.postDelayed(runable,1000);
        binding.iv11.setTag("0");
        binding.iv12.setTag("1");
        binding.iv21.setTag("2");
        binding.iv22.setTag("3");
        binding.iv31.setTag("4");
        binding.iv32.setTag("5");
        binding.iv41.setTag("6");
        binding.iv42.setTag("7");
        Collections.shuffle(Arrays.asList(cardsArray));


        binding.openforsecondlv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.openforsecondlv4.setEnabled(false);


                if(binding.iv11.getVisibility() != View.INVISIBLE){
                    binding.iv11.setEnabled(false);
                    if (cardsArray[0] == 101) {
                        binding.iv11.setImageResource(selectedimg);
                    } else if (cardsArray[0] == 102) {
                        binding.iv11.setImageResource(selectedimg2);
                    }else if (cardsArray[0] == 103) {
                        binding.iv11.setImageResource(selectedimg3);
                    }else if (cardsArray[0] == 104) {
                        binding.iv11.setImageResource(selectedimg4);
                    } else if (cardsArray[0] == 201) {
                        binding.iv11.setImageResource(selectedimg);
                    } else if (cardsArray[0] == 202) {
                        binding.iv11.setImageResource(selectedimg2);
                    }else if (cardsArray[0] == 203) {
                        binding.iv11.setImageResource(selectedimg3);
                    }
                    else if (cardsArray[0] == 204) {
                        binding.iv11.setImageResource(selectedimg4);
                    }


                }
                if(binding.iv12.getVisibility() != View.INVISIBLE){
                    binding.iv12.setEnabled(false);
                    if (cardsArray[1] == 101) {
                        binding.iv12.setImageResource(selectedimg);
                    } else if (cardsArray[1] == 102) {
                        binding.iv12.setImageResource(selectedimg2);
                    }else if (cardsArray[1] == 103) {
                        binding.iv12.setImageResource(selectedimg3);
                    }else if (cardsArray[1] == 104) {
                        binding.iv12.setImageResource(selectedimg4);
                    } else if (cardsArray[1] == 201) {
                        binding.iv12.setImageResource(selectedimg);
                    } else if (cardsArray[1] == 202) {
                        binding.iv12.setImageResource(selectedimg2);
                    }else if (cardsArray[1] == 203) {
                        binding.iv12.setImageResource(selectedimg3);
                    }
                    else if (cardsArray[1] == 204) {
                        binding.iv12.setImageResource(selectedimg4);
                    }


                }
                if(binding.iv21.getVisibility() != View.INVISIBLE){
                    binding.iv21.setEnabled(false);
                    if (cardsArray[2] == 101) {
                        binding.iv21.setImageResource(selectedimg);
                    } else if (cardsArray[2] == 102) {
                        binding.iv21.setImageResource(selectedimg2);
                    }else if (cardsArray[2] == 103) {
                        binding.iv21.setImageResource(selectedimg3);
                    }else if (cardsArray[2] == 104) {
                        binding.iv21.setImageResource(selectedimg4);
                    }  else if (cardsArray[2] == 201) {
                        binding.iv21.setImageResource(selectedimg);
                    } else if (cardsArray[2] == 202) {
                        binding.iv21.setImageResource(selectedimg2);
                    }else if (cardsArray[2] == 203) {
                        binding.iv21.setImageResource(selectedimg3);
                    }
                    else if (cardsArray[2] == 204) {
                        binding.iv21.setImageResource(selectedimg4);
                    }



                }
                if(binding.iv22.getVisibility() != View.INVISIBLE){
                    binding.iv22.setEnabled(false);
                    if (cardsArray[3] == 101) {
                        binding.iv22.setImageResource(selectedimg);
                    } else if (cardsArray[3] == 102) {
                        binding.iv22.setImageResource(selectedimg2);
                    }else if (cardsArray[3] == 103) {
                        binding.iv22.setImageResource(selectedimg3);
                    }else if (cardsArray[3] == 104) {
                        binding.iv22.setImageResource(selectedimg4);
                    }
                    else if (cardsArray[3] == 201) {
                        binding.iv22.setImageResource(selectedimg);
                    } else if (cardsArray[3] == 202) {
                        binding.iv22.setImageResource(selectedimg2);
                    }else if (cardsArray[3] == 203) {
                        binding.iv22.setImageResource(selectedimg3);
                    }else if (cardsArray[3] == 204) {
                        binding.iv22.setImageResource(selectedimg4);
                    }
                }

                if(binding.iv31.getVisibility() != View.INVISIBLE){
                    binding.iv31.setEnabled(false);
                    if (cardsArray[4] == 101) {
                        binding.iv31.setImageResource(selectedimg);
                    } else if (cardsArray[4] == 102) {
                        binding.iv31.setImageResource(selectedimg2);
                    }else if (cardsArray[4] == 103) {
                        binding.iv31.setImageResource(selectedimg3);
                    }else if (cardsArray[4] == 104) {
                        binding.iv31.setImageResource(selectedimg4);
                    }  else if (cardsArray[4] == 201) {
                        binding.iv31.setImageResource(selectedimg);
                    } else if (cardsArray[4] == 202) {
                        binding.iv31.setImageResource(selectedimg2);
                    }else if (cardsArray[4] == 203) {
                        binding.iv31.setImageResource(selectedimg3);
                    }else if (cardsArray[4] == 204) {
                        binding.iv31.setImageResource(selectedimg4);
                    }
                }

                if(binding.iv32.getVisibility() != View.INVISIBLE){
                    binding.iv32.setEnabled(false);
                    if (cardsArray[5] == 101) {
                        binding.iv32.setImageResource(selectedimg);
                    } else if (cardsArray[5] == 102) {
                        binding.iv32.setImageResource(selectedimg2);
                    }else if (cardsArray[5] == 103) {
                        binding.iv32.setImageResource(selectedimg3);
                    }else if (cardsArray[5] == 104) {
                        binding.iv32.setImageResource(selectedimg4);
                    } else if (cardsArray[5] == 201) {
                        binding.iv32.setImageResource(selectedimg);
                    } else if (cardsArray[5] == 202) {
                        binding.iv32.setImageResource(selectedimg2);
                    }else if (cardsArray[5] == 203) {
                        binding.iv32.setImageResource(selectedimg3);
                    }else if (cardsArray[5] == 204) {
                        binding.iv32.setImageResource(selectedimg4);
                    }
                }

                if(binding.iv41.getVisibility() != View.INVISIBLE){
                    binding.iv41.setEnabled(false);
                    if (cardsArray[6] == 101) {
                        binding.iv41.setImageResource(selectedimg);
                    } else if (cardsArray[6] == 102) {
                        binding.iv41.setImageResource(selectedimg2);
                    }else if (cardsArray[6] == 103) {
                        binding.iv41.setImageResource(selectedimg3);
                    }else if (cardsArray[6] == 104) {
                        binding.iv41.setImageResource(selectedimg4);
                    } else if (cardsArray[6] == 201) {
                        binding.iv41.setImageResource(selectedimg);
                    } else if (cardsArray[6] == 202) {
                        binding.iv41.setImageResource(selectedimg2);
                    }else if (cardsArray[6] == 203) {
                        binding.iv41.setImageResource(selectedimg3);
                    }else if (cardsArray[6] == 204) {
                        binding.iv41.setImageResource(selectedimg4);
                    }
                }

                if(binding.iv42.getVisibility() != View.INVISIBLE){
                    binding.iv42.setEnabled(false);
                    if (cardsArray[7] == 101) {
                        binding.iv42.setImageResource(selectedimg);
                    } else if (cardsArray[7] == 102) {
                        binding.iv42.setImageResource(selectedimg2);
                    }else if (cardsArray[7] == 103) {
                        binding.iv42.setImageResource(selectedimg3);
                    }else if (cardsArray[7] == 104) {
                        binding.iv42.setImageResource(selectedimg4);
                    } else if (cardsArray[7] == 201) {
                        binding.iv42.setImageResource(selectedimg);
                    } else if (cardsArray[7] == 202) {
                        binding.iv42.setImageResource(selectedimg2);
                    }else if (cardsArray[7] == 203) {
                        binding.iv42.setImageResource(selectedimg3);
                    }else if (cardsArray[7] == 204) {
                        binding.iv42.setImageResource(selectedimg4);
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
                        if(binding.iv31.getVisibility() != View.INVISIBLE){
                            binding.iv31.setImageResource(R.drawable.questionmark2);
                            binding.iv31.setEnabled(true);
                        }
                        if(binding.iv32.getVisibility() != View.INVISIBLE){
                            binding.iv32.setImageResource(R.drawable.questionmark2);
                            binding.iv32.setEnabled(true);
                        }
                        if(binding.iv41.getVisibility() != View.INVISIBLE){
                            binding.iv41.setImageResource(R.drawable.questionmark2);
                            binding.iv41.setEnabled(true);
                        }
                        if(binding.iv42.getVisibility() != View.INVISIBLE){
                            binding.iv42.setImageResource(R.drawable.questionmark2);
                            binding.iv42.setEnabled(true);
                        }
                        binding.openforsecondlv4.setEnabled(true);
                    }
                };
                handler.postDelayed(runable, 1000);
            }
        });


        binding.Geritusumlvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(MemoryLevelFour.this, MemoryMap.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.Anasayfayadonmlvl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                seskes();
                Intent intent = new Intent(MemoryLevelFour.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                finish();
            }
        });
        binding.iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(binding.iv11,theCard);
            }
        });
        binding.iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(binding.iv12,theCard);
            }
        });
        binding.iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(binding.iv21,theCard);
            }
        });
        binding.iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(binding.iv22,theCard);
            }
        });
        binding.iv31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(binding.iv31,theCard);
            }
        });
        binding.iv32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(binding.iv32,theCard);
            }
        });
        binding.iv41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(binding.iv41,theCard);
            }
        });
        binding.iv42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String)view.getTag());
                doStuff(binding.iv42,theCard);
            }
        });

    }
    private void randomimg(){
        ArrayList<Integer> pics= new ArrayList<>();
        img1 = R.drawable.ic_enstruman_baglama;
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
        pics.add(img1);pics.add(img2);pics.add(img3);pics.add(img4);pics.add(img5);pics.add(img6);pics.add(img7);pics.add(img8);
        pics.add(img9);pics.add(img10);pics.add(img11);pics.add(img12);pics.add(img13);pics.add(img14);pics.add(img15);pics.add(img16);
        pics.add(img17);
        Random generator = new Random();
        r = generator.nextInt(17);
        selectedimg = pics.get(r);
        pics.remove(r);
        r2= generator.nextInt(16);
        selectedimg2=pics.get(r2);
        pics.remove(r2);
        r3= generator.nextInt(15);
        selectedimg3=pics.get(r3);
        pics.remove(r3);
        r4= generator.nextInt(14);
        selectedimg4=pics.get(r4);
    }

    private void doStuff(ImageView iv, int card) {
        //hangi resim seçildi ve geçici olarak kaydedildi

        if(cardsArray[card]==101){
            iv.setImageResource(selectedimg);
        }
        else if(cardsArray[card]==102){
            iv.setImageResource(selectedimg2);
        }
        else if(cardsArray[card]==103){
            iv.setImageResource(selectedimg3);
        }
        else if(cardsArray[card]==104){
            iv.setImageResource(selectedimg4);
        }
        else if(cardsArray[card]==201){
            iv.setImageResource(selectedimg);
        }
        else if(cardsArray[card]==202){
            iv.setImageResource(selectedimg2);
        }
        else if(cardsArray[card]==203){
            iv.setImageResource(selectedimg3);
        }
        else if(cardsArray[card]==204){
            iv.setImageResource(selectedimg4);
        }

        if (cardNumber==1){
            firstcard=cardsArray[card];
            if(firstcard>200){
                firstcard = firstcard-100;
            }
            cardNumber=2;
            clickedfirst = card;
            binding.openforsecondlv4.setEnabled(false);
            iv.setEnabled(false);

        }else if(cardNumber==2){
            secondcard = cardsArray[card];
            if(secondcard>200){
                secondcard = secondcard-100;
            }
            cardNumber=1;
            clickedsecond=card;
            binding.iv11.setEnabled(false);
            binding.iv12.setEnabled(false);
            binding.iv21.setEnabled(false);
            binding.iv22.setEnabled(false);
            binding.iv31.setEnabled(false);
            binding.iv32.setEnabled(false);
            binding.iv41.setEnabled(false);
            binding.iv42.setEnabled(false);
            binding.openforsecondlv4.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            },1000);
        }
    }

    private void calculate() {
        if(firstcard==secondcard){
            if(clickedfirst==0){
                Drawable a = binding.iv11.getDrawable();
                binding.iv11.setVisibility(View.INVISIBLE);
                binding.trueiv11.setImageDrawable(a);
                binding.trueiv11.setVisibility(View.VISIBLE);
                binding.iv11card.setBackgroundResource(R.drawable.border);
            }
            else if(clickedfirst==1){
                Drawable a = binding.iv12.getDrawable();
                binding.iv12.setVisibility(View.INVISIBLE);
                binding.trueiv12.setImageDrawable(a);
                binding.trueiv12.setVisibility(View.VISIBLE);
                binding.iv12card.setBackgroundResource(R.drawable.border);
            }
            else if(clickedfirst==2){
                Drawable a = binding.iv21.getDrawable();
                binding.iv21.setVisibility(View.INVISIBLE);
                binding.trueiv21.setImageDrawable(a);
                binding.trueiv21.setVisibility(View.VISIBLE);
                binding.iv21card.setBackgroundResource(R.drawable.border);
            }
            else if(clickedfirst==3){
                Drawable a = binding.iv22.getDrawable();
                binding.iv22.setVisibility(View.INVISIBLE);
                binding.trueiv22.setImageDrawable(a);
                binding.trueiv22.setVisibility(View.VISIBLE);
                binding.iv22card.setBackgroundResource(R.drawable.border);

            }
            else if(clickedfirst==4){
                Drawable a = binding.iv31.getDrawable();
                binding.iv31.setVisibility(View.INVISIBLE);
                binding.trueiv31.setImageDrawable(a);
                binding.trueiv31.setVisibility(View.VISIBLE);
                binding.iv31card.setBackgroundResource(R.drawable.border);
            }
            else if(clickedfirst==5){
                Drawable a = binding.iv32.getDrawable();
                binding.iv32.setVisibility(View.INVISIBLE);
                binding.trueiv32.setImageDrawable(a);
                binding.trueiv32.setVisibility(View.VISIBLE);
                binding.iv32card.setBackgroundResource(R.drawable.border);
            }
            else if(clickedfirst==6){
                Drawable a = binding.iv41.getDrawable();
                binding.iv41.setVisibility(View.INVISIBLE);
                binding.trueiv41.setImageDrawable(a);
                binding.trueiv41.setVisibility(View.VISIBLE);
                binding.iv41card.setBackgroundResource(R.drawable.border);
            }
            else if(clickedfirst==7){
                Drawable a = binding.iv42.getDrawable();
                binding.iv42.setVisibility(View.INVISIBLE);
                binding.trueiv42.setImageDrawable(a);
                binding.trueiv42.setVisibility(View.VISIBLE);
                binding.iv42card.setBackgroundResource(R.drawable.border);
            }


            if(clickedsecond==0){
                Drawable a = binding.iv11.getDrawable();
                binding.iv11.setVisibility(View.INVISIBLE);
                binding.trueiv11.setImageDrawable(a);
                binding.trueiv11.setVisibility(View.VISIBLE);
                binding.iv11card.setBackgroundResource(R.drawable.border);

            }
            else if(clickedsecond==1){
                Drawable a = binding.iv12.getDrawable();
                binding.iv12.setVisibility(View.INVISIBLE);
                binding.trueiv12.setImageDrawable(a);
                binding.trueiv12.setVisibility(View.VISIBLE);
                binding.iv12card.setBackgroundResource(R.drawable.border);

            }
            else if(clickedsecond==2){
                Drawable a = binding.iv21.getDrawable();
                binding.iv21.setVisibility(View.INVISIBLE);
                binding.trueiv21.setImageDrawable(a);
                binding.trueiv21.setVisibility(View.VISIBLE);
                binding.iv21card.setBackgroundResource(R.drawable.border);

            }
            else if(clickedsecond==3){
                Drawable a = binding.iv22.getDrawable();
                binding.iv22.setVisibility(View.INVISIBLE);
                binding.trueiv22.setImageDrawable(a);
                binding.trueiv22.setVisibility(View.VISIBLE);
                binding.iv22card.setBackgroundResource(R.drawable.border);
            }
            else if(clickedsecond==4){
                Drawable a = binding.iv31.getDrawable();
                binding.iv31.setVisibility(View.INVISIBLE);
                binding.trueiv31.setImageDrawable(a);
                binding.trueiv31.setVisibility(View.VISIBLE);
                binding.iv31card.setBackgroundResource(R.drawable.border);
            }
            else if(clickedsecond==5){
                Drawable a = binding.iv32.getDrawable();
                binding.iv32.setVisibility(View.INVISIBLE);
                binding.trueiv32.setImageDrawable(a);
                binding.trueiv32.setVisibility(View.VISIBLE);
                binding.iv32card.setBackgroundResource(R.drawable.border);
            }
            else if(clickedsecond==6){
                Drawable a = binding.iv41.getDrawable();
                binding.iv41.setVisibility(View.INVISIBLE);
                binding.trueiv41.setImageDrawable(a);
                binding.trueiv41.setVisibility(View.VISIBLE);
                binding.iv41card.setBackgroundResource(R.drawable.border);
            }
            else if(clickedsecond==7){
                Drawable a = binding.iv42.getDrawable();
                binding.iv42.setVisibility(View.INVISIBLE);
                binding.trueiv42.setImageDrawable(a);
                binding.trueiv42.setVisibility(View.VISIBLE);
                binding.iv42card.setBackgroundResource(R.drawable.border);
            }
        }
        else{
            sesfalse();

            binding.iv11.setImageResource(R.drawable.questionmark2);
            binding.iv12.setImageResource(R.drawable.questionmark2);
            binding.iv21.setImageResource(R.drawable.questionmark2);
            binding.iv22.setImageResource(R.drawable.questionmark2);
            binding.iv31.setImageResource(R.drawable.questionmark2);
            binding.iv32.setImageResource(R.drawable.questionmark2);
            binding.iv41.setImageResource(R.drawable.questionmark2);
            binding.iv42.setImageResource(R.drawable.questionmark2);
        }
        binding.iv11.setEnabled(true);
        binding.iv12.setEnabled(true);
        binding.iv21.setEnabled(true);
        binding.iv22.setEnabled(true);
        binding.iv31.setEnabled(true);
        binding.iv32.setEnabled(true);
        binding.iv41.setEnabled(true);
        binding.iv42.setEnabled(true);
        binding.openforsecondlv4.setEnabled(true);
        checkEnd();
    }

    private void checkEnd() {
        if(binding.iv11.getVisibility()==View.INVISIBLE&&
                binding.iv12.getVisibility()==View.INVISIBLE&&
                binding.iv21.getVisibility()==View.INVISIBLE&&
                binding.iv22.getVisibility()==View.INVISIBLE&&
                binding.iv31.getVisibility()==View.INVISIBLE&&
                binding.iv41.getVisibility()==View.INVISIBLE&&
                binding.iv42.getVisibility()==View.INVISIBLE&&
                binding.iv32.getVisibility()==View.INVISIBLE){
            Bundle extras = getIntent().getExtras();
            int intentpicker = (Integer) extras.get("LVL4");
            sestrue();
            mediaPlayerdogrucevap.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    if (intentpicker == 1) {
                        Intent intent = new Intent(MemoryLevelFour.this, MemoryLevelFour.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("LVL4", 2);
                        startActivity(intent);
                        finish();
                    } else if (intentpicker == 2) {
                        Intent intent = new Intent(MemoryLevelFour.this, MemoryLevelFour.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("LVL4", 3);
                        startActivity(intent);
                        finish();
                    } else if (intentpicker == 3) {
                        Intent intent = new Intent(MemoryLevelFour.this, MemoryLevelFour.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("LVL4", 4);
                        startActivity(intent);
                        finish();
                    } else if (intentpicker == 4) {
                        Intent intent = new Intent(MemoryLevelFour.this, MemoryLevelFour.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("LVL4", 5);
                        startActivity(intent);
                        finish();
                    } else if (intentpicker == 5) {
                        Intent intent = new Intent(MemoryLevelFour.this, MemoryLevelFive.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                        intent.putExtra("LVL5", 1);
                        startActivity(intent);
                        finish();
                    }
                }
            });

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