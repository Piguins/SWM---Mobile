package com.han.swm.domain.model

data class Statistic(
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

val statisticMock = Statistic(
    0f, 0f, "", 0f, "", 0f, 0f, 0f, ""
)