package com.aquiestoy.aqui_estoy

import com.aquiestoy.aqui_estoy.server.ServerLostPublication
import com.aquiestoy.aqui_estoy.server.ServerUser
import com.aquiestoy.domain.LostPublication
import com.aquiestoy.domain.User
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