package com.aecg.oyunvemuzikae.ui.fragment

import android.content.res.ColorStateList
import android.media.MediaPlayer
import android.media.PlaybackParams
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.data.model.SesModel
import com.aecg.oyunvemuzikae.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentOyunHizliYavasBinding
import com.bumptech.glide.Glide
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class OyunHizliYavasFragment : BaseFragment<FragmentOyunHizliYavasBinding>(FragmentOyunHizliYavasBinding::inflate) {

    private val randomFirstOneFast = Random.nextBoolean()
    private val randomQuestionFast = Random.nextBoolean()

    private lateinit var sesList: ArrayList<SesModel>
    private lateinit var soundResIds: List<Int>
    private lateinit var randomSound: SesModel

    private var mediaPlayer: MediaPlayer? = null
    private var currentIndex = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setSoruText(randomQuestionFast)
        sesList = OyunHizliYavasFragmentArgs.fromBundle(requireArguments())
            .hizliYavasList
            .toCollection(ArrayList())

        randomSound = sesList.random()

        Glide.with(requireContext())
            .load(randomSound.imageResourceId)
            .into(binding.imgHizliYavas)

        sesList.remove(randomSound)
        soundResIds = getSoundResIds()
        playNextSound()

        binding.btnHizliYavasNextSound.setOnClickListener {
            currentIndex++
            playNextSound()
        }

        binding.btnMuzik1.setOnClickListener {
            setButtonBackground(binding.btnMuzik1, randomFirstOneFast, randomQuestionFast)
        }

        binding.btnMuzik2.setOnClickListener {
            setButtonBackground(binding.btnMuzik2, !randomFirstOneFast, randomQuestionFast)
        }
    }

    private fun setSoruText(randomQuestionFast: Boolean) {
        binding.txtHizliYavasHeader.text = if (randomQuestionFast) {
            "Hızlı olan müziği bulabilir misin ?"
        } else {
            "Yavaş olan müziği bulabilir misin ?"
        }
    }

    private fun getSoundResIds(): List<Int> {
        return listOf(
            if (randomQuestionFast) R.raw.sound_oyun_hizliyavas_hizli1 else R.raw.sound_oyun_sestenbul_soru_yavas,
            randomSound.sesResourceId,
            R.raw.sound_oyun_sestenbul_soru_ikincimuzik,
            randomSound.sesResourceId,
            if (randomQuestionFast) R.raw.sound_oyun_sestenbul_soru2 else R.raw.sound_oyun_sestenbul_soru_yavas2,
            R.raw.sound_cevap_dogru
        )
    }

    private fun playNextSound() {
        // Geçerli indeks ses kaynakları içinde sınırdaysa
        if (currentIndex < soundResIds.size) {
            // Mevcut medya çalar kaynaklarını serbest bırak ve yeni medya çalar oluştur
            releaseAndCreateMediaPlayer()
            // Hızlandırma işlemini uygula
            adjustPlaybackSpeed(currentIndex)
            // Buton görünürlüğünü ayarla
            manageButtonVisibility(currentIndex)
            // Ses tamamlandığında bir sonraki sesi çal
            mediaPlayer?.setOnCompletionListener {
                handleSoundCompletion()
            }
            mediaPlayer?.start()
        }
    }

    private fun handleSoundCompletion() {
        when (currentIndex) {
            4 -> isAnswerButtonsEnabled(true)
            5 -> navigateToSelf()
            else -> {
                currentIndex++
                playNextSound()
            }
        }
    }

    private fun navigateToSelf() {
        val action =
            OyunHizliYavasFragmentDirections.actionOyunHizliYavasFragmentSelf(sesList.toTypedArray())
        findNavController().navigate(action)
    }

    private fun isAnswerButtonsEnabled(isEnabled: Boolean) {
        binding.btnMuzik1.isEnabled = isEnabled
        binding.btnMuzik2.isEnabled = isEnabled
    }

    private fun releaseAndCreateMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(requireContext(), soundResIds[currentIndex])
    }

    private fun adjustPlaybackSpeed(index: Int) {
        val fastSpeed = 1.3f
        val slowSpeed = 0.7f
        // Hız ayarlamak için uygun hız değerini belirle
        val playbackSpeed = when {
            index == 1 && randomFirstOneFast -> fastSpeed // İlk müzik hızlıysa
            index == 3 && randomFirstOneFast -> slowSpeed // Üçüncü müzik yavaşsa
            index == 1 && !randomFirstOneFast -> slowSpeed // İlk müzik yavaşsa
            index == 3 && !randomFirstOneFast -> fastSpeed // Üçüncü müzik hızlıysa
            else -> 1.0f // Normal hız
        }
        // Eğer index 1 veya 3 ise hız ayarını uygula
        if (index == 1 || index == 3) {
            val playbackParams = PlaybackParams().apply {
                speed = playbackSpeed
            }
            mediaPlayer?.playbackParams = playbackParams
        }
    }

    private fun manageButtonVisibility(index: Int) {
        when {
            index == 5 -> {
                binding.btnHizliYavasNextSound.visibility = View.GONE
            }
            index % 2 == 1 -> {
                lifecycleScope.launch {
                    delay(2000) // 2 saniye bekle
                    if (isAdded) {
                        binding.btnHizliYavasNextSound.visibility = View.VISIBLE
                    }
                }
            }
            else -> binding.btnHizliYavasNextSound.visibility = View.GONE
        }
    }

    private fun setButtonBackground(
        selectedButton: Button,
        isFirstMusicFast: Boolean, // Çalınan müzik hızlı mı
        isQuestionAskingForFast: Boolean // Soru hızlı müziği mi bulmamızı istiyor
    ) {
        val backgroundResource = when {
            isQuestionAskingForFast == isFirstMusicFast -> {
                isAnswerButtonsEnabled(false)
                currentIndex++
                playNextSound()
                ContextCompat.getColor(requireContext(), R.color.green)
            }
            else -> ContextCompat.getColor(requireContext(), R.color.red)
        }
        selectedButton.backgroundTintList = ColorStateList.valueOf(backgroundResource)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mediaPlayer?.release() // Activity kapatıldığında mediaPlayer'i serbest bırak
    }
}
