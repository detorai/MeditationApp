package com.example.meditationapp.repository

import com.example.meditationapp.data.AuthUser
import com.example.meditationapp.data.ResponseFeeling
import com.example.meditationapp.data.ResponseWrapper
import com.example.meditationapp.data.User
import com.example.meditationapp.network.MeditationApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class MainRepository(val meditationApiService: MeditationApiService)  {
    suspend fun auth(authUser: AuthUser) : Flow<ResponseWrapper<User>> = flow {
       return@flow try{
           val result =  meditationApiService.auth(authUser)
           if (!result.isSuccessful){
               throw HttpException(result)
           }
           emit(ResponseWrapper.Success(result.body()))
       }catch (exception: Exception){
           emit(ResponseWrapper.Error(exception))
       }
    }
    suspend fun getFeelings() : Flow<ResponseWrapper<ResponseFeeling>> = flow {
        return@flow try {
            val feeling = meditationApiService.getFeelings().data
            emit(ResponseWrapper.Success(feeling))
        } catch (e: Exception){
            emit(ResponseWrapper.Error(e))
        }
    }


}
