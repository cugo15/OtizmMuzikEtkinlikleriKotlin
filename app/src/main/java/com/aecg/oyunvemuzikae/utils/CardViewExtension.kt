package com.aecg.oyunvemuzikae.utils

import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

fun CardView.setForegroundDrawable(drawableId: Int) {
    this.foreground = ContextCompat.getDrawable(context, drawableId)
}
