package com.example.aqui_estoy

import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

//http://localhost:5500/api/users/632333ceca137c2c4b95168c/pets
//const val URL_BASE = "https://aquiestoymongodb.azurewebsites.net/api/"
//const val Users ="users/"
//const val Pets="users/632333ceca137c2c4b95168c/pets/"
//const val Publication="users/632333ceca137c2c4b95168c/lostPetsPosts/"
interface PetApiService {

    @GET("pets/635716a5a2059dbd379482bb")
    suspend fun getPet(): Pet
    @GET("pets/635716a5a2059dbd379482bb")
    suspend fun getPets(): List<Pet>

    @POST(ConstantsRestApi.Pets)
    suspend fun registerPet(@Path("id") id: String, @Body pet: Pet): Pet
}