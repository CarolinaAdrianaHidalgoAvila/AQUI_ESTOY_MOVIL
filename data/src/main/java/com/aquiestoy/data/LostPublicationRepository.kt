package com.aquiestoy.data

import com.aquiestoy.domain.LostPublication
import javax.inject.Inject

class LostPublicationRepository @Inject constructor(val remoteDataSource: IRemoteDataSource) {
    suspend fun getAllLostPublications() : List<LostPublication> {
        return remoteDataSource.getAllLostPublications()
    }
}