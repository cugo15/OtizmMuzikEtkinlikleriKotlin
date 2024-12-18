package com.aecg.oyunvemuzikae.data.repository

import com.aecg.oyunvemuzikae.data.model.MuzikModel

interface MuzikRepository {
    val muzikList: Array<MuzikModel>
}