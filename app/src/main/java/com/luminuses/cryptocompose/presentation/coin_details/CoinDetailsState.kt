package com.luminuses.cryptocompose.presentation.coin_details

import com.luminuses.cryptocompose.domain.model.CoinDetail

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetail? = null,
    val error: String = ""
)