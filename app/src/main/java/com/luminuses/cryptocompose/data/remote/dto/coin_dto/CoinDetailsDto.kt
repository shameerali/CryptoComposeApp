package com.luminuses.cryptocompose.data.remote.dto.coin_dto

import com.luminuses.cryptocompose.domain.model.CoinDetail

data class CoinDetailsDto(
    val description: String,
    val development_status: String,
    val first_data_at: String,
    val hardware_wallet: Boolean,
    val hash_algorithm: String,
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val last_data_at: String,
    val links: Links,
    val links_extended: List<LinksExtended>,
    val logo: String,
    val message: String,
    val name: String,
    val open_source: Boolean,
    val org_structure: String,
    val proof_type: String,
    val rank: Int,
    val started_at: String,
    val symbol: String,
    val tags: List<Tag>,
    val team: List<Team>,
    val type: String,
    val whitepaper: Whitepaper
)

fun CoinDetailsDto.toCoinDetail() : CoinDetail {
    return CoinDetail(
        name =name,
        description =description,
        id = id,
        isActive = is_active,
        rank = rank,
        symbol = symbol,
        tags = tags.map { it.name },
        team = team
    )
}