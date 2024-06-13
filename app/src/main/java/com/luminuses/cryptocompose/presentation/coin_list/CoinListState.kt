package com.luminuses.cryptocompose.presentation.coin_list

import com.luminuses.cryptocompose.domain.model.Coin

data class CoinListState (
    val isLoading: Boolean = false,
    val coin: List<Coin> = emptyList(),
    val error: String = ""
)