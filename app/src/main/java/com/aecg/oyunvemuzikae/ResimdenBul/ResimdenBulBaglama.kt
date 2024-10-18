package com.aecg.oyunvemuzikae.ResimdenBul

import android.content.Intent
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.aecg.oyunvemuzikae.MainActivity
import com.aecg.oyunvemuzikae.OyunlarMenu
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.ActivityResimdenBulBaglamaBinding
import java.util.Random

class ResimdenBulBaglama : AppCompatActivity() {
    private var binding: ActivityResimdenBulBaglamaBinding? = null
    var soru: MediaPlayer? = null
    var animation: Animation? = null
    var hand: Handler? = null
    var runab: Runnable? = null
    var animationzoom: Animation? = null
    var animationfadein: Animation? = null
    var animationmovefromleft: Animation? = null
    var animationmovefromright: Animation? = null
    private var decorView: View? = null
    var dogruses: MediaPlayer? = null
    var mediaPlayeryanliscevap: MediaPlayer? = null
    var mediaPlayerdogrucevap: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResimdenBulBaglamaBinding.inflate(
            layoutInflater
        )
        val view: View = binding!!.root
        setContentView(view)
        decorView = window.decorView
        decorView!!.setOnSystemUiVisibilityChangeListener { i ->
            if (i == 0) {
                decorView!!.systemUiVisibility = hideSystemBars()
            }
        }

