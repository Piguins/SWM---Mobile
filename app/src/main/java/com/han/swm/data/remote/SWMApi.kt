package com.han.swm.data.remote

import com.han.swm.data.dto.UserDto
import com.han.swm.data.dto.SignInDto
import com.han.swm.data.dto.SignInRequest
import com.han.swm.data.dto.StatDto
import com.han.swm.data.dto.UpdateProfileRequest
import com.han.swm.data.dto.WeekStatisticDto
import com.han.swm.data.dto.inbound.InboundDto
import com.han.swm.data.dto.shipment.ShipmentDto
import com.han.swm.data.dto.stock.Product
import com.han.swm.data.dto.stock.StockDto
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface SWMApi {

    @POST("api/auth/sign-in")
    suspend fun signIn(@Body request: SignInRequest): SignInDto

    @POST("api/auth/profile/{id}")
    suspend fun updateProfile(
        @Path("id") id: Int,
        @Body request: UpdateProfileRequest
    ): UserDto

    @GET("api/auth")
    suspend fun getProfile(): UserDto

    @GET("api/statistics/week")
    suspend fun getWeekStatistic(): WeekStatisticDto

    @GET("api/statistics")
    suspend fun getStat(): StatDto

    @GET("api/products/all")
    suspend fun getStockList(): StockDto

    @GET("api/products/{id}")
    suspend fun getProductDetail(@Path("id") id: Int): Product

    @POST("api/shipments/list")
    suspend fun getShipmentList(
        @Body emptyBody: RequestBody = RequestBody.create("application/json".toMediaType(), "{}")
    ): ShipmentDto

    @GET("api/inboundReports/{id}")
    suspend fun getInBoundDetail(@Path("id") id: Int): InboundDto
}