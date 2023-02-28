package com.ae.iscryptoavailable.domain.model

import com.google.gson.annotations.SerializedName

data class Coin(
    @SerializedName("id")
    val id: String,
    @SerializedName("is_active")
    val isActive: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String
)
