package com.aecg.oyunvemuzikae.ui.fragment

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.ui.fragment.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentMuzikBinding
import com.aecg.oyunvemuzikae.ui.adapter.MuzikAdapter
import com.aecg.oyunvemuzikae.data.model.MuzikModel
import com.aecg.oyunvemuzikae.ui.viewmodel.MuzikViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MuzikFragment : BaseFragment<FragmentMuzikBinding>(FragmentMuzikBinding::inflate) {

    private val muzikViewModel: MuzikViewModel by viewModels()
    private lateinit var animationZoom: Animation

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        animationZoom = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_inshort)
        val muzikList = muzikViewModel.muzikList
        setupRecyclerView(muzikList)
    }

    private fun setupRecyclerView(muzikList: Array<MuzikModel>) {
        binding.rvMuzikler.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = MuzikAdapter(
                muzikList = muzikList,
                onItemClick = { uri, type ->
                    muzikViewModel.onMusicItemClicked(uri, type, ::openVideo)
                },
                onItemAnimate = { view ->
                    view.startAnimation(animationZoom)
                }
            )
        }
    }
    private fun openVideo(videoId: String) {
        val action = MuzikFragmentDirections.actionMuzikFragmentToWebViewDialogFragment(videoId)
        findNavController().navigate(action)
    }
}
