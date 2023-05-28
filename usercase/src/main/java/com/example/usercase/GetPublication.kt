package com.example.usercase
import com.example.data.PublicationRepository
import com.example.domain.Publication
class GetPublication(val repository: PublicationRepository){

    suspend fun invoke(): Publication {
        return repository.getPublication()
    }
}