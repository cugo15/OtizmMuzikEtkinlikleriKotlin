package com.aecg.oyunvemuzikae.data.repository

import android.content.Context
import android.media.SoundPool
import android.util.Log
import com.aecg.oyunvemuzikae.data.datasource.PianoDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PianoRepositoryImpl @Inject constructor(
    pianoDataSource: PianoDataSource,
    private val context: Context,
    private val soundPool: SoundPool
) : PianoRepository {

    override val whitePianoSounds: Array<Int> = pianoDataSource.getWhitePianoSounds()
    override val blackPianoSounds: Array<Int> = pianoDataSource.getBlackPianoSounds()
    override val doNotation: Array<String> = pianoDataSource.getDoNotation()
    override val pitchNotation: Array<String> = pianoDataSource.getPitchNotation()
    override val clearNotation: Array<String> = pianoDataSource.getClearNotation()
    override val pianoKeyboardColors: Array<Int> = pianoDataSource.getPianoKeyboardColors()
    override val pianoKeyboardTxtColors: Array<Int> = pianoDataSource.getPianoKeyboardTxt()
    private val soundMap = mutableMapOf<String, Int>()

    override suspend fun loadSounds() {
        // IO thread üzerinde işlemleri başlatıyoruz
        withContext(Dispatchers.IO) {
            val whiteSounds = async {
                whitePianoSounds.forEachIndexed { index, soundRes ->
                    val soundId = soundPool.load(context, soundRes, 1)
                    soundMap["white_$index"] = soundId
                }
            }
            val blackSounds = async {
                blackPianoSounds.forEachIndexed { index, soundRes ->
                    val soundId = soundPool.load(context, soundRes, 1)
                    soundMap["black_$index"] = soundId
                }
            }
            whiteSounds.await()
            blackSounds.await()
            withContext(Dispatchers.Main) {
                Log.d("SoundPool", "Sesler yüklendi. Toplam ses sayısı: ${soundMap.size}")
            }
        }
    }

    override fun getColorForKey(index: Int): Int = pianoKeyboardColors[index % pianoKeyboardColors.size]

    override fun getColorForTxt(index: Int): Int {
        if (index in 0..6){
            return pianoKeyboardTxtColors[0]
        }
        else if (index in 7..13){
            return pianoKeyboardTxtColors[1]
        }
        else if (index in 14..20){
            return pianoKeyboardTxtColors[2]
        }
        else if (index in 21..27){
            return pianoKeyboardTxtColors[3]
        }
        else if (index in 28..34){
            return pianoKeyboardTxtColors[4]
        }
        else{
            return pianoKeyboardTxtColors[5]
        }
    }



    override fun playSound(tag: String) {
            val soundId = soundMap[tag]
            soundId?.let {
                soundPool.play(it, 1f, 1f, 0, 0, 1f)
            }
    }

    override fun getNotationAction(buttonText: String, isFixedDo: Boolean): Array<String> {
        return when (buttonText) {
            "Do2" -> if (isFixedDo) clearNotation else pitchNotation
            "C2" -> if (isFixedDo) doNotation else clearNotation
            else -> if (isFixedDo) doNotation else pitchNotation
        }
    }
    override fun calculateButtonWidth(increase: Boolean, currentWidth: Int, increment: Int): Int {
        return when {
            increase -> currentWidth + increment
            !increase -> currentWidth - increment
            else -> currentWidth
        }
    }
    override fun release() {
        soundPool.release()
    }

}
