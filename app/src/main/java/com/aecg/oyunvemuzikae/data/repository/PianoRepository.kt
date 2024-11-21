package com.aecg.oyunvemuzikae.data.repository

import android.widget.Button

interface PianoRepository {
    fun getWhitePianoSounds(): Array<Int>
    fun getBlackPianoSounds(): Array<Int>
    fun getDoNotation(): Array<String>
    fun getPitchNotation(): Array<String>
    fun playSound(button: Button)
    fun getPianoKeyboardColors(): Array<Int>
}