package com.architect.g1.cocktailfever.usecases

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository

class GetAllCocteles(private val coctelesRepository: CoctelesRepository) {
    suspend fun invoke() = coctelesRepository.getAllCocteles()
}