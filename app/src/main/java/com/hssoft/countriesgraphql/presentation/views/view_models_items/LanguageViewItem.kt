package com.hssoft.countriesgraphql.presentation.views.view_models_items

import android.os.Parcel
import com.hssoft.countriesgraphql.domain.extensions.emptyString

class LanguageViewItem(val code: String, val title: String) : KParcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?: emptyString(),
        parcel.readString()?: emptyString())

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel){
        writeString(code)
        writeString(title)
    }

    companion object {
        @JvmField val CREATOR = creator(::LanguageViewItem)
    }
}