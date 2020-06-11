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
import org.mockito.Mockito.inOrder
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

        runBlocking {
//            val cocteles = listOf(mockedCoctel.copy(1))
//            whenever(getAllCocteles.invoke()).thenReturn(cocteles)
            mainViewModel.model.observeForever(observer)

            val inOrder = inOrder(observer)
            inOrder.verify(observer).onChanged(MainViewModel.UiModel.Loading)
//            inOrder.verify(observer).onChanged(MainViewModel.UiModel.Content(cocteles))

        }
    }

    @Test
    fun `getAllCocteles is called`() {

        runBlocking {
            val cocteles = listOf(mockedCoctel.copy(1))

            whenever(getAllCocteles.invoke()).thenReturn(cocteles)
            mainViewModel.model.observeForever(observer)

            verify(observer).onChanged(MainViewModel.UiModel.Content(cocteles))
        }
    }

    @Test
    fun `onCoctelClicked is Called`() {
        runBlocking {
            val coctel = mockedCoctel.copy(1)
            mainViewModel.onCoctelClicked(coctel)

            mainViewModel.model.observeForever(observer)

            verify(observer).onChanged(MainViewModel.UiModel.Navigation(coctel))
        }
    }

}