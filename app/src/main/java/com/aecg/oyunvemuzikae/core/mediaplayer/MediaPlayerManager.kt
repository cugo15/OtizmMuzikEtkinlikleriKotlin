package com.aecg.oyunvemuzikae.core.mediaplayer

import android.media.MediaPlayer

interface MediaPlayerManager {
    fun initialize(): MediaPlayer
    fun release()
    fun reset()
    fun resumeIfPaused()
    fun pauseIfPlaying()
    fun playSoundByUri(uri: String){}
    fun playSoundById(id: Int){}

}