package com.aecg.oyunvemuzikae.utils

import android.view.View
import androidx.core.content.ContextCompat

fun View.setForegroundDrawable(drawableId: Int) {
    this.foreground = ContextCompat.getDrawable(context, drawableId)
}



