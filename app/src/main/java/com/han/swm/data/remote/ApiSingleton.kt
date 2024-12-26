package com.han.swm.data.remote

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiSingleton {

    private fun provideSWMApi(): SWMApi {
        val json = Json {
            ignoreUnknownKeys = true
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(SWMApiInterceptor())
            .build()
        return Retrofit.Builder()
            .baseUrl("https://inventory-management-server-fkr8.onrender.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SWMApi::class.java)
    }

    val swmApi by lazy { provideSWMApi() }
}