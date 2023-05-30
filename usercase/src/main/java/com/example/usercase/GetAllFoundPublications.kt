package com.example.usercase

import com.example.data.repository.FoundPublicationRepository
import com.example.domain.FoundPublication

class GetAllFoundPublications(val repository: FoundPublicationRepository) {
    suspend fun invoke() : List<FoundPublication> {
        return repository.getAllFoundPublications();
    }
}