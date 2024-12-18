package com.aecg.oyunvemuzikae.core.mediaplayer

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import java.io.IOException
import javax.inject.Inject

class MuzikMediaPlayerManager @Inject constructor(private val context: Context,
                                                  mediaPlayer: MediaPlayer
) : MediaPlayerManagerImpl(mediaPlayer) {
    override fun playSoundByUri(uri: String) {
        // MuzikFragment'e özgü ses çalma işlemleri
        try {
            mediaPlayer.reset()
            mediaPlayer.apply {
                setDataSource(context, Uri.parse(uri))
                prepare()
                start()
                setOnCompletionListener {
                    it.release() // Ses tamamlandığında serbest bırak
                }
            }
        } catch (e: IOException) {
            e.printStackTrace() // Hata yönetimi
        }
    }
}