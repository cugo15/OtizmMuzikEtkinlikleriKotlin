package com.aecg.oyunvemuzikae.data.repository

import com.aecg.oyunvemuzikae.data.datasource.MuzikDataSource
import com.aecg.oyunvemuzikae.data.model.MuzikModel
import javax.inject.Inject

class MuzikRepositoryImpl@Inject constructor(muzikDataSource: MuzikDataSource, ):MuzikRepository {
    override val muzikList: Array<MuzikModel> = muzikDataSource.getMuzikList()
}