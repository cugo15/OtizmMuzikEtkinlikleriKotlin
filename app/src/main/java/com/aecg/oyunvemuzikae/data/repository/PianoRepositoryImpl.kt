package com.aecg.oyunvemuzikae.data.repository

import android.content.Context
import android.media.SoundPool
import android.util.Log
import android.widget.Button
import com.aecg.oyunvemuzikae.data.datasource.PianoDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
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
    override fun getClearNotation() = pianoDataSource.getClearNotation()

    override fun getPianoKeyboardColors(): Array<Int> = pianoDataSource.getPianoKeyboardColors()

    private val soundMap = mutableMapOf<String, Int>()
    // Seslerin yüklenmesi
    override suspend fun loadSounds() {
        // IO thread üzerinde işlemleri başlatıyoruz
        withContext(Dispatchers.IO) {
            val whiteSounds = async {
                getWhitePianoSounds().forEachIndexed { index, soundRes ->
                    // Yükleme işlemi hemen başlayacak, ancak sesin yüklenmesini bekleyeceğiz
                    val soundId = soundPool.load(context, soundRes, 1)
                    soundMap["white_$index"] = soundId
                }
            }
            val blackSounds = async {
                getBlackPianoSounds().forEachIndexed { index, soundRes ->
                    // Aynı şekilde, her bir sesin yüklenmesini bekliyoruz
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


    // Butonla eşleşen sesi çalma
    override fun playSound(button: Button) {
            val soundId = button.tag?.toString()?.let { soundMap[it] }
            soundId?.let {
                soundPool.play(it, 1f, 1f, 0, 0, 1f)
            }

    }
    override fun release() {
        soundPool.release()
    }

}
