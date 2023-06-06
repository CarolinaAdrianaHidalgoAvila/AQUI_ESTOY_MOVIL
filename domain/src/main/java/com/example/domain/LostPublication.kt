package com.example.domain

import java.util.Date

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
    val userId: String,
    val photos: List<String>
){
    lateinit var userObject: User
}