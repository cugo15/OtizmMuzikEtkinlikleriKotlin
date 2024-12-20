package com.aecg.oyunvemuzikae.ui.viewmodel


import SesType
import android.util.Log
import androidx.lifecycle.ViewModel
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.core.mediaplayer.SesMediaPlayerManager
import com.aecg.oyunvemuzikae.data.model.SesModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SesViewModel @Inject constructor(private val sesMediaPlayerManager: SesMediaPlayerManager) :ViewModel() {

    fun playSoundById(id: Int) {
        sesMediaPlayerManager.playSoundById(id)
    }

    fun getStyleForType(sesType: SesType): Pair<Int, Int> {
        // SesType'a göre drawable ve padding değerlerini belirle
        return when (sesType) {
            SesType.ENSTRUMAN.UFLEMELI -> R.drawable.underline_card_instrument_orange to 24
            SesType.ENSTRUMAN.TELLI -> R.drawable.underline_card_instrument_blue to 24
            SesType.ENSTRUMAN.VURMALI -> R.drawable.underline_card_instrument_green to 24
            SesType.ENSTRUMAN.ORFF -> R.drawable.underline_card_instrument_purple to 24
            else -> R.drawable.cardview_hafiza to 0
        }
    }

    fun getBackgroundResourceForCategory(category: SesType): Int {
        return when (category) {
            SesType.ENSTRUMAN.UFLEMELI -> R.drawable.bg_enstrumanlar
            SesType.HAYVAN -> R.drawable.bg_hayvanlar
            SesType.INSAN -> R.drawable.bg_insanlar
            SesType.DOGA -> R.drawable.bg_doga
            SesType.ARAC -> R.drawable.bg_araclar
            SesType.SAYI -> R.drawable.bg_sayilar
            SesType.SEKIL -> R.drawable.bg_sekiller
            else -> R.drawable.bg_enstrumanlar // Default arka plan
        }
    }
    fun findPositionForType(sesType: SesType, sesList: ArrayList<SesModel>): Int {
        return sesList.indexOfFirst { it.type == sesType }.takeIf { it != -1 } ?: 0
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("SesViewModel", "SesViewModel cleared")
        sesMediaPlayerManager.reset()
    }
}