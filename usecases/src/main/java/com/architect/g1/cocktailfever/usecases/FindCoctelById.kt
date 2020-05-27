package com.architect.g1.cocktailfever.usecases

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.domain.Coctel

class FindCoctelById(private val coctelesRepository: CoctelesRepository) {
    suspend fun invoke(id: Int): Coctel = coctelesRepository.getCoctelById(id)
}