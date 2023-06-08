package com.aquiestoy.domain

data class User(
    val id: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String,
    val address: String,
    val photo: String
) {
    lateinit var pets : List<Pet>
}

