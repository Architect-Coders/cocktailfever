package com.architect.g1.cocktailfever.data.repository

import com.architect.g1.cocktailfever.data.repository.LocalDataSource
import com.architect.g1.cocktailfever.data.repository.RemoteDataSource

class IngredientesRepository(val localDataSource: LocalDataSource, val remoteDataSource: RemoteDataSource) {
}
