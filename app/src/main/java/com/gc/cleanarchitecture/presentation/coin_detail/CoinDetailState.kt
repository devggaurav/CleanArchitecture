package com.gc.cleanarchitecture.presentation.coin_detail

import com.gc.cleanarchitecture.domain.model.Coin
import com.gc.cleanarchitecture.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)