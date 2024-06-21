package com.example.meditationapp.repository


import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.Feelings
import com.example.meditationapp.data.Quotes
import com.example.meditationapp.data.ResponseFeeling
import com.example.meditationapp.data.ResponseWrapper
import com.example.meditationapp.data.User

import com.example.meditationapp.network.MeditationApiService
import com.example.meditationapp.network.MeditationApiServiceImpl
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class MainRepository(private val meditationApiServiceImpl: MeditationApiServiceImpl)  {

    suspend fun auth(authUser: AuthUser) : Flow<ResponseWrapper<User>> = flow {
       return@flow try{
           val result =  meditationApiServiceImpl.auth(authUser)
           if (!result.isSuccessful){
               throw HttpException(result)
           }
           emit(ResponseWrapper.Success(result.body()))
       }catch (exception: Exception){
           emit(ResponseWrapper.Error(exception))
       }
    }
    suspend fun getFeelings() : Flow<ResponseWrapper<List<Feelings>>> = flow {
        return@flow try {
            val feeling = meditationApiServiceImpl.getFeelings().data
            emit(ResponseWrapper.Success(feeling))
        } catch (e: Exception){
            emit(ResponseWrapper.Error(e))
        }
    }
    suspend fun getQuotes(): Flow<ResponseWrapper<List<Quotes>>> = flow {
        return@flow try {
            val quotes = meditationApiServiceImpl.getQuotes().data
            emit(ResponseWrapper.Success(quotes))
        } catch (e: Exception) {
            emit(ResponseWrapper.Error(e))
        }
    }


}
