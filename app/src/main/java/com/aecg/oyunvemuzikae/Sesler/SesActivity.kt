package com.aecg.oyunvemuzikae.Sesler

import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.aecg.oyunvemuzikae.BaseActivity
import com.aecg.oyunvemuzikae.ui.MainActivity
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.ActivitySesBinding
import com.aecg.oyunvemuzikae.scrollInDirection
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition
import kotlin.collections.ArrayList

class SesActivity : BaseActivity() {
    private var _binding: ActivitySesBinding? = null
    private val binding get() = _binding!!

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var sesList: ArrayList<SesModel>
    private lateinit var animationzoom: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySesBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        animationzoom = AnimationUtils.loadAnimation(applicationContext, R.anim.zoom_inshort)

        sesList = intent.getParcelableArrayListExtra<SesModel>("sesListesi") ?: arrayListOf()

        val category = sesList[1].type
        binding.textViewSesHeader.text = category.displayName

        val backgroundResourceMap = mapOf(
            SesType.HAYVAN to R.drawable.bg_hayvanlar,
            SesType.INSAN to R.drawable.bg_insanlar,
            SesType.ENSTRUMAN to R.drawable.bg_enstrumanlar,
            SesType.DOGA to R.drawable.bg_doga,
            SesType.ARAC to R.drawable.bg_araclar,
            SesType.SAYI to R.drawable.bg_sayilar,
            SesType.SEKIL to R.drawable.bg_sekiller
        )
        val backgroundResource = backgroundResourceMap[category] ?: R.drawable.bg_doga

        Glide.with(this)
            .load(backgroundResource)
            .into(object : CustomTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    // Yüklenen Drawable'i arka plana set et
                    binding.layoutSes.background = resource
                }
                override fun onLoadCleared(placeholder: Drawable?) {
                    // Yükleme iptal edildiğinde yapılacak işlemler
                }
                override fun onLoadFailed(errorDrawable: Drawable?) {
                    // Yükleme başarısız olursa varsayılan arka plan ayarla
                    binding.layoutSes.setBackgroundResource(R.drawable.bg_doga) // varsayılan arka plan
                }
            })



        setupRecyclerView(sesList)

        binding.btnScrollLeftSes.setOnClickListener {
            binding.rvSes.scrollInDirection(-1)
        }

        binding.BtnScrollRightSes.setOnClickListener {
            binding.rvSes.scrollInDirection(1)
        }

        binding.btnHomeSes.setOnClickListener { navigateToActivity(MainActivity::class.java) }
        binding.btnBackSes.setOnClickListener { navigateToActivity(SesMenu::class.java) }

    }
    private fun setupRecyclerView(sesList: ArrayList<SesModel>) {
        // RecyclerView'e yatay (horizontal) LinearLayoutManager ata
        binding.rvSes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        // SesAdapter'ı RecyclerView'e ata
        binding.rvSes.adapter = SesAdapter(sesList, { id ->
            // Sesi çal
            playSoundById(id)
        }) { view ->
            // Animasyonu başlat
            view.startAnimation(animationzoom)
        }
    }

    private fun playSoundById(id: Int) {
        // Önce var olan MediaPlayer nesnesini serbest bırak
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
            mediaPlayer = MediaPlayer.create(this, id)
            mediaPlayer.start()

            // Ses bitince MediaPlayer'ı serbest bırak
            mediaPlayer.setOnCompletionListener {
                mediaPlayer.release()
            }
    }

    private fun navigateToActivity(destination: Class<*>) {
        val intent = Intent(this, destination)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
        _binding = null
        sesList.clear()
    }

}