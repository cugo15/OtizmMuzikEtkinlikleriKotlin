package com.aecg.oyunvemuzikae.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentPianoBinding
import com.aecg.oyunvemuzikae.ui.viewmodel.PianoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PianoFragment : BaseFragment<FragmentPianoBinding>(FragmentPianoBinding::inflate) {

    private val pianoViewModel: PianoViewModel by viewModels()
    private lateinit var whiteKeys: List<Button>
    private lateinit var blackKeys: List<Button>
    private lateinit var allKeys: List<Button>
    private lateinit var firstVisibleItem: Button
    private var c: Int = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        whiteKeys = getWhiteKeys()
        blackKeys = getBlackKeys()
        allKeys = whiteKeys + blackKeys
        firstVisibleItem = binding.btnC4
        triggerSoundForKey()

        binding.scrollViewKeyboard.post { attachKeyToSeekBar(firstVisibleItem) }

        binding.seekBarOctave.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                linkSeekBarToKeyboard(i)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        binding.btnHome.setOnClickListener { findNavController().navigate(R.id.pianoFragment_to_homeFragment) }
        binding.btnIncreaseKeySize.setOnClickListener { adjustKeyboardSize(true) }
        binding.btnDecreaseKeySize.setOnClickListener { adjustKeyboardSize(false) }
        binding.btnFixedDo.setOnClickListener { handleNotationButtonClick(binding.btnC2.text.toString()) }
        binding.btnpitchNotation.setOnClickListener { handlePitchNotationButtonClick(binding.btnC2.text.toString()) }

        binding.btnColor.setOnClickListener {
            c++
            when {
                c % 2 == 0 -> whiteKeyboard()  // Beyaz yap
                else -> updateKeyboardColors(pianoViewModel.getPianoColors())     // Renkli yap
            }
        }
    }


    @SuppressLint("ClickableViewAccessibility")
    private fun triggerSoundForKey() {
        allKeys.forEach {
            it.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    pianoViewModel.playSound(it)
                }
                false
            }
        }
    }

    private fun updateButtonTexts(notations: Array<String>) {
        whiteKeys.forEachIndexed { index, button ->
                button.text = notations[index]
        }
    }
    private fun handleNotationButtonClick(buttonText: String) {
        when (buttonText) {
            "" -> fixedDo()  // Eğer metin boşsa, fixedDo() çağrılır
            "Do2" -> clearNotation()  // Eğer metin "Do2" ise, notaları temizle
            "C2" -> fixedDo()  // Eğer metin "C2" ise, fixedDo() çağrılır
        }
    }
    private fun handlePitchNotationButtonClick(buttonText: String) {
        when (buttonText) {
            "" -> pitchNotation()  // Eğer metin boşsa, pitchNotation() çağrılır
            "C2" -> clearNotation()  // Eğer metin "C2" ise, notaları temizle
            "Do2" -> pitchNotation()  // Eğer metin "Do2" ise, pitchNotation() çağrılır
        }
    }
    private fun fixedDo() = updateButtonTexts(pianoViewModel.getDoNotation())
    private fun pitchNotation() = updateButtonTexts(pianoViewModel.getPitchNotation())
    private fun clearNotation() = updateButtonTexts(Array(whiteKeys.size) { "" })


    private fun updateKeyboardColors(colors: Array<Int>) {
        whiteKeys.forEachIndexed { index, button ->
            val drawable = ContextCompat.getDrawable(requireContext(), colors[index % colors.size])
            drawable?.let {
                button.background = it
            }
        }
    }
    // Klavyeyi beyazlat
    private fun whiteKeyboard() {
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.pressed_and_normal_selector)
        whiteKeys.forEach { button ->
            drawable?.let {
                button.background = it
            }
        }
    }

    private fun getBlackKeys(): List<Button> {
        return listOf(
            binding.btnDiyezC2, // C#2
            binding.btnDiyezD2, // D#2
            binding.btnDiyezF2, // F#2
            binding.btnDiyezG2, // G#2
            binding.btnDiyezA2, // A#2

            binding.btnDiyezC3, // C#3
            binding.btnDiyezD3, // D#3
            binding.btnDiyezF3, // F#3
            binding.btnDiyezG3, // G#3
            binding.btnDiyezA3, // A#3

            binding.btnDiyezC4, // C#4
            binding.btnDiyezD4, // D#4
            binding.btnDiyezF4, // F#4
            binding.btnDiyezG4, // G#4
            binding.btnDiyezA4, // A#4

            binding.btnDiyezC5, // C#5
            binding.btnDiyezD5, // D#5
            binding.btnDiyezF5, // F#5
            binding.btnDiyezG5, // G#5
            binding.btnDiyezA5, // A#5

            binding.btnDiyezC6, // C#6
            binding.btnDiyezD6, // D#6
            binding.btnDiyezF6, // F#6
            binding.btnDiyezG6, // G#6
            binding.btnDiyezA6, // A#6
        )
    }

    private fun getWhiteKeys(): List<Button> {
        return listOf(
            binding.btnC2,   // C2 butonu
            binding.btnD2,   // D2 butonu
            binding.btnE2,   // E2 butonu
            binding.btnF2,   // F2 butonu
            binding.btnG2,   // G2 butonu
            binding.btnA2,   // A2 butonu
            binding.btnB2,   // B2 butonu

            binding.btnC3,   // C3 butonu
            binding.btnD3,   // D3 butonu
            binding.btnE3,   // E3 butonu
            binding.btnF3,   // F3 butonu
            binding.btnG3,   // G3 butonu
            binding.btnA3,   // A3 butonu
            binding.btnB3,   // B3 butonu

            binding.btnC4,   // C4 butonu
            binding.btnD4,   // D4 butonu
            binding.btnE4,   // E4 butonu
            binding.btnF4,   // F4 butonu
            binding.btnG4,   // G4 butonu
            binding.btnA4,   // A4 butonu
            binding.btnB4,   // B4 butonu

            binding.btnC5,   // C5 butonu
            binding.btnD5,   // D5 butonu
            binding.btnE5,   // E5 butonu
            binding.btnF5,   // F5 butonu
            binding.btnG5,   // G5 butonu
            binding.btnA5,   // A5 butonu
            binding.btnB5,   // B5 butonu

            binding.btnC6,   // C6 butonu
            binding.btnD6,   // D6 butonu
            binding.btnE6,   // E6 butonu
            binding.btnF6,   // F6 butonu
            binding.btnG6,   // G6 butonu
            binding.btnA6,   // A6 butonu
            binding.btnB6,   // B6 butonu

            binding.btnC7    // C7 butonu
        )
    }

    // Tüm tuşların boyutunu artıran fonksiyon
    private fun adjustKeyboardSize(
        increase: Boolean,
        whiteIncrement: Int = 9,
        blackIncrement: Int = 6,
        maxWhiteWidth: Int = 270,
        minWhiteWidth: Int = 90,
        maxBlackWidth: Int = 180,
        minBlackWidth: Int = 60
    ) {
        // Tuşları düzenle
        adjustKeysSize(whiteKeys, increase, maxWhiteWidth, minWhiteWidth, whiteIncrement, "Beyaz")
        adjustKeysSize(blackKeys, increase, maxBlackWidth, minBlackWidth, blackIncrement, "Siyah")
    }
    // Tuşların boyutunu ayarlayan yardımcı fonksiyon
    private fun adjustKeysSize(
        keys: List<View>,
        increase: Boolean,
        maxWidth: Int,
        minWidth: Int,
        increment: Int,
        keyType: String
    ) {
        keys.forEach { key ->
            val newWidth = calculateNewWidth(key.width, increase, maxWidth, minWidth, increment)
            updateButtonWidth(key, newWidth, keyType)
        }
    }
    // Yeni genişliği hesaplamak için yardımcı fonksiyon
    private fun calculateNewWidth(
        currentWidth: Int,
        increase: Boolean,
        maxButtonWidth: Int,
        minButtonWidth: Int,
        increment: Int
    ): Int {
        return when {
            increase && (currentWidth < maxButtonWidth || currentWidth == 0) -> currentWidth + increment
            !increase && currentWidth > minButtonWidth -> currentWidth - increment
            else -> currentWidth
        }
    }
    // Tuş genişliğini güncelleyen yardımcı fonksiyon
    private fun updateButtonWidth(button: View, newWidth: Int, keyType: String) {
        if (newWidth != button.width) {
            println("$keyType tuş mevcut genişlik: ${button.width}")
            button.layoutParams = (button.layoutParams as RelativeLayout.LayoutParams).apply {
                width = newWidth // Yeni genişliği ayarla
            }

            // Beyaz tuşlar için ekstra işlem
            if (keyType == "Beyaz") {
                binding.scrollViewKeyboard.post { attachKeyToSeekBar(firstVisibleItem) }
            }
        }
    }
    // SeekBar ile klavyeyi bağlayan fonksiyon
    private fun linkSeekBarToKeyboard(i: Int) {
        if (i in whiteKeys.indices) {
            attachKeyToSeekBar(whiteKeys[i]) // İlgili tuşu SeekBar ile bağla
            firstVisibleItem = whiteKeys[i]
        } else if (i == 36) { // Özel bir durum için
            attachKeyToSeekBar(binding.btnC7) // C7 tuşunu bağla
        }

    }
    // Buton'u SeekBar ile bağlamak için fonksiyon
    private fun attachKeyToSeekBar(button: Button) {
        binding.layoutKeyboard.post {
            val x = button.left // Tuşun sol pozisyonunu al
            val y = button.top  // Tuşun üst pozisyonunu al
            binding.scrollViewKeyboard.smoothScrollTo(x, y) // ScrollView'u yumuşak bir şekilde kaydır
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }
}