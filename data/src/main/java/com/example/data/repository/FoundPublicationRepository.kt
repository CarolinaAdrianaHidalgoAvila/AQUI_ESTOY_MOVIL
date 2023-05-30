package com.example.data.repository

import com.example.data.IRemoteDataSource
import com.example.data.RestApiAdapter
import com.example.data.serverModel.ServerFoundPublication
import com.example.domain.FoundPublication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoundPublicationRepository(val remoteDataSource: IRemoteDataSource, val apiKey: String){
    suspend fun getAllFoundPublications() = remoteDataSource.getAllFoundPublication(apiKey)
}


