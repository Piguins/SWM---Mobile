package com.han.swm.domain.model

import com.han.swm.data.dto.WeekStatItem

data class WeekStatItem(
    val day: String,
    val inbound: Int,
    val outbound: Int
)

data class WeekStatistic(
    val stats: List<WeekStatItem>
)

val weekStatisticMock = WeekStatistic(
    stats = listOf(
        WeekStatItem("Mon", 0, 0),
        WeekStatItem("Tue", 0, 0),
        WeekStatItem("Wed", 0, 0),
        WeekStatItem("Thu", 0, 0),
        WeekStatItem("Fri", 0, 0),
        WeekStatItem("Sat", 0, 0),
        WeekStatItem("Sun", 0, 0),
    )
)