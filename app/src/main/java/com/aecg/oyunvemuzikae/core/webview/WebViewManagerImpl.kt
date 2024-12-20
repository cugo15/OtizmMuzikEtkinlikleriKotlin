package com.aecg.oyunvemuzikae.core.webview

import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import javax.inject.Inject

class WebViewManagerImpl @Inject constructor(): WebViewManager {
    override fun setupWebView(webView: WebView) {
        webView.apply {
            settings.javaScriptEnabled = true
            settings.mediaPlaybackRequiresUserGesture = false
            settings.allowContentAccess = true
            webViewClient = createWebViewClient()
        }
    }

    override fun loadYouTubeVideo(webView: WebView, videoUrl: String) {
        val iframeHtml = generateIframeHtml(videoUrl)
        webView.loadDataWithBaseURL("https://www.youtube.com", iframeHtml, "text/html", "utf-8", null)
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

    private fun createWebViewClient() = object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
            return true // Farklı bir URL açılmak istendiğinde engelle
        }
    }

}