package com.aecg.oyunvemuzikae

import android.content.Intent
import android.media.SoundPool
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.SeekBar
import android.widget.SeekBar.OnSeekBarChangeListener
import com.aecg.oyunvemuzikae.databinding.ActivityPlayPiyanoBinding

class PlayPiyano : BaseActivity() {
    private lateinit var binding: ActivityPlayPiyanoBinding
    private lateinit var soundPool: SoundPool
    private val soundMap = mutableMapOf<View, Int>()

    private var c: Int = 0
    private var widthp = 0
    private var widthb = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayPiyanoBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)
        binding.scrollViewKeyboard.setScrolling(false)
        tumdiez()

        soundPool = SoundPool.Builder()
            .setMaxStreams(10) // Aynı anda çalabilecek maksimum ses sayısı
            .build()



        binding.btnHome.setOnClickListener {
            val intent = Intent(this@PlayPiyano, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.scrollViewKeyboard.post { seekpiyanobagla(binding.btnC4) }

        binding.seekBarOctave.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                seekbag2(i)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })

        binding.btnIncreaseKeySize.setOnClickListener {
            binding.seekBarOctave.post {
                val i = binding.seekBarOctave.progress
                incsize()
                seekbag2(i)
            }
        }
        binding.btnDecreaseKeySize.setOnClickListener {
            binding.seekBarOctave.post {
                val i = binding.seekBarOctave.progress
                decsize()
                seekbag2(i - 1)
            }
        }

        binding.btnDo.setOnClickListener {
            when (binding.btnC2.text) {
                "" -> notatodoremi() // Eğer metin boşsa
                "Do2" -> notabos()   // Eğer metin "Do2" ise
                "C2" -> notatodoremi() // Eğer metin "C2" ise
                else -> {
                    // Diğer durumlar için isteğe bağlı bir işlem
                }
            }
        }
        binding.btnC.setOnClickListener {
            when (binding.btnC2.text) {
                "" -> notacdef()   // Eğer metin boşsa
                "C2" -> notabos()  // Eğer metin "C2" ise
                "Do2" -> notacdef() // Eğer metin "Do2" ise
                else -> {
                    // Diğer durumlar için isteğe bağlı bir işlem
                }
            }
        }
        binding.btnColor.setOnClickListener {
            c++
            when {
                c % 2 == 0 -> { // Eğer c çift ise
                    beyazlat()  // Beyaz yap
                    notabos()   // Notayı boşalt
                }
                else -> { // c tek ise
                    renklendir() // Renkli yap
                }
            }
        }
        loadSounds()

        soundMap.forEach { (button) ->
            button.setOnTouchListener { _, event ->
                if (event.action == MotionEvent.ACTION_DOWN) {
                    playSound(button)
                }
                false
            }
        }
