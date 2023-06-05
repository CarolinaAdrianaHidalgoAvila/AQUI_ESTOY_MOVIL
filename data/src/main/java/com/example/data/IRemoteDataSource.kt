package com.example.data
import com.example.domain.Pet
import com.example.domain.Publication
import com.example.domain.User
interface IRemoteDataSource {
    suspend fun getPet( IdUser: String,IdPet: String): Pet
    suspend fun postPet( apiKey: String): Pet

    suspend fun getPublication( apiKey: String): Publication
    suspend fun postPublication( apiKey: String): Publication

    suspend fun getUser( apiKey: String): User
}