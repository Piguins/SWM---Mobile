package com.han.swm.data.dto

import com.han.swm.domain.model.CalendarType

data class Calendar(
    val endTime: Long,
    val id: Int,
    val note: String,
    val pics: List<String>,
    val startTime: Long,
    val type: String
)

fun Calendar.asDomainModel() = com.han.swm.domain.model.Calendar(
    id = id,
    type = CalendarType.AUDIT, //CHANGE
    startTime = startTime,
    endTime = endTime,
    note = note,
    picture = pics
)