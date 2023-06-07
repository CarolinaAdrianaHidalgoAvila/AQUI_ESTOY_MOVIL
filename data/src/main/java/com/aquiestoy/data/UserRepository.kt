package com.aquiestoy.data

import com.aquiestoy.domain.User
import javax.inject.Inject

class UserRepository @Inject constructor(val remoteDataSource: IRemoteDataSource){
    suspend fun getUser(idUser: String): User {
        return remoteDataSource.getUser(idUser)
    }

}