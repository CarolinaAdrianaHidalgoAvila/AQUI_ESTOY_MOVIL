package com.example.aqui_estoy

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PetRepository {
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://aquiestoymongodb.azurewebsites.net/api/users/632333ceca137c2c4b95168c/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val petApiService: PetApiService = retrofit.create(PetApiService::class.java)

    suspend fun getPet(): Pet {
        return petApiService.getPet()
    }
}