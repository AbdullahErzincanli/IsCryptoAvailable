package com.ae.iscryptoavailable.domain.use_case.get_coin

import com.ae.iscryptoavailable.common.Resource
import com.ae.iscryptoavailable.data.remote.dto.toCoin
import com.ae.iscryptoavailable.data.remote.dto.toCoinDetail
import com.ae.iscryptoavailable.domain.model.Coin
import com.ae.iscryptoavailable.domain.model.CoinDetail
import com.ae.iscryptoavailable.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage?: "An unexpected error occured"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection."))
        }
    }
}