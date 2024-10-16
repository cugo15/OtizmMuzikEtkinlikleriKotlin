package com.aecg.oyunvemuzikae

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.aecg.oyunvemuzikae.databinding.ActivityMuziklerBinding

class Muzikler : AppCompatActivity() {
    private lateinit var binding: ActivityMuziklerBinding
    private lateinit var decorView: View
    private lateinit var merhaba: MediaPlayer
    private lateinit var ucboyutlucisimler: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMuziklerBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        merhaba = MediaPlayer.create(this, R.raw.merhabasarkisi)
        ucboyutlucisimler = MediaPlayer.create(this, R.raw.ucboyutlucisimler)

        decorView = window.decorView
        decorView.setOnSystemUiVisibilityChangeListener { i ->
            if (i == 0) {
                decorView.systemUiVisibility = hideSystemBars()
            }
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        binding.ucboyutimg.setOnClickListener {
            hayvansesdurdur(ucboyutlucisimler, merhaba)
            hayvansesbaslatma(ucboyutlucisimler, merhaba)
        }
        binding.merhabaimg.setOnClickListener {
            hayvansesdurdur(ucboyutlucisimler, merhaba)
            hayvansesbaslatma(merhaba, ucboyutlucisimler)
        }
        binding.Geritususesmenu.setOnClickListener {
            hayvansesdurdur(ucboyutlucisimler, merhaba)
            val intent = Intent(this@Muzikler, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        binding.Anasayfayadonsesmenu.setOnClickListener {
            hayvansesdurdur(ucboyutlucisimler, merhaba)
            val intent = Intent(this@Muzikler, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }


        binding.karaokeimg.setOnClickListener {
            hayvansesdurdur(ucboyutlucisimler, merhaba)
            val intent = Intent(this@Muzikler, MrbKareoke::class.java)
            intent.putExtra("VIDEO_URL", "MU8o4SA-DB4")
            startActivity(intent)
            finish()
        }

        binding.alkisimg.setOnClickListener {
            hayvansesdurdur(ucboyutlucisimler, merhaba)
            val intent = Intent(this@Muzikler, MrbKareoke::class.java)
            intent.putExtra("VIDEO_URL", "soqD2OJ9Nb8")
            startActivity(intent)
            finish()
        }

        binding.cardd.setOnClickListener {
            hayvansesdurdur(ucboyutlucisimler, merhaba)
            val intent = Intent(this@Muzikler, MrbKareoke::class.java)
            intent.putExtra("VIDEO_URL", "bZtDgNI2QWY")
            startActivity(intent)
            finish()
        }


        binding.sesmenuscrollgeri.setOnClickListener {
            binding.sesmenuscroll.arrowScroll(
                ScrollView.FOCUS_LEFT
            )
        }
        binding.sesmenuscrollileri.setOnClickListener {
            binding.sesmenuscroll.arrowScroll(
                ScrollView.FOCUS_RIGHT
            )
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

    fun hayvansesbaslatma(playingone: MediaPlayer?, b: MediaPlayer?) {
        if (b!!.isPlaying == true) {
            b.pause()
            b.seekTo(0)
            playingone!!.start()
        } else {
            playingone!!.seekTo(0)
            playingone.start()
        }
    }

    fun hayvansesdurdur(a: MediaPlayer?, b: MediaPlayer?) {
        if (a!!.isPlaying == true) {
            a.pause()
            a.seekTo(0)
        } else if (b!!.isPlaying == true) {
            b.pause()
            b.seekTo(0)
        } else {
        }
    }

    override fun onPause() {
        hayvansesdurdur(ucboyutlucisimler, merhaba)


        super.onPause()
    }

    override fun onStop() {
        hayvansesdurdur(ucboyutlucisimler, merhaba)

        super.onStop()
    }
}