package com.gc.cleanarchitecture.domain.repository

import com.gc.cleanarchitecture.data.remote.dto.CoinDetailDto
import com.gc.cleanarchitecture.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins() : List<CoinDto>

     suspend fun  getCoinById(coinId : String) : CoinDetailDto


}