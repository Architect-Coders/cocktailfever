package com.architect.g1.cocktailfever.usecases

import com.architect.g1.cocktailfever.data.repository.IngredientesRepository

class GetAllIngredientes(private val ingredientesRepository: IngredientesRepository) {
    suspend fun invoke() = ingredientesRepository.getAllIngredientes()
}