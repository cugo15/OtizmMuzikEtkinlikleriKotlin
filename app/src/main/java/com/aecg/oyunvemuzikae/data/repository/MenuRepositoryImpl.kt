package com.aecg.oyunvemuzikae.data.repository

import com.aecg.oyunvemuzikae.data.datasource.MenuDataSource
import com.aecg.oyunvemuzikae.data.datasource.MuzikDataSource
import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.data.model.MuzikModel
import javax.inject.Inject

class MenuRepositoryImpl @Inject constructor(
    private val menuDataSource: MenuDataSource,
    private val muzikDataSource: MuzikDataSource
) :MenuRepository{
    override fun getSesMenuList(): Array<MenuModel> = menuDataSource.getSesMenuList()
    override fun getOyunMenuList(): Array<MenuModel> = menuDataSource.getOyunMenuList()
    override fun getMuzikMenuList(): Array<MuzikModel> = muzikDataSource.getMuzikList()
}