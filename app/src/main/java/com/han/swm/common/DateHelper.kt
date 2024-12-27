package com.han.swm.common

import java.text.SimpleDateFormat
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

object DateHelper {
    fun longToFormattedDateString(
        value: Long,
        format: String = "dd/MM/yyyy"
    ): String {
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.format(Date(value))
    }

    fun stringToTimestamp(
        value: String,
        format: String = "dd/MM/yyyy"
    ): Long {
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())
        return dateFormat.parse(value)?.time ?: throw IllegalArgumentException("Invalid date format")
    }

    fun isoStringTimeStamp(dateString: String?): Long {
        if (dateString == null) return System.currentTimeMillis()
        val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
        val offsetDateTime = OffsetDateTime.parse(dateString, formatter)
        return offsetDateTime.toInstant().toEpochMilli()
    }
}