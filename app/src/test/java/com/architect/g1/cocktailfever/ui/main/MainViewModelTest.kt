package com.architect.g1.cocktailfever.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.architect.g1.cocktailfever.testshared.mockedCoctel
import com.architect.g1.cocktailfever.usecases.GetAllCocteles
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var getAllCocteles: GetAllCocteles

    @Mock
    lateinit var observer: Observer<MainViewModel.UiModel>

    private lateinit var mainViewModel: MainViewModel

    @Before
    fun setup() {
        mainViewModel = MainViewModel(getAllCocteles, Dispatchers.Unconfined)
    }

    @Test
    fun `after requesting all cocteles, loading is shown`() {
        //FIXME para testear el estado Loading, se debe invocar a getAllCocteles, ¿no?
        val cocteles = listOf(mockedCoctel.copy(1))

        runBlocking {
            whenever(getAllCocteles.invoke()).thenReturn(cocteles)
            mainViewModel.model.observeForever(observer)
        }

        verify(observer).onChanged(MainViewModel.UiModel.Loading)
    }

    @Test
    fun `getAllCocteles is called`() {

        val cocteles = listOf(mockedCoctel.copy(1))
        runBlocking {

            whenever(getAllCocteles.invoke()).thenReturn(cocteles)
            mainViewModel.model.observeForever(observer)

        }
        verify(observer).onChanged(MainViewModel.UiModel.Content(cocteles))
    }

}