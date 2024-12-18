package com.aecg.oyunvemuzikae.ui.fragment

import android.os.Bundle
import android.view.View
import com.aecg.oyunvemuzikae.core.mediaplayer.WebViewManager
import com.aecg.oyunvemuzikae.databinding.FragmentMuzikVideoBinding
import com.aecg.oyunvemuzikae.ui.fragment.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MuzikVideoFragment : BaseFragment<FragmentMuzikVideoBinding>(FragmentMuzikVideoBinding::inflate) {
    @Inject
    lateinit var webViewManager: WebViewManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val videoId = MuzikVideoFragmentArgs.fromBundle(requireArguments()).videoId
        webViewManager.setupWebView(binding.webView)
        webViewManager.loadYouTubeVideo(binding.webView, videoId)
    }

}
