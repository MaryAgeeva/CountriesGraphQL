package com.hssoft.countriesgraphql.domain.repositories

import com.hssoft.countriesgraphql.domain.entities.Continent
import io.reactivex.Single

interface RemoteData {
    fun getContinents() : Single<List<Continent>>
}