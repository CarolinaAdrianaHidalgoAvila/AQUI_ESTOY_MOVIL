package com.aquiestoy.aqui_estoy.server


import com.aquiestoy.aqui_estoy.toDomainLostPublication
import com.aquiestoy.aqui_estoy.toDomainUser
import com.aquiestoy.data.IRemoteDataSource
import com.aquiestoy.domain.LostPublication
import com.aquiestoy.domain.Pet
import com.aquiestoy.domain.Publication
import com.aquiestoy.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSource @Inject constructor(val apiRest: RetrofitBuilder) : IRemoteDataSource {
    override suspend fun getPet(IdUser: String, IdPet: String): Pet {
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