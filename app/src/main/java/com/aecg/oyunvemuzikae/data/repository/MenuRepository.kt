package com.aecg.oyunvemuzikae.data.repository

import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.data.model.MuzikModel
import com.aecg.oyunvemuzikae.data.model.SesModel

interface MenuRepository {
    val sesMenuList: Array<MenuModel>
    val oyunMenuList: Array<MenuModel>
    val muzikMenuList: Array<MuzikModel>
    val enstrumanList: Array<SesModel>
    val dogaList: Array<SesModel>
    val insanList: Array<SesModel>
    val aracList: Array<SesModel>
    val hayvanList: Array<SesModel>
    val sekilList: Array<SesModel>
    val sayiList: Array<SesModel>
    val oyunHizliYavasList: Array<SesModel>
    val oyunResimdenBulList: Array<SesModel>
    val oyunMemoryListMenu: Array<MenuModel>

}