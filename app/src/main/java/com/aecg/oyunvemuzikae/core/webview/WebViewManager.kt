package com.aecg.oyunvemuzikae.core.webview

import android.webkit.WebView

interface WebViewManager {
    fun setupWebView(webView: WebView)
    fun loadYouTubeVideo(webView: WebView, videoUrl: String)
}