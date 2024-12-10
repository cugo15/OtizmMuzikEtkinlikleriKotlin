package com.aecg.oyunvemuzikae.domain

import com.aecg.oyunvemuzikae.R

enum class MenuType (val displayName: String, val backgroundResource: Int) {
    SES("Sesler", R.drawable.bg_menu_ses),
    OYUN("Oyunlar", R.drawable.bg_menu_oyun),
    MEMORYLEVEL("Seviye Seç", R.drawable.bg_oyun_menu_hafiza),
}
