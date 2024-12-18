package com.aecg.oyunvemuzikae.ui.fragment

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.ui.adapter.SesAdapter
import com.aecg.oyunvemuzikae.domain.SesType
import com.aecg.oyunvemuzikae.data.model.SesModel
import com.aecg.oyunvemuzikae.ui.fragment.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentSesBinding
import com.aecg.oyunvemuzikae.utils.loadLayoutBackgroundWithGlide
import com.aecg.oyunvemuzikae.utils.scrollInDirection
import com.aecg.oyunvemuzikae.utils.setForegroundDrawable

class SesFragment : BaseFragment<FragmentSesBinding>(FragmentSesBinding::inflate) {
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var sesList: ArrayList<SesModel>
    private lateinit var animationzoom: Animation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animationzoom = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_inshort)
        sesList = SesFragmentArgs.fromBundle(requireArguments()).sesList.toList() as ArrayList<SesModel>
        val category = sesList.first().type
        initializeCategory(category)
        setupRecyclerView(sesList)

        binding.btnScrollLeftSes.setOnClickListener {binding.rvSes.scrollInDirection(-1)}
        binding.BtnScrollRightSes.setOnClickListener {binding.rvSes.scrollInDirection(1)}
        binding.btnUflemeli.setOnClickListener { smoothScrollToLeft((findPositionForType(SesType.ENSTRUMAN.UFLEMELI))) }
        binding.btnTelli.setOnClickListener { smoothScrollToLeft((findPositionForType(SesType.ENSTRUMAN.TELLI))) }
        binding.btnVurmali.setOnClickListener { smoothScrollToLeft((findPositionForType(SesType.ENSTRUMAN.VURMALI))) }
        binding.btnOrff.setOnClickListener { smoothScrollToLeft((findPositionForType(SesType.ENSTRUMAN.ORFF))) }

    }
    private fun findPositionForType(sesType: SesType): Int {
        return sesList.indexOfFirst { it.type == sesType }.takeIf { it != -1 } ?: 0
    }

    private fun smoothScrollToLeft(position: Int) {
        (binding.rvSes.layoutManager as? LinearLayoutManager)?.apply {
            val smoothScroller = object : LinearSmoothScroller(context) {
                override fun getHorizontalSnapPreference(): Int = SNAP_TO_START
            }
            smoothScroller.targetPosition = position
            startSmoothScroll(smoothScroller)
        }
    }

    private fun setupRecyclerView(sesList: ArrayList<SesModel>) {
        binding.rvSes.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = SesAdapter(sesList, { view, soundId ->
                playSoundById(soundId)
                view.startAnimation(animationzoom)
            }) { cView, iView, sesType ->
                applyStyle(cView, iView, sesType)
            }
        }
    }

    private fun applyStyle(cview: CardView, iview: View, sesType: SesType) {
        // SesType'a göre drawable ve padding değerlerini belirle
        val (drawableResId, padding) = when (sesType) {
            SesType.ENSTRUMAN.UFLEMELI -> R.drawable.underline_card_instrument_orange to 24
            SesType.ENSTRUMAN.TELLI -> R.drawable.underline_card_instrument_blue to 24
            SesType.ENSTRUMAN.VURMALI -> R.drawable.underline_card_instrument_green to 24
            SesType.ENSTRUMAN.ORFF -> R.drawable.underline_card_instrument_purple to 24
            else -> R.drawable.cardview_hafiza to 0
        }
        // Stil uygulaması
        cview.setForegroundDrawable(drawableResId)
        iview.setPadding(padding, padding, padding, padding)
    }

    private fun playSoundById(id: Int) {
        // Önce var olan MediaPlayer nesnesini serbest bırak
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
        mediaPlayer = MediaPlayer.create(requireContext(), id)
        mediaPlayer.start()

        // Ses bitince MediaPlayer'ı serbest bırak
        mediaPlayer.setOnCompletionListener {
            mediaPlayer.release()
        }
    }

    private fun initializeCategory(category: SesType) {
        // Başlık metnini güncelle
        binding.textViewSesHeader.text = category.displayName
        // Arka planı güncelle
        setBackground(category)
        // Butonların görünürlüğünü ayarla
        toggleButtonsVisibility(category)
    }

    private fun setBackground(category: SesType) {
        // Arka planı Glide ile yükle
        binding.layoutSes.loadLayoutBackgroundWithGlide(requireContext(), getBackgroundResourceForCategory(category))
    }

    private fun getBackgroundResourceForCategory(category: SesType): Int {
        return when (category) {
            SesType.ENSTRUMAN.UFLEMELI -> R.drawable.bg_enstrumanlar
            SesType.HAYVAN -> R.drawable.bg_hayvanlar
            SesType.INSAN -> R.drawable.bg_insanlar
            SesType.DOGA -> R.drawable.bg_doga
            SesType.ARAC -> R.drawable.bg_araclar
            SesType.SAYI -> R.drawable.bg_sayilar
            SesType.SEKIL -> R.drawable.bg_sekiller
            else -> R.drawable.bg_enstrumanlar // Default arka plan
        }
    }

    private fun toggleButtonsVisibility(category: SesType) {
        // Kategoriye göre butonları göster veya gizle
        if (category == SesType.ENSTRUMAN.UFLEMELI) {
            toggleVisibility(true, binding.btnUflemeli, binding.btnTelli, binding.btnVurmali, binding.btnOrff)
            toggleVisibility(false, binding.btnScrollLeftSes, binding.BtnScrollRightSes)
        } else {
            toggleVisibility(false, binding.btnUflemeli, binding.btnTelli, binding.btnVurmali, binding.btnOrff)
            toggleVisibility(true, binding.btnScrollLeftSes, binding.BtnScrollRightSes)
        }
    }

    private fun toggleVisibility(isVisible: Boolean, vararg views: View) {
        val visibility = if (isVisible) View.VISIBLE else View.GONE
        views.forEach { it.visibility = visibility }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
        sesList.clear()
    }

}