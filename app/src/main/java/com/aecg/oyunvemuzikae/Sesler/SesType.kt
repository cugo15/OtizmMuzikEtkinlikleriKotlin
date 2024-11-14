package com.aecg.oyunvemuzikae.Sesler

sealed class SesType(val displayName: String) {

    data object HAYVAN : SesType("Hayvan Sesleri")
    data object INSAN : SesType("İnsan Sesleri")
    data object DOGA : SesType("Doğa Sesleri")
    data object ARAC : SesType("Araç Sesleri")
    data object SAYI : SesType("Sayılar")
    data object SEKIL : SesType("Geometrik Şekiller")

    // ENSTRUMAN türü için sealed class ve alt sınıfları tanımlıyoruz
    sealed class ENSTRUMAN(
        displayName: String = "Enstrüman Sesleri",
        val displayGameHeader: String
    ) : SesType(displayName) {
        data object ORFF : ENSTRUMAN(displayGameHeader = "Orff")
        data object VURMALI : ENSTRUMAN(displayGameHeader = "Vurmalı")
        data object TELLI : ENSTRUMAN(displayGameHeader = "Telli")
        data object UFLEMELI : ENSTRUMAN(displayGameHeader = "Üflemeli")
        data object OTHER : ENSTRUMAN(displayGameHeader = "Diğer")
    }
}


