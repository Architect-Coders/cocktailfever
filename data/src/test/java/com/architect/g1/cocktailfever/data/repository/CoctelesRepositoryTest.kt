package com.architect.g1.cocktailfever.data.repository

import com.architect.g1.cocktailfever.data.source.LocalDataSource
import com.architect.g1.cocktailfever.data.source.RemoteDataSource
import com.architect.g1.cocktailfever.domain.Coctel
import com.architect.g1.cocktailfever.testshared.mockedCoctel
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.junit.runner.RunWith

@RunWith(MockitoJUnitRunner::class)
class CoctelesRepositoryTest {

    @Mock
    lateinit var localDataSource: LocalDataSource

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    lateinit var coctelesRepository: CoctelesRepository

    @Before
    fun setUp() {
        coctelesRepository =
            CoctelesRepository(localDataSource, remoteDataSource)
    }

    @Test
    fun `getAllCocteles gets from local data source`() {
        runBlocking {

            val localCocteles = listOf(mockedCoctel.copy(1))
            whenever(localDataSource.isCoctelTableEmpty()).thenReturn(false)
            whenever(localDataSource.getAllCocteles()).thenReturn(localCocteles)

            val result = coctelesRepository.getAllCocteles()

            assertEquals(localCocteles, result)
        }
    }

    @Test
    fun `getCoctelById calls from local data source`() {
        runBlocking {

            val coctel = mockedCoctel.copy(5)
            whenever(localDataSource.getCoctelById(5)).thenReturn(coctel)

            val result = coctelesRepository.getCoctelById((5))

            assertEquals(coctel, result)
        }
    }

    @Test
    fun `isCoctelTableEmpty in local data source`() {
        runBlocking {
            whenever(localDataSource.isCoctelTableEmpty()).thenReturn(true)

            val result = coctelesRepository.isCoctelTableEmpty()

            assert(result)
        }
    }

    @Test
    fun `insertCoctel inserts in local data source`() {
        runBlocking {

            val coctel = mockedCoctel.copy(1)
            coctelesRepository.insertCoctel(coctel)

            verify(localDataSource).insertCoctel(coctel)
        }
    }

    @Test
    fun `insertAllCocteles inserts a coctel in local data source`() {
        runBlocking {

            val coctel = mockedCoctel.copy(1)
            val listCocteles: List<Coctel> = listOf(coctel)
            coctelesRepository.insertAllCocteles(listCocteles)

            verify(localDataSource).insertAllCocteles(listCocteles)
        }
    }

    @Test
    fun `updateCoctel updates local data source`() {
        runBlocking {

            val coctel = mockedCoctel.copy(1)
            coctelesRepository.updateCoctel(coctel)

            verify(localDataSource).updateCoctel(coctel)
        }
    }

    @Test
    fun `deleteCoctel deletes a coctel in local data source`() {
        runBlocking {
            val coctel = mockedCoctel.copy(1)
            coctelesRepository.deleteCoctel(coctel)

            verify(localDataSource).deleteCoctel(coctel)
        }
    }

    @Test
    fun `deletesAllCocteles deletes all cocteles in local data soruce`() {
        runBlocking {
            coctelesRepository.deleteAllCocteles()

            verify(localDataSource).deleteAllCocteles()
        }
    }
}
