package com.aquiestoy.usercase
import com.aquiestoy.data.PublicationRepository
import com.aquiestoy.domain.Publication
class PostPublication(val repository: PublicationRepository) {
    suspend fun invoke(): Publication {
        return repository.postPublication()
    }
}