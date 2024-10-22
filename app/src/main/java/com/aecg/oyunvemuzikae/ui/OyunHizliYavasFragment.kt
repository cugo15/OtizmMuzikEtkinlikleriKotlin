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
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.FragmentOyunHizliYavasBinding
import com.aecg.oyunvemuzikae.loadLayoutBackgroundWithGlide
import kotlin.random.Random

class OyunHizliYavasFragment : Fragment() {
    private var _binding: FragmentOyunHizliYavasBinding? = null
    private val binding get() = _binding!!
    private var handler: Handler? = null
    private var randomBoolean: Boolean? = null
    private val soundResIds = listOf(
        R.raw.hizliolanibul, // Hızlandırılacak ses dosyası
        R.raw.sound_enstruman_piyano,
        R.raw.ikincmuzik,
        R.raw.sound_enstruman_piyano,
        R.raw.hizlitempo
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
        randomBoolean = Random.nextBoolean()
        playNextSound()

        binding.btnHizliYavasNextSound.setOnClickListener {
            currentIndex++
            playNextSound()
        }

        return view
    }

    private fun playNextSound() {
        if (currentIndex < soundResIds.size) {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(requireContext(), soundResIds[currentIndex])

            // Hızlandırma işlemi sadece ilk ses dosyası için
            if (randomBoolean!!) {
                // Eğer randomBoolean true ise, ilk ses dosyasını hızlandır
                if (currentIndex == 1) { // Hızlandırma sadece ilk ses dosyası için
                    val playbackParams = PlaybackParams().setSpeed(1.5f) // 1.5 kat hızlandır
                    mediaPlayer?.playbackParams = playbackParams
                }
                if (currentIndex == 3) {
                    val playbackParams = PlaybackParams().setSpeed(0.5f) // 1.5 kat hızlandır
                    mediaPlayer?.playbackParams = playbackParams
                }
            } else {
                if (currentIndex == 1) {
                    val playbackParams = PlaybackParams().setSpeed(0.5f) // 1.5 kat hızlandır
                    mediaPlayer?.playbackParams = playbackParams
                }
                if (currentIndex == 3) {
                    val playbackParams = PlaybackParams().setSpeed(1.5f) // 1.5 kat hızlandır
                    mediaPlayer?.playbackParams = playbackParams
                }
            }

            if (currentIndex % 2 == 1) {
                handler = Handler(Looper.getMainLooper())
                handler?.postDelayed({
                    if (isAdded) { // Fragment hala aktif mi kontrol et
                        binding.btnHizliYavasNextSound.visibility = View.VISIBLE
                    }
                }, 2000)
            } else {
                binding.btnHizliYavasNextSound.visibility = View.GONE
            }

            mediaPlayer?.setOnCompletionListener {
                currentIndex++
                playNextSound()
            }

            mediaPlayer?.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        handler?.removeCallbacksAndMessages(null)
        _binding = null
        mediaPlayer?.release() // Activity kapatıldığında mediaPlayer'i serbest bırak
    }
}
