package com.aquiestoy.aqui_estoy.server

import com.aquiestoy.domain.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface IApiService {
    @GET(ConstantsRestApi.LOST_PETS_POSTS)
    suspend fun getAllLostPublications() : List<ServerLostPublication>

    @GET(ConstantsRestApi.USER)
    suspend fun getUser(@Path("idUser") idUser: String) : ServerUser
}