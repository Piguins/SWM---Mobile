package com.han.swm.data.dto

import com.han.swm.domain.model.Auth

data class SignInDto(
    val accessToken: String,
    val address: String,
    val avatar: String,
    val createdTime: String,
    val department: String,
    val dob: String,
    val id: Int,
    val name: String,
    val phone: String,
    val position: String,
    val role: String,
    val username: String
)

fun SignInDto.toDomainModel() = Auth(
    id = id,
    username = username,
    accessToken = accessToken
)