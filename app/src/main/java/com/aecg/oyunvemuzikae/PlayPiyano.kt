package com.aecg.oyunvemuzikae

import android.content.Intent
import android.media.MediaPlayer
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
    private var c: Int = 0
    private var widthp = 0
    private var widthb = 0

    //recordpath
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayPiyanoBinding.inflate(
            layoutInflater
        )
        val view: View = binding.root
        setContentView(view)


        binding.scrollViewKeyboard.setScrolling(false)
        tumdiez()



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

        val pianoButtons = listOf(
            // 2. Oktav
            Pair(binding.btnC2, R.raw.sound_piano_c2), Pair(binding.btnDiyezC2, R.raw.sound_piano_c2diyez),
            Pair(binding.btnD2, R.raw.sound_piano_d2), Pair(binding.btnDiyezD2, R.raw.sound_piano_d2diyez),
            Pair(binding.btnE2, R.raw.sound_piano_e2),
            Pair(binding.btnF2, R.raw.sound_piano_f2), Pair(binding.btnDiyezF2, R.raw.sound_piano_f2diyez),
            Pair(binding.btnG2, R.raw.sound_piano_g2), Pair(binding.btnDiyezG2, R.raw.sound_piano_g2diyez),
            Pair(binding.btnA2, R.raw.sound_piano_a2), Pair(binding.btnDiyezA2, R.raw.sound_piano_a2diyez),
            Pair(binding.btnB2, R.raw.sound_piano_b2),

            // 3. Oktav
            Pair(binding.btnC3, R.raw.sound_piano_c3), Pair(binding.btnDiyezC3, R.raw.sound_piano_c3diyez),
            Pair(binding.btnD3, R.raw.sound_piano_d3), Pair(binding.btnDiyezD3, R.raw.sound_piano_d3diyez),
            Pair(binding.btnE3, R.raw.sound_piano_e3),
            Pair(binding.btnF3, R.raw.sound_piano_f3), Pair(binding.btnDiyezF3, R.raw.sound_piano_f3diyez),
            Pair(binding.btnG3, R.raw.sound_piano_g3), Pair(binding.btnDiyezG3, R.raw.sound_piano_g3diyez),
            Pair(binding.btnA3, R.raw.sound_piano_a3), Pair(binding.btnDiyezA3, R.raw.sound_piano_a3diyez),
            Pair(binding.btnB3, R.raw.sound_piano_b3),

            // 4. Oktav
            Pair(binding.btnC4, R.raw.sound_piano_c4), Pair(binding.btnDiyezC4, R.raw.sound_piano_c4diyez),
            Pair(binding.btnD4, R.raw.sound_piano_d4), Pair(binding.btnDiyezD4, R.raw.sound_piano_d4diyez),
            Pair(binding.btnE4, R.raw.sound_piano_e4),
            Pair(binding.btnF4, R.raw.sound_piano_f4), Pair(binding.btnDiyezF4, R.raw.sound_piano_f4diyez),
            Pair(binding.btnG4, R.raw.sound_piano_g4), Pair(binding.btnDiyezG4, R.raw.sound_piano_g4diyez),
            Pair(binding.btnA4, R.raw.sound_piano_a4), Pair(binding.btnDiyezA4, R.raw.sound_piano_a4diyez),
            Pair(binding.btnB4, R.raw.sound_piano_b4),

            // 5. Oktav
            Pair(binding.btnC5, R.raw.sound_piano_c5), Pair(binding.btnDiyezC5, R.raw.sound_piano_c5diyez),
            Pair(binding.btnD5, R.raw.sound_piano_d5), Pair(binding.btnDiyezD5, R.raw.sound_piano_d5diyez),
            Pair(binding.btnE5, R.raw.sound_piano_e5),
            Pair(binding.btnF5, R.raw.sound_piano_f5), Pair(binding.btnDiyezF5, R.raw.sound_piano_f5diyez),
            Pair(binding.btnG5, R.raw.sound_piano_g5), Pair(binding.btnDiyezG5, R.raw.sound_piano_g5diyez),
            Pair(binding.btnA5, R.raw.sound_piano_a5), Pair(binding.btnDiyezA5, R.raw.sound_piano_a5diyez),
            Pair(binding.btnB5, R.raw.sound_piano_b5),

            // 6. Oktav
            Pair(binding.btnC6, R.raw.sound_piano_c6), Pair(binding.btnDiyezC6, R.raw.sound_piano_c6diyez),
            Pair(binding.btnD6, R.raw.sound_piano_d6), Pair(binding.btnDiyezD6, R.raw.sound_piano_d6diyez),
            Pair(binding.btnE6, R.raw.sound_piano_e6),
            Pair(binding.btnF6, R.raw.sound_piano_f6), Pair(binding.btnDiyezF6, R.raw.sound_piano_f6diyez),
            Pair(binding.btnG6, R.raw.sound_piano_g6), Pair(binding.btnDiyezG6, R.raw.sound_piano_g6diyez),
            Pair(binding.btnA6, R.raw.sound_piano_a6), Pair(binding.btnDiyezA6, R.raw.sound_piano_a6diyez),
            Pair(binding.btnB6, R.raw.sound_piano_b6),

            // 7. Oktav
            Pair(binding.btnC7, R.raw.sound_piano_c7),
        )

