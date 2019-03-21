package com.hssoft.countriesgraphql.presentation.views.view_models_items

import android.os.Parcel
import android.os.Parcelable

interface KParcelable : Parcelable {
    override fun describeContents(): Int = 0
}

inline fun <reified T> creator(crossinline create: (Parcel) -> T) =
    object: Parcelable.Creator<T> {
        override fun createFromParcel(parcel: Parcel): T = create(parcel)

        override fun newArray(size: Int) = arrayOfNulls<T>(size)
    }

fun Parcel.writeBoolean(value: Boolean) {
    writeByte(if(value) 1 else 0)
}

fun Parcel.readBoolean(): Boolean = readByte() != 0.toByte()