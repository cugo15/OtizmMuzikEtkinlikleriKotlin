package com.aecg.oyunvemuzikae

import android.app.Application
import com.aecg.oyunvemuzikae.Sesler.SesType
import com.aecg.oyunvemuzikae.Sesler.SesModel
import com.aecg.oyunvemuzikae.ui.MenuModel

class MyApplication:Application() {

    val dogaList = arrayListOf(
    SesModel("Deniz",SesType.DOGA, R.raw.sound_doga_deniz, R.drawable.ic_doga_deniz),
    SesModel("Şehir",SesType.DOGA, R.raw.sound_doga_sehir, R.drawable.ic_doga_sehir),
    SesModel("Yağmur",SesType.DOGA, R.raw.sound_doga_yagmur, R.drawable.ic_doga_yagmur),
    SesModel("Rüzgar",SesType.DOGA, R.raw.sound_doga_ruzgar, R.drawable.ic_doga_ruzgar),
    SesModel("Orman",SesType.DOGA, R.raw.sound_doga_orman, R.drawable.ic_doga_orman),
    SesModel("Şelale",SesType.DOGA, R.raw.sound_doga_selale, R.drawable.ic_doga_selale),
    SesModel("Fırtına",SesType.DOGA, R.raw.sound_hayvan_horoz, R.drawable.ic_doga_firtina)
    )

    val enstrumanList = arrayListOf(
        SesModel("Trombon",SesType.ENSTRUMAN, R.raw.sound_enstruman_trombon, R.drawable.ic_enstruman_trombon),
        SesModel("Piyano",SesType.ENSTRUMAN, R.raw.sound_enstruman_piyano, R.drawable.ic_enstruman_piyano),
        SesModel("Obua",SesType.ENSTRUMAN, R.raw.sound_enstruman_obua, R.drawable.ic_enstruman_obua),
        SesModel("Metronom",SesType.ENSTRUMAN, R.raw.sound_enstruman_metronom, R.drawable.ic_enstruman_metronom),
        SesModel("Gitar",SesType.ENSTRUMAN, R.raw.sound_enstruman_gitar, R.drawable.ic_enstruman_gitar),
        SesModel("Trompet",SesType.ENSTRUMAN, R.raw.sound_enstruman_trompet, R.drawable.ic_enstruman_trompet),
        SesModel("Bateri",SesType.ENSTRUMAN, R.raw.sound_enstruman_bateri, R.drawable.ic_enstruman_bateri),
        SesModel("Bağlama",SesType.ENSTRUMAN, R.raw.sound_enstruman_baglama, R.drawable.ic_enstruman_baglama),
        SesModel("Zurna",SesType.ENSTRUMAN, R.raw.sound_enstruman_zurna, R.drawable.ic_enstruman_zurna),
        SesModel("Zil",SesType.ENSTRUMAN, R.raw.sound_enstruman_zil, R.drawable.ic_enstruman_zil),
        SesModel("Keman",SesType.ENSTRUMAN, R.raw.sound_enstruman_keman, R.drawable.ic_enstruman_keman),
        SesModel("Flüt",SesType.ENSTRUMAN, R.raw.sound_enstruman_flut, R.drawable.ic_enstruman_flut),
        SesModel("Def",SesType.ENSTRUMAN, R.raw.sound_enstruman_def, R.drawable.ic_enstruman_def),
        SesModel("Davul",SesType.ENSTRUMAN, R.raw.sound_enstruman_davul, R.drawable.ic_enstruman_davul),
        SesModel("Ksilafon",SesType.ENSTRUMAN, R.raw.sound_enstruman_ksilafon, R.drawable.ic_enstruman_ksilofon),
        SesModel("Kanun",SesType.ENSTRUMAN, R.raw.sound_enstruman_kanun, R.drawable.ic_enstruman_kanun),
        SesModel("Ud",SesType.ENSTRUMAN, R.raw.sound_enstruman_ud, R.drawable.ic_enstruman_ud),
    )

    val insanList = arrayListOf(
        SesModel("Kız Çocuk",SesType.INSAN, R.raw.sound_insan_kiz_cocuk, R.drawable.ic_insan_kiz_cocuk),
        SesModel("Erkek Çocuk",SesType.INSAN, R.raw.sound_insan_erkek_cocuk, R.drawable.ic_insan_erkek_cocuk),
        SesModel("Kadın",SesType.INSAN, R.raw.sound_insan_kadin, R.drawable.ic_insan_kadin),
        SesModel("Erkek",SesType.INSAN, R.raw.sound_insan_erkek, R.drawable.ic_insan_erkek),
        SesModel("Bebek",SesType.INSAN, R.raw.sound_insan_bebek, R.drawable.ic_insan_bebek),
    )

    val hayvanList = arrayListOf(
        SesModel("İnek",SesType.HAYVAN, R.raw.sound_hayvan_inek, R.drawable.ic_hayvan_inek),
        SesModel("Kuş",SesType.HAYVAN, R.raw.sound_hayvan_kus, R.drawable.ic_hayvan_kus),
        SesModel("At",SesType.HAYVAN, R.raw.sound_hayvan_at, R.drawable.ic_hayvan_at),
        SesModel("Horoz",SesType.HAYVAN, R.raw.sound_hayvan_horoz, R.drawable.ic_hayvan_horoz),
        SesModel("Eşek",SesType.HAYVAN, R.raw.sound_hayvan_esek, R.drawable.ic_hayvan_esek),
        SesModel("Köpek",SesType.HAYVAN, R.raw.sound_hayvan_kopek, R.drawable.ic_hayvan_kopek),
        SesModel("Kedi",SesType.HAYVAN, R.raw.sound_hayvan_kedi, R.drawable.ic_hayvan_kedi),
        SesModel("Koyun",SesType.HAYVAN, R.raw.sound_hayvan_koyun, R.drawable.ic_hayvan_koyun),
        )

