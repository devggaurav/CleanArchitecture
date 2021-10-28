package com.gc.cleanarchitecture.domain.use_case.get_coin

import com.gc.cleanarchitecture.common.Resource
import com.gc.cleanarchitecture.data.remote.dto.toCoin
import com.gc.cleanarchitecture.data.remote.dto.toCoinDetail
import com.gc.cleanarchitecture.domain.model.Coin
import com.gc.cleanarchitecture.domain.model.CoinDetail
import com.gc.cleanarchitecture.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinDetailUseCase @Inject constructor(private val repository: CoinRepository) {

    operator fun invoke(coinId : String) : Flow<Resource<CoinDetail>> = flow {
        try{
            emit(Resource.Loading<CoinDetail>())
            val coins = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coins))

        }catch (e : HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An unexpected error occured"))
        }catch (e : IOException){
         emit(Resource.Error<CoinDetail>("Couldn't reach server, check your internet server"))
        }

    }


}