package com.luminuses.cryptocompose.domain.use_case.get_coin_detail

import com.luminuses.cryptocompose.data.remote.dto.coin_dto.toCoinDetail
import com.luminuses.cryptocompose.data.remote.dto.coin_list_dto.toCoin
import com.luminuses.cryptocompose.domain.model.Coin
import com.luminuses.cryptocompose.domain.model.CoinDetail
import com.luminuses.cryptocompose.domain.repository.CoinRepository
import com.luminuses.cryptocompose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(private val repository : CoinRepository) {
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())

            val coins = repository.getCoinDetail(coinId = coinId).toCoinDetail()

            emit((Resource.Success(coins)))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection"))
        }
    }
}