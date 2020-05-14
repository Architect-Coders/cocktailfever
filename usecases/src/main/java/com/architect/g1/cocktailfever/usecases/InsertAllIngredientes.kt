package com.architect.g1.cocktailfever.usecases

import com.architect.g1.cocktailfever.data.repository.IngredientesRepository
import com.architect.g1.cocktailfever.domain.Ingrediente

class InsertAllIngredientes(private val ingredientesRepository: IngredientesRepository) {
    suspend fun invoke(ingredientes: List<Ingrediente>) = ingredientesRepository.insertAllIngredientes(ingredientes)
}