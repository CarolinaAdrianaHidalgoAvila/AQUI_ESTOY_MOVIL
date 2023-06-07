package com.aquiestoy.aqui_estoy

import com.aquiestoy.domain.Publication
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServicePublication {
    @GET(com.aquiestoy.aqui_estoy.ConstantsRestApi.Companion.URL_PUBLICATION)
    suspend fun getPublication(@Path("idUser") idUser: String,
                       @Path("idPublication") idPublication: String): Publication
}