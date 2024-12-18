package com.aecg.oyunvemuzikae.core.mediaplayer

import android.webkit.WebView

interface WebViewManager {
    fun setupWebView(webView: WebView)
    fun loadYouTubeVideo(webView: WebView, videoUrl: String)
}