package com.ae.iscryptoavailable.domain.repository

import com.ae.iscryptoavailable.data.remote.dto.CoinDetailDto
import com.ae.iscryptoavailable.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}