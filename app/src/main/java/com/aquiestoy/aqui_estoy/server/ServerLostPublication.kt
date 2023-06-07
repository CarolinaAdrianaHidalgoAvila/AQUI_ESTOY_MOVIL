package com.aquiestoy.aqui_estoy.server

import com.google.gson.annotations.SerializedName

data class ServerLostPublication (
    @SerializedName("idPublication") val id: String,
    @SerializedName("namePet") val namePet: String,
    @SerializedName("species") val species: String,
    @SerializedName("datePublication") val datePublication: String,
    @SerializedName("longitude") val longitude: Float,
    @SerializedName("latitude") val latitude: Float,
    @SerializedName("email") val email: String,
    @SerializedName("description") val description: String,
    @SerializedName("reward") val reward: Int,
    @SerializedName("userID") val userID: String,
    @SerializedName("photos") val photos: Collection<String>
) {}