package com.aecg.oyunvemuzikae.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aecg.oyunvemuzikae.databinding.MenuItemBinding
import com.bumptech.glide.Glide

class MuzikViewHolder(val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {

    // Bind fonksiyonu, bir SesModel nesnesini alır ve gerekli verileri UI bileşenlerine atar
    inline fun bind(
        muzikModel: MuzikModel,
        crossinline onClickListener: (String,MuzikType) -> Unit,
        crossinline onItemAnimated: (View) -> Unit
    ) {
        // Ses modelinin görselini ata
        Glide.with(binding.imgMenu.context)
            .load(muzikModel.imageResourceId)
            .into(binding.imgMenu)

        // Ses modelinin adını TextView'a ata
        binding.txtMenu.text = muzikModel.muzikName

        // Tıklama olayının tetiklenmesi
        binding.root.setOnClickListener {
            // Tıklandığında, ses kaynağı ID'sini dışarıya ilet
            onClickListener(muzikModel.muzikUri,muzikModel.muzikType)
            // Tıklandığında, animasyon için kullanılan view'i dışarıya ilet
            onItemAnimated(binding.cardMenu)
        }
    }
}