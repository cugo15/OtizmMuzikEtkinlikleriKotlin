package com.aecg.oyunvemuzikae.app

import android.app.Application
import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.data.model.SesModel
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication:Application() {

    val enstrumanList = arrayListOf(
        // UFLEMELI Türü
        SesModel("Trombon", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_trombon,
            R.drawable.ic_enstruman_trombon
        ),
        SesModel("Obua", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_obua,
            R.drawable.ic_enstruman_obua
        ),
        SesModel("Trompet", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_trompet,
            R.drawable.ic_enstruman_trompet
        ),
        SesModel("Zurna", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_zurna,
            R.drawable.ic_enstruman_zurna
        ),
        SesModel("Flüt", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_flut,
            R.drawable.ic_enstruman_flut
        ),
        SesModel("Saksafon", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_saksafon,
            R.drawable.ic_enstruman_saksafon
        ),
        SesModel("Korno", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_korno,
            R.drawable.ic_enstruman_korno
        ),
        SesModel("Blok Flüt", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_blokflut,
            R.drawable.ic_enstruman_blokflut
        ),
        SesModel("Tuba", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_tuba,
            R.drawable.ic_enstruman_tuba
        ),
        SesModel("Ney", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_ney,
            R.drawable.ic_enstruman_ney
        ),
        SesModel("Klarnet", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_klarnet,
            R.drawable.ic_enstruman_klarnet
        ),
        // TELLI Türü
        SesModel("Gitar", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_gitar,
            R.drawable.ic_enstruman_gitar
        ),
        SesModel("Bağlama", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_baglama,
            R.drawable.ic_enstruman_baglama
        ),
        SesModel("Ud", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_ud,
            R.drawable.ic_enstruman_ud
        ),
        SesModel("Keman", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_keman,
            R.drawable.ic_enstruman_keman
        ),
        SesModel("Kanun", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_kanun,
            R.drawable.ic_enstruman_kanun
        ),
        SesModel("Cümbüş", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_cumbus,
            R.drawable.ic_enstruman_cumbus
        ),
        SesModel("Elektro Gitar", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_elektrogitar,
            R.drawable.ic_enstruman_elektrogitar
        ),
        SesModel("Mandolin", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_mandolin,
            R.drawable.ic_enstruman_mandolin
        ),
        SesModel("Ukulele", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_ukulele,
            R.drawable.ic_enstruman_ukulele
        ),

        // VURMALI Türü
        SesModel("Davul", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_davul,
            R.drawable.ic_enstruman_davul
        ),
        SesModel("Trampet", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_trampet,
            R.drawable.ic_enstruman_trampet
        ),
        SesModel("Timpani", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_timpani,
            R.drawable.ic_enstruman_timpani
        ),
        SesModel("Darbuka", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_darbuka,
            R.drawable.ic_enstruman_darbuka
        ),
        SesModel("Konser Zili", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_konserzili,
            R.drawable.ic_enstruman_konserzili
        ),
        SesModel("Bateri", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_bateri,
            R.drawable.ic_enstruman_bateri
        ),
        SesModel("Konser Ksilafonu", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_konserksilafonu,
            R.drawable.ic_enstruman_konserksilafonu
        ),//hem ses
        SesModel("Def", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_def,
            R.drawable.ic_enstruman_def
        ),
        SesModel("Kajon", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_kajon,
            R.drawable.ic_enstruman_kajon
        ),
        SesModel("Nakkare", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_nakkare,
            R.drawable.ic_enstruman_nakkare
        ),//hem ses
        SesModel("Tumba", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_tumba,
            R.drawable.ic_enstruman_tumba
        ),
        SesModel("İnek Çanı", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_inekcani,
            R.drawable.ic_enstruman_inekcani
        ),

        // ORFF Türü
        SesModel("Marakas", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_marakas,
            R.drawable.ic_enstruman_marakas
        ),
        SesModel("Kastanyet", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_kastanyet,
            R.drawable.ic_enstruman_kastanyet
        ),
        SesModel("Ritim Çubuğu", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_ritimcubugu,
            R.drawable.ic_enstruman_ritimcubugu
        ),
        SesModel("Üçgen Zil", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_ucgenzil,
            R.drawable.ic_enstruman_ucgen_zil
        ),
        SesModel("El Davulu", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_eldavulu,
            R.drawable.ic_enstruman_eldavulu
        ),
        SesModel("Ksilafon", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_ksilafon,
            R.drawable.ic_enstruman_ksilofon
        ),
        SesModel("Guiro", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_guiro,
            R.drawable.ic_enstruman_guiro
        ),
        SesModel("Rüzgar Çanı", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_ruzgarcani,
            R.drawable.ic_enstruman_ruzgarcani
        ),
        SesModel("Zil", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_zil,
            R.drawable.ic_enstruman_zil
        ),
        SesModel("Tahta Blok", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_tahtablok,
            R.drawable.ic_enstruman_tahtablok
        ),

        // Diğer türler (Normal enstrümanlar)
        SesModel("Piyano", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_piyano,
            R.drawable.ic_enstruman_piyano
        ),
        )

    val oyunResimdenBulList = arrayListOf(
        SesModel("Trombon", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_trombon,
            R.drawable.ic_enstruman_trombon
        ),
        SesModel("Obua", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_obua,
            R.drawable.ic_enstruman_obua
        ),
        SesModel("Trompet", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_trompet,
            R.drawable.ic_enstruman_trompet
        ),
        SesModel("Zurna", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_zurna,
            R.drawable.ic_enstruman_zurna
        ),
        SesModel("Flüt", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_flut,
            R.drawable.ic_enstruman_flut
        ),
        SesModel("Saksafon", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_saksafon,
            R.drawable.ic_enstruman_saksafon
        ),
        SesModel("Korno", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_korno,
            R.drawable.ic_enstruman_korno
        ),
        SesModel("Blok Flüt", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_blokflut,
            R.drawable.ic_enstruman_blokflut
        ),
        SesModel("Tuba", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_tuba,
            R.drawable.ic_enstruman_tuba
        ),
        SesModel("Ney", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_ney,
            R.drawable.ic_enstruman_ney
        ),
        SesModel("Klarnet", SesType.ENSTRUMAN.UFLEMELI,
            R.raw.sound_enstruman_name_klarnet,
            R.drawable.ic_enstruman_klarnet
        ),
        // TELLI Türü
        SesModel("Gitar", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_name_gitar,
            R.drawable.ic_enstruman_gitar
        ),
        SesModel("Bağlama", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_name_baglama,
            R.drawable.ic_enstruman_baglama
        ),
        SesModel("Ud", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_name_ud,
            R.drawable.ic_enstruman_ud
        ),
        SesModel("Keman", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_name_keman,
            R.drawable.ic_enstruman_keman
        ),
        SesModel("Kanun", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_name_kanun,
            R.drawable.ic_enstruman_kanun
        ),
        SesModel("Cümbüş", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_name_cumbus,
            R.drawable.ic_enstruman_cumbus
        ),
        SesModel("Elektro Gitar", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_name_elektrogitar,
            R.drawable.ic_enstruman_elektrogitar
        ),
        SesModel("Mandolin", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_name_mandolin,
            R.drawable.ic_enstruman_mandolin
        ),
        SesModel("Ukulele", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_name_ukulele,
            R.drawable.ic_enstruman_ukulele
        ),
        SesModel("Piyano", SesType.ENSTRUMAN.TELLI,
            R.raw.sound_enstruman_piyano,
            R.drawable.ic_enstruman_piyano
        ),// isim söylenmesi eksik

        // VURMALI Türü
        SesModel("Davul", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_davul,
            R.drawable.ic_enstruman_davul
        ),
        SesModel("Trampet", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_trampet,
            R.drawable.ic_enstruman_trampet
        ),//isim söylenmesi eksik
        SesModel("Timpani", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_timpani,
            R.drawable.ic_enstruman_timpani
        ),
        SesModel("Darbuka", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_darbuka,
            R.drawable.ic_enstruman_darbuka
        ),
        SesModel("Konser Zili", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_konserzili,
            R.drawable.ic_enstruman_konserzili
        ),
        SesModel("Bateri", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_bateri,
            R.drawable.ic_enstruman_bateri
        ),
        SesModel("Konser Ksilafonu", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_konserksilafonu,
            R.drawable.ic_enstruman_konserksilafonu
        ),//hem ses
        SesModel("Def", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_def,
            R.drawable.ic_enstruman_def
        ),
        SesModel("Kajon", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_kajon,
            R.drawable.ic_enstruman_kajon
        ),
        SesModel("Nakkare", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_nakkare,
            R.drawable.ic_enstruman_nakkare
        ),//hem ses
        SesModel("Tumba", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_tumba,
            R.drawable.ic_enstruman_tumba
        ),
        SesModel("İnek Çanı", SesType.ENSTRUMAN.VURMALI,
            R.raw.sound_enstruman_name_inekcani,
            R.drawable.ic_enstruman_inekcani
        ),

        // ORFF Türü
        SesModel("Marakas", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_name_marakas,
            R.drawable.ic_enstruman_marakas
        ),
        SesModel("Kastanyet", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_name_kastanyet,
            R.drawable.ic_enstruman_kastanyet
        ),
        SesModel("Ritim Çubuğu", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_name_ritimcubugu,
            R.drawable.ic_enstruman_ritimcubugu
        ),
        SesModel("Üçgen Zil", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_name_ucgenzil,
            R.drawable.ic_enstruman_ucgen_zil
        ),
        SesModel("El Davulu", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_name_eldavulu,
            R.drawable.ic_enstruman_eldavulu
        ),
        SesModel("Ksilafon", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_name_ksilafon,
            R.drawable.ic_enstruman_ksilofon
        ),
        SesModel("Guiro", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_guiro,
            R.drawable.ic_enstruman_guiro
        ),//isim söylenmesi eksik
        SesModel("Rüzgar Çanı", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_name_ruzgarcani,
            R.drawable.ic_enstruman_ruzgarcani
        ),
        SesModel("Zil", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_name_zil,
            R.drawable.ic_enstruman_zil
        ),
        SesModel("Tahta Blok", SesType.ENSTRUMAN.ORFF,
            R.raw.sound_enstruman_name_tahtablok,
            R.drawable.ic_enstruman_tahtablok
        ),

        // Diğer türler (Normal enstrümanlar)

        )
}