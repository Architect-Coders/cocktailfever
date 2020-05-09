package com.architect.g1.cocktailfever.data.database.dao

import androidx.room.*
import com.architect.g1.cocktailfever.data.database.entity.Coctel

@Dao
interface CoctelDao {
    @Query("SELECT * FROM coctel")
    fun getAll(): List<Coctel>

    @Query("SELECT * FROM coctel WHERE id = :idCoctel")
    fun getById(idCoctel: Int): Coctel

    @Query("SELECT * FROM coctel WHERE nombre = :nombreCoctel")
    fun getByName(nombreCoctel: String): Coctel

    @Query("SELECT COUNT(id) FROM coctel")
    fun count(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(coctel: Coctel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(cocteles: List<Coctel>)

    @Update
    fun update(coctel: Coctel)

    @Delete
    fun delete(coctel: Coctel)

    @Query("DELETE FROM coctel")
    fun deleteAll()
}
