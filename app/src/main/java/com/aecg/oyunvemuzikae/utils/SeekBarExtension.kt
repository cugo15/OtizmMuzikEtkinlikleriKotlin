package com.aecg.oyunvemuzikae.utils

import android.widget.SeekBar

inline fun SeekBar.setOnCustomSeekBarChangeListener(crossinline onProgressChanged: (progress: Int, fromUser: Boolean) -> Unit) {
    setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
            onProgressChanged(progress, fromUser)
        }
        override fun onStartTrackingTouch(seekBar: SeekBar) {}
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    })
}
