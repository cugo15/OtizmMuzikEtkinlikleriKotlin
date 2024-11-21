package com.aecg.oyunvemuzikae.data.repository

import android.content.Context
import android.media.SoundPool
import android.widget.Button
import com.aecg.oyunvemuzikae.data.datasource.PianoDataSource
import javax.inject.Inject

class PianoRepositoryImpl @Inject constructor(
    private val pianoDataSource: PianoDataSource,
    private val context: Context,
    private val soundPool: SoundPool
) : PianoRepository {

    override fun getWhitePianoSounds() = pianoDataSource.getWhitePianoSounds()
    override fun getBlackPianoSounds() = pianoDataSource.getBlackPianoSounds()
    override fun getDoNotation() = pianoDataSource.getDoNotation()
    override fun getPitchNotation() = pianoDataSource.getPitchNotation()
    override fun getPianoKeyboardColors(): Array<Int> = pianoDataSource.getPianoKeyboardColors()

    private val soundMap = mutableMapOf<String, Int>()
    // Sesler yükleniyor
    init {
        loadSounds()
    }
    // Seslerin yüklenmesi
    private fun loadSounds() {
        // Beyaz tuşların seslerini yükle
        pianoDataSource.getWhitePianoSounds().forEachIndexed { index, soundRes ->
            soundMap["white_$index"] = soundPool.load(context, soundRes, 1)
        }
        // Siyah tuşların seslerini yükle
        pianoDataSource.getBlackPianoSounds().forEachIndexed { index, soundRes ->
            soundMap["black_$index"] = soundPool.load(context, soundRes, 1)
        }
    }
    // Butonla eşleşen sesi çalma
    override fun playSound(button: Button) {
        // Butonun tag'ini kullanarak doğru ses ID'sini bul
        val soundId = button.tag?.toString()?.let { soundMap[it] }
        // Ses ID'si varsa, sesi çal
        soundId?.let {
            soundPool.play(it, 1f, 1f, 0, 0, 1f)
        }
    }

}
