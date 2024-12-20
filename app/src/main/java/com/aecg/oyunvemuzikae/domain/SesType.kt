import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class SesType(open val displayName: String) : Parcelable {

    @Parcelize
    data object HAYVAN : SesType("Hayvan Sesleri"), Parcelable

    @Parcelize
    data object INSAN : SesType("İnsan Sesleri"), Parcelable

    @Parcelize
    data object DOGA : SesType("Doğa Sesleri"), Parcelable

    @Parcelize
    data object ARAC : SesType("Araç Sesleri"), Parcelable

    @Parcelize
    data object SAYI : SesType("Sayılar"), Parcelable

    @Parcelize
    data object SEKIL : SesType("Geometrik Şekiller"), Parcelable

    @Parcelize
    sealed class ENSTRUMAN(
        override val displayName: String = "Enstrüman Sesleri",
        val displayGameHeader: String
    ) : SesType(displayName), Parcelable {

        @Parcelize
        data object ORFF : ENSTRUMAN(displayGameHeader = "Orff"), Parcelable

        @Parcelize
        data object VURMALI : ENSTRUMAN(displayGameHeader = "Vurmalı"), Parcelable

        @Parcelize
        data object TELLI : ENSTRUMAN(displayGameHeader = "Telli"), Parcelable

        @Parcelize
        data object UFLEMELI : ENSTRUMAN(displayGameHeader = "Üflemeli"), Parcelable

        @Parcelize
        data object OTHER : ENSTRUMAN(displayGameHeader = "Diğer"), Parcelable
    }
}
