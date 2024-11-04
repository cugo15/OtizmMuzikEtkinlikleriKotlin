package com.aecg.oyunvemuzikae.ui

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var animationZoom: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        // Animasyonu bir kez yükleyin
        animationZoom = AnimationUtils.loadAnimation(this, R.anim.zoom_inshort)
        // Uygulamanın yatay modda açılmasını sağla
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null // Bellek sızıntısını önle
    }
}
