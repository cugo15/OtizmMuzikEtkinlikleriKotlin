package com.aecg.oyunvemuzikae.ui

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.databinding.FragmentOyunHizliYavasBinding
import com.aecg.oyunvemuzikae.loadLayoutBackgroundWithGlide

class OyunHizliYavasFragment : Fragment() {
    private var _binding: FragmentOyunHizliYavasBinding? = null
    private val binding get() = _binding!!

    private val soundResIds = listOf(
        R.raw.hizliolanibul, // Ses dosyalarını buraya ekle
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
        playNextSound()



        return view
}

    private fun playNextSound() {
        if (currentIndex < soundResIds.size) {
            mediaPlayer?.release() // Önceki mediaPlayer'i serbest bırak
            mediaPlayer = MediaPlayer.create(requireContext(), soundResIds[currentIndex])

            mediaPlayer?.setOnCompletionListener {
                currentIndex++
                playNextSound() // Sıradaki sesi çal
            }

            mediaPlayer?.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        mediaPlayer?.release() // Activity kapatıldığında mediaPlayer'i serbest bırak
    }
}