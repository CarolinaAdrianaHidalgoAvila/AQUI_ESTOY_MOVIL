package com.aquiestoy.usercase
import com.aquiestoy.data.PetRepository
import com.aquiestoy.domain.Pet
class PostPet(val repository: PetRepository) {
    suspend fun invoke() {
        return repository.postPet()
    }
}