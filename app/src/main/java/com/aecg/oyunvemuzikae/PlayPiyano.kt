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

        val mediaPlayerk1 = MediaPlayer.create(this, R.raw.sound_piano_c3)
        val mediaPlayerk2 = MediaPlayer.create(this, R.raw.sound_piano_c3diyez)
        val mediaPlayerk3 = MediaPlayer.create(this, R.raw.sound_piano_d3)
        val mediaPlayerk4 = MediaPlayer.create(this, R.raw.sound_piano_d3diyez)
        val mediaPlayerk5 = MediaPlayer.create(this, R.raw.sound_piano_e3)
        val mediaPlayerk6 = MediaPlayer.create(this, R.raw.sound_piano_f3)
        val mediaPlayerk7 = MediaPlayer.create(this, R.raw.sound_piano_f3diyez)
        val mediaPlayerk8 = MediaPlayer.create(this, R.raw.sound_piano_g3)
        val mediaPlayerk9 = MediaPlayer.create(this, R.raw.sound_piano_g3diyez)
        val mediaPlayerk10 = MediaPlayer.create(this, R.raw.sound_piano_a3)
        val mediaPlayerk11 = MediaPlayer.create(this, R.raw.sound_piano_a3diyez)
        val mediaPlayerk12 = MediaPlayer.create(this, R.raw.sound_piano_b3)

        val mediaPlayers1 = MediaPlayer.create(this, R.raw.sound_piano_c2)
        val mediaPlayers2 = MediaPlayer.create(this, R.raw.sound_piano_c2diyez)
        val mediaPlayers3 = MediaPlayer.create(this, R.raw.sound_piano_d2)
        val mediaPlayers4 = MediaPlayer.create(this, R.raw.sound_piano_d2diyez)
        val mediaPlayers5 = MediaPlayer.create(this, R.raw.sound_piano_e2)
        val mediaPlayers6 = MediaPlayer.create(this, R.raw.sound_piano_f2)
        val mediaPlayers7 = MediaPlayer.create(this, R.raw.sound_piano_f2diyez)
        val mediaPlayers8 = MediaPlayer.create(this, R.raw.sound_piano_g2)
        val mediaPlayers9 = MediaPlayer.create(this, R.raw.sound_piano_g2diyez)
        val mediaPlayers10 = MediaPlayer.create(this, R.raw.sound_piano_a2)
        val mediaPlayers11 = MediaPlayer.create(this, R.raw.sound_piano_a2diyez)
        val mediaPlayers12 = MediaPlayer.create(this, R.raw.sound_piano_b2)

        val mediaPlayerm1 = MediaPlayer.create(this, R.raw.sound_piano_c4)
        val mediaPlayerm2 = MediaPlayer.create(this, R.raw.sound_piano_c4diyez)
        val mediaPlayerm3 = MediaPlayer.create(this, R.raw.sound_piano_d4)
        val mediaPlayerm4 = MediaPlayer.create(this, R.raw.sound_piano_d4diyez)
        val mediaPlayerm5 = MediaPlayer.create(this, R.raw.sound_piano_e4)
        val mediaPlayerm6 = MediaPlayer.create(this, R.raw.sound_piano_f4)
        val mediaPlayerm7 = MediaPlayer.create(this, R.raw.sound_piano_f4diyez)
        val mediaPlayerm8 = MediaPlayer.create(this, R.raw.sound_piano_g4)
        val mediaPlayerm9 = MediaPlayer.create(this, R.raw.sound_piano_g4diyez)
        val mediaPlayerm10 = MediaPlayer.create(this, R.raw.sound_piano_a4)
        val mediaPlayerm11 = MediaPlayer.create(this, R.raw.sound_piano_a4diyez)
        val mediaPlayerm12 = MediaPlayer.create(this, R.raw.sound_piano_b4)

        val mediaPlayermor1 = MediaPlayer.create(this, R.raw.sound_piano_c5)
        val mediaPlayermor2 = MediaPlayer.create(this, R.raw.sound_piano_c5diyez)
        val mediaPlayermor3 = MediaPlayer.create(this, R.raw.sound_piano_d5)
        val mediaPlayermor4 = MediaPlayer.create(this, R.raw.sound_piano_d5diyez)
        val mediaPlayermor5 = MediaPlayer.create(this, R.raw.sound_piano_e5)
        val mediaPlayermor6 = MediaPlayer.create(this, R.raw.sound_piano_f5)
        val mediaPlayermor7 = MediaPlayer.create(this, R.raw.sound_piano_f5diyez)
        val mediaPlayermor8 = MediaPlayer.create(this, R.raw.sound_piano_g5)
        val mediaPlayermor9 = MediaPlayer.create(this, R.raw.sound_piano_g5diyez)
        val mediaPlayermor10 = MediaPlayer.create(this, R.raw.sound_piano_a5)
        val mediaPlayermor11 = MediaPlayer.create(this, R.raw.sound_piano_a5diyez)
        val mediaPlayermor12 = MediaPlayer.create(this, R.raw.sound_piano_b5)

        val mediaPlayery1 = MediaPlayer.create(this, R.raw.sound_piano_c6)
        val mediaPlayery2 = MediaPlayer.create(this, R.raw.sound_piano_c6diyez)
        val mediaPlayery3 = MediaPlayer.create(this, R.raw.sound_piano_d6)
        val mediaPlayery4 = MediaPlayer.create(this, R.raw.sound_piano_d6diyez)
        val mediaPlayery5 = MediaPlayer.create(this, R.raw.sound_piano_e6)
        val mediaPlayery6 = MediaPlayer.create(this, R.raw.sound_piano_f6)
        val mediaPlayery7 = MediaPlayer.create(this, R.raw.sound_piano_f6diyez)
        val mediaPlayery8 = MediaPlayer.create(this, R.raw.sound_piano_g6)
        val mediaPlayery9 = MediaPlayer.create(this, R.raw.sound_piano_g6diyez)
        val mediaPlayery10 = MediaPlayer.create(this, R.raw.sound_piano_a6)
        val mediaPlayery11 = MediaPlayer.create(this, R.raw.sound_piano_a6diyez)
        val mediaPlayery12 = MediaPlayer.create(this, R.raw.sound_piano_b6)

        val mediaPlayerp1 = MediaPlayer.create(this, R.raw.sound_piano_c7)

        binding.btnHome.setOnClickListener {
            val intent = Intent(this@PlayPiyano, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.scrollViewKeyboard.post { seekpiyanobagla(binding.p15) }
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
            when (binding.p1.text) {
                "" -> notatodoremi() // Eğer metin boşsa
                "Do2" -> notabos()   // Eğer metin "Do2" ise
                "C2" -> notatodoremi() // Eğer metin "C2" ise
                else -> {
                    // Diğer durumlar için isteğe bağlı bir işlem
                }
            }
        }
        binding.btnC.setOnClickListener {
            when (binding.p1.text) {
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

        // Tüm p ve b butonlarıyla ilişkili MediaPlayer'ları bir dizide topluyoruz
        val pianoButtons = listOf(
            Pair(binding.p1, mediaPlayers1), Pair(binding.b1, mediaPlayers2),
            Pair(binding.p2, mediaPlayers3), Pair(binding.b2, mediaPlayers4),
            Pair(binding.p3, mediaPlayers5), Pair(binding.p4, mediaPlayers6),
            Pair(binding.b3, mediaPlayers7), Pair(binding.p5, mediaPlayers8),
            Pair(binding.b4, mediaPlayers9), Pair(binding.p6, mediaPlayers10),
            Pair(binding.b5, mediaPlayers11), Pair(binding.p7, mediaPlayers12),
            Pair(binding.p8, mediaPlayerk1), Pair(binding.b6, mediaPlayerk2),
            Pair(binding.p9, mediaPlayerk3), Pair(binding.b7, mediaPlayerk4),
            Pair(binding.p10, mediaPlayerk5), Pair(binding.p11, mediaPlayerk6),
            Pair(binding.b8, mediaPlayerk7), Pair(binding.p12, mediaPlayerk8),
            Pair(binding.b9, mediaPlayerk9), Pair(binding.p13, mediaPlayerk10),
            Pair(binding.b10, mediaPlayerk11), Pair(binding.p14, mediaPlayerk12),
            Pair(binding.p15, mediaPlayerm1), Pair(binding.b11, mediaPlayerm2),
            Pair(binding.p16, mediaPlayerm3), Pair(binding.b12, mediaPlayerm4),
            Pair(binding.p17, mediaPlayerm5), Pair(binding.p18, mediaPlayerm6),
            Pair(binding.b13, mediaPlayerm7), Pair(binding.p19, mediaPlayerm8),
            Pair(binding.b14, mediaPlayerm9), Pair(binding.p20, mediaPlayerm10),
            Pair(binding.b15, mediaPlayerm11), Pair(binding.p21, mediaPlayerm12),
            Pair(binding.p22, mediaPlayermor1), Pair(binding.b16, mediaPlayermor2),
            Pair(binding.p23, mediaPlayermor3), Pair(binding.b17, mediaPlayermor4),
            Pair(binding.p24, mediaPlayermor5), Pair(binding.p25, mediaPlayermor6),
            Pair(binding.b18, mediaPlayermor7), Pair(binding.p26, mediaPlayermor8),
            Pair(binding.b19, mediaPlayermor9), Pair(binding.p27, mediaPlayermor10),
            Pair(binding.b20, mediaPlayermor11), Pair(binding.p28, mediaPlayermor12),
            Pair(binding.p29, mediaPlayery1), Pair(binding.b21, mediaPlayery2),
            Pair(binding.p30, mediaPlayery3), Pair(binding.b22, mediaPlayery4),
            Pair(binding.p31, mediaPlayery5), Pair(binding.p32, mediaPlayery6),
            Pair(binding.b23, mediaPlayery7), Pair(binding.p33, mediaPlayery8),
            Pair(binding.b24, mediaPlayery9), Pair(binding.p34, mediaPlayery10),
            Pair(binding.b25, mediaPlayery11), Pair(binding.p35, mediaPlayery12),
            Pair(binding.p36, mediaPlayerp1)
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