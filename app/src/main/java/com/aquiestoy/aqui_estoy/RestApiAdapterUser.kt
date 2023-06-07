package com.aquiestoy.aqui_estoy

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiAdapterUser {
    fun connectionApi(): com.aquiestoy.aqui_estoy.ApiServiceUser {
        val retrofit = Retrofit.Builder()
            .baseUrl(ConstantsRestApi.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create( com.aquiestoy.aqui_estoy.ApiServiceUser::class.java)
    }
}