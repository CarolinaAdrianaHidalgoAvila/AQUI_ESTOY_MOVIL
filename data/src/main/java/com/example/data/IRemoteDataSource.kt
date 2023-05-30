package com.example.data
import com.example.domain.FoundPublication
import com.example.domain.LostPublication
import com.example.domain.Pet
import com.example.domain.User
interface IRemoteDataSource {
    suspend fun getPet( apiKey: String): Pet
    suspend fun postPet( apiKey: String): Pet

    suspend fun getAllFoundPublication( apiKey: String): List<FoundPublication>
    suspend fun postFoundPublication( apiKey: String): FoundPublication

    suspend fun getAllLostPublication( apiKey: String): List<LostPublication>
    suspend fun postLostPublication( apiKey: String): LostPublication

    suspend fun getUser( apiKey: String): User
}