package com.example.usercase

import com.example.data.repository.LostPublicationRepository
import com.example.domain.LostPublication
import com.example.domain.Pet

class GetAllLostPublications(val repository: LostPublicationRepository) {
    suspend fun invoke(): List<LostPublication> {
        return repository.getAllLostPublications();
    }
}