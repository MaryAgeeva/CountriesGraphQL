package com.hssoft.countriesgraphql.di

import com.hssoft.countriesgraphql.data.apollo.ApolloClientCreator
import com.hssoft.countriesgraphql.data.helpers.NetworkUtil
import com.hssoft.countriesgraphql.data.mappers.ContinentsMapper
import com.hssoft.countriesgraphql.data.mappers.DBMapper
import com.hssoft.countriesgraphql.data.repositories.AllDataRepository
import com.hssoft.countriesgraphql.data.repositories.LocalDataRepository
import com.hssoft.countriesgraphql.domain.interactor.GetAllDataUseCase
import com.hssoft.countriesgraphql.domain.interactor.GetDetailDataUseCase
import com.hssoft.countriesgraphql.domain.repositories.LocalData
import com.hssoft.countriesgraphql.domain.repositories.RemoteData
import com.hssoft.countriesgraphql.domain.utils.PostExecutor
import com.hssoft.countriesgraphql.presentation.mappers.ContinentsViewMapper
import com.hssoft.countriesgraphql.presentation.threads.UIThread
import com.hssoft.countriesgraphql.presentation.view_models.ContinentsViewModel
import com.hssoft.countriesgraphql.presentation.view_models.CountriesViewModel
import com.hssoft.countriesgraphql.presentation.views.fragments.ContinentsFragment
import com.hssoft.countriesgraphql.presentation.views.fragments.CountriesFragment
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single { ApolloClientCreator().apolloClient }
    single<RemoteData> { AllDataRepository(get(), get()) }
    single<LocalData> { LocalDataRepository(get(), get()) }
    factory { ContinentsMapper() }
    factory { DBMapper() }
    factory<PostExecutor> { UIThread() }
    factory { NetworkUtil(get()) }
    factory { ContinentsViewMapper() }
    scope(named<ContinentsFragment>()) {
        scoped { GetAllDataUseCase(get(), get(), get(), get()) }
        viewModel { ContinentsViewModel(get(), get()) }
    }
    scope(named<CountriesFragment>()) {
        scoped { GetDetailDataUseCase(get(), get()) }
        viewModel { CountriesViewModel(get(), get()) }
    }
}