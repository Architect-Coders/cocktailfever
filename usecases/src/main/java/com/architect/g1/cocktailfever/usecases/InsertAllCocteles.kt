package com.architect.g1.cocktailfever.usecases

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.domain.Coctel

class InsertAllCocteles(private val coctelesRepository: CoctelesRepository) {
    suspend fun invoke(cocteles: List<Coctel>) = coctelesRepository.insertAllCocteles(cocteles)
}
