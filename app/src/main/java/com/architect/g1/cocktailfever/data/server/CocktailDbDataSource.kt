package com.architect.g1.cocktailfever.data.server

import com.architect.g1.cocktailfever.data.aDomainCoctel
import com.architect.g1.cocktailfever.data.aDomainCoctelDetalle
import com.architect.g1.cocktailfever.data.source.RemoteDataSource
import com.architect.g1.cocktailfever.domain.Coctel

class CocktailDbDataSource: RemoteDataSource {

    override suspend fun obtenerCocteles(): List<Coctel> =
        CocktailDb.servicio.obtenerTodosLosCocteles().drinks.map { it.aDomainCoctel() }

    override suspend fun obtenerDetalleCoctel(id: String): Coctel {
        val cocteles: List<CoctelDetalle> = CocktailDb.servicio.obtenerDetalleCoctel(id).drinks
        val coctel = cocteles.map { it.aDomainCoctelDetalle() }[0]
        return  coctel
    }

}