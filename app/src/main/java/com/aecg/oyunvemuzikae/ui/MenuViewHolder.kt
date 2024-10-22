package com.aecg.oyunvemuzikae.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aecg.oyunvemuzikae.databinding.SesItemBinding
import com.bumptech.glide.Glide

class MenuViewHolder(val binding: SesItemBinding) : RecyclerView.ViewHolder(binding.root) {

    // Bind fonksiyonu, bir SesModel nesnesini alır ve gerekli verileri UI bileşenlerine atar
    inline fun bind(
        menuModel: MenuModel,
        crossinline onClickListener: (Int) -> Unit,
        crossinline onItemAnimated: (View) -> Unit
    ) {
        // Ses modelinin görselini ata
        Glide.with(binding.imgSes.context)
            .load(menuModel.imageResourceId)
            .into(binding.imgSes)

        // Ses modelinin adını TextView'a ata
        binding.txtSes.text = menuModel.name

        // Tıklama olayının tetiklenmesi
        binding.root.setOnClickListener {
            // Tıklandığında, ses kaynağı ID'sini dışarıya ilet
            onClickListener(menuModel.id)
            // Tıklandığında, animasyon için kullanılan view'i dışarıya ilet
            onItemAnimated(binding.cardSes)
        }
    }
}