        animation = AnimationUtils.loadAnimation(applicationContext, R.anim.blink_ani)
        animationzoom = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_in)
        animationfadein = AnimationUtils.loadAnimation(applicationContext, R.anim.fade_in)
        animationmovefromleft = AnimationUtils.loadAnimation(
            applicationContext, R.anim.movefrom_left
        )
        animationmovefromright = AnimationUtils.loadAnimation(
            applicationContext, R.anim.movefrom_right
        )
        binding!!.bag1card.startAnimation(animationmovefromleft)
        binding!!.bag2card.startAnimation(animationfadein)
        binding!!.bag3card.startAnimation(animationmovefromright)
        binding!!.baglamaimg1.isEnabled = false
        binding!!.baglamaimg2.isEnabled = false
        binding!!.baglamaimg3.isEnabled = false
        soru = MediaPlayer.create(this, R.raw.acababaglama)
        dogruses = MediaPlayer.create(this, R.raw.sound_enstruman_baglama)
        mediaPlayeryanliscevap = MediaPlayer.create(this, R.raw.yanliscevap)
        mediaPlayerdogrucevap = MediaPlayer.create(this, R.raw.tebriklerdogrucevap)
        val sorusure = soru!!.getDuration()
        val yanliscevapsure = mediaPlayeryanliscevap!!.getDuration()
        val dogrusessure = dogruses!!.getDuration()
        val handlerhizlihizli = Handler()
        val runablehizlihizli = Runnable {
            soru!!.start()
            Handler().postDelayed({
                binding!!.Anasayfayadonresimdenbaglama.isEnabled = true
                binding!!.Geritusuacababaglama.isEnabled = true
                binding!!.baglamaimg1.isEnabled = true
                binding!!.baglamaimg2.isEnabled = true
                binding!!.baglamaimg3.isEnabled = true
            }, sorusure.toLong())
        }
        handlerhizlihizli.postDelayed(runablehizlihizli, 700)

        val random = Random()
        val r = random.nextInt(3)
        val r2 = random.nextInt(13)
        val r3 = random.nextInt(12)
        if (r == 0) {
            binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_baglama)
            if (r2 == 0) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_zil)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 1) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 2) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 3) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 4) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_def)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 5) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 6) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 7) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_obua)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 8) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 9) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 10) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 11) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_flut)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
            }
            if (r2 == 12) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_keman)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
        }
        if (r == 1) {
            binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_baglama)
            if (r2 == 0) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 1) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 2) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 3) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 4) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 5) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 6) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 7) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 8) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 9) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 10) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 11) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
            }
            if (r2 == 12) {
                binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                if (r3 == 0) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
        }
        if (r == 2) {
            binding!!.baglamaimg3.setBackgroundResource(R.drawable.ic_enstruman_baglama)
            if (r2 == 0) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_zil)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 1) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 2) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 3) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 4) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_def)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 5) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 6) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 7) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_obua)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 8) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 9) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 10) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
            if (r2 == 11) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_flut)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_keman)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
            }
            if (r2 == 12) {
                binding!!.baglamaimg2.setBackgroundResource(R.drawable.ic_enstruman_keman)
                if (r3 == 0) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_bateri)
                }
                if (r3 == 1) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zil)
                }
                if (r3 == 2) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trompet)
                }
                if (r3 == 3) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_trombon)
                }
                if (r3 == 4) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_def)
                }
                if (r3 == 5) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_zurna)
                }
                if (r3 == 6) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_piyano)
                }
                if (r3 == 7) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_obua)
                }
                if (r3 == 8) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_metronom)
                }
                if (r3 == 9) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_ksilofon)
                }
                if (r3 == 10) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_gitar)
                }
                if (r3 == 11) {
                    binding!!.baglamaimg1.setBackgroundResource(R.drawable.ic_enstruman_flut)
                }
            }
        }

        binding!!.Anasayfayadonresimdenbaglama.setOnClickListener {
            if (hand != null) {
                hand!!.removeCallbacks(runab!!)
            }
            seskes()
            val intent = Intent(this@ResimdenBulBaglama, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        binding!!.Geritusuacababaglama.setOnClickListener {
            if (hand != null) {
                hand!!.removeCallbacks(runab!!)
            }
            seskes()
            val intent = Intent(this@ResimdenBulBaglama, OyunlarMenu::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        binding!!.baglamaimg1.setOnClickListener {
            if (r == 0) {
                binding!!.bag1card.setBackgroundResource(R.drawable.border)
                binding!!.bag1card.startAnimation(animationzoom)
                binding!!.baglamaimg1.isClickable = false
                binding!!.baglamaimg2.isClickable = false
                binding!!.baglamaimg3.isClickable = false
                mediaPlayerdogrucevap!!.start()
                mediaPlayerdogrucevap!!.setOnCompletionListener(OnCompletionListener {
                    dogruses!!.start()
                    binding!!.imageView.visibility = View.VISIBLE
                    binding!!.imageView.startAnimation(animation)
                    dogruses!!.setOnCompletionListener(OnCompletionListener { randomact() })
                })
                binding!!.imageView.setOnClickListener { randomact() }
            }
            if (r == 1) {
                binding!!.bag1card.setBackgroundResource(R.drawable.border_red)
            }
            if (r == 2) {
                binding!!.bag1card.setBackgroundResource(R.drawable.border_red)
            }
        }
        binding!!.baglamaimg2.setOnClickListener {
            if (r == 0) {
                binding!!.bag2card.setBackgroundResource(R.drawable.border_red)
            }
            if (r == 1) {
                binding!!.bag2card.setBackgroundResource(R.drawable.border)
                binding!!.bag2card.startAnimation(animationzoom)

                binding!!.baglamaimg1.isClickable = false
                binding!!.baglamaimg2.isClickable = false
                binding!!.baglamaimg3.isClickable = false
                mediaPlayerdogrucevap!!.start()
                mediaPlayerdogrucevap!!.setOnCompletionListener(OnCompletionListener {
                    dogruses!!.start()
                    binding!!.imageView.visibility = View.VISIBLE
                    binding!!.imageView.startAnimation(animation)
                    dogruses!!.setOnCompletionListener(OnCompletionListener { randomact() })
                })

                binding!!.imageView.setOnClickListener { randomact() }
            }
            if (r == 2) {
                binding!!.bag2card.setBackgroundResource(R.drawable.border_red)
            }
        }
        binding!!.baglamaimg3.setOnClickListener {
            if (r == 0) {
                binding!!.bag3card.setBackgroundResource(R.drawable.border_red)
            }
            if (r == 1) {
                binding!!.bag3card.setBackgroundResource(R.drawable.border_red)
            }
            if (r == 2) {
                binding!!.bag3card.setBackgroundResource(R.drawable.border)
                binding!!.bag3card.startAnimation(animationzoom)

                binding!!.baglamaimg1.isClickable = false
                binding!!.baglamaimg2.isClickable = false
                binding!!.baglamaimg3.isClickable = false
                mediaPlayerdogrucevap!!.start()
                mediaPlayerdogrucevap!!.setOnCompletionListener(OnCompletionListener {
                    dogruses!!.start()
                    binding!!.imageView.visibility = View.VISIBLE
                    binding!!.imageView.startAnimation(animation)
                    dogruses!!.setOnCompletionListener(OnCompletionListener { randomact() })
                })

                binding!!.imageView.setOnClickListener { randomact() }
            }
        }
    }

    fun seskes() {
        if (soru != null) {
            soru!!.stop()
            soru!!.release()
            soru = null
        }
        if (dogruses != null) {
            dogruses!!.stop()
            dogruses!!.release()
            dogruses = null
        }
        if (mediaPlayeryanliscevap != null) {
            mediaPlayeryanliscevap!!.stop()
            mediaPlayeryanliscevap!!.release()
            mediaPlayeryanliscevap = null
        }
        if (mediaPlayerdogrucevap != null) {
            mediaPlayerdogrucevap!!.stop()
            mediaPlayerdogrucevap!!.release()
            mediaPlayerdogrucevap = null
        }
    }

    fun randomact() {
        seskes()
        var activitylist: ArrayList<Class<*>?>? = ArrayList()
        val extras = intent.extras
        activitylist = extras!!["ACTIVITY_LIST"] as ArrayList<Class<*>?>?

        val generator = Random()
        val number = generator.nextInt(activitylist!!.size)
        if (number == 0) {
            val intent = Intent(applicationContext, activitylist[0])
            activitylist.removeAt(0)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 1) {
            val intent = Intent(applicationContext, activitylist[1])
            activitylist.removeAt(1)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 2) {
            val intent = Intent(applicationContext, activitylist[2])
            activitylist.removeAt(2)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 3) {
            val intent = Intent(applicationContext, activitylist[3])
            activitylist.removeAt(3)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 4) {
            val intent = Intent(applicationContext, activitylist[4])
            activitylist.removeAt(4)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 5) {
            val intent = Intent(applicationContext, activitylist[5])
            activitylist.removeAt(5)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 6) {
            val intent = Intent(applicationContext, activitylist[6])
            activitylist.removeAt(6)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 7) {
            val intent = Intent(applicationContext, activitylist[7])
            activitylist.removeAt(7)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 8) {
            val intent = Intent(applicationContext, activitylist[8])
            activitylist.removeAt(8)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 9) {
            val intent = Intent(applicationContext, activitylist[9])
            activitylist.removeAt(9)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 10) {
            val intent = Intent(applicationContext, activitylist[10])
            activitylist.removeAt(10)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 11) {
            val intent = Intent(applicationContext, activitylist[11])
            activitylist.removeAt(11)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 12) {
            val intent = Intent(applicationContext, activitylist[12])
            activitylist.removeAt(12)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 13) {
            val intent = Intent(applicationContext, activitylist[13])
            activitylist.removeAt(13)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 14) {
            val intent = Intent(applicationContext, activitylist[14])
            activitylist.removeAt(14)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 15) {
            val intent = Intent(applicationContext, activitylist[15])
            activitylist.removeAt(15)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        if (number == 16) {
            val intent = Intent(applicationContext, activitylist[16])
            activitylist.removeAt(16)
            if (activitylist.size == 0) {
                activitylist.add(ResimdenBulBaglama::class.java)
                activitylist.add(ResimdenBulBateri::class.java)
                activitylist.add(ResimdenBulDavul::class.java)
                activitylist.add(ResimdenBulGitar::class.java)
                activitylist.add(ResimdenBulDef::class.java)
                activitylist.add(ResimdenBulFlut::class.java)
                activitylist.add(ResimdenBulKeman::class.java)
                activitylist.add(ResimdenBulKsilafon::class.java)
                activitylist.add(ResimdenBulMetronom::class.java)
                activitylist.add(ResimdenBulObua::class.java)
                activitylist.add(ResimdenBulPiyano::class.java)
                activitylist.add(ResimdenBulTrombon::class.java)
                activitylist.add(ResimdenBulTrompet::class.java)
                activitylist.add(ResimdenBulZil::class.java)
                activitylist.add(ResimdenBulZurna::class.java)
                activitylist.add(ResimdenBulUd::class.java)
                activitylist.add(ResimdenBulKanun::class.java)
            }
            intent.putExtra("ACTIVITY_LIST", activitylist)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            decorView!!.systemUiVisibility = hideSystemBars()
        }
    }

    private fun hideSystemBars(): Int {
        return View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
    }

    override fun onPause() {
        seskes()

        super.onPause()
    }

    override fun onStop() {
        seskes()
        super.onStop()
    }
}