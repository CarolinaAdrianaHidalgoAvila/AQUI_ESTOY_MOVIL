package com.example.data

import com.example.domain.User
import javax.inject.Inject

class UserRepository @Inject constructor(val remoteDataSource: IRemoteDataSource){
    suspend fun getUser(idUser: String): User {
        return remoteDataSource.getUser(idUser)
    }

}