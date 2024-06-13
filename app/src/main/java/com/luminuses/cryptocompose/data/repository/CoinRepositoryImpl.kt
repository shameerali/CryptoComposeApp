package com.luminuses.cryptocompose.data.repository

import com.luminuses.cryptocompose.data.remote.CoinPaprikaApi
import com.luminuses.cryptocompose.data.remote.dto.coin_dto.CoinDetailsDto
import com.luminuses.cryptocompose.data.remote.dto.coin_list_dto.CoinDtoItem
import com.luminuses.cryptocompose.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
) : CoinRepository{
    override suspend fun getCoinList(): List<CoinDtoItem> {

        return coinPaprikaApi.getCoinList()
    }

    override suspend fun getCoinDetail(coinId: String): CoinDetailsDto {
        return coinPaprikaApi.getCoinDetail(coinId)
    }
}