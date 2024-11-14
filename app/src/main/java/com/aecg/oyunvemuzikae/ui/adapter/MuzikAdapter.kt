package com.aecg.oyunvemuzikae.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aecg.oyunvemuzikae.databinding.MenuItemBinding
import com.aecg.oyunvemuzikae.data.model.MuzikModel
import com.aecg.oyunvemuzikae.domain.MuzikType

class MuzikAdapter(
    private val muzikList: ArrayList<MuzikModel>, // SesModel nesnelerinin bulunduğu liste
    private val onItemClick: (String, MuzikType) -> Unit, // Tıklama olayı için callback
    private val onItemAnimate: (View) -> Unit // Animasyon tetiklemek için callback
) : RecyclerView.Adapter<MuzikViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuzikViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MenuItemBinding.inflate(inflater, parent, false)
        return MuzikViewHolder(binding)
    }
    // Adapter'deki toplam item sayısını döndür
    override fun getItemCount(): Int {
        return muzikList.size
    }

    // Her bir ViewHolder için veriyi bağlamak için çağrılır
    override fun onBindViewHolder(holder: MuzikViewHolder, position: Int) {
        // Mevcut pozisyondaki SesModel nesnesini al
        val currentSesModel = muzikList[position]
        // ViewHolder'ı bağla ve gerekli callback'leri geçir
        holder.bind(currentSesModel, onItemClick, onItemAnimate)
    }
}
