package com.example.data.repository

import com.example.data.IRemoteDataSource

class UserRepository(val remoteDataSource: IRemoteDataSource, val apiKey: String){
    suspend fun getUser() = remoteDataSource.getUser(apiKey)
}