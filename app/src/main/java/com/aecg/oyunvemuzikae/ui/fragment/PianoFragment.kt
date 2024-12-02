package com.aecg.oyunvemuzikae.ui.fragment

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.base.BaseFragment
import com.aecg.oyunvemuzikae.databinding.FragmentPianoBinding
import com.aecg.oyunvemuzikae.ui.viewmodel.PianoViewModel
import com.aecg.oyunvemuzikae.utils.PianoConfig
import com.aecg.oyunvemuzikae.utils.setOnCustomSeekBarChangeListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PianoFragment : BaseFragment<FragmentPianoBinding>(FragmentPianoBinding::inflate) {

    private val pianoViewModel: PianoViewModel by viewModels()
    private lateinit var whiteKeys: Array<Button>
    private lateinit var blackKeys: Array<Button>
    private lateinit var allKeys: Array<Button>
    private lateinit var firsVisibleKey: Button
    private var isKeyboardColorful: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pianoViewModel.loadSounds()
        whiteKeys = getWhiteKeys()
        blackKeys = getBlackKeys()
        allKeys = whiteKeys + blackKeys
        firsVisibleKey = binding.btnC4
        triggerSoundForKey()

        with(binding) {
            scrollViewKeyboard.post { attachKeyToSeekBar(firsVisibleKey) }

            seekBarOctave.setOnCustomSeekBarChangeListener { progress, _ -> linkSeekBarToKeyboard(progress) }

            btnIncreaseKeySize.setOnClickListener { adjustKeyboardSize(true) }
            btnDecreaseKeySize.setOnClickListener { adjustKeyboardSize(false) }

            btnFixedDo.setOnClickListener {updateButtonTexts(pianoViewModel.getNotationAction(btnC2.text.toString(), true)) }
            btnpitchNotation.setOnClickListener {updateButtonTexts(pianoViewModel.getNotationAction(btnC2.text.toString(), false)) }
            btnColor.setOnClickListener { updateKeyboardColors() }

            btnHome.setOnClickListener {findNavController().navigate(R.id.pianoFragment_to_homeFragment) }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun triggerSoundForKey() {
        allKeys.forEach {
            it.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    val buttonTag = it.tag
                    pianoViewModel.playSound(buttonTag.toString())
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
    private fun updateKeyboardColors() {
        val (keyColor, textColor) = if (isKeyboardColorful) {
            Pair(ContextCompat.getDrawable(requireContext(), R.drawable.pressed_and_normal_selector), null)
        } else {Pair(null, Color.WHITE) }

        whiteKeys.forEachIndexed { index, button ->
            button.background = keyColor
                ?: ContextCompat.getDrawable(requireContext(), pianoViewModel.getColorForKey(index))

            val resolvedTextColor = textColor ?: run {
                val colorRes = pianoViewModel.getColorForTxt(index)
                ContextCompat.getColor(requireContext(), colorRes)
            }

            button.setTextColor(resolvedTextColor)
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
    ) {
        adjustKeysSize(whiteKeys, increase, PianoConfig.PHONE_INCREMENT_W)
        adjustKeysSize(blackKeys, increase, PianoConfig.PHONE_INCREMENT_B)
        binding.scrollViewKeyboard.post { attachKeyToSeekBar(firsVisibleKey) }
    }
    // Tuşların boyutunu ayarlayan yardımcı fonksiyon
    private fun adjustKeysSize(
        keys: Array<Button>,
        increase: Boolean,
        increment: Int,
    ) {
        val currentWidth = keys.first().width
        keys.forEach { key ->
            // Koşula göre minimum ve maksimum değerleri belirle
            val (minWidth, maxWidth) = if (key.tag.toString().startsWith("w")) {
                PianoConfig.PHONE_MIN_WIDTH_W to PianoConfig.PHONE_MAX_WIDTH_W
            } else {
                PianoConfig.PHONE_MIN_WIDTH_B to PianoConfig.PHONE_MAX_WIDTH_B
            }
            val newWidth = pianoViewModel
                .calculateButtonWidth(increase, currentWidth, increment)
                .coerceIn(minWidth, maxWidth)
            updateButtonWidth(key, newWidth)
        }
    }

    // Tuş genişliğini güncelleyen yardımcı fonksiyon
    private fun updateButtonWidth(button: Button, newWidth: Int) {
        button.layoutParams = (button.layoutParams as ConstraintLayout.LayoutParams).apply { width = newWidth
        Log.d("ButtonWidth", "Button width updated to: $newWidth")}
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