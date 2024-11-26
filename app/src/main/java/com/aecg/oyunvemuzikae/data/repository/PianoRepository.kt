package com.aecg.oyunvemuzikae.data.repository

import android.widget.Button

interface PianoRepository {
    fun getWhitePianoSounds(): Array<Int>
    fun getBlackPianoSounds(): Array<Int>
    fun getDoNotation(): Array<String>
    fun getPitchNotation(): Array<String>
    fun getClearNotation(): Array<String>
    fun getPianoKeyboardColors(): Array<Int>
    suspend fun loadSounds()
    fun release()
    fun playSound(button: Button)
}
