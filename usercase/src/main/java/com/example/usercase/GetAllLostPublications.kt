package com.example.usercase

import com.example.data.LostPublicationRepository
import com.example.domain.LostPublication
import javax.inject.Inject

class GetAllLostPublications @Inject constructor(val repository: LostPublicationRepository) {
    suspend fun invoke(): List<LostPublication> {
        return repository.getAllLostPublications()
    }
}