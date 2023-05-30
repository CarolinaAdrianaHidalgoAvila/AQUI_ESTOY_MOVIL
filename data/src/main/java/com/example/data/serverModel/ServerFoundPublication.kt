package com.example.data.serverModel

import com.example.domain.User
import java.util.*

data class ServerFoundPublication(
    val idFoundPetPost: String,
    val namePet: String,
    val species: String,
    val datePublication: String,
    val longitude: Float,
    val latitude: Float,
    val email: String,
    val description: String,
    val userID: String,
    val personWhoFound: String,
    val photos: List<String>
) {}