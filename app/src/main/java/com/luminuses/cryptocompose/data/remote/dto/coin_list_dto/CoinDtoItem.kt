package com.luminuses.cryptocompose.data.remote.dto.coin_list_dto

import com.google.gson.annotations.SerializedName
import com.luminuses.cryptocompose.domain.model.Coin

data class CoinDtoItem(
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDtoItem.toCoin() : Coin {
    return Coin(id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol)

}