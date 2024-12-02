package com.aecg.oyunvemuzikae.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aecg.oyunvemuzikae.data.repository.PianoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PianoViewModel @Inject constructor(private val pianoRepository: PianoRepository) : ViewModel() {

    fun getNotationAction(buttonText: String, isFixedDo: Boolean) = pianoRepository.getNotationAction(buttonText, isFixedDo)
    fun playSound(tag: String) = pianoRepository.playSound(tag)
    fun getColorForKey(index: Int):Int = pianoRepository.getColorForKey(index)
    fun getColorForTxt(index: Int):Int = pianoRepository.getColorForTxt(index)
    fun calculateButtonWidth(increase: Boolean, currentWidth: Int, increment: Int): Int = pianoRepository.calculateButtonWidth(increase, currentWidth, increment)
    fun loadSounds() {
        viewModelScope.launch {
            pianoRepository.loadSounds()
        }
    }

    override fun onCleared() {
        super.onCleared()
        pianoRepository.release()
    }
}