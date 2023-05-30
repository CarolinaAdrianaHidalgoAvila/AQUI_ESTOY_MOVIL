package com.example.data.serverModel

import com.example.domain.User
import java.util.*

data class ServerLostPublication (
    val idPublication: String,
    val namePet: String,
    val species: String,
    val datePublication: String,
    val longitude: Float,
    val latitude: Float,
    val email: String,
    val description: String,
    val reward: Int,
    val userID: String,
    val photos: List<String>
) {}