package com.architect.g1.cocktailfever.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.architect.g1.cocktailfever.testshared.mockedCoctel
import com.architect.g1.cocktailfever.usecases.FindCoctelById
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
class DetailViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var getCoctelById: FindCoctelById

    @Mock
    lateinit var observer: Observer<DetailViewModel.UiModel>

    private lateinit var detailViewModel: DetailViewModel

    @Before
    fun setup() {
        detailViewModel = DetailViewModel(1, getCoctelById, Dispatchers.Unconfined)
    }

    @Test
    fun `finds a coctel`() {
        runBlocking {
            val coctel = mockedCoctel.copy(1)

            whenever(getCoctelById.invoke(1)).thenReturn(coctel)
            detailViewModel.model.observeForever(observer)
            verify(observer).onChanged(DetailViewModel.UiModel(coctel))
        }

    }

}