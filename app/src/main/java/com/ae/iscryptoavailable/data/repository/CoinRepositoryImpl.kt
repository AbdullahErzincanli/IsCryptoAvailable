package com.ae.iscryptoavailable.data.repository

import com.ae.iscryptoavailable.data.remote.CoinPaprikaApi
import com.ae.iscryptoavailable.data.remote.dto.CoinDetailDto
import com.ae.iscryptoavailable.data.remote.dto.CoinDto
import com.ae.iscryptoavailable.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

}