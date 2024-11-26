package com.aecg.oyunvemuzikae.data.datasource

import com.aecg.oyunvemuzikae.R
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PianoDataSource@Inject constructor() {

    fun getWhitePianoSounds(): Array<Int> {
        return arrayOf(
            R.raw.sound_piano_c2,
            R.raw.sound_piano_d2,
            R.raw.sound_piano_e2,
            R.raw.sound_piano_f2,
            R.raw.sound_piano_g2,
            R.raw.sound_piano_a2,
            R.raw.sound_piano_b2,
            R.raw.sound_piano_c3,
            R.raw.sound_piano_d3,
            R.raw.sound_piano_e3,
            R.raw.sound_piano_f3,
            R.raw.sound_piano_g3,
            R.raw.sound_piano_a3,
            R.raw.sound_piano_b3,
            R.raw.sound_piano_c4,
            R.raw.sound_piano_d4,
            R.raw.sound_piano_e4,
            R.raw.sound_piano_f4,
            R.raw.sound_piano_g4,
            R.raw.sound_piano_a4,
            R.raw.sound_piano_b4,
            R.raw.sound_piano_c5,
            R.raw.sound_piano_d5,
            R.raw.sound_piano_e5,
            R.raw.sound_piano_f5,
            R.raw.sound_piano_g5,
            R.raw.sound_piano_a5,
            R.raw.sound_piano_b5,
            R.raw.sound_piano_c6,
            R.raw.sound_piano_d6,
            R.raw.sound_piano_e6,
            R.raw.sound_piano_f6,
            R.raw.sound_piano_g6,
            R.raw.sound_piano_a6,
            R.raw.sound_piano_b6,
            R.raw.sound_piano_c7
        )
    }

    fun getBlackPianoSounds(): Array<Int> {
        return arrayOf(
            R.raw.sound_piano_c2diyez,
            R.raw.sound_piano_d2diyez,
            R.raw.sound_piano_f2diyez,
            R.raw.sound_piano_g2diyez,
            R.raw.sound_piano_a2diyez,
            R.raw.sound_piano_c3diyez,
            R.raw.sound_piano_d3diyez,
            R.raw.sound_piano_f3diyez,
            R.raw.sound_piano_g3diyez,
            R.raw.sound_piano_a3diyez,
            R.raw.sound_piano_c4diyez,
            R.raw.sound_piano_d4diyez,
            R.raw.sound_piano_f4diyez,
            R.raw.sound_piano_g4diyez,
            R.raw.sound_piano_a4diyez,
            R.raw.sound_piano_c5diyez,
            R.raw.sound_piano_d5diyez,
            R.raw.sound_piano_f5diyez,
            R.raw.sound_piano_g5diyez,
            R.raw.sound_piano_a5diyez,
            R.raw.sound_piano_c6diyez,
            R.raw.sound_piano_d6diyez,
            R.raw.sound_piano_f6diyez,
            R.raw.sound_piano_g6diyez,
            R.raw.sound_piano_a6diyez
        )
    }

    fun getDoNotation(): Array<String> {
        return arrayOf(
            "Do2", "Re2", "Mi2", "Fa2", "Sol2", "La2", "Si2",
            "Do3", "Re3", "Mi3", "Fa3", "Sol3", "La3", "Si3",
            "Do4", "Re4", "Mi4", "Fa4", "Sol4", "La4", "Si4",
            "Do5", "Re5", "Mi5", "Fa5", "Sol5", "La5", "Si5",
            "Do6", "Re6", "Mi6", "Fa6", "Sol6", "La6", "Si6",
            "Do7"
        )
    }

    fun getPitchNotation(): Array<String> {
        return arrayOf(
            "C2", "D2", "E2", "F2", "G2", "A2", "B2",
            "C3", "D3", "E3", "F3", "G3", "A3", "B3",
            "C4", "D4", "E4", "F4", "G4", "A4", "B4",
            "C5", "D5", "E5", "F5", "G5", "A5", "B5",
            "C6", "D6", "E6", "F6", "G6", "A6", "B6",
            "C7"
        )
    }

    fun getClearNotation(): Array<String> {
        return Array(getDoNotation().size) { "" }
    }

    fun getPianoKeyboardColors(): Array<Int> {
        return arrayOf(
            R.drawable.pressed_and_normal_selector_kirmizi,
            R.drawable.pressed_and_normal_selector_yesil,
            R.drawable.pressed_and_normal_selector_mor,
            R.drawable.piano_key_pressed_sari,
            R.drawable.pressed_and_normal_selector_mavi,
            R.drawable.pressed_and_normal_selector_pembe,
            R.drawable.pressed_and_normal_selector_gri
        )
    }

}
