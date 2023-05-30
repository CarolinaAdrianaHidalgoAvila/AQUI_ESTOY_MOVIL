package com.example.data

import com.example.domain.LostPublication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApiAdapter {
    fun connectionApi() : EndPointApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(ConstantsRestApi.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(EndPointApi::class.java)
    }

    fun <Data> getDataFromApi(responseCall: Call<Data>, getData: () -> Data) {
        responseCall.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>, response: Response<Data>) {
                val statusCode = response.code()
                if (response.isSuccessful) {
                    val lostPublicationViews = response.body();
                    val statusCode = response.code()
                    // Aqui ejecutamos el codigo


                } else {
                    // Manejar respuesta no exitosa aquí
                    throw Exception("Response: $statusCode")
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                t?.printStackTrace();
                throw Exception("Response: Failed on Consume WebAPI")
            }

        });
    }
}