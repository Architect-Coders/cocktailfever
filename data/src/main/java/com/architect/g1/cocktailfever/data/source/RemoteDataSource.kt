package com.architect.g1.cocktailfever.data.source

import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.domain.CoctelLista

interface RemoteDataSource {
    suspend fun obtenerCocteles(): List<CoctelLista>
    suspend fun obtenerDetalleCoctel(id: String): Coctel
}