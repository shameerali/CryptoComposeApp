package com.luminuses.cryptocompose.presentation.coin_details

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luminuses.cryptocompose.domain.use_case.get_coin_detail.GetCoinDetailUseCase
import com.luminuses.cryptocompose.utils.Constants
import com.luminuses.cryptocompose.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

//    val coinId:String =""
    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoinDetails(coinId)
        }
    }

    private fun getCoinDetails( coinId:String) {

        Log.d("TAG==>", "getCoinDetails id: $coinId")

        getCoinDetailUseCase(coinId).onEach {result ->
            when(result) {
                is Resource.Error -> {

                    _state.value = CoinDetailsState(error = result.message ?:"An unexpected error occurred")
                }
                is Resource.Loading -> {

                    _state.value = CoinDetailsState(isLoading = true)
                }
                is Resource.Success -> {

                    _state.value = CoinDetailsState(coinDetails = result.data )
                }
            }

        }.launchIn(viewModelScope)

    }
}