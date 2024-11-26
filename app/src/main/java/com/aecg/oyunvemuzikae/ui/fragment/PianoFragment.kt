package com.aecg.oyunvemuzikae.ui.fragment

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentPianoBinding
import com.aecg.oyunvemuzikae.ui.viewmodel.PianoViewModel
import com.aecg.oyunvemuzikae.utils.setOnCustomSeekBarChangeListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PianoFragment : BaseFragment<FragmentPianoBinding>(FragmentPianoBinding::inflate) {

    private val pianoViewModel: PianoViewModel by viewModels()
    private lateinit var whiteKeys: Array<Button>
    private lateinit var blackKeys: Array<Button>
    private lateinit var allKeys: Array<Button>

    private val fixedDo by lazy { pianoViewModel.getDoNotation() }
    private val pitchNotation by lazy { pianoViewModel.getPitchNotation() }
    private val clearNotation by lazy { pianoViewModel.getClearNotation() }

    private lateinit var firsVisibleKey: Button
    private var isKeyboardColorful: Boolean = false
    private var keyColor: Drawable? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pianoViewModel.loadSounds()
        whiteKeys = getWhiteKeys()
        blackKeys = getBlackKeys()
        allKeys = whiteKeys + blackKeys
        firsVisibleKey = binding.btnC4
        triggerSoundForKey()
        binding.scrollViewKeyboard.post { attachKeyToSeekBar(firsVisibleKey) }
        binding.seekBarOctave.setOnCustomSeekBarChangeListener { progress, _ -> linkSeekBarToKeyboard(progress) }
        binding.btnIncreaseKeySize.setOnClickListener { adjustKeyboardSize(true) }
        binding.btnDecreaseKeySize.setOnClickListener { adjustKeyboardSize(false) }
        binding.btnFixedDo.setOnClickListener {updateButtonTexts(handleNotationButtonClick(binding.btnC2.text.toString(),true))}
        binding.btnpitchNotation.setOnClickListener {updateButtonTexts(handleNotationButtonClick(binding.btnC2.text.toString(),false))}
        binding.btnHome.setOnClickListener { findNavController().navigate(R.id.pianoFragment_to_homeFragment) }
        binding.btnColor.setOnClickListener { updateKeyboardColors() }
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

    private fun handleNotationButtonClick(buttonText: String, isFixedDo: Boolean):Array<String> {
        val notationAction = when (buttonText) {
            "Do2" -> if (isFixedDo) { clearNotation } else { pitchNotation }
            "C2" -> if (isFixedDo) { fixedDo } else { clearNotation }
            else -> if (isFixedDo) { fixedDo } else { pitchNotation }
        }
        return notationAction
    }

    private fun updateKeyboardColors() {
        if (isKeyboardColorful) {
            keyColor = ContextCompat.getDrawable(requireContext(), R.drawable.pressed_and_normal_selector)
        }
        whiteKeys.forEachIndexed { index, button ->
            if (!isKeyboardColorful){
                keyColor = ContextCompat.getDrawable(requireContext(), pianoViewModel.getColorForKey(index))
            }
            button.background = keyColor
        }
        isKeyboardColorful = !isKeyboardColorful
    }

    private fun getBlackKeys(): Array<Button> {
        return arrayOf(
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
    private fun getWhiteKeys(): Array<Button> {
        return arrayOf(
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
        keys: Array<Button>,
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
                binding.scrollViewKeyboard.post { attachKeyToSeekBar(firsVisibleKey) }
            }
        }
    }
    // SeekBar ile klavyeyi bağlayan fonksiyon
    private fun linkSeekBarToKeyboard(i: Int) {
        if (i in whiteKeys.indices) {
            attachKeyToSeekBar(whiteKeys[i])
            firsVisibleKey = whiteKeys[i]
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

}