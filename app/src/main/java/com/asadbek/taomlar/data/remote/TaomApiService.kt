package com.asadbek.taomlar.data.remote

import retrofit2.http.GET
import retrofit2.http.Query

interface TaomApiService {

    @GET("filter.php")
    suspend fun getTaomByCategory(
        @Query("c") category: String
    ): TaomResponseDto





    @GET("lookup.php")
    suspend fun getTaomDetail(
        @Query("i") id: String
    ): TaomDetailResponseDto
}

