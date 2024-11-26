package com.aecg.oyunvemuzikae.ui.viewmodel

import android.widget.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aecg.oyunvemuzikae.data.repository.PianoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PianoViewModel @Inject constructor(private val pianoRepository: PianoRepository) : ViewModel() {
    private val doNotation = pianoRepository.getDoNotation()
    private val pitchNotation = pianoRepository.getPitchNotation()
    private val clearNotation = pianoRepository.getClearNotation()

    private val pianoColors = pianoRepository.getPianoKeyboardColors()

    fun getClearNotation() = clearNotation
    fun getDoNotation() = doNotation
    fun getPitchNotation() = pitchNotation
    fun playSound(button: Button) = pianoRepository.playSound(button)
    fun getColorForKey(index: Int): Int {
        return pianoColors[index % pianoColors.size]
    }

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