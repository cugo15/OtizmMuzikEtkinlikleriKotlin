package com.aecg.oyunvemuzikae.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.aecg.oyunvemuzikae.BaseActivity

import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    var animationzoom: Animation? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        animationzoom = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_inshort)


    }

    private fun setClickListener(imageView: ImageView, targetActivity: Class<*>) {
        imageView.setOnClickListener {
            imageView.startAnimation(animationzoom) // Animasyonu başlat
            val intent = Intent(this@MainActivity, targetActivity)
            startActivity(intent) // Aktiviteyi başlat
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }
}