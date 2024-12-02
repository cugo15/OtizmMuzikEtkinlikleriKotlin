package com.aecg.oyunvemuzikae.data.repository

interface PianoRepository {
    val whitePianoSounds: Array<Int>
    val blackPianoSounds: Array<Int>
    val doNotation: Array<String>
    val pitchNotation: Array<String>
    val clearNotation: Array<String>
    val pianoKeyboardColors: Array<Int>
    val pianoKeyboardTxtColors: Array<Int>
    fun calculateButtonWidth(increase: Boolean, currentWidth: Int, increment: Int): Int
    suspend fun loadSounds()
    fun getNotationAction(buttonText: String, isFixedDo: Boolean): Array<String>
    fun getColorForKey(index: Int): Int
    fun getColorForTxt(index: Int): Int
    fun release()
    fun playSound(tag: String)
}
