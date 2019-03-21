package com.hssoft.countriesgraphql.presentation.views.view_models_items

import android.os.Parcel
import com.hssoft.countriesgraphql.domain.extensions.emptyString

class CountryViewItem(val code: String = emptyString(), val title: String = emptyString(),
                      val phone: String = emptyString(), val currency: String = emptyString(),
                      val native: String = emptyString(), val emoji: String = emptyString(),
                      val languages: List<LanguageViewItem> = listOf()) : KParcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()?: emptyString(),
        parcel.readString()?: emptyString(),
        parcel.readString()?: emptyString(),
        parcel.readString()?: emptyString(),
        parcel.readString()?: emptyString(),
        parcel.readString()?: emptyString(),
        parcel.createTypedArrayList(LanguageViewItem.CREATOR)?: listOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel) {
        writeString(code)
        writeString(title)
        writeString(phone)
        writeString(currency)
        writeString(native)
        writeString(emoji)
        writeTypedList(languages)
    }

    companion object {
        @JvmField val CREATOR = creator(::CountryViewItem)
    }
}