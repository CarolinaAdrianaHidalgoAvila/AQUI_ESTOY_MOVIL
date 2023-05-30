package com.example.usercase
import com.example.data.repository.UserRepository
import com.example.domain.User
class GetUser(val repository: UserRepository){
    suspend fun invoke(): User {
        return repository.getUser()
    }
}