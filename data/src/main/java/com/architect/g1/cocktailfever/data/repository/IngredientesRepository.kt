package com.architect.g1.cocktailfever.data.repository

import com.architect.g1.cocktailfever.data.source.LocalDataSource
import com.architect.g1.cocktailfever.domain.Ingrediente

class IngredientesRepository(
    private val localDataSource: LocalDataSource
) {

    suspend fun getIngredienteById(id: Int): Ingrediente {
        return localDataSource.getIngredienteById(id)
    }

    suspend fun getAllIngredientes(): List<Ingrediente> {
        return localDataSource.getAllIngredientes()
    }

    suspend fun isIngredienteTableEmpty() {
        localDataSource.isIngredienteTableEmpty()
    }

    suspend fun insertIngrediente(ingrediente: Ingrediente) {
        localDataSource.insertIngrediente(ingrediente)
    }

    suspend fun insertAllIngredientes(ingredientes: List<Ingrediente>) {
        localDataSource.insertAllIngredientes(ingredientes)
    }

    suspend fun updateIngrediente(ingrediente: Ingrediente) {
        localDataSource.updateIngrediente(ingrediente)
    }

    suspend fun deleteIngrediente(ingrediente: Ingrediente) {
        localDataSource.deleteIngrediente(ingrediente)
    }

    suspend fun deleteAllIngredientes() {
        localDataSource.deleteAllIngredientes()
    }
}
