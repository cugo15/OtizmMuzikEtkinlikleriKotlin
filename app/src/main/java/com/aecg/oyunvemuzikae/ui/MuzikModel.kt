package com.aecg.oyunvemuzikae.ui

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MuzikModel(
    val muzikName: String,
    val muzikType: MuzikType,
    val muzikUri: String,
    val imageResourceId: Int):Parcelable {
}