package com.architect.g1.cocktailfever.di

import com.architect.g1.cocktailfever.data.server.CocktailDb
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ServerModule {
    @Singleton
    @Provides
    @Named("baseUrl")
    fun baseUrlProvider() = "https://www.thecocktaildb.com/api/json/v1/1/"

    @Singleton
    @Provides
    fun movieDBProvider(@Named("baseUrl") baseUrl: String) = CocktailDb(baseUrl)
}