    val aracList = arrayListOf(
        SesModel("Tren",SesType.ARAC, R.raw.sound_arac_tren, R.drawable.ic_arac_tren),
        SesModel("Motorsiklet",SesType.ARAC, R.raw.sound_arac_motorsiklet, R.drawable.ic_arac_motorsiklet),
        SesModel("Uçak",SesType.ARAC, R.raw.sound_arac_ucak, R.drawable.ic_arac_ucak),
        SesModel("Araba",SesType.ARAC, R.raw.sound_arac_araba, R.drawable.ic_arac_araba),
        SesModel("Vapur",SesType.ARAC, R.raw.sound_arac_vapur, R.drawable.ic_arac_vapur),
        SesModel("At Arabası",SesType.ARAC, R.raw.sound_arac_at_arabasi, R.drawable.ic_arac_at_arabasi),
        SesModel("Helikopter",SesType.ARAC, R.raw.sound_arac_helikopter, R.drawable.ic_arac_helikopter),
        SesModel("Ambulans",SesType.ARAC, R.raw.sound_arac_ambulans, R.drawable.ic_arac_ambulans),
    )

    val sekilList = arrayListOf(
        SesModel("Üçgen",SesType.SEKIL, R.raw.sound_sekil_ucgen, R.drawable.ic_sekil_ucgen),
        SesModel("Kare",SesType.SEKIL, R.raw.sound_sekil_kare, R.drawable.ic_sekil_kare),
        SesModel("Dikdörtgen",SesType.SEKIL, R.raw.sound_sekil_dikdortgen, R.drawable.ic_sekil_dikdortgen),
        SesModel("Daire",SesType.SEKIL, R.raw.sound_sekil_daire, R.drawable.ic_sekil_daire),
        SesModel("Oval",SesType.SEKIL, R.raw.sound_sekil_oval, R.drawable.ic_sekil_oval),
        SesModel("Beşgen",SesType.SEKIL, R.raw.sound_sekil_besgen, R.drawable.ic_sekil_besgen),
        SesModel("Küp",SesType.SEKIL, R.raw.sound_sekil_kup, R.drawable.ic_sekil_kup),
        SesModel("Küre",SesType.SEKIL, R.raw.sound_sekil_kure, R.drawable.ic_sekil_kure),
        SesModel("Silindir",SesType.SEKIL, R.raw.sound_sekil_silindir, R.drawable.ic_sekil_silindir),
        SesModel("Piramit",SesType.SEKIL, R.raw.sound_sekil_piramit, R.drawable.ic_sekil_piramit),
        SesModel("Koni",SesType.SEKIL, R.raw.sound_sekil_koni, R.drawable.ic_sekil_koni),

        )

    val sayiList = arrayListOf(
        SesModel("Bir",SesType.SAYI, R.raw.sound_sayi_bir, R.drawable.ic_sayi_bir),
        SesModel("İki",SesType.SAYI, R.raw.sound_sayi_iki, R.drawable.ic_sayi_iki),
        SesModel("Üç",SesType.SAYI, R.raw.sound_sayi_uc, R.drawable.ic_sayi_uc),
        SesModel("Dört",SesType.SAYI, R.raw.sound_sayi_dort, R.drawable.ic_sayi_dort),
        SesModel("Beş",SesType.SAYI, R.raw.sound_sayi_bes, R.drawable.ic_sayi_bes),
        SesModel("Altı",SesType.SAYI, R.raw.sound_sayi_alti, R.drawable.ic_sayi_alti),
        SesModel("Yedi",SesType.SAYI, R.raw.sound_sayi_yedi, R.drawable.ic_sayi_yedi),
        SesModel("Sekiz",SesType.SAYI, R.raw.sound_sayi_sekiz, R.drawable.ic_sayi_sekiz),
        SesModel("Dokuz",SesType.SAYI, R.raw.sound_sayi_dokuz, R.drawable.ic_sayi_dokuz),
        SesModel("On",SesType.SAYI, R.raw.sound_sayi_on, R.drawable.ic_sayi_on),
        )


    val sesMenuList = arrayListOf(
        MenuModel("Enstrüman",MenuType.SES,R.drawable.ic_sesmenu_enstruman),
        MenuModel("Doğa",MenuType.SES,R.drawable.ic_sesmenu_doga),
        MenuModel("İnsan",MenuType.SES,R.drawable.ic_sesmenu_insan),
        MenuModel("Araçlar",MenuType.SES,R.drawable.ic_sesmenu_araclar),
        MenuModel("Hayvan",MenuType.SES,R.drawable.ic_sesmenu_hayvan),
        MenuModel("Sayılar",MenuType.SES,R.drawable.ic_sesmenu_sayilar),
        MenuModel("Şekiller",MenuType.SES,R.drawable.ic_sesmenu_sekiller),
    )
}