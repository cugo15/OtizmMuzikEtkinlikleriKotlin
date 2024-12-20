package com.aecg.oyunvemuzikae.ui.fragment

import SesType
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.core.mediaplayer.SesMediaPlayerManager
import com.aecg.oyunvemuzikae.ui.adapter.SesAdapter
import com.aecg.oyunvemuzikae.data.model.SesModel
import com.aecg.oyunvemuzikae.ui.fragment.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentSesBinding
import com.aecg.oyunvemuzikae.ui.viewmodel.SesViewModel
import com.aecg.oyunvemuzikae.utils.loadLayoutBackgroundWithGlide
import com.aecg.oyunvemuzikae.utils.scrollInDirection
import com.aecg.oyunvemuzikae.utils.setForegroundDrawable
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SesFragment : BaseFragment<FragmentSesBinding>(FragmentSesBinding::inflate) {
    private val sesViewModel: SesViewModel by viewModels()
    private lateinit var sesList: ArrayList<SesModel>
    private lateinit var animationzoom: Animation
    @Inject
    lateinit var mediaPlayerManager: SesMediaPlayerManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animationzoom = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_inshort)
        sesList = SesFragmentArgs.fromBundle(requireArguments()).sesList.toList() as ArrayList<SesModel>
        val category = sesList.first().type
        initializeCategory(category)
        setupRecyclerView(sesList)

        with(binding){
            btnScrollLeftSes.setOnClickListener {binding.rvSes.scrollInDirection(-1)}
            BtnScrollRightSes.setOnClickListener {binding.rvSes.scrollInDirection(1)}
            btnUflemeli.setOnClickListener { smoothScrollToLeft((sesViewModel.findPositionForType(SesType.ENSTRUMAN.UFLEMELI,sesList))) }
            btnTelli.setOnClickListener { smoothScrollToLeft((sesViewModel.findPositionForType(SesType.ENSTRUMAN.TELLI,sesList))) }
            btnVurmali.setOnClickListener { smoothScrollToLeft((sesViewModel.findPositionForType(SesType.ENSTRUMAN.VURMALI,sesList))) }
            btnOrff.setOnClickListener { smoothScrollToLeft((sesViewModel.findPositionForType(SesType.ENSTRUMAN.ORFF,sesList))) }
        }
        lifecycle.addObserver(mediaPlayerManager)

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
            adapter = SesAdapter(
                sesList = sesList,
                onItemClick = {view, soundId ->
                    sesViewModel.playSoundById(soundId)
                    view.startAnimation(animationzoom)
                },
                onItemStyle = { cView, iView, sesType ->
                    applyStyle(cView, iView, sesType)
                }
                )
        }
    }

    private fun applyStyle(cview: CardView, iview: View, sesType: SesType) {
        val (drawableResId,padding) = sesViewModel.getStyleForType(sesType)
        cview.setForegroundDrawable(drawableResId)
        iview.setPadding(padding, padding, padding, padding)
    }

    private fun initializeCategory(category: SesType) {
        binding.textViewSesHeader.text = category.displayName
        setBackground(category)
        toggleButtonsVisibility(category)
    }

    private fun setBackground(category: SesType) = binding.layoutSes.loadLayoutBackgroundWithGlide(requireContext(), sesViewModel.getBackgroundResourceForCategory(category))

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
        lifecycle.removeObserver(mediaPlayerManager)
    }

}