package com.hssoft.countriesgraphql.data.repositories

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.rx2.Rx2Apollo
import com.hssoft.countriesgraphql.data.mappers.ContinentsMapper
import com.hssoft.countriesgraphql.domain.entities.Continent
import com.hssoft.countriesgraphql.domain.repositories.RemoteData
import hssoft.com.GetAllContinentsQuery
import io.reactivex.Single

class AllDataRepository(private val apolloClient: ApolloClient,
                        private val mapper: ContinentsMapper) : RemoteData {

    override fun getContinents() : Single<List<Continent>> {
        return Rx2Apollo.from(apolloClient.query(GetAllContinentsQuery.builder().build()))
                .singleElement().toSingle()
            .map {
                return@map it.data()?.continents()?.let { items -> mapper.transform(items) }?: listOf()
            }
    }
}