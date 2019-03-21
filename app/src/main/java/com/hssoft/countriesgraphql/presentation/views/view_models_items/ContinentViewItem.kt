package com.hssoft.countriesgraphql.presentation.views.view_models_items

import android.os.Parcel
import com.hssoft.countriesgraphql.domain.extensions.emptyString

open class ContinentViewItem(val code: String = emptyString(), val name: String = emptyString()) : KParcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString()?: emptyString(),
        parcel.readString()?: emptyString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) = with(parcel) {
        writeString(code)
        writeString(name)
    }

    companion object {
        @JvmField val CREATOR = creator(::ContinentViewItem)
    }
}