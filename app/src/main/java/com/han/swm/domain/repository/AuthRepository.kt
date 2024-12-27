package com.han.swm.domain.repository

import com.han.swm.domain.model.Auth
import com.han.swm.domain.model.User

interface AuthRepository {
    suspend fun signIn(email: String, password: String): Auth

    suspend fun updateProfile(
        user: User
    )

    suspend fun getProfile(): User
}