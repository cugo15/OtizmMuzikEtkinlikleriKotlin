package com.aecg.oyunvemuzikae.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.aecg.oyunvemuzikae.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

fun View.loadLayoutBackgroundWithGlide(context: Context, resourceId: Int) {
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
                this@loadLayoutBackgroundWithGlide.setBackgroundResource(R.drawable.bg_home) // varsayılan arka plan
            }
        })
}
fun ImageView.loadResourceImageWithGlide(resourceId: Int) {
    Glide.with(this.context)
        .load(resourceId)  // Kaynak görseli yükler
        //.apply(RequestOptions().placeholder(R.drawable.placeholder))  // Yükleme sırasında placeholder (isteğe bağlı)
        .into(this)  // ImageView'a yükler
}