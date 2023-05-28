package com.example.data

class UserRepository(val remoteDataSource: IRemoteDataSource, val apiKey: String){
    suspend fun getUser() = remoteDataSource.getUser(apiKey)
}