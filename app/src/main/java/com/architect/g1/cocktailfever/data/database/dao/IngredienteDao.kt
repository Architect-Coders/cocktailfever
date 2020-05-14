package com.architect.g1.cocktailfever.data.database.dao

import androidx.room.*
import com.architect.g1.cocktailfever.data.database.entity.Ingrediente

@Dao
interface IngredienteDao {
    @Query("SELECT * FROM ingrediente")
    fun getAll(): List<Ingrediente>

    @Query("SELECT * FROM ingrediente WHERE id = :idIngrediente")
    fun getById(idIngrediente: Int): Ingrediente

    @Query("SELECT * FROM ingrediente WHERE nombre = :nombreIngrediente")
    fun getByName(nombreIngrediente: String): Ingrediente

    @Query("SELECT count(id) FROM ingrediente")
    fun count(): Int

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(ingrediente: Ingrediente)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(ingredientes: List<Ingrediente>)

    @Update
    fun update(ingrediente: Ingrediente)

    @Delete
    fun delete(ingrediente: Ingrediente)

    @Query("DELETE FROM ingrediente")
    fun deleteAll()
}
