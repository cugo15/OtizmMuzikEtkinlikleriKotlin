package com.aecg.oyunvemuzikae.data.datasource

import com.aecg.oyunvemuzikae.R
import com.aecg.oyunvemuzikae.data.model.MuzikModel
import com.aecg.oyunvemuzikae.domain.MuzikType
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MuzikDataSource @Inject constructor() {

    fun getMuzikList(): Array<MuzikModel> {
        return arrayOf(
            MuzikModel("Merhaba Şarkısı", MuzikType.MUZIK,"android.resource://com.aecg.oyunvemuzikae/raw/${R.raw.sound_muzik_merhabasarkisi}", R.drawable.ic_muzik_merhabalar),
            MuzikModel("Üç Boyutlu Cisimler", MuzikType.MUZIK,"android.resource://com.aecg.oyunvemuzikae/raw/${R.raw.sound_muzik_ucboyutlucisimler}", R.drawable.ic_muzik_ucboyutlu),
            MuzikModel("Geri Sayma", MuzikType.VIDEO,"bZtDgNI2QWY", R.drawable.ic_muzik_gerisayma),
            MuzikModel("Merhaba Kareoke", MuzikType.VIDEO,"MU8o4SA-DB4", R.drawable.ic_muzik_kareoke),
            MuzikModel("Alkış Oyunu", MuzikType.VIDEO,"soqD2OJ9Nb8", R.drawable.ic_muzikler_alkis_oyunu),
        )
    }

}