package com.architect.g1.cocktailfever

import android.app.Application
import androidx.room.Room
import com.architect.g1.cocktailfever.data.database.CocktailFeverDatabase

class CoctelApp : Application() {

    lateinit var db: CocktailFeverDatabase
        private set

    override fun onCreate() {
        super.onCreate()

        db = Room.databaseBuilder(
            this,
            CocktailFeverDatabase::class.java, "coctel-db"
        ).build()
    }
}