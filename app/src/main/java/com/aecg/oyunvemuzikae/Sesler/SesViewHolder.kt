package com.aecg.oyunvemuzikae.Sesler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aecg.oyunvemuzikae.databinding.SesItemBinding
import com.bumptech.glide.Glide

class SesViewHolder(val binding: SesItemBinding) : RecyclerView.ViewHolder(binding.root) {

    // Bind fonksiyonu, bir SesModel nesnesini alır ve gerekli verileri UI bileşenlerine atar
    inline fun bind(
        sesModel: SesModel,
        crossinline onClickListener: (Int) -> Unit,
        crossinline onItemAnimated: (View) -> Unit
    ) {
        // Ses modelinin görselini ata
        Glide.with(binding.imgSes.context)
            .load(sesModel.imageResourceId)
            .into(binding.imgSes)

        // Ses modelinin adını TextView'a ata
        binding.txtSes.text = sesModel.sesName

        // Tıklama olayının tetiklenmesi
        binding.root.setOnClickListener {
            // Tıklandığında, ses kaynağı ID'sini dışarıya ilet
            onClickListener(sesModel.sesResourceId)
            // Tıklandığında, animasyon için kullanılan view'i dışarıya ilet
            onItemAnimated(binding.cardSes)
        }
    }
}
