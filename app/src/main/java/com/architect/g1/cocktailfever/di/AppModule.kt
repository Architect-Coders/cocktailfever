package com.architect.g1.cocktailfever.di

import android.app.Application
import androidx.room.Room
import com.architect.g1.cocktailfever.data.database.CocktailFeverDatabase
import com.architect.g1.cocktailfever.data.database.source.RoomDataSource
import com.architect.g1.cocktailfever.data.server.CocktailDb
import com.architect.g1.cocktailfever.data.server.CocktailDbDataSource
import com.architect.g1.cocktailfever.data.source.LocalDataSource
import com.architect.g1.cocktailfever.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun databaseProvider(app: Application): CocktailFeverDatabase = Room.databaseBuilder(
        app,
        CocktailFeverDatabase::class.java,
        "coctel-db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: CocktailFeverDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(cocktailDb: CocktailDb): RemoteDataSource = CocktailDbDataSource(cocktailDb)

    @Provides
    fun scopeViewModel(): CoroutineDispatcher {
        return Dispatchers.Main
    }
}