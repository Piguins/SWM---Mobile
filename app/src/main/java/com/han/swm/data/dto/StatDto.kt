package com.han.swm.data.dto

import com.han.swm.domain.model.Statistic

data class StatDto(
    val inboundNeededNumber: Float,
    val inboundNeededPercent: Float,
    val inboundNeededPercentChange: String,
    val inboundPercent: Float,
    val inboundPercentChange: String,
    val indboundNumber: Float,
    val stockNumber: Float,
    val stockPercent: Float,
    val stockPercentChange: String
)

fun StatDto.asDomainModel() = Statistic(
    inboundNeededNumber, inboundNeededPercent, inboundNeededPercentChange, inboundPercent, inboundPercentChange, indboundNumber, stockNumber, stockPercent, stockPercentChange
)