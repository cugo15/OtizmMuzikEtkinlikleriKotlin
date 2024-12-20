package com.aecg.oyunvemuzikae.core.mediaplayer

import android.media.MediaPlayer
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

import javax.inject.Inject

open class MediaPlayerManagerImpl @Inject constructor(protected val mediaPlayer: MediaPlayer) :
    MediaPlayerManager, DefaultLifecycleObserver {
    private var isPaused = false

    final override fun initialize(): MediaPlayer = mediaPlayer
    final override fun release() = mediaPlayer.release()
    final override fun reset() = mediaPlayer.reset()

    final override fun resumeIfPaused() {
        if (isPaused) {
            mediaPlayer.start()
            isPaused = false
        }
    }
    final override fun pauseIfPlaying() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
            isPaused = true
        }
    }

    override fun onStart(owner: LifecycleOwner) = resumeIfPaused()

    override fun onResume(owner: LifecycleOwner) = resumeIfPaused()

    override fun onPause(owner: LifecycleOwner) = pauseIfPlaying()

    override fun onStop(owner: LifecycleOwner) = pauseIfPlaying()


}
