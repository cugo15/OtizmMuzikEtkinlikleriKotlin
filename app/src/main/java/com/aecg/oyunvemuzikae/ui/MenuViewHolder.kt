package com.aecg.oyunvemuzikae.ui

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aecg.oyunvemuzikae.MenuType
import com.aecg.oyunvemuzikae.databinding.MenuItemBinding
import com.bumptech.glide.Glide

class MenuViewHolder(val binding: MenuItemBinding) : RecyclerView.ViewHolder(binding.root) {

    // Bind fonksiyonu, bir SesModel nesnesini alır ve gerekli verileri UI bileşenlerine atar
    inline fun bind(
        menuModel: MenuModel,
        crossinline onClickListener: (String,MenuType) -> Unit,
        crossinline onItemAnimated: (View) -> Unit
    ) {
        // Ses modelinin görselini ata
        Glide.with(binding.imgMenu.context)
            .load(menuModel.menuImageResourceId)
            .into(binding.imgMenu)

        // Ses modelinin adını TextView'a ata
        binding.txtMenu.text = menuModel.menuName

        // Tıklama olayının tetiklenmesi
        binding.root.setOnClickListener {
            // Tıklandığında, ses kaynağı ID'sini dışarıya ilet
            onClickListener(menuModel.menuName,menuModel.type)
            // Tıklandığında, animasyon için kullanılan view'i dışarıya ilet
            onItemAnimated(binding.cardMenu)
        }
    }
}