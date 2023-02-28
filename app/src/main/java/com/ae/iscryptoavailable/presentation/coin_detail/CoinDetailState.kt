package com.ae.iscryptoavailable.presentation.coin_detail


import com.ae.iscryptoavailable.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)