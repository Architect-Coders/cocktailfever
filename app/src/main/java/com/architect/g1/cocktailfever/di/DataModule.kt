package com.architect.g1.cocktailfever.di

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.data.source.LocalDataSource
import com.architect.g1.cocktailfever.data.source.RemoteDataSource
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun coctelesRepositoryProvider(
        localDataSource: LocalDataSource,
        remoteDataSource: RemoteDataSource
    ) = CoctelesRepository(localDataSource, remoteDataSource)
}