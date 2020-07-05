package com.architect.g1.cocktailfever.usecases

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.testshared.mockedCoctel
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAllCoctelesTest {

    @Mock
    lateinit var coctelesRepository: CoctelesRepository

    lateinit var getAllCocteles: GetAllCocteles

    @Before
    fun setup() {
        getAllCocteles = GetAllCocteles(coctelesRepository)
    }

    @Test
    fun `invoke calls cocteles repository`() {
        runBlocking {
            val cocteles = listOf<Coctel>(mockedCoctel.copy(1))
            whenever(coctelesRepository.getAllCocteles()).thenReturn(cocteles)

            val result = getAllCocteles.invoke()

            assertEquals(cocteles, result)
        }
    }
}