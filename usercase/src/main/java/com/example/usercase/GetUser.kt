package com.example.usercase
import com.example.data.UserRepository
import com.example.domain.User
import javax.inject.Inject

class GetUser @Inject constructor(val repository: UserRepository){
    suspend fun invoke(idUser: String): User {
        return repository.getUser(idUser)
    }
}