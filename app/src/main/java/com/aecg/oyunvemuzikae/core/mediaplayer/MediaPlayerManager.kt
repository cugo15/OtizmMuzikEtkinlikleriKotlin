package com.aecg.oyunvemuzikae.core.mediaplayer

import android.media.MediaPlayer

interface MediaPlayerManager {
    fun initialize(): MediaPlayer
    fun release()
    fun playSoundByUri(uri: String){}
}