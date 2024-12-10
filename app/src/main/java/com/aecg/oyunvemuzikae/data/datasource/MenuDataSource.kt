package com.aecg.oyunvemuzikae.data.datasource

import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.domain.GameType
import com.aecg.oyunvemuzikae.domain.MemoryType
import com.aecg.oyunvemuzikae.domain.MenuType
import com.aecg.oyunvemuzikae.domain.SesType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MenuDataSource @Inject constructor() {

    fun getSesMenuList(): Array<MenuModel> {
        return arrayOf(
            MenuModel(SesType.ENSTRUMAN.ORFF.displayName, MenuType.SES, R.drawable.ic_sesmenu_enstruman),
            MenuModel(SesType.DOGA.displayName, MenuType.SES, R.drawable.ic_sesmenu_doga),
            MenuModel(SesType.INSAN.displayName, MenuType.SES, R.drawable.ic_sesmenu_insan),
            MenuModel(SesType.ARAC.displayName, MenuType.SES, R.drawable.ic_sesmenu_araclar),
            MenuModel(SesType.HAYVAN.displayName, MenuType.SES, R.drawable.ic_sesmenu_hayvan),
            MenuModel(SesType.SAYI.displayName, MenuType.SES, R.drawable.ic_sesmenu_sayilar),
            MenuModel(SesType.SEKIL.displayName, MenuType.SES, R.drawable.ic_sesmenu_sekiller)
        )
    }

    fun getOyunMenuList(): Array<MenuModel> {
        return arrayOf(
            MenuModel(GameType.HIZLIYAVAS.displayName, MenuType.OYUN, R.drawable.ic_oyunmenu_hizliyavas),
            MenuModel(GameType.RESIMDENBUL.displayName, MenuType.OYUN, R.drawable.ic_oyunmenu_resimdenbul),
            MenuModel(GameType.SESTENBUL.displayName, MenuType.OYUN, R.drawable.ic_oyunmenu_sestenbul),
            MenuModel(GameType.ENSTRUMANTIPI.displayName, MenuType.OYUN, R.drawable.ic_oyunmenu_hafiza),
            MenuModel(GameType.HAFIZA.displayName, MenuType.OYUN, R.drawable.ic_oyunmenu_hafiza),
        )
    }

    fun getOyunMemoryListMenu(): Array<MenuModel> {
        return arrayOf(
            MenuModel(MemoryType.LVL1.displayName, MenuType.MEMORYLEVEL, R.drawable.ic_menu_oyun_hafiza_lvl1),
            MenuModel(MemoryType.LVL2.displayName, MenuType.MEMORYLEVEL, R.drawable.ic_menu_oyun_hafiza_lvl2),
            MenuModel(MemoryType.LVL3.displayName, MenuType.MEMORYLEVEL, R.drawable.ic_menu_oyun_hafiza_lvl3),
            MenuModel(MemoryType.LVL4.displayName, MenuType.MEMORYLEVEL, R.drawable.ic_menu_oyun_hafiza_lvl4),
            MenuModel(MemoryType.LVL5.displayName, MenuType.MEMORYLEVEL, R.drawable.ic_menu_oyun_hafiza_lvl5),
            )
    }
}