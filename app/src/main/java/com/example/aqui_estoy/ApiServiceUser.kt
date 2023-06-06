package com.example.aqui_estoy

import com.example.domain.User
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceUser {
    @GET(ConstantsRestApi.URL_USER)
    suspend fun getUser(@Path("idUser") idUser: String): User
}