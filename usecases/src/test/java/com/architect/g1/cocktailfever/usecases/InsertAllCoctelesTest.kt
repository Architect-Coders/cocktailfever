package com.architect.g1.cocktailfever.usecases

import com.architect.g1.cocktailfever.data.repository.CoctelesRepository
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.testshared.mockedCoctel
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class InsertAllCoctelesTest {

    @Mock
    lateinit var coctelesRepository: CoctelesRepository

    lateinit var insertAllCocteles: InsertAllCocteles

    @Before
    fun setup() {
        insertAllCocteles = InsertAllCocteles(coctelesRepository)
    }

    @Test
    fun `invoke calls cocteles repository`() {
        runBlocking {
            val cocteles = listOf<Coctel>(mockedCoctel.copy(1))
            insertAllCocteles.invoke(cocteles)

            verify(coctelesRepository).insertAllCocteles(cocteles)
        }
    }
}