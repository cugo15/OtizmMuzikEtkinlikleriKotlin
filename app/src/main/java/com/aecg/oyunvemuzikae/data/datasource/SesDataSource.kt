package com.aecg.oyunvemuzikae.data.datasource

import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.data.model.SesModel
import com.aecg.oyunvemuzikae.domain.SesType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SesDataSource @Inject constructor() {

    fun getDogaList(): Array<SesModel> {
        return arrayOf(
            SesModel("Deniz", SesType.DOGA, R.raw.sound_doga_deniz, R.drawable.ic_doga_deniz),
            SesModel("Şehir", SesType.DOGA, R.raw.sound_doga_sehir, R.drawable.ic_doga_sehir),
            SesModel("Yağmur", SesType.DOGA, R.raw.sound_doga_yagmur, R.drawable.ic_doga_yagmur),
            SesModel("Rüzgar", SesType.DOGA, R.raw.sound_doga_ruzgar, R.drawable.ic_doga_ruzgar),
            SesModel("Orman", SesType.DOGA, R.raw.sound_doga_orman, R.drawable.ic_doga_orman),
            SesModel("Şelale", SesType.DOGA, R.raw.sound_doga_selale, R.drawable.ic_doga_selale),
            SesModel("Fırtına", SesType.DOGA, R.raw.sound_hayvan_horoz, R.drawable.ic_doga_firtina)
        )
    }

    fun getEnstrumanList(): Array<SesModel>{
        return arrayOf(
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
            SesModel("Piyano", SesType.ENSTRUMAN.TELLI,
                R.raw.sound_enstruman_piyano,
                R.drawable.ic_enstruman_piyano
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


        )
    }
    
    fun getInsanList(): Array<SesModel>{
        return arrayOf(
        SesModel("Kız Çocuk", SesType.INSAN, R.raw.sound_insan_kiz_cocuk, R.drawable.ic_insan_kiz_cocuk),
        SesModel("Erkek Çocuk", SesType.INSAN, R.raw.sound_insan_erkek_cocuk, R.drawable.ic_insan_erkek_cocuk),
        SesModel("Kadın", SesType.INSAN, R.raw.sound_insan_kadin, R.drawable.ic_insan_kadin),
        SesModel("Erkek", SesType.INSAN, R.raw.sound_insan_erkek, R.drawable.ic_insan_erkek),
        SesModel("Bebek", SesType.INSAN, R.raw.sound_insan_bebek, R.drawable.ic_insan_bebek),
        )
    }
    
    fun getHayvanList(): Array<SesModel>{
        return arrayOf(
            SesModel("İnek", SesType.HAYVAN, R.raw.sound_hayvan_inek, R.drawable.ic_hayvan_inek),
            SesModel("Kuş", SesType.HAYVAN, R.raw.sound_hayvan_kus, R.drawable.ic_hayvan_kus),
            SesModel("At", SesType.HAYVAN, R.raw.sound_hayvan_at, R.drawable.ic_hayvan_at),
            SesModel("Horoz", SesType.HAYVAN, R.raw.sound_hayvan_horoz, R.drawable.ic_hayvan_horoz),
            SesModel("Eşek", SesType.HAYVAN, R.raw.sound_hayvan_esek, R.drawable.ic_hayvan_esek),
            SesModel("Köpek", SesType.HAYVAN, R.raw.sound_hayvan_kopek, R.drawable.ic_hayvan_kopek),
            SesModel("Kedi", SesType.HAYVAN, R.raw.sound_hayvan_kedi, R.drawable.ic_hayvan_kedi),
            SesModel("Koyun", SesType.HAYVAN, R.raw.sound_hayvan_koyun, R.drawable.ic_hayvan_koyun),
            SesModel("Kaz", SesType.HAYVAN, R.raw.sound_hayvan_kaz, R.drawable.ic_hayvan_kaz),

            )
    }
    
    fun getAracList(): Array<SesModel>{
        return arrayOf(
            SesModel("Tren", SesType.ARAC, R.raw.sound_arac_tren, R.drawable.ic_arac_tren),
            SesModel("Motorsiklet", SesType.ARAC, R.raw.sound_arac_motorsiklet, R.drawable.ic_arac_motorsiklet),
            SesModel("Uçak", SesType.ARAC, R.raw.sound_arac_ucak, R.drawable.ic_arac_ucak),
            SesModel("Araba", SesType.ARAC, R.raw.sound_arac_araba, R.drawable.ic_arac_araba),
            SesModel("Vapur", SesType.ARAC, R.raw.sound_arac_vapur, R.drawable.ic_arac_vapur),
            SesModel("At Arabası", SesType.ARAC, R.raw.sound_arac_at_arabasi, R.drawable.ic_arac_at_arabasi),
            SesModel("Helikopter", SesType.ARAC, R.raw.sound_arac_helikopter, R.drawable.ic_arac_helikopter),
            SesModel("Ambulans", SesType.ARAC, R.raw.sound_arac_ambulans, R.drawable.ic_arac_ambulans),
            SesModel("Bisiklet", SesType.ARAC, R.raw.sound_arac_bisiklet, R.drawable.ic_arac_bsiklet),
            )
    }
    
    fun getSekilList(): Array<SesModel>{
        return arrayOf(
            SesModel("Üçgen", SesType.SEKIL, R.raw.sound_sekil_ucgen, R.drawable.ic_sekil_ucgen),
            SesModel("Kare", SesType.SEKIL, R.raw.sound_sekil_kare, R.drawable.ic_sekil_kare),
            SesModel("Dikdörtgen", SesType.SEKIL,R.raw.sound_sekil_dikdortgen, R.drawable.ic_sekil_dikdortgen),
            SesModel("Daire", SesType.SEKIL, R.raw.sound_sekil_daire, R.drawable.ic_sekil_daire),
            SesModel("Oval", SesType.SEKIL, R.raw.sound_sekil_oval, R.drawable.ic_sekil_oval),
            SesModel("Beşgen", SesType.SEKIL, R.raw.sound_sekil_besgen, R.drawable.ic_sekil_besgen),
            SesModel("Küp", SesType.SEKIL, R.raw.sound_sekil_kup, R.drawable.ic_sekil_kup),
            SesModel("Küre", SesType.SEKIL, R.raw.sound_sekil_kure, R.drawable.ic_sekil_kure),
            SesModel("Silindir", SesType.SEKIL, R.raw.sound_sekil_silindir, R.drawable.ic_sekil_silindir),
            SesModel("Piramit", SesType.SEKIL, R.raw.sound_sekil_piramit, R.drawable.ic_sekil_piramit),
            SesModel("Koni", SesType.SEKIL, R.raw.sound_sekil_koni, R.drawable.ic_sekil_koni),
            )
    }
    
    fun getSayiList(): Array<SesModel>{
        return arrayOf(
            SesModel("Bir", SesType.SAYI, R.raw.sound_sayi_bir, R.drawable.ic_sayi_bir),
            SesModel("İki", SesType.SAYI, R.raw.sound_sayi_iki, R.drawable.ic_sayi_iki),
            SesModel("Üç", SesType.SAYI, R.raw.sound_sayi_uc, R.drawable.ic_sayi_uc),
            SesModel("Dört", SesType.SAYI, R.raw.sound_sayi_dort, R.drawable.ic_sayi_dort),
            SesModel("Beş", SesType.SAYI, R.raw.sound_sayi_bes, R.drawable.ic_sayi_bes),
            SesModel("Altı", SesType.SAYI, R.raw.sound_sayi_alti, R.drawable.ic_sayi_alti),
            SesModel("Yedi", SesType.SAYI, R.raw.sound_sayi_yedi, R.drawable.ic_sayi_yedi),
            SesModel("Sekiz", SesType.SAYI, R.raw.sound_sayi_sekiz, R.drawable.ic_sayi_sekiz),
            SesModel("Dokuz", SesType.SAYI, R.raw.sound_sayi_dokuz, R.drawable.ic_sayi_dokuz),
            SesModel("On", SesType.SAYI, R.raw.sound_sayi_on, R.drawable.ic_sayi_on),
        )
    }

    fun getOyunHizliYavasList(): Array<SesModel>{
        return arrayOf(
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
    }

    fun getOyunResimdenBulList(): Array<SesModel>{
        return arrayOf(
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
                R.raw.sound_enstruman_name_piyano,
                R.drawable.ic_enstruman_piyano
            ),// isim söylenmesi eksik

            // VURMALI Türü
            SesModel("Davul", SesType.ENSTRUMAN.VURMALI,
                R.raw.sound_enstruman_name_davul,
                R.drawable.ic_enstruman_davul
            ),
            SesModel("Trampet", SesType.ENSTRUMAN.VURMALI,
                R.raw.sound_enstruman_name_trampet,
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
                R.raw.sound_enstruman_name_guiro,
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
}