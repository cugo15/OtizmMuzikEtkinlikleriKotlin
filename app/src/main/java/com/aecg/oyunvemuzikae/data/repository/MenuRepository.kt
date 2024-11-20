package com.aecg.oyunvemuzikae.data.repository

import com.aecg.oyunvemuzikae.data.model.MenuModel
import com.aecg.oyunvemuzikae.data.model.MuzikModel

interface MenuRepository {
    fun getSesMenuList(): Array<MenuModel>
    fun getOyunMenuList(): Array<MenuModel>
    fun getMuzikMenuList(): Array<MuzikModel>
}