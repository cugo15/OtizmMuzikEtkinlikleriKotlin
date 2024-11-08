package com.aecg.oyunvemuzikae.Sesler

// Ana sealed class olan SesType
sealed class SesType(val displayName: String) {

    object HAYVAN : SesType("Hayvan Sesleri")
    object INSAN : SesType("İnsan Sesleri")
    object DOGA : SesType("Doğa Sesleri")
    object ARAC : SesType("Araç Sesleri")
    object SAYI : SesType("Sayılar")
    object SEKIL : SesType("Geometrik Şekiller")

    // ENSTRUMAN türü için sealed class ve alt enum class tanımlıyoruz
    sealed class ENSTRUMAN(displayName: String) : SesType(displayName) {
        object ORFF : ENSTRUMAN("Orff Çalgıları")
        object VURMALI : ENSTRUMAN("Vurmalı Çalgılar")
        object TELLI : ENSTRUMAN("Telli Çalgılar")
        object UFLEMELI : ENSTRUMAN("Üflemeli Çalgılar")
        object OTHER : ENSTRUMAN("Diğer Çalgılar")
    }
}

