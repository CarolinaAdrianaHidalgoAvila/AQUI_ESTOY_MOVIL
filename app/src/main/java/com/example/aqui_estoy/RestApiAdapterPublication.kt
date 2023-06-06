package com.example.aqui_estoy

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiAdapterPublication {
    fun connectionApi(): ApiServicePublication {
        val retrofit = Retrofit.Builder()
            .baseUrl(ConstantsRestApi.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create( ApiServicePublication::class.java)
    }
}