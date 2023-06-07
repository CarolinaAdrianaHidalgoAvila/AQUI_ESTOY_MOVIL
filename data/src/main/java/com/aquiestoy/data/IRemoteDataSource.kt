package com.aquiestoy.data
import com.aquiestoy.domain.LostPublication
import com.aquiestoy.domain.Pet
import com.aquiestoy.domain.Publication
import com.aquiestoy.domain.User
interface IRemoteDataSource {
    suspend fun getPet( IdUser: String,IdPet: String): Pet
    suspend fun postPet( apiKey: String): Pet

    suspend fun getAllLostPublications(): List<LostPublication>
    suspend fun getPublication( apiKey: String): Publication
    suspend fun postPublication( apiKey: String): Publication

    suspend fun getUser(id: String): User
}