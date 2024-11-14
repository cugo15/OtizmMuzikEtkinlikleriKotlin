package com.aecg.oyunvemuzikae.data.model

import android.os.Parcelable
import com.aecg.oyunvemuzikae.domain.MuzikType
import kotlinx.parcelize.Parcelize

@Parcelize
data class MuzikModel(
    val muzikName: String,
    val muzikType: MuzikType,
    val muzikUri: String,
    val imageResourceId: Int):Parcelable {
}