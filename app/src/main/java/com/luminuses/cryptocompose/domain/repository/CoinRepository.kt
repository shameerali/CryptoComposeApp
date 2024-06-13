package com.luminuses.cryptocompose.domain.repository

import com.luminuses.cryptocompose.data.remote.dto.coin_dto.CoinDetailsDto
import com.luminuses.cryptocompose.data.remote.dto.coin_list_dto.CoinDtoItem

interface CoinRepository {
    suspend fun getCoinList():List<CoinDtoItem>
    suspend fun getCoinDetail(coinId: String):CoinDetailsDto
}