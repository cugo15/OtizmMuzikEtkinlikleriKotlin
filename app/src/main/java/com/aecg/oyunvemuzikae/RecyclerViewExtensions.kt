package com.aecg.oyunvemuzikae

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.scrollInDirection(direction: Int) {
    val layoutManager = this.layoutManager as LinearLayoutManager
    val itemCount = layoutManager.itemCount
    val lastVisiblePosition = layoutManager.findLastVisibleItemPosition()
    val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()

    val newPosition = when (direction) {
        1 -> if (lastVisiblePosition < itemCount - 1) lastVisiblePosition + 1 else return
        -1 -> if (firstVisiblePosition > 0) firstVisiblePosition - 1 else return
        else -> return
    }
    this.smoothScrollToPosition(newPosition)
}