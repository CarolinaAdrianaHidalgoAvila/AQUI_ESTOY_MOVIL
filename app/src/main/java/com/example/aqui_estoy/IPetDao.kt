package com.example.aqui_estoy

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface IPetDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(pet: Pet)

    @Query("SELECT * FROM book_table")
    fun getList(): List<Pet>
}