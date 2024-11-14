package com.aecg.oyunvemuzikae.data.model

import android.os.Parcelable
import com.aecg.oyunvemuzikae.domain.MenuType
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuModel(
    val menuName: String,            // Menü adı
    val type: MenuType,              // Menü türü (enum olarak tanımlı)
    val menuImageResourceId: Int     // Menü görsel kaynak ID'si
) : Parcelable
