package com.architect.g1.cocktailfever.usecases

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
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
class FindCoctelByIdTest {

    @Mock
    lateinit var coctelesRepository: CoctelesRepository
    lateinit var findCoctelById: FindCoctelById

    @Before
    fun setup() {
        findCoctelById = FindCoctelById(coctelesRepository)
    }

    @Test
    fun `invoke calls coctel repository`() {
        runBlocking {
            val coctel = mockedCoctel.copy(1)
            whenever(coctelesRepository.getCoctelById(1)).thenReturn(coctel)

            val result =findCoctelById.invoke(1)

            assertEquals(coctel, result)
        }

    }
}