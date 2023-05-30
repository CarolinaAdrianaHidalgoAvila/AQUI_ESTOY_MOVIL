package com.example.domain

import java.util.*

data class FoundPublication (
    val Id: String,
    val namePet: String,
    val species: String,
    val datePublication: Date,
    val longitude: Float,
    val latitude: Float,
    val email: String,
    val description: String,
    val user: User,
    val personWhoFound: String,
    val photos: List<String>
) {}