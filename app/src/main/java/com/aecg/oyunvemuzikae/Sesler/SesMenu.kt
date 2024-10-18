package com.aecg.oyunvemuzikae.Sesler

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ScrollView
import com.aecg.oyunvemuzikae.BaseActivity
import com.aecg.oyunvemuzikae.MainActivity
import com.aecg.oyunvemuzikae.MyApplication
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.ActivitySesMenuBinding

class SesMenu : BaseActivity() {
    private lateinit var binding: ActivitySesMenuBinding
    private lateinit var animationZoom: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySesMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val app = application as MyApplication
        animationZoom = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_inshort)

        binding.sesmenuscrollgeri.setOnClickListener {
            binding.sesmenuscroll.arrowScroll(ScrollView.FOCUS_LEFT)
        }
        binding.sesmenuscrollileri.setOnClickListener {
            binding.sesmenuscroll.arrowScroll(ScrollView.FOCUS_RIGHT)
        }

        binding.Anasayfayadonsesmenu.setOnClickListener { navigateToMainActivity() }
        binding.Geritususesmenu.setOnClickListener { navigateToMainActivity() }

        setMenuClickListener(binding.hayvanmenuimg, app.hayvanList)
        setMenuClickListener(binding.rakammenuimg, app.sayiList)
        setMenuClickListener(binding.seklmenucard, app.sekilList)
        setMenuClickListener(binding.enstrumanmenuimg, app.enstrumanList)
        setMenuClickListener(binding.insanmenuimg, app.insanList)
        setMenuClickListener(binding.cansizmenuimage, app.aracList)
        setMenuClickListener(binding.dogaseslerimenuimg, app.dogaList)
    }

    private fun navigateToMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setMenuClickListener(imageView: View, sesList: ArrayList<SesModel>) {
        imageView.setOnClickListener {
            imageView.startAnimation(animationZoom)
            val intent = Intent(this, SesActivity::class.java)
            intent.putParcelableArrayListExtra("sesListesi", sesList) // Listeyi gönderiyoruz
            startActivity(intent)
            finish()
        }
    }
}
