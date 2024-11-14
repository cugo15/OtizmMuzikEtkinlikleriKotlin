package com.aecg.oyunvemuzikae.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.aecg.oyunvemuzikae.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentWebViewDialogBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WebViewDialogFragment : BaseFragment<FragmentWebViewDialogBinding>(FragmentWebViewDialogBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val videoId = WebViewDialogFragmentArgs.fromBundle(requireArguments()).videoId
        setupWebView()
        loadYouTubeVideo(videoId)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        binding.webView.apply {
            settings.javaScriptEnabled = true
            settings.mediaPlaybackRequiresUserGesture = false
            settings.allowContentAccess = true
            webViewClient = createWebViewClient()
        }
    }

    private fun createWebViewClient() = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            return true // Farklı bir URL açılmak istendiğinde engelle
        }
    }

    private fun loadYouTubeVideo(videoId: String) {
        val iframeHtml = generateIframeHtml(videoId)
        CoroutineScope(Dispatchers.Main).launch {
            binding.webView.loadDataWithBaseURL("https://www.youtube.com", iframeHtml, "text/html", "utf-8", null)
        }
    }

    private fun generateIframeHtml(videoId: String): String {
        return """
            <html>
            <body style="margin:0;padding:0;">
                <iframe 
                    id="player" 
                    type="text/html" 
                    width="100%"
                    height="100%" 
                    src="https://www.youtube.com/embed/$videoId?enablejsapi=1&controls=0&modestbranding=1&rel=0&autohide=1&autoplay=0" 
                    frameborder="0"
                    allowfullscreen>
                </iframe>
                <script>
                    var tag = document.createElement('script');
                    tag.src = "https://www.youtube.com/iframe_api";
                    var firstScriptTag = document.getElementsByTagName('script')[0];
                    firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);
                </script>
            </body>
            </html>
        """.trimIndent()
    }

}
