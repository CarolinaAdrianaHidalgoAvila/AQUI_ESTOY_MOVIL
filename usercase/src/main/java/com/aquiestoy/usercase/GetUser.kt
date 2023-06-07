package com.aquiestoy.usercase
import com.aquiestoy.data.UserRepository
import com.aquiestoy.domain.User
import javax.inject.Inject

class GetUser @Inject constructor(val repository: UserRepository){
    suspend fun invoke(idUser: String): User {
        return repository.getUser(idUser)
    }
}