package com.architect.g1.cocktailfever.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.architect.g1.cocktailfever.data.database.dao.CoctelDao
import com.architect.g1.cocktailfever.data.database.dao.IngredienteDao
import com.architect.g1.cocktailfever.data.database.entity.Coctel
import com.architect.g1.cocktailfever.data.database.entity.Converters
import com.architect.g1.cocktailfever.data.database.entity.Ingrediente

@Database(
    entities = [Coctel::class, Ingrediente::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class CocktailFeverDatabase : RoomDatabase() {
    abstract fun coctelDao(): CoctelDao
    abstract fun ingredienteDao(): IngredienteDao
}
