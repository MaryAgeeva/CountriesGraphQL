package com.hssoft.countriesgraphql.domain.interactor

import com.hssoft.countriesgraphql.data.helpers.NetworkUtil
import com.hssoft.countriesgraphql.domain.utils.BaseUseCase
import com.hssoft.countriesgraphql.domain.utils.PostExecutor
import com.hssoft.countriesgraphql.domain.entities.Continent
import com.hssoft.countriesgraphql.domain.exceptions.NoNetworkConnection
import com.hssoft.countriesgraphql.domain.repositories.LocalData
import com.hssoft.countriesgraphql.domain.repositories.RemoteData
import io.reactivex.Single

class GetAllDataUseCase(uiExecutor: PostExecutor,
                        private val remoteData: RemoteData,
                        private val localData: LocalData,
                        private val networkUtil: NetworkUtil)
                                            : BaseUseCase<List<Continent>, Unit>(uiExecutor) {

    override fun createSingle(params: Unit): Single<List<Continent>> {
        return when(localData.isNotEmpty()) {
            true -> localData.getContinents()
            false -> remoteData.getContinents()
                .map {
                    localData.insertContinents(it)
                    return@map it
                }
        }
    }

    override fun run(success: (List<Continent>) -> Unit, errorCall: (Throwable) -> Unit, params: Unit) {
        when(networkUtil.isNetworkConnection) {
            true -> super.run(success, errorCall, params)
            false -> errorCall(NoNetworkConnection())
        }
    }
}