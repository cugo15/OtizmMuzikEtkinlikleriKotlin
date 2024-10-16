package com.aecg.oyunvemuzikae

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.aecg.oyunvemuzikae.databinding.ActivityMrbKareokeBinding

class MrbKareoke : AppCompatActivity() {
    private lateinit var connectivityManager: ConnectivityManager
    private lateinit var networkCallback: ConnectivityManager.NetworkCallback
    private lateinit var binding: ActivityMrbKareokeBinding
    private lateinit var animation: Animation
    private lateinit var decorView: View
    private var openedOnce = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMrbKareokeBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        decorView = window.decorView
        animation = AnimationUtils.loadAnimation(applicationContext, R.anim.blink_ani)
        val videoURL = intent.getStringExtra("VIDEO_URL") ?: ""

        val setupWebview = object : WebViewSetup {
        }
        binding.gohom1.setOnClickListener {
            val intent = Intent(this@MrbKareoke, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        binding.govideolist1.setOnClickListener {
            val intent = Intent(this@MrbKareoke, Muzikler::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
            finish()
        }
        // Hide system bars and set up visibility change listener
        decorView!!.setOnSystemUiVisibilityChangeListener { visibility ->
            if (visibility == 0) {
                hideSystemBars()
            }
        }

        // Check if network is enabled and display message accordingly
        if (!isNetworkEnabled) {
            binding.videoText.text = "Lütfen internet bağlantınızı kontrol ediniz."
            binding.videoText.startAnimation(animation)
        }else{
            setupWebview.setupWebView(binding.videoView, videoURL)
            openedOnce = true
        }

        // Initialize connectivity manager
        connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        // Set up WebView


        // NetworkCallback to handle connection changes
        networkCallback = object : ConnectivityManager.NetworkCallback() {
            override fun onAvailable(network: Network) {
                runOnUiThread {
                    if (!openedOnce) {
                    binding.videoText.text = "Haydi Şarkı Söyleyelim!"
                    setupWebview.setupWebView(binding.videoView, videoURL)
                    openedOnce = true
                    }
                }
            }

            override fun onLost(network: Network) {
                runOnUiThread {
                    binding.videoText.text = "Lütfen internet bağlantınızı kontrol ediniz."
                    binding.videoText.startAnimation(animation)
                }
            }
        }

        // Register the network callback
        registerNetworkCallback()
    }

    // Method to register the network callback
    private fun registerNetworkCallback() {
        val request = NetworkRequest.Builder()
            .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
            .build()
        connectivityManager.registerNetworkCallback(request, networkCallback)
    }

    // Check if the network is enabled
    private val isNetworkEnabled: Boolean
        get() {
            val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val network = connectivityManager.activeNetwork ?: return false
            val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
            return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET) &&
                    networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED)
        }

    // Handle window focus changes to hide system bars
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemBars()
        }
    }

    // Method to hide system bars based on API level
    private fun hideSystemBars() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.let { controller ->
                controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                controller.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                    View.SYSTEM_UI_FLAG_FULLSCREEN or
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        // NetworkCallback'ı kapat
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}
