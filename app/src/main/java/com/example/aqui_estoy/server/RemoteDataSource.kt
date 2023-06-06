package com.example.aqui_estoy.server


import com.example.aqui_estoy.toDomainLostPublication
import com.example.aqui_estoy.toDomainUser
import com.example.data.IRemoteDataSource
import com.example.domain.LostPublication
import com.example.domain.Pet
import com.example.domain.Publication
import com.example.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val apiRest: RetrofitBuilder) : IRemoteDataSource {
    override suspend fun getPet(apiKey: String): Pet {
        TODO("Not yet implemented")
    }

    override suspend fun postPet(apiKey: String): Pet {
        TODO("Not yet implemented")
    }

    override suspend fun getAllLostPublications(): List<LostPublication> {
        return withContext(Dispatchers.IO) {
            val response = apiRest.apiService.getAllLostPublications()
            response.map { it.toDomainLostPublication() }
        }
    }

    override suspend fun getPublication(apiKey: String): Publication {
        TODO("Not yet implemented")
    }

    override suspend fun postPublication(apiKey: String): Publication {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(idUser: String): User {
        return withContext(Dispatchers.IO) {
            val response = apiRest.apiService.getUser(idUser)
            response.toDomainUser()
        }
    }

}