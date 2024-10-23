package com.aecg.oyunvemuzikae.ui

import android.media.MediaPlayer
import android.media.PlaybackParams
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.FragmentOyunHizliYavasBinding
import com.aecg.oyunvemuzikae.loadLayoutBackgroundWithGlide
import kotlin.random.Random

class OyunHizliYavasFragment : Fragment() {
    private var _binding: FragmentOyunHizliYavasBinding? = null
    private val binding get() = _binding!!

    private var handler: Handler? = null

    private val randomFast = Random.nextBoolean()
    private val randomQuestion = Random.nextBoolean()

    private val soundResIds = listOf(
        if (randomQuestion) R.raw.hizliolanibul else R.raw.yavasolanibul,
        R.raw.sound_enstruman_piyano,
        R.raw.ikincmuzik,
        R.raw.sound_enstruman_piyano,
        if (randomQuestion) R.raw.hizlitempo else R.raw.yavastempo,
    )

    private var mediaPlayer: MediaPlayer? = null
    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOyunHizliYavasBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.layoutOyunHizliYavas.loadLayoutBackgroundWithGlide(requireContext(), R.drawable.hizliyavasbkg, R.drawable.bg_doga)
        playNextSound()

        binding.btnHizliYavasNextSound.setOnClickListener {
            currentIndex++
            playNextSound()
        }

        binding.btnMuzik1.setOnClickListener {
            setButtonBackground(binding.btnMuzik1, randomFast, randomQuestion)
        }

        binding.btnMuzik2.setOnClickListener {
            setButtonBackground(binding.btnMuzik2, !randomFast, randomQuestion)
        }

        return view
    }

    private fun playNextSound() {
        if (currentIndex < soundResIds.size) {
            // Mevcut medya çalar kaynakları serbest bırakılıyor ve yeni medya çalıcı başlatılıyor
            releaseAndCreateMediaPlayer()
            // Hızlandırma işlemi
            adjustPlaybackSpeed(currentIndex)
            // Butonun görünürlüğünü ayarla
            manageButtonVisibility(currentIndex)
            // Ses tamamlandığında bir sonraki sesi çal
            mediaPlayer?.setOnCompletionListener {
                currentIndex++
                playNextSound()
            }
            mediaPlayer?.start()
        }
    }

    private fun releaseAndCreateMediaPlayer() {
        mediaPlayer?.release()
        mediaPlayer = MediaPlayer.create(requireContext(), soundResIds[currentIndex])
    }

    private fun adjustPlaybackSpeed(index: Int) {
        // Hızlandırma ve yavaşlatma hızları
        val fastSpeed = 1.3f
        val slowSpeed = 0.7f
        // İlk ve üçüncü ses dosyası için hız değişimi yap
        if (index == 1 || index == 3) {
            val playbackParams = PlaybackParams().apply {
                speed = when {
                    randomFast && index == 1 -> fastSpeed // İlk müzik hızlıysa
                    randomFast && index == 3 -> slowSpeed // Üçüncü müzik yavaşsa
                    !randomFast && index == 1 -> slowSpeed // İlk müzik yavaşsa
                    !randomFast && index == 3 -> fastSpeed // Üçüncü müzik hızlıysa
                    else -> 1.0f // Normal hız
                }
            }
            mediaPlayer?.playbackParams = playbackParams
        }
    }

    private fun manageButtonVisibility(index: Int) {
        // Tek indekslerde buton görünür, çift indekslerde gizlenir
        if (index % 2 == 1) {
            handler = Handler(Looper.getMainLooper())
            handler?.postDelayed({
                if (isAdded) {
                    binding.btnHizliYavasNextSound.visibility = View.VISIBLE
                }
            }, 2000)
        } else {
            binding.btnHizliYavasNextSound.visibility = View.GONE
        }
    }

    private fun setButtonBackground(
        selectedButton: Button,
        isFirstMusicFast: Boolean, // Çalınan müzik hızlı mı
        isQuestionAskingForFast: Boolean // Soru hızlı müziği mi bulmamızı istiyor
    ) {
        val backgroundResource = if (isQuestionAskingForFast == isFirstMusicFast) {
            R.drawable.border
        } else {
            R.drawable.border_red
        }
        selectedButton.setBackgroundResource(backgroundResource)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler?.removeCallbacksAndMessages(null)
        _binding = null
        mediaPlayer?.release() // Activity kapatıldığında mediaPlayer'i serbest bırak
    }
}
