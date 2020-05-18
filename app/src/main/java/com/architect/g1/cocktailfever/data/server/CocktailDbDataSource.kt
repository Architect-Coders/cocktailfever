package com.architect.g1.cocktailfever.data.server

import com.architect.g1.cocktailfever.data.aDomainCoctel
import com.architect.g1.cocktailfever.data.aDomainCoctelDetalle
import com.architect.g1.cocktailfever.data.source.RemoteDataSource
import com.architect.g1.cocktailfever.domain.Coctel

class CocktailDbDataSource: RemoteDataSource {

    override suspend fun obtenerCocteles(): List<Coctel> =
        CocktailDb.servicio.obtenerTodosLosCocteles().resultados.map { it.aDomainCoctel() }

    override suspend fun obtenerDetalleCoctel(id: String): Coctel =
        CocktailDb.servicio.obtenerDetalleCoctel(id).aDomainCoctelDetalle()

}