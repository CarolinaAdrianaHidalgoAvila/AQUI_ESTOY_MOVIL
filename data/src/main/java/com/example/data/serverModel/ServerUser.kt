package com.example.data.serverModel

data class ServerUser (
    val id: String,
    val firstName: String,
    val lastName: String,
    val phone: String,
    val email: String,
    val address: String,
    val photo: String
) {
    constructor() : this ("Id", "name", "last name", "phone", "email", "address", "photo")
}