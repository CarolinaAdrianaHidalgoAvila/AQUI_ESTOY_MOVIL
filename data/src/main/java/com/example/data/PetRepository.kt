package com.example.data
import com.example.domain.Pet
class PetRepository(val remoteDataSource: IRemoteDataSource){
     suspend fun getPet() : Pet {
          val IdUser = "632333ceca137c2c4b95168c"
          val IdPet = "635716a5a2059dbd379482bb"
          return remoteDataSource.getPet(IdPet, IdUser)}

     suspend fun postPet() {

     }
}