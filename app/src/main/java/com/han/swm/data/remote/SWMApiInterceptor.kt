package com.han.swm.data.remote

import com.han.swm.data.datastore.TokenStorage
import com.han.swm.data.datastore.TokenStorageDataStore
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import java.util.concurrent.TimeUnit

class SWMApiInterceptor(
    private val tokenStorageDataStore: TokenStorageDataStore = TokenStorage.dataStore
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val token = runBlocking { tokenStorageDataStore.getAccessToken() }

        val newRequest = if (token != null) {
            request.newBuilder()
                .addHeader("token", "Bearer $token")
                .build()
        } else request

        return chain
//            .withReadTimeout(3000, TimeUnit.MILLISECONDS)
//            .withConnectTimeout(3000, TimeUnit.MILLISECONDS)
//            .withWriteTimeout(3000, TimeUnit.MILLISECONDS)
            .proceed(newRequest)
    }
}