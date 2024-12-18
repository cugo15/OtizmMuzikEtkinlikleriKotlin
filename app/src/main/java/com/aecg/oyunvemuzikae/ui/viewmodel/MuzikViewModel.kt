package com.aecg.oyunvemuzikae.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.aecg.oyunvemuzikae.core.mediaplayer.MuzikMediaPlayerManager
import com.aecg.oyunvemuzikae.data.repository.MuzikRepository
import com.aecg.oyunvemuzikae.domain.MuzikType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MuzikViewModel @Inject constructor(
    muzikRepository: MuzikRepository,
    private val muzikMediaPlayerManager: MuzikMediaPlayerManager
) : ViewModel() {
    val muzikList = muzikRepository.muzikList
    // Müzik çalma fonksiyonu
    private fun playSoundByUri(uri: String) = muzikMediaPlayerManager.playSoundByUri(uri)

    fun onMusicItemClicked(
        uri: String,
        type: MuzikType,
        openVideoAction: (String) -> Unit
    ) {
        when (type) {
            MuzikType.MUZIK -> playSoundByUri(uri)
            MuzikType.VIDEO -> openVideoAction(uri)
        }
    }

    // ViewModel temizlendiğinde mediaPlayer'ı serbest bırak
    override fun onCleared() {
        super.onCleared()
        muzikMediaPlayerManager.release() // MediaPlayerManager'ı serbest bırak
    }
}
