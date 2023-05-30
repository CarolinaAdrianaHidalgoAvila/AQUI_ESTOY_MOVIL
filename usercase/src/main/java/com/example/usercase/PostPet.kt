package com.example.usercase
import com.example.data.PetRepository
import com.example.domain.Pet
class PostPet(val repository: PetRepository) {
    suspend fun invoke(): Pet {
        return repository.postPet()
    }
}