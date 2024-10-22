package com.aecg.oyunvemuzikae.ui

import android.os.Parcelable
import android.os.Parcel
import com.aecg.oyunvemuzikae.MenuType


data class MenuModel(
    val menuName: String,            // Menü adı
    val type: MenuType,              // Menü türü (enum olarak tanımlı)
    val menuImageResourceId: Int     // Menü görsel kaynak ID'si
) : Parcelable {

    // Parcel'dan nesneyi oluşturmak için constructor
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",      // menuName
        MenuType.valueOf(parcel.readString() ?: MenuType.SES.name), // type
        parcel.readInt()                 // menuImageResourceId
    )

    // Nesneyi parcel'a yazmak için
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(menuName)                // menuName
        parcel.writeString(type.name)                // type'ı yaz
        parcel.writeInt(menuImageResourceId)        // menuImageResourceId
    }

    override fun describeContents(): Int = 0

    // Parcelable nesnesini oluşturmak için companion object
    companion object CREATOR : Parcelable.Creator<MenuModel> {
        override fun createFromParcel(parcel: Parcel): MenuModel = MenuModel(parcel)
        override fun newArray(size: Int): Array<MenuModel?> = arrayOfNulls(size)
    }
}
