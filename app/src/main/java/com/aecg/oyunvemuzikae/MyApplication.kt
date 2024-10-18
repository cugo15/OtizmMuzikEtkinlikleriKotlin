package com.aecg.oyunvemuzikae

import android.app.Application
import com.aecg.oyunvemuzikae.Sesler.SesCategory
import com.aecg.oyunvemuzikae.Sesler.SesModel

class MyApplication:Application() {

    val dogaList = arrayListOf(
    SesModel("Deniz",SesCategory.DOGA, R.raw.sound_doga_deniz, R.drawable.ic_doga_deniz),
    SesModel("Şehir",SesCategory.DOGA, R.raw.sound_doga_sehir, R.drawable.ic_doga_sehir),
    SesModel("Yağmur",SesCategory.DOGA, R.raw.sound_doga_yagmur, R.drawable.ic_doga_yagmur),
    SesModel("Rüzgar",SesCategory.DOGA, R.raw.sound_doga_ruzgar, R.drawable.ic_doga_ruzgar),
    SesModel("Orman",SesCategory.DOGA, R.raw.sound_doga_orman, R.drawable.ic_doga_orman),
    SesModel("Şelale",SesCategory.DOGA, R.raw.sound_doga_selale, R.drawable.ic_doga_selale),
    SesModel("Fırtına",SesCategory.DOGA, R.raw.sound_hayvan_horoz, R.drawable.ic_doga_firtina)
    )

    val enstrumanList = arrayListOf(
        SesModel("Trombon",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_trombon, R.drawable.ic_enstruman_trombon),
        SesModel("Piyano",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_piyano, R.drawable.ic_enstruman_piyano),
        SesModel("Obua",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_obua, R.drawable.ic_enstruman_obua),
        SesModel("Metronom",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_metronom, R.drawable.ic_enstruman_metronom),
        SesModel("Gitar",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_gitar, R.drawable.ic_enstruman_gitar),
        SesModel("Trompet",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_trompet, R.drawable.ic_enstruman_trompet),
        SesModel("Bateri",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_bateri, R.drawable.ic_enstruman_bateri),
        SesModel("Bağlama",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_baglama, R.drawable.ic_enstruman_baglama),
        SesModel("Zurna",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_zurna, R.drawable.ic_enstruman_zurna),
        SesModel("Zil",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_zil, R.drawable.ic_enstruman_zil),
        SesModel("Keman",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_keman, R.drawable.ic_enstruman_keman),
        SesModel("Flüt",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_flut, R.drawable.ic_enstruman_flut),
        SesModel("Def",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_def, R.drawable.ic_enstruman_def),
        SesModel("Davul",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_davul, R.drawable.ic_enstruman_davul),
        SesModel("Ksilafon",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_ksilafon, R.drawable.ic_enstruman_ksilofon),
        SesModel("Kanun",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_kanun, R.drawable.ic_enstruman_kanun),
        SesModel("Ud",SesCategory.ENSTRUMAN, R.raw.sound_enstruman_ud, R.drawable.ic_enstruman_ud),
    )

    val insanList = arrayListOf(
        SesModel("Kız Çocuk",SesCategory.INSAN, R.raw.sound_insan_kiz_cocuk, R.drawable.ic_insan_kiz_cocuk),
        SesModel("Erkek Çocuk",SesCategory.INSAN, R.raw.sound_insan_erkek_cocuk, R.drawable.ic_insan_erkek_cocuk),
        SesModel("Kadın",SesCategory.INSAN, R.raw.sound_insan_kadin, R.drawable.ic_insan_kadin),
        SesModel("Erkek",SesCategory.INSAN, R.raw.sound_insan_erkek, R.drawable.ic_insan_erkek),
        SesModel("Bebek",SesCategory.INSAN, R.raw.sound_insan_bebek, R.drawable.ic_insan_bebek),
    )

    val hayvanList = arrayListOf(
        SesModel("İnek",SesCategory.HAYVAN, R.raw.sound_hayvan_inek, R.drawable.ic_hayvan_inek),
        SesModel("Kuş",SesCategory.HAYVAN, R.raw.sound_hayvan_kus, R.drawable.ic_hayvan_kus),
        SesModel("At",SesCategory.HAYVAN, R.raw.sound_hayvan_at, R.drawable.ic_hayvan_at),
        SesModel("Horoz",SesCategory.HAYVAN, R.raw.sound_hayvan_horoz, R.drawable.ic_hayvan_horoz),
        SesModel("Eşek",SesCategory.HAYVAN, R.raw.sound_hayvan_esek, R.drawable.ic_hayvan_esek),
        SesModel("Köpek",SesCategory.HAYVAN, R.raw.sound_hayvan_kopek, R.drawable.ic_hayvan_kopek),
        SesModel("Kedi",SesCategory.HAYVAN, R.raw.sound_hayvan_kedi, R.drawable.ic_hayvan_kedi),
        SesModel("Koyun",SesCategory.HAYVAN, R.raw.sound_hayvan_koyun, R.drawable.ic_hayvan_koyun),
        )

