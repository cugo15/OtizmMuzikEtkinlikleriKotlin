package com.aecg.oyunvemuzikae.ui.viewmodel


import androidx.lifecycle.ViewModel
import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.data.model.MuzikModel
import com.aecg.oyunvemuzikae.data.repository.MenuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    menuRepository: MenuRepository
) : ViewModel() {

    val sesMenuList: Array<MenuModel> by lazy { menuRepository.getSesMenuList() }
    val oyunMenuList: Array<MenuModel> by lazy { menuRepository.getOyunMenuList() }
    val muzikMenuList: Array<MuzikModel> by lazy { menuRepository.getMuzikMenuList() }

}
