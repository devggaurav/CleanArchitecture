package com.gc.cleanarchitecture.data.repository

import com.gc.cleanarchitecture.data.remote.CoinPaprikaApi
import com.gc.cleanarchitecture.data.remote.dto.CoinDetailDto
import com.gc.cleanarchitecture.data.remote.dto.CoinDto
import com.gc.cleanarchitecture.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {

     return api.getCoinById(coinId)
    }
}