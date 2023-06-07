package com.aquiestoy.usercase

import com.aquiestoy.data.LostPublicationRepository
import com.aquiestoy.domain.LostPublication
import javax.inject.Inject

class GetAllLostPublications @Inject constructor(val repository: LostPublicationRepository) {
    suspend fun invoke(): List<LostPublication> {
        return repository.getAllLostPublications()
    }
}