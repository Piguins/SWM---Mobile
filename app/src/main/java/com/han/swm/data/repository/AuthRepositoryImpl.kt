package com.han.swm.data.repository

import com.han.swm.data.dto.SignInRequest
import com.han.swm.data.dto.asDomainModel
import com.han.swm.data.dto.asUpdateProfileRequest
import com.han.swm.data.dto.toDomainModel
import com.han.swm.data.remote.SWMApi
import com.han.swm.domain.model.Auth
import com.han.swm.domain.model.User
import com.han.swm.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val swmApi: SWMApi
): AuthRepository {
    override suspend fun signIn(email: String, password: String): Auth {
        return swmApi.signIn(
            SignInRequest(
                username = email,
                password = password
            )
        ).toDomainModel()
    }

    override suspend fun updateProfile(user: User) {
        swmApi.updateProfile(
            id = user.id,
            request = user.asUpdateProfileRequest()
        )
    }

    override suspend fun getProfile(): User {
        return swmApi.getProfile().asDomainModel()
    }
}