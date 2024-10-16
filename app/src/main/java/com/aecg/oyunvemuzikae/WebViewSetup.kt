package com.aecg.oyunvemuzikae

import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

interface WebViewSetup {
    fun setupWebView(webView: WebView,videoId:String) {
        webView.webViewClient = WebViewClient() // WebView içinde sayfa yüklensin
        val webSettings: WebSettings = webView.settings
        webSettings.apply {
            allowContentAccess = true
            javaScriptEnabled = true
            mediaPlaybackRequiresUserGesture = true
        } // JavaScript'i etkinleştir
        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest): Boolean {
                val url = request.url.toString()
                // Yalnızca belirli bir YouTube video URL'sinin yüklenmesine izin ver
                return url == "https://www.youtube.com/embed/$videoId"
            }
        }
        webView.loadUrl("https://www.youtube.com/embed/$videoId")
    }
}