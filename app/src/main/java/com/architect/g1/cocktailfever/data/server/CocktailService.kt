package com.architect.g1.cocktailfever.data.server

import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailService {
    @GET("filter.php?c=Cocktail")
    suspend fun obtenerTodosLosCocteles():ResultadoCoctelDb

    @GET("lookup.php")
    suspend fun obtenerDetalleCoctel(@Query("i") id: String): ResultadoCoctelDetalleDb

}