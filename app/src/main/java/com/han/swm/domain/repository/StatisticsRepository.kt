package com.han.swm.domain.repository

import com.han.swm.domain.model.Statistic
import com.han.swm.domain.model.WeekStatistic

interface StatisticsRepository {

    suspend fun getWeekStatistic(): WeekStatistic

    suspend fun getStatistic(): Statistic
}