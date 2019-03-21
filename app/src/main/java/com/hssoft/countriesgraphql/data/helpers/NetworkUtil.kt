package com.hssoft.countriesgraphql.data.helpers

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtil(private val context: Context) {

    val isNetworkConnection: Boolean
        get() {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            return cm?.activeNetworkInfo?.isConnectedOrConnecting == true
        }
}