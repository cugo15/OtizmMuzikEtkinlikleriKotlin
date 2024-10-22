package com.aecg.oyunvemuzikae.ui

import android.media.SoundPool
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.aecg.oyunvemuzikae.R

import com.aecg.oyunvemuzikae.databinding.FragmentPianoBinding

class PianoFragment : Fragment() {
    private var _binding: FragmentPianoBinding? = null
    private val binding get() = _binding!!

    private lateinit var soundPool: SoundPool
    private val soundMap = mutableMapOf<View, Int>()
    private lateinit var whiteKeys: List<Button>
    private lateinit var blackKeys: List<Button>
    private lateinit var firstVisibleItem: Button
    private var c: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPianoBinding.inflate(inflater, container, false)
        val view = binding.root
        whiteKeys = getWhiteKeys()
        blackKeys = getBlackKeys()
        firstVisibleItem = binding.btnC4

        initializeSoundPool()
        loadSounds()
        setupListeners()

        binding.scrollViewKeyboard.setScrolling(false)

        binding.scrollViewKeyboard.post { attachKeyToSeekBar(firstVisibleItem) }

        binding.seekBarOctave.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                linkSeekBarToKeyboard(i)
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.pianoFragment_to_homeFragment)
        }

        binding.btnIncreaseKeySize.setOnClickListener {
            adjustKeyboardSize(true)
        }
        binding.btnDecreaseKeySize.setOnClickListener {
            adjustKeyboardSize(false)
        }

        binding.btnFixedDo.setOnClickListener {
            when (binding.btnC2.text) {
                "" -> fixedDo() // Eğer metin boşsa
                "Do2" -> clearNotation()   // Eğer metin "Do2" ise
                "C2" -> fixedDo() // Eğer metin "C2" ise
            }
        }
        binding.btnpitchNotation.setOnClickListener {
            when (binding.btnC2.text) {
                "" -> pitchNotation()   // Eğer metin boşsa
                "C2" -> clearNotation()  // Eğer metin "C2" ise
                "Do2" -> pitchNotation() // Eğer metin "Do2" ise
            }
        }
        binding.btnColor.setOnClickListener {
            c++
            when {
                c % 2 == 0 -> whiteKeyboard()  // Beyaz yap
                else -> colorfulKeyboard()      // Renkli yap
            }
        }



        return view
    }

    private fun initializeSoundPool() {
        soundPool = SoundPool.Builder()
            .setMaxStreams(10) // Aynı anda çalabilecek maksimum ses sayısı
            .build()
    }
    private fun loadSounds() {
        // Ses dosyalarının kaynakları
        val soundResources = mapOf(
            binding.btnC2 to R.raw.sound_piano_c2,
            binding.btnDiyezC2 to R.raw.sound_piano_c2diyez,
            binding.btnD2 to R.raw.sound_piano_d2,
            binding.btnDiyezD2 to R.raw.sound_piano_d2diyez,
            binding.btnE2 to R.raw.sound_piano_e2,
            binding.btnF2 to R.raw.sound_piano_f2,
            binding.btnDiyezF2 to R.raw.sound_piano_f2diyez,
            binding.btnG2 to R.raw.sound_piano_g2,
            binding.btnDiyezG2 to R.raw.sound_piano_g2diyez,
            binding.btnA2 to R.raw.sound_piano_a2,
            binding.btnDiyezA2 to R.raw.sound_piano_a2diyez,
            binding.btnB2 to R.raw.sound_piano_b2,
            binding.btnC3 to R.raw.sound_piano_c3,
            binding.btnDiyezC3 to R.raw.sound_piano_c3diyez,
            binding.btnD3 to R.raw.sound_piano_d3,
            binding.btnDiyezD3 to R.raw.sound_piano_d3diyez,
            binding.btnE3 to R.raw.sound_piano_e3,
            binding.btnF3 to R.raw.sound_piano_f3,
            binding.btnDiyezF3 to R.raw.sound_piano_f3diyez,
            binding.btnG3 to R.raw.sound_piano_g3,
            binding.btnDiyezG3 to R.raw.sound_piano_g3diyez,
            binding.btnA3 to R.raw.sound_piano_a3,
            binding.btnDiyezA3 to R.raw.sound_piano_a3diyez,
            binding.btnB3 to R.raw.sound_piano_b3,
            binding.btnC4 to R.raw.sound_piano_c4,
            binding.btnDiyezC4 to R.raw.sound_piano_c4diyez,
            binding.btnD4 to R.raw.sound_piano_d4,
            binding.btnDiyezD4 to R.raw.sound_piano_d4diyez,
            binding.btnE4 to R.raw.sound_piano_e4,
            binding.btnF4 to R.raw.sound_piano_f4,
            binding.btnDiyezF4 to R.raw.sound_piano_f4diyez,
            binding.btnG4 to R.raw.sound_piano_g4,
            binding.btnDiyezG4 to R.raw.sound_piano_g4diyez,
            binding.btnA4 to R.raw.sound_piano_a4,
            binding.btnDiyezA4 to R.raw.sound_piano_a4diyez,
            binding.btnB4 to R.raw.sound_piano_b4,
            binding.btnC5 to R.raw.sound_piano_c5,
            binding.btnDiyezC5 to R.raw.sound_piano_c5diyez,
            binding.btnD5 to R.raw.sound_piano_d5,
            binding.btnDiyezD5 to R.raw.sound_piano_d5diyez,
            binding.btnE5 to R.raw.sound_piano_e5,
            binding.btnF5 to R.raw.sound_piano_f5,
            binding.btnDiyezF5 to R.raw.sound_piano_f5diyez,
            binding.btnG5 to R.raw.sound_piano_g5,
            binding.btnDiyezG5 to R.raw.sound_piano_g5diyez,
            binding.btnA5 to R.raw.sound_piano_a5,
            binding.btnDiyezA5 to R.raw.sound_piano_a5diyez,
            binding.btnB5 to R.raw.sound_piano_b5,
            binding.btnC6 to R.raw.sound_piano_c6,
            binding.btnDiyezC6 to R.raw.sound_piano_c6diyez,
            binding.btnD6 to R.raw.sound_piano_d6,
            binding.btnDiyezD6 to R.raw.sound_piano_d6diyez,
            binding.btnE6 to R.raw.sound_piano_e6,
            binding.btnF6 to R.raw.sound_piano_f6,
            binding.btnDiyezF6 to R.raw.sound_piano_f6diyez,
            binding.btnG6 to R.raw.sound_piano_g6,
            binding.btnDiyezG6 to R.raw.sound_piano_g6diyez,
            binding.btnA6 to R.raw.sound_piano_a6,
            binding.btnDiyezA6 to R.raw.sound_piano_a6diyez,
            binding.btnB6 to R.raw.sound_piano_b6,
            binding.btnC7 to R.raw.sound_piano_c7
        )
        // Sesleri yükleme işlemi
        soundResources.forEach { (view, resId) ->
            soundMap[view] = soundPool.load(requireContext(), resId, 1)
        }
    }

    private fun setupListeners() {
        binding.btnHome.setOnClickListener {
            findNavController().navigate(R.id.pianoFragment_to_homeFragment)
        }

        soundMap.keys.forEach { button ->
            button.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    playSound(button)
                }
                false
            }
        }
    }

    private fun playSound(view: View) {
        // soundMap'den 'view' ile eşleşen ses ID'sini alır
        soundMap[view]?.let { soundId ->
            // Eğer 'soundId' mevcutsa, ses çalınır
            soundPool.play(
                soundId,  // Çalmak istediğiniz ses kaynağının kimliği
                1f,       // Ses seviyesi (1.0 maksimum)
                1f,       // Ses seviyesi (1.0 maksimum)
                0,        // Sesin tekrar sayısı (0, sesi yalnızca bir kez çalar)
                0,        // Sesin başlangıç zamanı (0, sesi hemen başlatır)
                1f        // Sesin hızını belirler (1.0 normal hız)
            )
        } // 'let' bloğu, soundId null değilse çalışır
    }

    private fun fixedDo() {
        val notalar = listOf(
            "Do2", "Re2", "Mi2", "Fa2", "Sol2", "La2", "Si2",
            "Do3", "Re3", "Mi3", "Fa3", "Sol3", "La3", "Si3",
            "Do4", "Re4", "Mi4", "Fa4", "Sol4", "La4", "Si4",
            "Do5", "Re5", "Mi5", "Fa5", "Sol5", "La5", "Si5",
            "Do6", "Re6", "Mi6", "Fa6", "Sol6", "La6", "Si6",
            "Do7"
        )
        whiteKeys.forEachIndexed { index, button ->
            button.text = notalar[index]
        }
    }
    //Pitch Notaları göster
    private fun pitchNotation() {
        val notalar = listOf(
            "C2", "D2", "E2", "F2", "G2", "A2", "B2",
            "C3", "D3", "E3", "F3", "G3", "A3", "B3",
            "C4", "D4", "E4", "F4", "G4", "A4", "B4",
            "C5", "D5", "E5", "F5", "G5", "A5", "B5",
            "C6", "D6", "E6", "F6", "G6", "A6", "B6",
            "C7"
        )
        whiteKeys.forEachIndexed { index, button ->
                button.text = notalar[index]
        }
    }
    // Notaları temizle
    private fun clearNotation() {
        whiteKeys.forEach { it.text = "" }
    }
    // Klavyeyi renklendir
    private fun colorfulKeyboard() {
        val renkler = listOf(
            R.drawable.pressed_and_normal_selector_kirmizi,
            R.drawable.pressed_and_normal_selector_yesil,
            R.drawable.pressed_and_normal_selector_mor,
            R.drawable.key_pressed_sari,
            R.drawable.pressed_and_normal_selector_mavi,
            R.drawable.pressed_and_normal_selector_pembe,
            R.drawable.pressed_and_normal_selector_gri
        )

        whiteKeys.forEachIndexed { index, button ->
            val drawable = ContextCompat.getDrawable(requireContext(), renkler[index % renkler.size])
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
        soundPool.release()
        _binding = null
    }
}