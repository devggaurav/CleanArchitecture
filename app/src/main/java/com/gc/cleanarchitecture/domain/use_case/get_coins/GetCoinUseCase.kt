package com.gc.cleanarchitecture.domain.use_case.get_coins

import com.gc.cleanarchitecture.common.Resource
import com.gc.cleanarchitecture.data.remote.dto.toCoin
import com.gc.cleanarchitecture.domain.model.Coin
import com.gc.cleanarchitecture.domain.model.CoinDetail
import com.gc.cleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try{
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))

        }catch (e : HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e : IOException){
         emit(Resource.Error<List<Coin>>("Couldn't reach server, check your internet server"))
        }

    }


}