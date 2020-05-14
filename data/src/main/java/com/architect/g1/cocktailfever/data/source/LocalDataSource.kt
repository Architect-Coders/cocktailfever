package com.architect.g1.cocktailfever.data.source

import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.domain.Ingrediente

interface LocalDataSource {
    suspend fun getCoctelById(id: Int): Coctel
    suspend fun getAllCocteles(): List<Coctel>
    suspend fun isCoctelTableEmpty(): Boolean
    suspend fun insertCoctel(coctel: Coctel)
    suspend fun insertAllCocteles(cocteles: List<Coctel>)
    suspend fun updateCoctel(coctel: Coctel)
    suspend fun deleteCoctel(coctel: Coctel)
    suspend fun deleteAllCocteles()

    suspend fun getIngredienteById(id: Int): Ingrediente
    suspend fun getAllIngredientes(): List<Ingrediente>
    suspend fun isIngredienteTableEmpty(): Boolean
    suspend fun insertIngrediente(ingrediente: Ingrediente)
    suspend fun insertAllIngredientes(ingredientes: List<Ingrediente>)
    suspend fun updateIngrediente(ingrediente: Ingrediente)
    suspend fun deleteIngrediente(ingrediente: Ingrediente)
    suspend fun deleteAllIngredientes()
}
