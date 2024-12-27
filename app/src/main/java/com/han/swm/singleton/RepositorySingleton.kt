package com.han.swm.singleton

import androidx.datastore.preferences.protobuf.Api
import com.han.swm.data.remote.ApiSingleton
import com.han.swm.data.repository.AuthRepositoryImpl
import com.han.swm.data.repository.SWMRepositoryImpl
import com.han.swm.data.repository.StatisticRepositoryImpl
import com.han.swm.domain.repository.AuthRepository
import com.han.swm.domain.repository.StatisticsRepository

object RepositorySingleton {
    val authRepository: AuthRepository by lazy { AuthRepositoryImpl(ApiSingleton.swmApi) }

    val statisticsRepository: StatisticsRepository by lazy { StatisticRepositoryImpl(ApiSingleton.swmApi) }

    val swmRepository by lazy {
        SWMRepositoryImpl(ApiSingleton.swmApi)
    }
}