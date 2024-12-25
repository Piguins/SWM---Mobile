package com.han.swm.domain.model

data class Calendar(
    val id: Int,
    val type: CalendarType,
    val startTime: Long,
    val endTime: Long,
    val note: String,
    val picture: List<String>
)

enum class CalendarType {
    AUDIT
}

val calendarMock = Calendar(
    id = 0,
    type = CalendarType.AUDIT,
    startTime = System.currentTimeMillis(),
    endTime = System.currentTimeMillis(),
    note = "Test note",
    picture = listOf()
)
