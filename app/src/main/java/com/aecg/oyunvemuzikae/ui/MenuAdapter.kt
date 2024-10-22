package com.aecg.oyunvemuzikae.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aecg.oyunvemuzikae.MenuType
import com.aecg.oyunvemuzikae.databinding.MenuItemBinding

class MenuAdapter(
    private val menuList: ArrayList<MenuModel>, // MenuModel nesnelerinin bulunduğu liste
    private val onItemClick: (String, MenuType) -> Unit, // Tıklama olayı için callback
    private val onItemAnimate: (View) -> Unit // Animasyon tetiklemek için callback
) : RecyclerView.Adapter<MenuViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MenuItemBinding.inflate(inflater, parent, false)
        return MenuViewHolder(binding)
    }

    // Adapter'deki toplam item sayısını döndür
    override fun getItemCount(): Int {
        return menuList.size
    }

    // Her bir ViewHolder için veriyi bağlamak için çağrılır
    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        // Mevcut pozisyondaki MenuModel nesnesini al
        val currentMenuModel = menuList[position]
        // ViewHolder'ı bağla ve gerekli callback'leri geçir
        holder.bind(currentMenuModel, onItemClick, onItemAnimate)
    }
}