package com.hssoft.countriesgraphql.presentation.views.view_models_items

import android.os.Parcel
import com.hssoft.countriesgraphql.domain.extensions.emptyString

class ContinentDetailViewItem(code: String = emptyString(), name: String = emptyString(),
                              val countries: List<CountryViewItem> = listOf()) : ContinentViewItem(code, name), KParcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()?: emptyString(),
        parcel.readString()?: emptyString(),
        parcel.createTypedArrayList(CountryViewItem.CREATOR)?: listOf()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel) {
        writeString(code)
        writeString(name)
        writeTypedList(countries)
    }

    companion object {
        @JvmField val CREATOR = creator(::ContinentDetailViewItem)
    }
}