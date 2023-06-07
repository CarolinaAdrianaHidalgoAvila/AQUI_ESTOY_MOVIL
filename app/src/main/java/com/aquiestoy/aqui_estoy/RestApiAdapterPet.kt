package com.aquiestoy.aqui_estoy

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiAdapterPet {
    fun connectionApi(): com.aquiestoy.aqui_estoy.ApiServicePet {
        val retrofit = Retrofit.Builder()
            .baseUrl(ConstantsRestApi.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create( com.aquiestoy.aqui_estoy.ApiServicePet::class.java)
    }

}