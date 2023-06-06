package com.example.domain

import java.util.*

data class Publication(val namePet: String,val species: String,
                       val datePublication: String, val longitud: Number,val latitud: Number, val email: String,
                       val description: String, val reward: Number, val userId: String) {
}