package com.example.domain

import java.util.*

data class LostPublication(
    val Id: String,
    val namePet: String,
    val species: String,
    val datePublication: Date,
    val longitude: Float,
    val latitude: Float,
    val email: String,
    val description: String,
    val reward: Int,
    val user: User,
    val photos: List<String>
) {}