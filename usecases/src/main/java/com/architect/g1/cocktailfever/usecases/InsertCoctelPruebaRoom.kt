package com.architect.g1.cocktailfever.usecases

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.domain.Coctel

class InsertCoctelPruebaRoom(private val coctelesRepository: CoctelesRepository) {
    suspend fun invoke(coctel: Coctel) = coctelesRepository.insertCoctel(coctel)
}