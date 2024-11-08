package com.aecg.oyunvemuzikae.Sesler

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class SesModel(
    val sesName: String,
    val type: @RawValue SesType, // type enum olarak tanımlı
    val sesResourceId: Int, // raw klasöründeki ses dosyasını temsil eden ID
    val imageResourceId: Int
) : Parcelable