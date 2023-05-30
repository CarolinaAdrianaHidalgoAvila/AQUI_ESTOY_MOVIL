package com.example.data.repository

import com.example.data.IRemoteDataSource
import com.example.data.RestApiAdapter
import com.example.data.serverModel.ServerLostPublication
import com.example.domain.LostPublication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LostPublicationRepository(val remoteDataSource: IRemoteDataSource, val apiKey: String){
    suspend fun getAllLostPublications() = remoteDataSource.getAllLostPublication(apiKey)
}

