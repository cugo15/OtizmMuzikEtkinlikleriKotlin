package com.aecg.oyunvemuzikae.data.datasource

import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.domain.GameType
import com.aecg.oyunvemuzikae.domain.MenuType
import javax.inject.Inject

class MenuDataSource @Inject constructor() {

    fun getSesMenuList(): Array<MenuModel> {
        return arrayOf(
            MenuModel("Enstrüman", MenuType.SES, R.drawable.ic_sesmenu_enstruman),
            MenuModel("Doğa", MenuType.SES, R.drawable.ic_sesmenu_doga),
            MenuModel("İnsan", MenuType.SES, R.drawable.ic_sesmenu_insan),
            MenuModel("Araçlar", MenuType.SES, R.drawable.ic_sesmenu_araclar),
            MenuModel("Hayvan", MenuType.SES, R.drawable.ic_sesmenu_hayvan),
            MenuModel("Sayılar", MenuType.SES, R.drawable.ic_sesmenu_sayilar),
            MenuModel("Şekiller", MenuType.SES, R.drawable.ic_sesmenu_sekiller)
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
            MenuModel("Seviye 1", MenuType.MEMORYLEVEL, R.drawable.ic_menu_oyun_hafiza_lvl1),
            MenuModel("Seviye 2", MenuType.MEMORYLEVEL, R.drawable.ic_menu_oyun_hafiza_lvl2),
            MenuModel("Seviye 3", MenuType.MEMORYLEVEL, R.drawable.ic_menu_oyun_hafiza_lvl3),
            MenuModel("Seviye 4", MenuType.MEMORYLEVEL, R.drawable.ic_menu_oyun_hafiza_lvl4),
            MenuModel("Seviye 5", MenuType.MEMORYLEVEL, R.drawable.ic_menu_oyun_hafiza_lvl5),

            )
    }

}