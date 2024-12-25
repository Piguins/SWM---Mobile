package com.han.swm.domain.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val role: Role,
    val password: String,
    val phone: String,
    val address: String,
    val calendars: List<Calendar>
)

val userMock = User(
    id = 0,
    name = "Test User",
    username = "testuser",
    role = Role.EMPLOYEE,
    password = "testpassword",
    phone = "0999999999",
    address = "Test address",
    calendars = listOf(calendarMock)
)