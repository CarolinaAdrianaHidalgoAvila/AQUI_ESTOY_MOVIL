package com.aquiestoy.aqui_estoy

import com.aquiestoy.domain.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceUser {
    @GET(com.aquiestoy.aqui_estoy.ConstantsRestApi.Companion.URL_USER)
    suspend fun getUser(@Path("idUser") idUser: String): User
}