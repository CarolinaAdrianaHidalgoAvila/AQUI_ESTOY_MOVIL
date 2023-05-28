package com.example.domain

import java.util.*

data class Publication(val path:String, val namePet: String, val gender: String,val species: String,
                       val datePublication: Date, val longitud: Number,val latitud: Number, val email: String,
                       val description: String, val reward: Number, val userId: String) {
}