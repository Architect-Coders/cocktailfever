package com.architect.g1.cocktailfever.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.architect.g1.cocktailfever.model.database.dao.CoctelDao
import com.architect.g1.cocktailfever.model.database.entity.Ingrediente

@Database(
    entities = [Ingrediente::class, Ingrediente::class],
    version = 1
)
abstract class CoctelDatabase : RoomDatabase() {
    abstract fun coctelDao(): CoctelDao
}
