package com.aecg.oyunvemuzikae.ui.adapter

import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.aecg.oyunvemuzikae.domain.SesType
import com.aecg.oyunvemuzikae.data.model.SesModel
import com.aecg.oyunvemuzikae.databinding.SesItemBinding
import com.bumptech.glide.Glide

class SesViewHolder(val binding: SesItemBinding) : RecyclerView.ViewHolder(binding.root) {

    // Bind fonksiyonu, bir SesModel nesnesini alır ve gerekli verileri UI bileşenlerine atar
    inline fun bind(
        sesModel: SesModel,
        crossinline onClickListener: (CardView, Int) -> Unit,
        crossinline onItemStyled: (CardView, ImageView, SesType) -> Unit
    ) {
        onItemStyled(binding.cardSes,binding.imgSes,sesModel.type)
        // Ses modelinin görselini ata
        Glide.with(binding.imgSes.context)
            .load(sesModel.imageResourceId)
            .into(binding.imgSes)
        // Ses modelinin adını TextView'a ata
        binding.txtSes.text = sesModel.sesName

        // Tıklama olayının tetiklenmesi
        binding.root.setOnClickListener {
            // Tıklandığında, ses kaynağı ID'sini dışarıya ilet
            onClickListener(binding.cardSes,sesModel.sesResourceId)
            // Tıklandığında, animasyon için kullanılan view'i dışarıya ilet

        }
    }
}
