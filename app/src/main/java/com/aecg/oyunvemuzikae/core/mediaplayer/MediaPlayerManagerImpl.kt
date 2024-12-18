package com.aecg.oyunvemuzikae.core.mediaplayer

import android.media.MediaPlayer
import javax.inject.Inject

open class MediaPlayerManagerImpl @Inject constructor(protected val mediaPlayer: MediaPlayer) :
    MediaPlayerManager {

    final override fun initialize(): MediaPlayer {
        return mediaPlayer
    }

    final override fun release() {
        mediaPlayer.release()
    }

}
