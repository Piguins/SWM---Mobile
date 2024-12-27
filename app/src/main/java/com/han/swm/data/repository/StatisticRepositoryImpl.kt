package com.han.swm.data.repository

import com.han.swm.data.dto.asDomainModel
import com.han.swm.data.remote.SWMApi
import com.han.swm.domain.model.Statistic
import com.han.swm.domain.model.WeekStatistic
import com.han.swm.domain.repository.StatisticsRepository

class StatisticRepositoryImpl(
    private val swmApi: SWMApi
): StatisticsRepository {
    override suspend fun getWeekStatistic(): WeekStatistic {
        return swmApi.getWeekStatistic().asDomainModel()
    }

    override suspend fun getStatistic(): Statistic {
        return swmApi.getStat().asDomainModel()
    }
}