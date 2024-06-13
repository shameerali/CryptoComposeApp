package com.luminuses.cryptocompose.data.remote

import com.luminuses.cryptocompose.data.remote.dto.coin_dto.CoinDetailsDto
import com.luminuses.cryptocompose.data.remote.dto.coin_list_dto.CoinDtoItem
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi {

    @GET("v1/coins")
    suspend fun getCoinList():List<CoinDtoItem>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinDetail(@Path("coinId") coinId: String):CoinDetailsDto
}