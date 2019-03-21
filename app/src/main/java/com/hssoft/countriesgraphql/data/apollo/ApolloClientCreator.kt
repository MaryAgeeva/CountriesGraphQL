package com.hssoft.countriesgraphql.data.apollo

import com.apollographql.apollo.ApolloClient
import okhttp3.OkHttpClient

class ApolloClientCreator {

    val apolloClient : ApolloClient = ApolloClient.builder().serverUrl(ENDPOINT).okHttpClient(OkHttpClient()).build()

    private companion object {
        const val ENDPOINT = "https://countries.trevorblades.com/"
    }
}
