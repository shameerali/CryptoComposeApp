package com.luminuses.cryptocompose.domain.model

import com.luminuses.cryptocompose.data.remote.dto.coin_dto.Team

data class CoinDetail(
    val name :String,
    val description: String,
    val id: String,
    val isActive: Boolean,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<Team>,
)