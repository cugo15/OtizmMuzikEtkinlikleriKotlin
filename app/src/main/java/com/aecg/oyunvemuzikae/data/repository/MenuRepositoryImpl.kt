package com.aecg.oyunvemuzikae.data.repository

import com.aecg.oyunvemuzikae.data.datasource.MenuDataSource
import com.aecg.oyunvemuzikae.data.datasource.MuzikDataSource
import com.aecg.oyunvemuzikae.data.datasource.SesDataSource
import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.data.model.MuzikModel
import com.aecg.oyunvemuzikae.data.model.SesModel
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    menuDataSource: MenuDataSource,
    muzikDataSource: MuzikDataSource,
    sesDataSource: SesDataSource
) :MenuRepository{
    override val sesMenuList: Array<MenuModel> = menuDataSource.getSesMenuList()
    override val oyunMenuList: Array<MenuModel> = menuDataSource.getOyunMenuList()
    override val oyunMemoryListMenu: Array<MenuModel> = menuDataSource.getOyunMemoryListMenu()

    override val muzikMenuList: Array<MuzikModel> = muzikDataSource.getMuzikList()

    override val enstrumanList: Array<SesModel> = sesDataSource.getEnstrumanList()
    override val dogaList: Array<SesModel> = sesDataSource.getDogaList()
    override val insanList: Array<SesModel> = sesDataSource.getInsanList()
    override val aracList: Array<SesModel> = sesDataSource.getAracList()
    override val hayvanList: Array<SesModel> = sesDataSource.getHayvanList()
    override val sekilList: Array<SesModel> = sesDataSource.getSekilList()
    override val sayiList: Array<SesModel> = sesDataSource.getSayiList()
    override val oyunHizliYavasList: Array<SesModel> = sesDataSource.getOyunHizliYavasList()
    override val oyunResimdenBulList: Array<SesModel> = sesDataSource.getOyunResimdenBulList()
}