package com.example.data

import com.example.data.serverModel.ServerFoundPublication
import com.example.data.serverModel.ServerLostPublication
import com.example.data.serverModel.ServerUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPointApi {
    @GET(ConstantsRestApi.LOST_PETS_POSTS)
    fun getAllLostPublications(): Call<List<ServerLostPublication>>

    @GET(ConstantsRestApi.FOUND_PETS_POSTS)
    fun getAllFoundPublications() : Call<List<ServerFoundPublication>>

    @GET(ConstantsRestApi.USER + "/{id}")
    fun getUser(@Path("id") id: String): Call<ServerUser>
}