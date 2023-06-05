package com.example.aqui_estoy
import com.example.domain.Pet
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServicePet {
    @GET(ConstantsRestApi.URL_PET)
    suspend fun getPet(@Path("idUser") idUser: String,
                       @Path("idPet") idPet: String): Pet

}