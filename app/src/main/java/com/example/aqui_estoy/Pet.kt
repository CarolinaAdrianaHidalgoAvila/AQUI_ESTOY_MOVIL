package com.example.aqui_estoy

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.format.DateTimeFormatterBuilder
data class Pet (
    val id: String,
    val namePet: String,
    val birthDate: String,
    val gender: String,
    val hasNecklace: String,
    val photo: String,
    val specie: String
)