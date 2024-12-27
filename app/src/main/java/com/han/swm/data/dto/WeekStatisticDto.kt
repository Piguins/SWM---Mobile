package com.han.swm.data.dto

import com.han.swm.domain.model.WeekStatistic

class WeekStatisticDto : ArrayList<WeekStatItem>()

fun WeekStatisticDto.asDomainModel() = WeekStatistic(
    stats = this
)