// Her bir p ve b butonuna setOnTouchListener atıyoruz
    }


    private fun loadSounds() :Map<View,Int>{
        // Sesleri yükleme işlemleri burada yapılacak
        soundMap[binding.btnC2] = soundPool.load(this, R.raw.sound_piano_c2, 1)
        soundMap[binding.btnDiyezC2] = soundPool.load(this, R.raw.sound_piano_c2diyez, 1)
        soundMap[binding.btnD2] = soundPool.load(this, R.raw.sound_piano_d2, 1)
        soundMap[binding.btnDiyezD2] = soundPool.load(this, R.raw.sound_piano_d2diyez, 1)
        soundMap[binding.btnE2] = soundPool.load(this, R.raw.sound_piano_e2, 1)
        soundMap[binding.btnF2] = soundPool.load(this, R.raw.sound_piano_f2, 1)
        soundMap[binding.btnDiyezF2] = soundPool.load(this, R.raw.sound_piano_f2diyez, 1)
        soundMap[binding.btnG2] = soundPool.load(this, R.raw.sound_piano_g2, 1)
        soundMap[binding.btnDiyezG2] = soundPool.load(this, R.raw.sound_piano_g2diyez, 1)
        soundMap[binding.btnA2] = soundPool.load(this, R.raw.sound_piano_a2, 1)
        soundMap[binding.btnDiyezA2] = soundPool.load(this, R.raw.sound_piano_a2diyez, 1)
        soundMap[binding.btnB2] = soundPool.load(this, R.raw.sound_piano_b2, 1)

        soundMap[binding.btnC3] = soundPool.load(this, R.raw.sound_piano_c3, 1)
        soundMap[binding.btnDiyezC3] = soundPool.load(this, R.raw.sound_piano_c3diyez, 1)
        soundMap[binding.btnD3] = soundPool.load(this, R.raw.sound_piano_d3, 1)
        soundMap[binding.btnDiyezD3] = soundPool.load(this, R.raw.sound_piano_d3diyez, 1)
        soundMap[binding.btnE3] = soundPool.load(this, R.raw.sound_piano_e3, 1)
        soundMap[binding.btnF3] = soundPool.load(this, R.raw.sound_piano_f3, 1)
        soundMap[binding.btnDiyezF3] = soundPool.load(this, R.raw.sound_piano_f3diyez, 1)
        soundMap[binding.btnG3] = soundPool.load(this, R.raw.sound_piano_g3, 1)
        soundMap[binding.btnDiyezG3] = soundPool.load(this, R.raw.sound_piano_g3diyez, 1)
        soundMap[binding.btnA3] = soundPool.load(this, R.raw.sound_piano_a3, 1)
        soundMap[binding.btnDiyezA3] = soundPool.load(this, R.raw.sound_piano_a3diyez, 1)
        soundMap[binding.btnB3] = soundPool.load(this, R.raw.sound_piano_b3, 1)

        soundMap[binding.btnC4] = soundPool.load(this, R.raw.sound_piano_c4, 1)
        soundMap[binding.btnDiyezC4] = soundPool.load(this, R.raw.sound_piano_c4diyez, 1)
        soundMap[binding.btnD4] = soundPool.load(this, R.raw.sound_piano_d4, 1)
        soundMap[binding.btnDiyezD4] = soundPool.load(this, R.raw.sound_piano_d4diyez, 1)
        soundMap[binding.btnE4] = soundPool.load(this, R.raw.sound_piano_e4, 1)
        soundMap[binding.btnF4] = soundPool.load(this, R.raw.sound_piano_f4, 1)
        soundMap[binding.btnDiyezF4] = soundPool.load(this, R.raw.sound_piano_f4diyez, 1)
        soundMap[binding.btnG4] = soundPool.load(this, R.raw.sound_piano_g4, 1)
        soundMap[binding.btnDiyezG4] = soundPool.load(this, R.raw.sound_piano_g4diyez, 1)
        soundMap[binding.btnA4] = soundPool.load(this, R.raw.sound_piano_a4, 1)
        soundMap[binding.btnDiyezA4] = soundPool.load(this, R.raw.sound_piano_a4diyez, 1)
        soundMap[binding.btnB4] = soundPool.load(this, R.raw.sound_piano_b4, 1)

        soundMap[binding.btnC5] = soundPool.load(this, R.raw.sound_piano_c5, 1)
        soundMap[binding.btnDiyezC5] = soundPool.load(this, R.raw.sound_piano_c5diyez, 1)
        soundMap[binding.btnD5] = soundPool.load(this, R.raw.sound_piano_d5, 1)
        soundMap[binding.btnDiyezD5] = soundPool.load(this, R.raw.sound_piano_d5diyez, 1)
        soundMap[binding.btnE5] = soundPool.load(this, R.raw.sound_piano_e5, 1)
        soundMap[binding.btnF5] = soundPool.load(this, R.raw.sound_piano_f5, 1)
        soundMap[binding.btnDiyezF5] = soundPool.load(this, R.raw.sound_piano_f5diyez, 1)
        soundMap[binding.btnG5] = soundPool.load(this, R.raw.sound_piano_g5, 1)
        soundMap[binding.btnDiyezG5] = soundPool.load(this, R.raw.sound_piano_g5diyez, 1)
        soundMap[binding.btnA5] = soundPool.load(this, R.raw.sound_piano_a5, 1)
        soundMap[binding.btnDiyezA5] = soundPool.load(this, R.raw.sound_piano_a5diyez, 1)
        soundMap[binding.btnB5] = soundPool.load(this, R.raw.sound_piano_b5, 1)

        soundMap[binding.btnC6] = soundPool.load(this, R.raw.sound_piano_c6, 1)
        soundMap[binding.btnDiyezC6] = soundPool.load(this, R.raw.sound_piano_c6diyez, 1)
        soundMap[binding.btnD6] = soundPool.load(this, R.raw.sound_piano_d6, 1)
        soundMap[binding.btnDiyezD6] = soundPool.load(this, R.raw.sound_piano_d6diyez, 1)
        soundMap[binding.btnE6] = soundPool.load(this, R.raw.sound_piano_e6, 1)
        soundMap[binding.btnF6] = soundPool.load(this, R.raw.sound_piano_f6, 1)
        soundMap[binding.btnDiyezF6] = soundPool.load(this, R.raw.sound_piano_f6diyez, 1)
        soundMap[binding.btnG6] = soundPool.load(this, R.raw.sound_piano_g6, 1)
        soundMap[binding.btnDiyezG6] = soundPool.load(this, R.raw.sound_piano_g6diyez, 1)
        soundMap[binding.btnA6] = soundPool.load(this, R.raw.sound_piano_a6, 1)
        soundMap[binding.btnDiyezA6] = soundPool.load(this, R.raw.sound_piano_a6diyez, 1)
        soundMap[binding.btnB6] = soundPool.load(this, R.raw.sound_piano_b6, 1)

        soundMap[binding.btnC7] = soundPool.load(this, R.raw.sound_piano_c7, 1)
        return soundMap
    }

    private fun playSound(view: View) {
        soundPool.play(soundMap[view] ?: 0, 1f, 1f, 0, 0, 1f)
    }
    private fun notatodoremi() {
        val notalar = listOf(
            "Do2", "Re2", "Mi2", "Fa2", "Sol2", "La2", "Si2",
            "Do3", "Re3", "Mi3", "Fa3", "Sol3", "La3", "Si3",
            "Do4", "Re4", "Mi4", "Fa4", "Sol4", "La4", "Si4",
            "Do5", "Re5", "Mi5", "Fa5", "Sol5", "La5", "Si5",
            "Do6", "Re6", "Mi6", "Fa6", "Sol6", "La6", "Si6",
            "Do7"
        )

        val pianoBindings = getPButtons()

        for (i in notalar.indices) {
            pianoBindings[i].text = notalar[i]
        }
    }

    private fun notacdef() {
        val notalar = listOf(
            "C2", "D2", "E2", "F2", "G2", "A2", "B2",
            "C3", "D3", "E3", "F3", "G3", "A3", "B3",
            "C4", "D4", "E4", "F4", "G4", "A4", "B4",
            "C5", "D5", "E5", "F5", "G5", "A5", "B5",
            "C6", "D6", "E6", "F6", "G6", "A6", "B6",
            "C7"
        )

        val pianoBindings = getPButtons()

        for (i in notalar.indices) {
            pianoBindings[i].text = notalar[i]
        }
    }

    private fun notabos() {
        val pianoBindings = getPButtons()

        pianoBindings.forEach { it.text = "" }
    }

    private fun renklendir() {
        val renkler = listOf(
            R.drawable.pressed_and_normal_selector_kirmizi,
            R.drawable.pressed_and_normal_selector_yesil,
            R.drawable.pressed_and_normal_selector_mor,
            R.drawable.key_pressed_sari,
            R.drawable.pressed_and_normal_selector_mavi,
            R.drawable.pressed_and_normal_selector_pembe,
            R.drawable.pressed_and_normal_selector_gri
        )

        val pianoBindings = getPButtons()

        for (i in pianoBindings.indices) {
            val index = i % renkler.size // Renkleri döngüsel kullanmak için mod alıyoruz
            pianoBindings[i].setBackgroundDrawable(getDrawable(renkler[index]))
        }
    }

    private fun beyazlat() {
        val pianoBindings = getPButtons()

        // Tüm butonların arka planını beyazlatmak için döngü kullanıyoruz.
        for (button in pianoBindings) {
            button.setBackgroundDrawable(getDrawable(R.drawable.pressed_and_normal_selector))
        }
    }
    private fun seekpiyanobagla(a: Button) {
        binding.layoutKeyboard.post {
            val x = a.left
            val y = a.top
            binding.scrollViewKeyboard.smoothScrollTo(x, y)
        }
    }

    private fun diezilkboyut(diez: Button, heightFactor: Float = 3 / 5f) {
        binding.btnC.viewTreeObserver.addOnGlobalLayoutListener {
            val height = (binding.btnC2.height * heightFactor).toInt()
            val params = diez.layoutParams as RelativeLayout.LayoutParams
            params.height = height
            diez.layoutParams = params
        }
    }

    private fun tumdiez() {
        val bButtons = getBButtons()
        // Tüm butonların boyutunu ayarlamak için döngü kullanıyoruz.
        for (button in bButtons) {
            diezilkboyut(button)
        }
    }
    // Tüm b butonlarını döndüren fonksiyon
    private fun getBButtons(): List<Button> {
        return listOf(

        )
    }
    // Tüm p butonlarını döndüren fonksiyon
    private fun getPButtons(): List<Button> {
        return listOf(

        )
    }

    fun increasesizep(buttonp: Button) {
        if(widthp<270||widthp==0){
            println(widthp)
            binding.btnC2.post {
                widthp = buttonp.width + 9
                val paramsp = buttonp.layoutParams as RelativeLayout.LayoutParams
                paramsp.width = widthp
                buttonp.layoutParams = paramsp
            }
        }
    }
    fun increasesizeb(buttonb: Button) {
        if(widthb<180||widthb==0){
            println(widthb)
            binding.btnC2.post {
                widthb = buttonb.width + 6
                val paramsb = buttonb.layoutParams as RelativeLayout.LayoutParams
                paramsb.width = widthb
                buttonb.layoutParams = paramsb
            }
        }
    }

    private fun decsizep(buttonp: Button) {
        if(widthp>90||widthp==0){
            binding.btnC2.post {
                widthp = buttonp.width - 9
                val paramsp = buttonp.layoutParams as RelativeLayout.LayoutParams
                paramsp.width = widthp
                buttonp.layoutParams = paramsp
            }
        }
    }
    private fun decsizeb(buttonb: Button) {
        if(widthb>60||widthb==0){
            binding.btnC2.post {
                widthb = buttonb.width - 6
                val paramsb = buttonb.layoutParams as RelativeLayout.LayoutParams
                paramsb.width = widthb
                buttonb.layoutParams = paramsb
            }
        }
    }

    private fun incsize() {
        // Tüm butonları gruplandırıyoruz
        val bButtons = getBButtons()
        val pButtons = getPButtons()

        // Butonları artırıyoruz
        changeButtonSizes(bButtons, ::increasesizeb)
        changeButtonSizes(pButtons, ::increasesizep)
    }
    private fun decsize() {
        // Tüm butonları gruplandırıyoruz
        val bButtons = getBButtons()
        val pButtons = getPButtons()

        // Butonları azaltıyoruz
        changeButtonSizes(bButtons, ::decsizeb)
        changeButtonSizes(pButtons, ::decsizep)
    }

    private fun changeButtonSizes(buttons: List<Button>, sizeChangeFunction: (Button) -> Unit) {
        buttons.forEach { button -> sizeChangeFunction(button) }
    }

    private fun seekbag2(i: Int) {
        val pianoBindings = getPButtons()

        if (i in pianoBindings.indices) {
            seekpiyanobagla(pianoBindings[i])
        } else if (i == 36) {
            seekpiyanobagla(binding.btnC7)
        }
    }



}