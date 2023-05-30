package com.example.usercase

class PostPublication(val repository: PublicationRepository) {
    suspend fun invoke(): Publication {
        return repository.postPublication()
    }
}