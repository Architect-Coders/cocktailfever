package com.architect.g1.cocktailfever.model.database.dao

import androidx.room.*
import com.architect.g1.cocktailfever.model.database.entity.Coctel

@Dao
interface CoctelDao {
    @Query("SELECT * FROM coctel")
    fun getAll(): List<Coctel>

    @Query("SELECT * FROM coctel WHERE id = :idCoctel")
    fun getById(idCoctel: Int): Coctel

    @Query("SELECT * FROM coctel WHERE nombre = :nombreCoctel")
    fun getByName(nombreCoctel: String): Coctel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(coctel: Coctel)

    @Update
    fun updateById(coctel: Coctel)

    @Delete
    fun deleteById(coctel: Coctel)

    @Query("DELETE FROM coctel")
    fun deleteAll()
}