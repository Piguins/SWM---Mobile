package com.han.swm.data.dto

import com.han.swm.domain.model.User

data class UpdateProfileRequest(
    val address: String,
    val createdTime: Long,
    val name: String,
    val phone: String,
    val position: String,
    val username: String
)

fun User.asUpdateProfileRequest() = UpdateProfileRequest(
    address = address,
    createdTime = createdTime,
    name = name,
    phone = phone,
    position = position,
    username = username
)