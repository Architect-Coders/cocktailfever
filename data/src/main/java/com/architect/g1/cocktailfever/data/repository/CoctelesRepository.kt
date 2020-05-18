package com.architect.g1.cocktailfever.data.repository

import com.architect.g1.cocktailfever.data.source.LocalDataSource
import com.architect.g1.cocktailfever.domain.Coctel

class CoctelesRepository(
    private val localDataSource: LocalDataSource
) {

    suspend fun getCoctelById(id: Int): Coctel {
        return localDataSource.getCoctelById(id)
    }

    suspend fun getAllCocteles(): List<Coctel> {
        return localDataSource.getAllCocteles()
    }

    suspend fun isCoctelTableEmpty() {
        localDataSource.isCoctelTableEmpty()
    }

    suspend fun insertCoctel(coctel: Coctel) {
        localDataSource.insertCoctel(coctel)
    }

    suspend fun insertAllCocteles(cocteles: List<Coctel>) {
        localDataSource.insertAllCocteles(cocteles)
    }

    suspend fun updateCoctel(coctel: Coctel) {
        localDataSource.updateCoctel(coctel)
    }

    suspend fun deleteCoctel(coctel: Coctel) {
        localDataSource.deleteCoctel(coctel)
    }

    suspend fun deleteAllCocteles() {
        localDataSource.deleteAllCocteles()
    }

}
