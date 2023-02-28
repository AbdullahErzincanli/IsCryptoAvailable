package com.ae.iscryptoavailable.domain.use_case.get_coins

import com.ae.iscryptoavailable.common.Resource
import com.ae.iscryptoavailable.data.remote.dto.toCoin
import com.ae.iscryptoavailable.domain.model.Coin
import com.ae.iscryptoavailable.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}