package com.example.data

class PetRepository(val remoteDataSource: IRemoteDataSource, val apiKey: String){
     suspend fun getPet() = remoteDataSource.getPet(apiKey)
     suspend fun postPet() = remoteDataSource.postPet(apiKey)
}