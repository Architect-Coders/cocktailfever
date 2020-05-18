package com.architect.g1.cocktailfever.data.source

import com.architect.g1.cocktailfever.domain.Coctel

interface RemoteDataSource {
    suspend fun obtenerCocteles(): List<Coctel>
    suspend fun obtenerDetalleCoctel(id: String): Coctel
}