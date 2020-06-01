package com.architect.g1.cocktailfever.data.repository

import com.architect.g1.cocktailfever.data.source.LocalDataSource
import com.architect.g1.cocktailfever.testshared.mockedIngrediente1
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class IngredientesRepositoryTest {

    @Mock
    lateinit var localDataSource: LocalDataSource

    lateinit var ingredientesRepository: IngredientesRepository

    @Before
    fun setUp() {
        ingredientesRepository =
            IngredientesRepository(localDataSource)
    }

    @Test
    fun `getIngredienteById in local data source`() {
        runBlocking {
            val ingrediente = mockedIngrediente1.copy("gin")
            whenever(localDataSource.getIngredienteById(1)).thenReturn(ingrediente)

            val result = ingredientesRepository.getIngredienteById(1)

            assertEquals(ingrediente, result)
        }
    }
}