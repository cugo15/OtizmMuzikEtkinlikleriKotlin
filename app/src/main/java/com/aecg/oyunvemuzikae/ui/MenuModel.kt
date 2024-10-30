package com.aecg.oyunvemuzikae.ui

import android.os.Parcelable
import com.aecg.oyunvemuzikae.MenuType
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuModel(
    val menuName: String,            // Menü adı
    val type: MenuType,              // Menü türü (enum olarak tanımlı)
    val menuImageResourceId: Int     // Menü görsel kaynak ID'si
) : Parcelable
