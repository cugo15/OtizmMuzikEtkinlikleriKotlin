package com.aecg.oyunvemuzikae.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.data.model.SesModel
import com.aecg.oyunvemuzikae.data.repository.MenuRepository
import com.aecg.oyunvemuzikae.domain.GameType
import com.aecg.oyunvemuzikae.domain.MemoryType
import com.aecg.oyunvemuzikae.domain.MenuType
import com.aecg.oyunvemuzikae.domain.SesType
import com.aecg.oyunvemuzikae.ui.fragment.MenuFragmentDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MenuViewModel @Inject constructor(
    menuRepository: MenuRepository
) : ViewModel() {

    private val enstrumanList: Array<SesModel> = menuRepository.enstrumanList
    private val dogaList: Array<SesModel> = menuRepository.dogaList
    private val insanList: Array<SesModel> = menuRepository.insanList
    private val aracList: Array<SesModel> = menuRepository.aracList
    private val hayvanList: Array<SesModel> = menuRepository.hayvanList
    private val sekilList: Array<SesModel> = menuRepository.sekilList
    private val sayiList: Array<SesModel> = menuRepository.sayiList
    private val oyunHizliYavasList: Array<SesModel> = menuRepository.oyunHizliYavasList
    private val oyunResimdenBulList: Array<SesModel> = menuRepository.oyunResimdenBulList
    private val oyunMemoryListMenu: Array<MenuModel> = menuRepository.oyunMemoryListMenu

    fun handleMenuClick(name: String, type: MenuType):NavDirections? {
        val action = when (type) {
            MenuType.SES -> when (name) {
                SesType.ENSTRUMAN.ORFF.displayName -> MenuFragmentDirections.menuFragmentToSesFragment(enstrumanList)
                SesType.DOGA.displayName -> MenuFragmentDirections.menuFragmentToSesFragment(dogaList)
                SesType.INSAN.displayName -> MenuFragmentDirections.menuFragmentToSesFragment(insanList)
                SesType.ARAC.displayName -> MenuFragmentDirections.menuFragmentToSesFragment(aracList)
                SesType.HAYVAN.displayName -> MenuFragmentDirections.menuFragmentToSesFragment(hayvanList)
                SesType.SEKIL.displayName -> MenuFragmentDirections.menuFragmentToSesFragment(sekilList)
                SesType.SAYI.displayName -> MenuFragmentDirections.menuFragmentToSesFragment(sayiList)
                else -> null
            }
            MenuType.OYUN -> when (name) {
                GameType.HIZLIYAVAS.displayName -> MenuFragmentDirections.menuFragmentToOyunHizliYavasFragment(oyunHizliYavasList)
                GameType.RESIMDENBUL.displayName -> MenuFragmentDirections.menuFragmentToOyunResimdenSestenBulFragment(oyunResimdenBulList, GameType.RESIMDENBUL)
                GameType.SESTENBUL.displayName -> MenuFragmentDirections.menuFragmentToOyunResimdenSestenBulFragment(enstrumanList, GameType.SESTENBUL)
                GameType.ENSTRUMANTIPI.displayName -> MenuFragmentDirections.menuFragmentToOyunResimdenSestenBulFragment(enstrumanList, GameType.ENSTRUMANTIPI)
                GameType.HAFIZA.displayName -> MenuFragmentDirections.menuFragmentToSelf(oyunMemoryListMenu)
                else -> null
            }
            MenuType.MEMORYLEVEL -> when (name) {
                MemoryType.LVL1.displayName -> MenuFragmentDirections.menuFragmentToOyunHafizaFragment(enstrumanList, MemoryType.LVL1.difficulty, MemoryType.LVL1.level)
                MemoryType.LVL2.displayName -> MenuFragmentDirections.menuFragmentToOyunHafizaFragment(enstrumanList, MemoryType.LVL2.difficulty, MemoryType.LVL2.level)
                MemoryType.LVL3.displayName -> MenuFragmentDirections.menuFragmentToOyunHafizaFragment(enstrumanList, MemoryType.LVL3.difficulty, MemoryType.LVL3.level)
                MemoryType.LVL4.displayName -> MenuFragmentDirections.menuFragmentToOyunHafizaFragment(enstrumanList, MemoryType.LVL4.difficulty, MemoryType.LVL4.level)
                MemoryType.LVL5.displayName -> MenuFragmentDirections.menuFragmentToOyunHafizaFragment(enstrumanList, MemoryType.LVL5.difficulty, MemoryType.LVL5.level)
                else -> null
            }
        }
        return action
    }

}