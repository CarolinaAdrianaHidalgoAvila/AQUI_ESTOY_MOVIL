package com.example.aqui_estoy

import com.example.domain.Publication
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServicePublication {
    @GET(ConstantsRestApi.URL_PUBLICATION)
    suspend fun getPublication(@Path("idUser") idUser: String,
                       @Path("idPublication") idPublication: String): Publication
}