// Her bir p ve b butonuna setOnTouchListener atıyoruz
        pianoButtons.forEach { (view, mediaPlayer) ->
            view.setOnTouchListener { _, motionEvent ->
                ondown(motionEvent, mediaPlayer)
                false
            }
        }

    }

    private fun ondown(event: MotionEvent, ses: MediaPlayer) {
        if (event.action == MotionEvent.ACTION_DOWN) {
            if (ses.isPlaying) {
                ses.pause()
                ses.seekTo(0)
            }
            ses.start()
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
        binding.p1.viewTreeObserver.addOnGlobalLayoutListener {
            val height = (binding.p1.height * heightFactor).toInt()
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
            binding.b1, binding.b2, binding.b3, binding.b4, binding.b5,
            binding.b6, binding.b7, binding.b8, binding.b9, binding.b10,
            binding.b11, binding.b12, binding.b13, binding.b14, binding.b15,
            binding.b16, binding.b17, binding.b18, binding.b19, binding.b20,
            binding.b21, binding.b22, binding.b23, binding.b24, binding.b25
        )
    }
    // Tüm p butonlarını döndüren fonksiyon
    private fun getPButtons(): List<Button> {
        return listOf(
            binding.p1, binding.p2, binding.p3, binding.p4, binding.p5,
            binding.p6, binding.p7, binding.p8, binding.p9, binding.p10,
            binding.p11, binding.p12, binding.p13, binding.p14, binding.p15,
            binding.p16, binding.p17, binding.p18, binding.p19, binding.p20,
            binding.p21, binding.p22, binding.p23, binding.p24, binding.p25,
            binding.p26, binding.p27, binding.p28, binding.p29, binding.p30,
            binding.p31, binding.p32, binding.p33, binding.p34, binding.p35, binding.p36
        )
    }

    fun increasesizep(buttonp: Button) {
        if(widthp<270||widthp==0){
            println(widthp)
            binding.p1.post {
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
           binding.p1.post {
               widthb = buttonb.width + 6
               val paramsb = buttonb.layoutParams as RelativeLayout.LayoutParams
               paramsb.width = widthb
               buttonb.layoutParams = paramsb
           }
       }
    }
    private fun decsizep(buttonp: Button) {
        if(widthp>90||widthp==0){
            binding.p1.post {
                widthp = buttonp.width - 9
                val paramsp = buttonp.layoutParams as RelativeLayout.LayoutParams
                paramsp.width = widthp
                buttonp.layoutParams = paramsp
            }
        }
    }
    private fun decsizeb(buttonb: Button) {
        if(widthb>60||widthb==0){
            binding.p1.post {
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
            seekpiyanobagla(binding.p36)
        }
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
}