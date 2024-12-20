package com.aecg.oyunvemuzikae.ui.adapter

import SesType
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.aecg.oyunvemuzikae.data.model.SesModel
import com.aecg.oyunvemuzikae.databinding.SesItemBinding

class SesAdapter(
    private val sesList: ArrayList<SesModel>, // SesModel nesnelerinin bulunduğu liste
    private val onItemClick: (CardView,Int) -> Unit, // Tıklama olayı için callback
    private val onItemStyle: (CardView, ImageView, SesType) -> Unit // Animasyon tetiklemek için callback
) : RecyclerView.Adapter<SesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = SesItemBinding.inflate(inflater, parent, false)
        return SesViewHolder(binding)
    }

    // Adapter'deki toplam item sayısını döndür
    override fun getItemCount(): Int {
        return sesList.size
    }

    // Her bir ViewHolder için veriyi bağlamak için çağrılır
    override fun onBindViewHolder(holder: SesViewHolder, position: Int) {
        // Mevcut pozisyondaki SesModel nesnesini al
        val currentSesModel = sesList[position]
        // ViewHolder'ı bağla ve gerekli callback'leri geçir
        holder.bind(currentSesModel, onItemClick, onItemStyle)
    }
}
