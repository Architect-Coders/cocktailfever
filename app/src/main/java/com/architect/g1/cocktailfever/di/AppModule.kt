package com.architect.g1.cocktailfever.di

import android.app.Application
import androidx.room.Room
import com.architect.g1.cocktailfever.data.database.CocktailFeverDatabase
import com.architect.g1.cocktailfever.data.database.source.RoomDataSource
import com.architect.g1.cocktailfever.data.server.CocktailDbDataSource
import com.architect.g1.cocktailfever.data.source.LocalDataSource
import com.architect.g1.cocktailfever.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun databaseProvider(app: Application) = Room.databaseBuilder(
        app,
        CocktailFeverDatabase::class.java,
        "coctel-db"
    ).build()

    @Provides
    fun localDataSourceProvider(db: CocktailFeverDatabase): LocalDataSource = RoomDataSource(db)

    @Provides
    fun remoteDataSourceProvider(): RemoteDataSource = CocktailDbDataSource()
}