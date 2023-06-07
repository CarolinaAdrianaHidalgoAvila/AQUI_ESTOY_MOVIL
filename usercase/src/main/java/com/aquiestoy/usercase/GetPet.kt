package com.aquiestoy.usercase
import com.aquiestoy.data.PetRepository
import com.aquiestoy.domain.Pet

class GetPet (val repository: PetRepository) {
    suspend fun invoke(): Pet {
        return repository.getPet()
    }
}