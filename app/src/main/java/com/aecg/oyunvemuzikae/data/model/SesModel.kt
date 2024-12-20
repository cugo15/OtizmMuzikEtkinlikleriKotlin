package com.aecg.oyunvemuzikae.data.model

import SesType
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SesModel(
    val sesName: String,
    val type: SesType, // type enum olarak tanımlı
    val sesResourceId: Int, // raw klasöründeki ses dosyasını temsil eden ID
    val imageResourceId: Int
) : Parcelable