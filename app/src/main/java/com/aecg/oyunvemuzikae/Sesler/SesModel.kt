package com.aecg.oyunvemuzikae.Sesler

import android.os.Parcel
import android.os.Parcelable

data class SesModel(
    val sesName: String,
    val type: SesType, // type enum olarak tanımlı
    val sesResourceId: Int, // raw klasöründeki ses dosyasını temsil eden ID
    val imageResourceId: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "", // sesName
        SesType.valueOf(parcel.readString() ?: SesType.HAYVAN.name), // type
        parcel.readInt(), // sesResourceId
        parcel.readInt() // imageResourceId
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(sesName) // sesName
        parcel.writeString(type.name) // category'yi yaz
        parcel.writeInt(sesResourceId) // sesResourceId
        parcel.writeInt(imageResourceId) // imageResourceId
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<SesModel> {
        override fun createFromParcel(parcel: Parcel): SesModel = SesModel(parcel)
        override fun newArray(size: Int): Array<SesModel?> = arrayOfNulls(size)
    }
}