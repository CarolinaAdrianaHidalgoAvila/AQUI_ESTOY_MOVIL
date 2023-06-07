package com.aquiestoy.aqui_estoy
import com.aquiestoy.domain.Pet
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServicePet {
    @GET(com.aquiestoy.aqui_estoy.ConstantsRestApi.Companion.URL_PET)
    suspend fun getPet(@Path("idUser") idUser: String,
                       @Path("idPet") idPet: String): Pet

}