    val aracList = arrayListOf(
        SesModel("Tren",SesCategory.ARAC, R.raw.sound_arac_tren, R.drawable.ic_arac_tren),
        SesModel("Motorsiklet",SesCategory.ARAC, R.raw.sound_arac_motorsiklet, R.drawable.ic_arac_motorsiklet),
        SesModel("Uçak",SesCategory.ARAC, R.raw.sound_arac_ucak, R.drawable.ic_arac_ucak),
        SesModel("Araba",SesCategory.ARAC, R.raw.sound_arac_araba, R.drawable.ic_arac_araba),
        SesModel("Vapur",SesCategory.ARAC, R.raw.sound_arac_vapur, R.drawable.ic_arac_vapur),
        SesModel("At Arabası",SesCategory.ARAC, R.raw.sound_arac_at_arabasi, R.drawable.ic_arac_at_arabasi),
        SesModel("Helikopter",SesCategory.ARAC, R.raw.sound_arac_helikopter, R.drawable.ic_arac_helikopter),
        SesModel("Ambulans",SesCategory.ARAC, R.raw.sound_arac_ambulans, R.drawable.ic_arac_ambulans),
    )

    val sekilList = arrayListOf(
        SesModel("Üçgen",SesCategory.SEKIL, R.raw.sound_sekil_ucgen, R.drawable.ic_sekil_ucgen),
        SesModel("Kare",SesCategory.SEKIL, R.raw.sound_sekil_kare, R.drawable.ic_sekil_kare),
        SesModel("Dikdörtgen",SesCategory.SEKIL, R.raw.sound_sekil_dikdortgen, R.drawable.ic_sekil_dikdortgen),
        SesModel("Daire",SesCategory.SEKIL, R.raw.sound_sekil_daire, R.drawable.ic_sekil_daire),
        SesModel("Oval",SesCategory.SEKIL, R.raw.sound_sekil_oval, R.drawable.ic_sekil_oval),
        SesModel("Beşgen",SesCategory.SEKIL, R.raw.sound_sekil_besgen, R.drawable.ic_sekil_besgen),
        SesModel("Küp",SesCategory.SEKIL, R.raw.sound_sekil_kup, R.drawable.ic_sekil_kup),
        SesModel("Küre",SesCategory.SEKIL, R.raw.sound_sekil_kure, R.drawable.ic_sekil_kure),
        SesModel("Silindir",SesCategory.SEKIL, R.raw.sound_sekil_silindir, R.drawable.ic_sekil_silindir),
        SesModel("Piramit",SesCategory.SEKIL, R.raw.sound_sekil_piramit, R.drawable.ic_sekil_piramit),
        SesModel("Koni",SesCategory.SEKIL, R.raw.sound_sekil_koni, R.drawable.ic_sekil_koni),

        )

    val sayiList = arrayListOf(
        SesModel("Bir",SesCategory.SAYI, R.raw.sound_sayi_bir, R.drawable.ic_sayi_bir),
        SesModel("İki",SesCategory.SAYI, R.raw.sound_sayi_iki, R.drawable.ic_sayi_iki),
        SesModel("Üç",SesCategory.SAYI, R.raw.sound_sayi_uc, R.drawable.ic_sayi_uc),
        SesModel("Dört",SesCategory.SAYI, R.raw.sound_sayi_dort, R.drawable.ic_sayi_dort),
        SesModel("Beş",SesCategory.SAYI, R.raw.sound_sayi_bes, R.drawable.ic_sayi_bes),
        SesModel("Altı",SesCategory.SAYI, R.raw.sound_sayi_alti, R.drawable.ic_sayi_alti),
        SesModel("Yedi",SesCategory.SAYI, R.raw.sound_sayi_yedi, R.drawable.ic_sayi_yedi),
        SesModel("Sekiz",SesCategory.SAYI, R.raw.sound_sayi_sekiz, R.drawable.ic_sayi_sekiz),
        SesModel("Dokuz",SesCategory.SAYI, R.raw.sound_sayi_dokuz, R.drawable.ic_sayi_dokuz),
        SesModel("On",SesCategory.SAYI, R.raw.sound_sayi_on, R.drawable.ic_sayi_on),
        )

}