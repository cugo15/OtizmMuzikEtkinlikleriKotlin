package com.aecg.oyunvemuzikae

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

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

fun View.loadLayoutBackgroundWithGlide(context: Context, resourceId: Int, defaultDrawableId: Int) {
    Glide.with(context)
        .load(resourceId)
        .into(object : CustomTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                // Yüklenen Drawable'i arka plana set et
                this@loadLayoutBackgroundWithGlide.background = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                // Yükleme iptal edildiğinde yapılacak işlemler
            }

            override fun onLoadFailed(errorDrawable: Drawable?) {
                // Yükleme başarısız olursa varsayılan arka plan ayarla
                this@loadLayoutBackgroundWithGlide.setBackgroundResource(defaultDrawableId) // varsayılan arka plan
            }
        })
}