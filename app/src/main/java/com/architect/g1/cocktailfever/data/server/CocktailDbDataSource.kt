package com.architect.g1.cocktailfever.data.server

import com.architect.g1.cocktailfever.data.aDomainCoctel
import com.architect.g1.cocktailfever.data.aDomainCoctelDetalle
import com.architect.g1.cocktailfever.data.source.RemoteDataSource
import com.architect.g1.cocktailfever.domain.Coctel

class CocktailDbDataSource(private val cocktailDb: CocktailDb): RemoteDataSource {

    override suspend fun obtenerCocteles(): List<Coctel> =
        cocktailDb.servicio.obtenerTodosLosCocteles().drinks.map { it.aDomainCoctel() }

    override suspend fun obtenerDetalleCoctel(id: String): Coctel {
        val cocteles: List<CoctelDetalle> = cocktailDb.servicio.obtenerDetalleCoctel(id).drinks
        val coctel = cocteles.map { it.aDomainCoctelDetalle() }[0]
        return  coctel
    }

}