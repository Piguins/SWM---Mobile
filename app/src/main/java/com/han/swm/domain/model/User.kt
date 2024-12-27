package com.han.swm.domain.model

data class User(
    val id: Int,
    val name: String,
    val username: String,
    val imageUrl: String,
    val role: String,
    val department: String,
    val position: String,
    val dob: Long,
    val password: String,
    val phone: String,
    val address: String,
    val calendars: List<Calendar>,
    val createdTime: Long,
)

val userMock = User(
    id = 0,
    name = "Test User",
    username = "testuser",
    role = "Employee",
    password = "testpassword",
    phone = "0999999999",
    address = "Test address",
    calendars = listOf(calendarMock),
    dob = System.currentTimeMillis(),
    department = "Kế toán, kiểm toán",
    position = "Trưởng phòng",
    imageUrl = "https://img.freepik.com/free-vector/smiling-young-man-illustration_1308-174669.jpg",
    createdTime = System.currentTimeMillis()
)