package com.example.data

import com.example.domain.LostPublication
import javax.inject.Inject

class LostPublicationRepository @Inject constructor(val remoteDataSource: IRemoteDataSource) {
    suspend fun getAllLostPublications() : List<LostPublication> {
        return remoteDataSource.getAllLostPublications()
    }
}