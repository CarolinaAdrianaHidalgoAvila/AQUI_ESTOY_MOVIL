package com.example.aqui_estoy

import com.example.aqui_estoy.server.ServerLostPublication
import com.example.aqui_estoy.server.ServerUser
import com.example.domain.LostPublication
import com.example.domain.User
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.util.*

fun ServerLostPublication.toDomainLostPublication() : LostPublication = LostPublication(
    id,
    namePet,
    species,
    parseStringToDate(datePublication),
    longitude,
    latitude,
    email,
    description,
    reward,
    userID,
    photos.toList()
)

fun ServerUser.toDomainUser() : User = User(
    id,
    firstName,
    lastName,
    phone,
    email,
    address,
    photo
)

private fun parseStringToDate(dateString: String) : Date {
    val formatter = DateTimeFormatter.ISO_INSTANT
    val instant = Instant.from(formatter.parse(dateString))
    return Date.from(instant)
}