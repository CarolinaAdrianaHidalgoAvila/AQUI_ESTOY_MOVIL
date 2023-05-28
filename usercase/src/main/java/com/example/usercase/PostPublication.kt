package com.example.usercase
import com.example.data.PublicationRepository
import com.example.domain.Publication
class PostPublication(val repository: PublicationRepository) {
    suspend fun invoke(): Publication {
        return repository.postPublication()
    }
}