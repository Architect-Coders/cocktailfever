package com.architect.g1.cocktailfever.model.database.dao

import androidx.room.*
import com.architect.g1.cocktailfever.model.database.entity.Ingrediente

@Dao
interface IngredienteDao {
    @Query("SELECT * FROM ingrediente")
    fun getAll(): List<Ingrediente>

    @Query("SELECT * FROM ingrediente WHERE id = :idIngrediente")
    fun getById(idIngrediente: Int): Ingrediente

    @Query("SELECT * FROM ingrediente WHERE nombre = :nombreIngrediente")
    fun getByName(nombreIngrediente: String): Ingrediente

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(ingrediente: Ingrediente)

    @Update
    fun updateById(ingrediente: Ingrediente)

    @Delete
    fun deleteById(ingrediente: Ingrediente)

    @Query("DELETE FROM ingrediente")
    fun deleteAll()
}