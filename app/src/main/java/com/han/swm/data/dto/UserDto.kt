package com.han.swm.data.dto

import com.han.swm.common.DateHelper
import com.han.swm.domain.model.User

data class UserDto(
    val address: String,
    val avatar: String,
    val calendars: List<Calendar>,
    val createdTime: String,
    val department: String,
    val dob: String,
    val id: Int,
    val name: String,
    val password: String,
    val phone: String,
    val position: String,
    val role: String,
    val username: String
)

fun UserDto.asDomainModel() = User(
    id = id,
    name = name,
    username = username,
    imageUrl = avatar,
    role = role,
    department = department,
    position = position,
    dob = DateHelper.isoStringTimeStamp(dob),
    password = password,
    phone = phone,
    address = address,
    calendars = calendars.map { it.asDomainModel() },
    createdTime = DateHelper.isoStringTimeStamp(createdTime)
)