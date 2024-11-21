package com.aecg.oyunvemuzikae.ui.viewmodel

import android.widget.Button
import androidx.lifecycle.ViewModel
import com.aecg.oyunvemuzikae.data.repository.PianoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PianoViewModel @Inject constructor(private val pianoRepository: PianoRepository) : ViewModel() {
    private val doNotation = pianoRepository.getDoNotation()
    private val pitchNotation = pianoRepository.getPitchNotation()
    private val pianoColors = pianoRepository.getPianoKeyboardColors()

    fun getDoNotation() = doNotation
    fun getPitchNotation() = pitchNotation
    fun getPianoColors() = pianoColors
    fun playSound(button: Button) = pianoRepository.playSound(button)
}