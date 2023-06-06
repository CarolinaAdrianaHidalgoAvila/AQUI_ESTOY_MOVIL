package com.example.aqui_estoy.server

import android.provider.ContactsContract.CommonDataKinds.Email
import android.provider.ContactsContract.CommonDataKinds.SipAddress
import com.google.gson.annotations.SerializedName

data class ServerUser(
    @SerializedName("id") val id: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("phone") val phone:String,
    @SerializedName("email") val email: String,
    @SerializedName("address") val address: String,
    @SerializedName("photo") val photo: String
) {}