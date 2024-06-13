package com.luminuses.cryptocompose.domain.use_case.get_coins_list

import com.luminuses.cryptocompose.data.remote.dto.coin_list_dto.toCoin
import com.luminuses.cryptocompose.domain.model.Coin
import com.luminuses.cryptocompose.domain.repository.CoinRepository
import com.luminuses.cryptocompose.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(private val repository : CoinRepository) {

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())

            val coins = repository.getCoinList().map { it.toCoin()  }

            emit((Resource.Success(coins)))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection"))
        }
    }
}