package com.aecg.oyunvemuzikae.ui.viewmodel


import androidx.lifecycle.ViewModel
import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.data.model.MuzikModel
import com.aecg.oyunvemuzikae.data.repository.MenuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(menuRepository: MenuRepository) : ViewModel() {

    // Menü listelerini doğrudan saklıyoruz
    private val sesMenuList: Array<MenuModel> = menuRepository.sesMenuList
    private val oyunMenuList: Array<MenuModel> = menuRepository.oyunMenuList
    private val muzikMenuList: Array<MuzikModel> = menuRepository.muzikMenuList

    // Getter metodları ile verilere erişim sağlıyoruz
    fun getSesMenuList(): Array<MenuModel> = sesMenuList
    fun getOyunMenuList(): Array<MenuModel> = oyunMenuList
    fun getMuzikMenuList(): Array<MuzikModel> = muzikMenuList
}

