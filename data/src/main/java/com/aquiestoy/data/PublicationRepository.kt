package com.aquiestoy.data

class PublicationRepository(val remoteDataSource: IRemoteDataSource, val apiKey: String){
    suspend fun getPublication() = remoteDataSource.getPublication(apiKey)
    suspend fun postPublication() = remoteDataSource.postPublication(apiKey)
}